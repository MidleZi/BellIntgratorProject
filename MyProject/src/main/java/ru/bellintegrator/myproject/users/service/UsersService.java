package ru.bellintegrator.myproject.users.service;

import ru.bellintegrator.myproject.users.view.UsersView;

import java.util.List;

public interface UsersService {

    /**
     *
     * @param users
     */
    void add(UsersView users);

    /**
     * Users service method
     * @return {@Users}
     */
    List<UsersView> user();
}
