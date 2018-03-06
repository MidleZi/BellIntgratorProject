package ru.bellintegrator.myProject.organization.controller;

import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.myProject.organization.view.OrganizationView;


import java.util.List;

public interface OrganizationController {

    /**
     * Add person
     * @param organization
     */
    void organization(@RequestBody OrganizationView organization);

    /**
     * Get all organizations
     * @return JSON organizations value
     */
    List<OrganizationView> organizations();
}
