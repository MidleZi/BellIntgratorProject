package ru.bellintegrator.myproject.countries.dao;

import ru.bellintegrator.myproject.countries.model.Countries;

import java.util.List;

public interface CountriesDAO {

    List<Countries> list();

    Countries getUserDocsById(Long id);

    void update(Countries contries);

    void save(Countries contries);

    void delete(Countries contries);
}
