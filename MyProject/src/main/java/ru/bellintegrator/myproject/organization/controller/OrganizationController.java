package ru.bellintegrator.myproject.organization.controller;


import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationController {

    /**
     * Get all organizations
     * @return JSON organizations value
     */
    List<OrganizationView> all(OrganizationView view);

    Organization getOrganizationById(Long id);

    void update(OrganizationView view);

    void save(OrganizationView view);

    void delete(Long id);


}
