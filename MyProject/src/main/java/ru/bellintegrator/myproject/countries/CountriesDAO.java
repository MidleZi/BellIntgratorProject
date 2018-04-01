package ru.bellintegrator.myproject.countries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bellintegrator.myproject.countries.Countries;
import ru.bellintegrator.myproject.docs.Docs;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


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

    public void save(Countries contries) {
        em.persist(contries);
    }

}
