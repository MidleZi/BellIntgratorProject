package ru.bellintegrator.myproject.organization.controller;


import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import ru.bellintegrator.myproject.organization.view.ResponseView;

import java.util.List;

public interface OrganizationController {

    /**
     * Get all organizations
     * @return JSON organizations value
     */
    List<ResponseView> organizations(OrganizationFilterView view);

    ResponseView getOrganizationById(String id);

    ResponseView update (OrganizationView view);

    ResponseView save (OrganizationView view);

    ResponseView delete (String id);


}
