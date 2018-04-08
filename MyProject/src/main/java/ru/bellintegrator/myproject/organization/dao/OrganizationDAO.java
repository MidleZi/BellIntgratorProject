package ru.bellintegrator.myproject.organization.dao;

import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import java.util.List;

public interface OrganizationDAO {

    List<Organization> getAllOrganizations();

    List<Organization> list(OrganizationFilterView filter);

    Organization getOrganizationById(Long id);

    void update(Organization organization);

    void save(Organization organization);

    void delete(Long id);

}
