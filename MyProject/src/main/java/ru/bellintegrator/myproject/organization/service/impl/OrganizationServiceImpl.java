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
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class OrganizationServiceImpl implements OrganizationService {


    private final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDAO DAO;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAOImpl dao) {
        this.DAO = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> list(OrganizationFilterView filterView) {
        List<OrganizationView> result = new ArrayList<>();
        List<Organization> orgs = DAO.list(filterView);

            for(Organization org : orgs) {
                OrganizationView view = org.convertOrgToView();

                logger.info(view.toString());

                result.add(view);
            }

            return result;
    }

    @Override
    @Transactional
    public Organization getOrganizationById (Long id) {
        logger.info("Organization get ID:" + id);
        return DAO.getOrganizationById(id);

    }

    @Override
    @Transactional
    public void update(OrganizationView view) {
        Long id = view.id;
        Organization organization = DAO.getOrganizationById(id);
        organization = view.orgConvert(organization);
        logger.info("update" + organization.toString());
        DAO.save(organization);

    }

    @Override
    @Transactional
    public void save(OrganizationView view) {
        Organization organization = new Organization(view.name, view.fullname, view.inn, view.kpp, view.address, view.phone,
                view.isActive);
        logger.info("save:" + organization.toString());
        DAO.save(organization);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        //Organization organization = new Organization(id);
        DAO.delete(id);
        logger.info("Organization deleted ID:" + id);
    }

}
