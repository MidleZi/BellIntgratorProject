package ru.bellintegrator.myproject.user.controller;

import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserView;

import java.util.List;

public interface UserController {

    /**
     * Get all offices
     * @return JSON offices value
     */
    List<UserView> all(UserView view);

    User getUserById(Long id);

    void update(UserView view);

    void save(UserView view);

    void delete(Long id);
}
