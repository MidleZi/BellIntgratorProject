package ru.bellintegrator.myproject.users.controller;

import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.myproject.users.view.UsersView;

import java.util.List;

public interface UsersController {

    /**
     * Add users
     * @param users
     */
    void users(@RequestBody UsersView users);

    /**
     * Get all user
     * @return JSON user value
     */
    List<UsersView> user();
}
