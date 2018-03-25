package ru.bellintegrator.myproject.office.controller;


import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.myproject.office.view.OfficeView;

import java.util.List;

public interface OfficeController {

    /**
     * Add person
     * @param office
     */
    void office(@RequestBody OfficeView office);

    /**
     * Get all offices
     * @return JSON offices value
     */
    List<OfficeView> offices();



}
