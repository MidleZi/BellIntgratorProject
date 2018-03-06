package ru.bellintegrator.myProject.office.service;

import ru.bellintegrator.myProject.office.view.OfficeView;

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
