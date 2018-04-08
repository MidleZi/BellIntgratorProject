package ru.bellintegrator.myproject.user.controller;


import ru.bellintegrator.myproject.user.view.UserFilterView;
import ru.bellintegrator.myproject.user.view.UserView;
import ru.bellintegrator.myproject.utils.Response;


public interface UserController {

    /**
     * Get all offices
     * @return JSON offices value
     */
    Response list(UserFilterView view);

    Response getUserById(Long id);

    Response update(UserView view);

    Response save(UserView view);

    Response delete(Long id);
}
