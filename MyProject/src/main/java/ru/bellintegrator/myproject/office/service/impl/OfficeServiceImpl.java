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

    private final OfficeDAOImpl DAO;

    @Autowired
    public OfficeServiceImpl(OfficeDAOImpl dao) {
        this.DAO = dao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<OfficeFilterViewList> list(OfficeFilterView filterView) {
        List<Office> orgs = DAO.list(filterView);
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
        Office office =DAO.getOfficeById(id);
        if(office == null) throw new ServiceException("Офиса с id " + id + " не существует");
        logger.info("Office get ID:" + id);
        return office;
    }

    @Override
    @Transactional
    public void update(OfficeView view) {
        Long id = view.id;
        if(id == null) throw new ServiceException("Офиса с id " + id + " не существует");
        Office office = new Office(view.id, view.name, view.address, view.phone, view.isActive);
        logger.info("Office update " + office.toString());
        DAO.update(office);
    }

    @Override
    @Transactional
    public void save(OfficeView view) {
        Office office = new Office(view.name, view.address, view.phone, view.isActive);
        logger.info("Office save " + office.toString());
        DAO.save(office);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Office office = getOfficeById(id);
        if(office == null) throw new ServiceException("Офиса с id " + id + " не существует");
        logger.info("Office deleted ID:" + id);
        DAO.delete(office);
    }


}
