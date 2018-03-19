package ru.bellintegrator.myproject.organization.service;

import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import ru.bellintegrator.myproject.organization.view.ResponseView;

import java.util.List;

public interface OrganizationService{

        /**
         * Organization service method
         * @return {@Organization}
         */
        List<OrganizationView> organization();


        void getOrganizationById(String id);

        void update(OrganizationView view);

        void save(OrganizationView view);

        void delete(String id);


}
