package ru.bellintegrator.myproject.office.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.office.dao.OfficeDAO;
import ru.bellintegrator.myproject.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OfficeDAOImpl implements OfficeDAO {

    private final EntityManager em;

    @Autowired
    public OfficeDAOImpl(EntityManager em){
        this.em = em;
    }

    public List<Office> all(){
        TypedQuery<Office> query = em.createQuery("SELECT h FROM House h", Office.class);
        return query.getResultList();

    }

    public Office getOfficeById(String id) {
        return em.find(Office.class, id);
    }

    public void update(Office office){
        em.merge(office);
    }

    public void save(Office office) {
        em.persist(office);
    }

    public void delete(Office office) {
        em.remove(office);
    }
}
