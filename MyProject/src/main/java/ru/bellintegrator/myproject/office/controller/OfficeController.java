package ru.bellintegrator.myproject.office.controller;


import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.office.view.OfficeResponseView;
import ru.bellintegrator.myproject.office.view.OfficeView;

import java.util.List;

public interface OfficeController {

    /**
     * Get all offices
     * @return JSON offices value
     */
    List<OfficeView> all(OfficeFilterView view);

    OfficeResponseView getOfficeById(Long id);

    OfficeResponseView update(OfficeView view);

    OfficeResponseView save(OfficeView view);

    OfficeResponseView delete(Long id);



}
