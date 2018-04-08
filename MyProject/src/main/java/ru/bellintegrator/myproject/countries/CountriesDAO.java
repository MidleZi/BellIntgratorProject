package ru.bellintegrator.myproject.countries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CountriesDAO{

    private EntityManager em;
    private final Logger logger = LoggerFactory.getLogger(ru.bellintegrator.myproject.countries.CountriesDAO.class);

    public CountriesDAO(EntityManager em) {
        this.em = em;
    }

    public List<Countries> allCountries() {
        TypedQuery<Countries> query = em.createNamedQuery("Countries.findAll", Countries.class);
        List<Countries> result = query.getResultList();

        return result;
    }

    public Countries getCountriesByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Countries> criteria = builder.createQuery(Countries.class);

        Root<Countries> account = criteria.from(Countries.class);
        criteria.where(builder.equal(account.get("name"), name));

        TypedQuery<Countries> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    public void save(Countries contries) {
        em.persist(contries);
    }

}
