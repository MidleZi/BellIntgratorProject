package ru.bellintegrator.myproject.organization.service;

import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterViewList;
import ru.bellintegrator.myproject.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService{

    List<OrganizationView> getAllOrganization();

    List<OrganizationFilterViewList> list(OrganizationFilterView filterView);

    Organization getOrganizationById(Long id);

    void update(OrganizationView view);

    void save(OrganizationView view);

    void delete(Long id);


}
