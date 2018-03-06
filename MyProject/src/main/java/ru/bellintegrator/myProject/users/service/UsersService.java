package ru.bellintegrator.myProject.users.service;

import ru.bellintegrator.myProject.users.view.UsersView;

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
