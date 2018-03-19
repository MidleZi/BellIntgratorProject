package ru.bellintegrator.myproject.organization.dao;

import ru.bellintegrator.myproject.organization.model.Organization;

import java.util.List;

public interface OrganizationDAO {

    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> all();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization getOrganizationById(String id);

    /**
     * Обновить Organization
     *
     * @param organization
     * @return
     */
    void update(Organization organization);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void delete(Organization organization);

}
