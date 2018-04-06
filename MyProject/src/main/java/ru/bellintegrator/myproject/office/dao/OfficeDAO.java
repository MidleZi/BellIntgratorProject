package ru.bellintegrator.myproject.office.dao;

import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.office.view.OfficeFilterView;

import java.util.List;

public interface OfficeDAO {

    List<Office> getAllOffice();

    List<Office> list(OfficeFilterView filter);

    Office getOfficeById(Long id);

    void update(Office office);

    void save(Office office);

    void delete(Office office);
}
