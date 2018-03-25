package ru.bellintegrator.myproject.organization.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.organization.model.Organization;

import javax.persistence.*;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    private final EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em) {
        this.em = em;
    }

    public List<Organization> all(){
        TypedQuery<Organization> query = em.createQuery("SELECT h FROM House h", Organization.class);
        return query.getResultList();

    }

    public Organization loadById(Long id){
        return em.find(Organization.class, id);
    }

    public void update(Organization organization){
        em.persist(organization);
    }

    public void save(Organization organization) {
        em.persist(organization);
    }

    public void delete(Organization organization) {
        em.persist(organization);
    }


}
