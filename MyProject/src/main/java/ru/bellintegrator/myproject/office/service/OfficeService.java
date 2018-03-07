package ru.bellintegrator.myproject.office.service;

import ru.bellintegrator.myproject.office.view.OfficeView;

import java.util.List;

public interface OfficeService {

    /**
     *
     * @param office
     */
    void add(OfficeView office);

    /**
     * Organization service method
     * @return {@Office}
     */
    List<OfficeView> offices();
}
