package ru.bellintegrator.myproject.office.dao;

import ru.bellintegrator.myproject.office.model.Office;

import java.util.List;

public interface OfficeDAO {

    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Office> all();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Office getOfficeById(Long id);

    /**
     * Обновить Organization
     *
     * @param office
     * @return
     */
    void update(Office office);

    /**
     * Сохранить Organization
     *
     * @param office
     */
    void save(Office office);

    /**
     * Сохранить Organization
     *
     * @param office
     */
    void delete(Office office);
}
