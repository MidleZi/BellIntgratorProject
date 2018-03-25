package ru.bellintegrator.myproject.user.controller;

import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.office.view.OfficeResponseView;
import ru.bellintegrator.myproject.office.view.OfficeView;
import ru.bellintegrator.myproject.user.view.UserFilterView;
import ru.bellintegrator.myproject.user.view.UserResponseView;
import ru.bellintegrator.myproject.user.view.UserView;

import java.util.List;

public interface UserController {

    /**
     * Get all offices
     * @return JSON offices value
     */
    List<UserView> all(UserFilterView view);

    UserResponseView getUserById(String id);

    UserResponseView update(UserView view);

    UserResponseView save(UserView view);

    UserResponseView delete(String id);
}
