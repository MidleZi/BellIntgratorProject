package ru.bellintegrator.myproject.countries.dao;

import ru.bellintegrator.myproject.countries.model.Countries;

import java.util.List;

public interface CountriesDAO {

    List<Countries> list();

    Countries getCountriesByCode(Long code);

    void update(Countries contries);

    void save(Countries contries);

    void delete(Countries contries);
}
