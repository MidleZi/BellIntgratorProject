package ru.bellintegrator.myproject.office.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myproject.office.dao.impl.OfficeDAOImpl;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.office.service.OfficeService;
import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.office.view.OfficeFilterViewList;
import ru.bellintegrator.myproject.office.view.OfficeView;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final Logger logger = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeDAOImpl dao;

    @Autowired
    public OfficeServiceImpl(OfficeDAOImpl dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<OfficeView> getAllOffice() {

        List<Office> allOffice = dao.getAllOffice();
        List<OfficeView> viewlist = new ArrayList();

        if(allOffice == null) throw new ServiceException("Сотрудников в базе нет");

        for (int i = 0; i <allOffice.size() ; i++) {

            OfficeView view = new OfficeView();

            view.id = allOffice.get(i).getId();
            view.name = allOffice.get(i).getName();
            view.address = allOffice.get(i).getAddress();
            view.phone =allOffice.get(i).getPhone();
            view.isActive = allOffice.get(i).getActive();

            viewlist.add(view);
        }
        //logger.info("User get ID:" + id);
        return viewlist;

    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeFilterViewList> list(OfficeFilterView filterView) {
        List<Office> orgs = dao.list(filterView);
        List<OfficeFilterViewList> outList = new ArrayList();

        for (int i = 0; i < orgs.size() ; i++) {
            OfficeFilterViewList listOut = new OfficeFilterViewList();
            listOut.setId(orgs.get(i).getId());
            listOut.setName(orgs.get(i).getName());
            listOut.setActive(orgs.get(i).getActive());

            outList.add(i, listOut);

        }

        logger.info("Geted List" + outList );

        return outList;
    }


    @Override
    @Transactional
    public Office getOfficeById(Long id) {
        Office office = dao.getOfficeById(id);
        if(office == null) throw new ServiceException("Офиса с id " + id + " не существует");
        logger.info("Office get ID:" + id);
        return office;
    }

    @Override
    @Transactional
    public void update(OfficeView view) {
        Long id = view.id;
        Office office = dao.getOfficeById(id);
        if(id == null) throw new ServiceException("Офиса с id " + id + " не существует");
        office = view.convertToEntity(office);
        logger.info("Office update " + office.toString());
        dao.update(office);
    }

    @Override
    @Transactional
    public void save(OfficeView view) {
        Office office = new Office(view.name, view.address, view.phone, view.isActive);
        logger.info("Office save " + office.toString());
        dao.save(office);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Office office = getOfficeById(id);
        if(office == null) throw new ServiceException("Офиса с id " + id + " не существует");
        logger.info("Office deleted ID:" + id);
        dao.delete(office);
    }


}
