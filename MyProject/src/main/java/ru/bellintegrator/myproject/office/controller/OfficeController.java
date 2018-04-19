package ru.bellintegrator.myproject.office.controller;


import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.office.view.OfficeView;
import ru.bellintegrator.myproject.utils.Response;


public interface OfficeController {

    /**
     * Get all offices
     * @return JSON offices value
     */
    public Response getAllOffice();

    Response list(OfficeFilterView view);

    Response getOfficeById(Long id);

    Response update(OfficeView view);

    Response save(OfficeView view);

    Response delete(Long id);



}
