package ru.bellintegrator.myproject.user.dao;

import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserFilterView;
import java.util.List;

public interface UserDAO {

    List<User> getAllUser();

    User getUserByName(String name);

    List<User> list(UserFilterView filter);

    User getUserById(Long id);

    void update(User user);

    void save(User user);

    void delete(Long id);
}
