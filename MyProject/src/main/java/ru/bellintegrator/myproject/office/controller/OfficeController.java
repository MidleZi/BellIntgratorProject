package ru.bellintegrator.myproject.office.controller;


import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.office.view.OfficeView;

import java.util.List;

public interface OfficeController {

    /**
     * Get all offices
     * @return JSON offices value
     */
    List<OfficeView> list(OfficeView view);

    Office getOfficeById(Long id);

    void update(OfficeView view);

    void save(OfficeView view);

    void delete(Long id);



}
