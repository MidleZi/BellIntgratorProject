package ru.bellintegrator.myproject.users.dao;

import ru.bellintegrator.myproject.users.model.Users;

import java.util.List;

public interface UsersDAO {
    /**
     * Получить все объекты Users
     *
     * @return
     */
    List<Users> all();

    /**
     * Получить Users по идентификатору
     *
     * @param id
     * @return
     */
    Users loadById(Long id);

    /**
     * Обновить Users
     *
     * @param users
     * @return
     */
    void update(Users users);

    /**
     * Сохранить Users
     *
     * @param users
     */
    void save(Users users);

    /**
     * Сохранить Users
     *
     * @param users
     */
    void delete(Users users);
}
