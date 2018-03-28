package ru.bellintegrator.myproject.countries.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bellintegrator.myproject.countries.model.Countries;

import javax.persistence.EntityManager;


public class CountriesDAOImpl {

    private EntityManager em;
    private final Logger logger = LoggerFactory.getLogger(CountriesDAOImpl.class);

    public CountriesDAOImpl(EntityManager em) {
        this.em = em;
    }

    public CountriesDAOImpl() {
    }

    public Countries getCountriesByCode(Long code){
        logger.info("Countries get code:" + code);
        return em.find(Countries.class, code);
    }
}
