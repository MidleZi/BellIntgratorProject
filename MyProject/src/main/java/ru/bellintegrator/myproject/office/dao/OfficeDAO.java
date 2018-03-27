package ru.bellintegrator.myproject.office.dao;

import ru.bellintegrator.myproject.office.model.Office;

import java.util.List;

public interface OfficeDAO {


    List<Office> list();


    Office getOfficeById(Long id);

    void update(Office office);

    void save(Office office);

    void delete(Office office);
}
