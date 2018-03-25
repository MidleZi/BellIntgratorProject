package ru.bellintegrator.myproject.user.service;

import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.myproject.organization.view.OrganizationResponseView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import ru.bellintegrator.myproject.user.view.UserResponseView;
import ru.bellintegrator.myproject.user.view.UserView;

import java.util.List;

public interface UserService {

    /**
     * Organization service method
     * @return {@User}
     */
    List<UserView> all();


    UserResponseView getUserById(Long id);

    UserResponseView update(UserView view);

    UserResponseView save(UserView view);

    UserResponseView delete(Long id);
}