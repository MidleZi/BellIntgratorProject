package ru.bellintegrator.myproject.user.controller;


import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserFilterView;
import ru.bellintegrator.myproject.user.view.UserView;
import ru.bellintegrator.myproject.utils.Response;

import java.util.List;


public interface UserController {

    /**
     * Get all offices
     * @return JSON offices value
     */
    Response getAllUser();

    Response list(UserFilterView view);

    Response getUserById(Long id);

    Response update(UserView view);

    Response save(UserView view);

    Response delete(Long id);
}
