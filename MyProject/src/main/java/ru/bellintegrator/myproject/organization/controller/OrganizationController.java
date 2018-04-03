package ru.bellintegrator.myproject.organization.controller;


import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import ru.bellintegrator.myproject.utils.Response;
import ru.bellintegrator.myproject.utils.ResponseViewData;

public interface OrganizationController {

    /**
     * Get all organizations
     * @return JSON organizations value
     */
    Response list(OrganizationFilterView view);

    Organization getOrganizationById(Long id);

    void update(OrganizationView view);

    void save(OrganizationView view);

    void delete(Long id);
}
