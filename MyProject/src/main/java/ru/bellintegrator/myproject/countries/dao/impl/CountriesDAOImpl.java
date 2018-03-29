package ru.bellintegrator.myproject.countries.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bellintegrator.myproject.countries.dao.CountriesDAO;
import ru.bellintegrator.myproject.countries.model.Countries;

import javax.persistence.EntityManager;
import java.util.List;


public class CountriesDAOImpl implements CountriesDAO{

    private EntityManager em;
    private final Logger logger = LoggerFactory.getLogger(CountriesDAOImpl.class);

    public CountriesDAOImpl(EntityManager em) {
        this.em = em;
    }

    public CountriesDAOImpl() {
    }

    @Override
    public List<Countries> list() {
        return null;
    }

    @Override
    public Countries getCountriesByCode(Long code){
        logger.info("Countries get code:" + code);
        return em.find(Countries.class, code);
    }

    @Override
    public void update(Countries contries) {

    }

    @Override
    public void save(Countries contries) {

    }

    @Override
    public void delete(Countries contries) {

    }
}
