package ru.bellintegrator.myproject.organization.service;

import ru.bellintegrator.myproject.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService{

        /**
         *
         * @param organization
         */
        void add(OrganizationView organization);

        /**
         * Organization service method
         * @return {@Organization}
         */
        List<OrganizationView> organizations();
}
