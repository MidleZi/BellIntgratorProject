package ru.bellintegrator.myproject.user.service;

import ru.bellintegrator.myproject.user.view.UserFilterView;
import ru.bellintegrator.myproject.user.view.UserFilterViewList;
import ru.bellintegrator.myproject.user.view.UserView;
import java.util.List;

public interface UserService {

    public List<UserView> getAllUser();

    public List<UserFilterViewList> list(UserFilterView filterView);

    UserView getUserById(Long id);

    void update(UserView view);

    void save(UserView view);

    void delete(Long id);
}