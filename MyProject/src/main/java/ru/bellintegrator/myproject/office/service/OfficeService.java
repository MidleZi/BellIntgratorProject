package ru.bellintegrator.myproject.office.service;

import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.office.view.OfficeFilterViewList;
import ru.bellintegrator.myproject.office.view.OfficeView;

import java.util.List;

public interface OfficeService {

    /**
     * Organization service method
     * @return {@Office}
     */
    public List<OfficeFilterViewList> list(OfficeFilterView filterView);

    Office getOfficeById(Long id);

    void update(OfficeView view);

    void save(OfficeView view);

    void delete(Long id);

}
