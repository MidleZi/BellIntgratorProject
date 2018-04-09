package ru.bellintegrator.myproject.organization.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    private final Logger logger = LoggerFactory.getLogger(OrganizationDAOImpl.class);

    private final EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> getAllOrganizations() {
        TypedQuery<Organization> query = em.createNamedQuery("Organization.findAll", Organization.class);
        List<Organization> result = query.getResultList();

        return result;
    }

    @Override
    public Organization getOrganizationByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> organization = criteria.from(Organization.class);
        criteria.where(builder.equal(organization.get("name"), name));

        TypedQuery<Organization> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    @Override
    public List<Organization> list(OrganizationFilterView filter) {
        OrgCriteriaConverter converter = new OrgCriteriaConverter(filter);
        CriteriaQuery cq = converter.getCriteriaQuery();
        Root<Organization> organizations = converter.getRoot();
        List<Predicate> predicates = converter.getPredicates();

        cq.select(organizations)
                .where(predicates.toArray(new Predicate[]{}));

        logger.info("Geted List" + em.createQuery(cq).getResultList() );

        return em.createQuery(cq).getResultList();
    }

    @Override
    public Organization getOrganizationById(Long id){
        logger.info("Organization get ID:  " + id);
        return em.find(Organization.class, id);
    }

    @Override
    public void update(Organization organization){
        logger.info("Organization update " + organization.toString());
        em.merge(organization);
    }

    @Override
    public void save(Organization organization) {
        logger.info("save:" + organization.toString());
        em.persist(organization);
    }

    @Override
    public void delete(Long id) {
        logger.info("Organization deleted ID:" + id);
        em.remove(getOrganizationById(id));
    }

    private class OrgCriteriaConverter {
        private final OrganizationFilterView filter;

        private final List<Predicate> predicates = new ArrayList<>();
        private Root<Organization> organizations;
        private CriteriaQuery criteriaQuery;

        public OrgCriteriaConverter(OrganizationFilterView filter) {
            this.filter = filter;
            makePredicates();
        }

        private void makePredicates() {
            String name = filter.name;
            String inn = filter.inn;
            Boolean isActive = filter.isActive;

            CriteriaBuilder qb = em.getCriteriaBuilder();
            criteriaQuery = qb.createQuery();
            organizations = criteriaQuery.from(Organization.class);

            if (name != null) {
                predicates.add(
                        qb.like(organizations.get("name"), "%" + name + "%"));
            }
            if (inn != null) {
                predicates.add(
                        qb.equal(organizations.get("inn"), inn));
            }
            if (isActive != null) {
                predicates.add(
                        qb.equal(organizations.get("isActive"), isActive));
            }
        }


        public List<Predicate> getPredicates() {
            return predicates;
        }

        public Root<Organization> getRoot() {
            return organizations;
        }

        public CriteriaQuery getCriteriaQuery() {
            return criteriaQuery;
        }

    }

}
