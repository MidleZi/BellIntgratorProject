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
import ru.bellintegrator.myproject.office.view.OfficeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeDAOImpl DAO;

    @Autowired
    public OfficeServiceImpl(OfficeDAOImpl dao) {
        this.DAO = dao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> list() {
        List<Office> all = DAO.list();

        Function<Office, OfficeView> mapOffice = p->{
            OfficeView view = new OfficeView();
            view.name = p.getName();
           // view.orgId = p.getOrganization();
            view.isActive = p.getActive();

            log.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapOffice)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Office getOfficeById(Long id) {
       return DAO.getOfficeById(id);
    }

    @Override
    @Transactional
    public void update(OfficeView view) {
        Office office = new Office();
        DAO.update(office);
    }

    @Override
    @Transactional
    public void save(OfficeView view) {
        Office office = new Office();
        DAO.save(office);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Office office = new Office();
        DAO.delete(office);
    }


}
