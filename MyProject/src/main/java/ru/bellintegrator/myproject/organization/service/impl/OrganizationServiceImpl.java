package ru.bellintegrator.myproject.organization.service.impl;

import org.hibernate.service.spi.ServiceException;
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
import ru.bellintegrator.myproject.organization.view.OrganizationFilterViewList;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import java.util.ArrayList;
import java.util.List;



@Service
public class OrganizationServiceImpl implements OrganizationService {


    private final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDAO dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAOImpl dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<OrganizationView> getAllOrganization() {

        List<Organization> allOrganization = dao.getAllOrganizations();
        List<OrganizationView> viewlist = new ArrayList();


        if(allOrganization == null) throw new ServiceException("Сотрудников в базе нет");

        for (int i = 0; i <allOrganization.size() ; i++) {

            OrganizationView view = new OrganizationView();

            view.id = allOrganization.get(i).getId();
            view.name = allOrganization.get(i).getName();
            view.fullname = allOrganization.get(i).getFullname();
            view.inn = allOrganization.get(i).getInn();
            view.kpp = allOrganization.get(i).getKpp();
            view.address = allOrganization.get(i).getAddress();
            view.phone =allOrganization.get(i).getPhone();
            view.isActive = allOrganization.get(i).getActive();

            viewlist.add(view);
        }
        //logger.info("User get ID:" + id);
        return viewlist;

    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationFilterViewList> list(OrganizationFilterView filterView) {
        List<Organization> orgs = dao.list(filterView);
        List<OrganizationFilterViewList> outList = new ArrayList();

        for (int i = 0; i < orgs.size() ; i++) {
            OrganizationFilterViewList listOut = new OrganizationFilterViewList();
            listOut.setId(orgs.get(i).getId());
            listOut.setName(orgs.get(i).getName());
            listOut.setActive(orgs.get(i).getActive());

            outList.add(i, listOut);

        }

            return outList;
    }

    @Override
    @Transactional
    public Organization getOrganizationById (Long id) {
        Organization org = dao.getOrganizationById(id);
        if(org == null) throw new ServiceException("Организации с id " + id + " не существует");
        logger.info("Organization get ID:" + id);
        return org;

    }

    @Override
    @Transactional
    public void update(OrganizationView view) {
        Long id = view.id;
        Organization organization = dao.getOrganizationById(id);
        organization = view.orgConvert(organization);
        if(organization == null) throw new ServiceException("Организации с id " + id + " не существует");
        logger.info("update" + organization.toString());
        dao.update(organization);

    }

    @Override
    @Transactional
    public void save(OrganizationView view) {
        Organization organization = new Organization(view.name, view.fullname, view.inn, view.kpp, view.address, view.phone,
                view.isActive);
        logger.info("save:" + organization.toString());
        dao.save(organization);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Organization org = dao.getOrganizationById(id);
        if(org == null) throw new ServiceException("Организации с id " + id + " не существует");
        logger.info("Organization deleted ID:" + id);
        dao.delete(id);
    }

}
