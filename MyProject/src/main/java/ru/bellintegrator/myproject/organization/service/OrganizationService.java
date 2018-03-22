package ru.bellintegrator.myproject.organization.service;

import ru.bellintegrator.myproject.organization.view.OrganizationResponseView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService{

        /**
         * Organization service method
         * @return {@Organization}
         */
        List<OrganizationView> all();


    OrganizationResponseView getOrganizationById(String id);

    OrganizationResponseView update(OrganizationView view);

    OrganizationResponseView save(OrganizationView view);

    OrganizationResponseView delete(String id);


}
