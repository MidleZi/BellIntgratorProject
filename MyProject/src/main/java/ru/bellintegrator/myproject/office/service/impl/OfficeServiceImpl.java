package ru.bellintegrator.myproject.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
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
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
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
        logger.info("Office get ID:" + id);
        return DAO.getOfficeById(id);
    }

    @Override
    @Transactional
    public void update(OfficeView view) {
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
        logger.info("Office deleted ID:" + id);
        DAO.delete(office);
    }


}
