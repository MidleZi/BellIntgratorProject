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
    List<OrganizationView> all(OrganizationFilterView view);

    OrganizationResponseView getOrganizationById(String id);

    OrganizationResponseView update(OrganizationView view);

    OrganizationResponseView save(OrganizationView view);

    OrganizationResponseView delete(String id);


}
