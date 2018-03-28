package ru.bellintegrator.myproject.office.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.office.dao.OfficeDAO;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.office.service.impl.OfficeServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OfficeDAOImpl implements OfficeDAO {

    private final EntityManager em;
    private final Logger logger = LoggerFactory.getLogger(OfficeDAOImpl.class);

    @Autowired
    public OfficeDAOImpl(EntityManager em){
        this.em = em;
    }

    public List<Office> list(){
        TypedQuery<Office> query = em.createQuery("SELECT h FROM House h", Office.class);
        return query.getResultList();

    }

    public Office getOfficeById(Long id) {
        logger.info("Office get ID:" + id);
        return em.find(Office.class, id);
    }

    public void update(Office office){
        logger.info("Office update " + office.toString());
        em.merge(office);
    }

    public void save(Office office) {
        logger.info("Office save " + office.toString());
        em.persist(office);
    }

    public void delete(Office office) {
        logger.info("Office deleted ID:" + office.getId());
        em.remove(office);
    }
}
