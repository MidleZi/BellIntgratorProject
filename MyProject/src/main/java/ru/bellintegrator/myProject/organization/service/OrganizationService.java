package ru.bellintegrator.myProject.organization.service;

import ru.bellintegrator.myProject.organization.view.OrganizationView;

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
