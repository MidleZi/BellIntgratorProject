package ru.bellintegrator.myproject.organization.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myproject.organization.dao.impl.OrganizationDAOImpl;
import ru.bellintegrator.myproject.organization.service.OrganizationService;
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.view.OrganizationView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class OrganizationServiceImpl implements OrganizationService {


    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDAO DAO;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAOImpl dao) {
        this.DAO = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> list() {
        List<Organization> all = DAO.list();

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
    public Organization getOrganizationById (Long id) {
       return DAO.getOrganizationById(id);

    }

    @Override
    @Transactional
    public void update(OrganizationView view) {
        Organization organization = new Organization(view.name, view.inn);
        DAO.save(organization);

    }

    @Override
    @Transactional
    public void save(OrganizationView view) {
        Organization organization = new Organization(view.name, view.fullName, view.inn, view.kpp, view.adress, view.phone,
                view.isActive);
        DAO.save(organization);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Organization organization = new Organization();
        DAO.delete(organization);
    }

}
