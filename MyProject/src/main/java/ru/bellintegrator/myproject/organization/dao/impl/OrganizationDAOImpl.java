package ru.bellintegrator.myproject.organization.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.service.impl.OrganizationServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    private final Logger logger = LoggerFactory.getLogger(OrganizationDAOImpl.class);

    private final EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em) {
        this.em = em;
    }

    public List<Organization> list(){
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM organization o", Organization.class);
        return query.getResultList();

    }
    @Override
    public Organization getOrganizationById(Long id){
        return em.find(Organization.class, id);
    }

    public void update(Organization organization){
        logger.info("Organization update " + organization.toString());
        em.merge(organization);
    }

    public void save(Organization organization) {
        logger.info("save:" + organization.toString());
        em.persist(organization);
    }

    public void delete(Organization organization) {
        logger.info("Organization deleted ID:" + organization.getId());
        em.remove(organization);
    }


}
