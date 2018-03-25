package ru.bellintegrator.myproject.organization.controller;


import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationResponseView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationController {

    /**
     * Get all organizations
     * @return JSON organizations value
     */
    List<OrganizationView> all(OrganizationView view);

    OrganizationResponseView getOrganizationById(Long id);

    OrganizationResponseView update(OrganizationView view);

    OrganizationResponseView save(OrganizationView view);

    OrganizationResponseView delete(Long id);


}
