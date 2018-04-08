package ru.bellintegrator.myproject.organization.controller;


import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import ru.bellintegrator.myproject.utils.Response;


public interface OrganizationController {

    /**
     * Get all organizations
     * @return JSON organizations value
     */
    Response list(OrganizationFilterView view);

    Response getOrganizationById(Long id);

    Response update(OrganizationView view);

    Response save(OrganizationView view);

    Response delete(Long id);
}
