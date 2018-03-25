package ru.bellintegrator.myproject.organization.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myproject.organization.service.OrganizationService;
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.view.OrganizationResponseView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class OrganizationServiceImpl implements OrganizationService {


    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDAO DAO;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAO dao) {
        this.DAO = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> all() {
        List<Organization> all = DAO.all();

        Function<Organization, OrganizationView> mapOrganization = o -> {
            OrganizationView view = new OrganizationView();
            view.name = o.getName();
            view.inn = o.getInn();
            view.isActive = o.getActive();

            log.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapOrganization)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrganizationResponseView getOrganizationById (Long id) {
        DAO.getOrganizationById(id);
        return null;
    }

    @Override
    @Transactional
    public OrganizationResponseView update(OrganizationView view) {
        Organization users = new Organization(view.name, view.inn);
        DAO.save(users);
        return null;
    }

    @Override
    @Transactional
    public OrganizationResponseView save(OrganizationView view) {
        Organization users = new Organization();
        DAO.save(users);
        return null;
    }

    @Override
    @Transactional
    public OrganizationResponseView delete(Long id) {
        Organization users = new Organization();
        DAO.save(users);
        return null;
    }

}
