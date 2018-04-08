package ru.bellintegrator.myproject.office.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.office.dao.OfficeDAO;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OfficeDAOImpl implements OfficeDAO {

    private final EntityManager em;
    private final Logger logger = LoggerFactory.getLogger(OfficeDAOImpl.class);

    @Autowired
    public OfficeDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public List<Office> getAllOffice() {
        TypedQuery<Office> query = em.createNamedQuery("Office.findAll", Office.class);
        List<Office> result = query.getResultList();

        return result;
    }

    @Override
    public List<Office> list(OfficeFilterView filter){
        OfficeCriteriaConverter converter = new OfficeCriteriaConverter(filter);
        CriteriaQuery cq = converter.getCriteriaQuery();
        Root<Office> office = converter.getRoot();
        List<Predicate> predicates = converter.getPredicates();

        cq.select(office)
                .where(predicates.toArray(new Predicate[]{}));

        logger.info("Geted List" + em.createQuery(cq).getResultList() );

        return em.createQuery(cq).getResultList();
    }

    @Override
    public Office getOfficeById(Long id) {
        logger.info("Office get ID:" + id);
        return em.find(Office.class, id);
    }

    @Override
    public void update(Office office){
        logger.info("Office update " + office.toString());
        em.merge(office);
    }

    @Override
    public void save(Office office) {
        logger.info("Office save " + office.toString());
        em.persist(office);
    }

    @Override
    public void delete(Office office) {
        logger.info("Office deleted ID:" + office.getId());
        em.remove(office);
    }

    private class OfficeCriteriaConverter {
        private final OfficeFilterView filter;

        private final List<Predicate> predicates = new ArrayList<>();
        private Root<Office> office;
        private CriteriaQuery criteriaQuery;

        public OfficeCriteriaConverter(OfficeFilterView filter) {
            this.filter = filter;
            makePredicates();
        }

        private void makePredicates() {
            String orgId = filter.orgId;
            String name = filter.name;
            String phone = filter.phone;
            Boolean isActive = filter.isActive;

            CriteriaBuilder qb = em.getCriteriaBuilder();
            criteriaQuery = qb.createQuery();
            office = criteriaQuery.from(Office.class);

            if(orgId != null){
                predicates.add(
                        qb.equal(office.get("organization").get("id"), orgId));
            }

            if (name != null) {
                predicates.add(
                        qb.like(office.<String>get("name"), "%" + name + "%"));
            }
            if (phone != null) {
                predicates.add(
                        qb.equal(office.<String>get("phone"), phone));
            }
            if (isActive != null) {
                predicates.add(
                        qb.equal(office.get("isActive"), isActive));
            }
        }


        public List<Predicate> getPredicates() {
            return predicates;
        }

        public Root<Office> getRoot() {
            return office;
        }

        public CriteriaQuery getCriteriaQuery() {
            return criteriaQuery;
        }

    }
}
