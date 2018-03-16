package ru.bellintegrator.myproject.organization.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myproject.organization.service.OrganizationService;
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.view.OrganizationView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrganizationServiceImpl implements OrganizationService {


    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDAO dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void add(OrganizationView view) {
        Organization users = new Organization(view.name, view.inn);
        dao.save(users);
    }


    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> organizations() {
        List<Organization> all = dao.all();

        Function<Organization, OrganizationView> mapOrganization = new Function<Organization, OrganizationView>() {
            @Override
            public OrganizationView apply(Organization o) {
                OrganizationView view = new OrganizationView();
                view.id = String.valueOf(o.getId());
                view.name = o.getName();
                view.name = o.getInn();

                log.info(view.toString());

                return view;
            }
        };

        return all.stream()
                .map(mapOrganization)
                .collect(Collectors.toList());
    }

}
