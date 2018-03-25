package ru.bellintegrator.myproject.user.dao;

import ru.bellintegrator.myproject.user.model.User;

import java.util.List;

public interface UserDAO {
    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<User> all();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * Обновить Organization
     *
     * @param user
     * @return
     */
    void update(User user);

    /**
     * Сохранить Organization
     *
     * @param user
     */
    void save(User user);

    /**
     * Сохранить Organization
     *
     * @param user
     */
    void delete(User user);
}
