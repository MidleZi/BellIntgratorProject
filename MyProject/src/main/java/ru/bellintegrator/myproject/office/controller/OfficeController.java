package ru.bellintegrator.myproject.office.controller;


import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.office.view.OfficeView;
import ru.bellintegrator.myproject.utils.Response;

import java.util.List;

public interface OfficeController {

    /**
     * Get all offices
     * @return JSON offices value
     */
    public Response list(OfficeFilterView view);

    Office getOfficeById(Long id);

    void update(OfficeView view);

    void save(OfficeView view);

    void delete(Long id);



}
