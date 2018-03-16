package ru.bellintegrator.myproject.users.service;

import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.myproject.users.view.UsersView;

import java.util.List;

public interface UsersService {

    /**
     *
     * @param users
     */
    void add(@RequestBody UsersView users);

    /**
     * Users service method
     * @return {@Users}
     */
    List<UsersView> user();
}
