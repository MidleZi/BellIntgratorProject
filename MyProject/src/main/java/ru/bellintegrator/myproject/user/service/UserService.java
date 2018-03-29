package ru.bellintegrator.myproject.user.service;

import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserView;

import java.util.List;

public interface UserService {

    /**
     * Organization service method
     * @return {@User}
     */
    List<UserView> list();


    UserView getUserById(Long id);

    void update(UserView view);

    void save(UserView view);

    void delete(Long id);
}