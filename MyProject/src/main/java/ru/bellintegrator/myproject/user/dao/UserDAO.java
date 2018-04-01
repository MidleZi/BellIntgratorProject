package ru.bellintegrator.myproject.user.dao;

import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserView;

import java.util.List;

public interface UserDAO {

    List<User> list();

    User getUserById(Long id);

    void update(User user);

    void save(User user);

    void delete(UserView user);
}
