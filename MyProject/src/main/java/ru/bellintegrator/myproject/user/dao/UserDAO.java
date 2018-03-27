package ru.bellintegrator.myproject.user.dao;

import ru.bellintegrator.myproject.user.model.User;

import java.util.List;

public interface UserDAO {

    List<User> all();

    User getUserById(Long id);

    void update(User user);

    void save(User user);

    void delete(User user);
}
