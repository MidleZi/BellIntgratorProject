package ru.bellintegrator.myProject.users.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myProject.users.dao.UsersDAO;
import ru.bellintegrator.myProject.users.model.Users;
import ru.bellintegrator.myProject.users.view.UsersView;
import ru.bellintegrator.myProject.users.service.UsersService;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UsersServiceImpl implements UsersService {


    private final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

    private final UsersDAO dao;

    @Autowired
    public UsersServiceImpl(UsersDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void add(UsersView view) {
        Users users = new Users(view.firstName, view.secondName);
        dao.save(users);
    }


    @Override
    @Transactional(readOnly = true)
    public List<UsersView> user() {
        List<Users> all = dao.all();

        Function<Users, UsersView> mapPerson = o -> {
            UsersView view = new UsersView();
            view.id = String.valueOf(o.getId());
            view.firstName = o.getFirstName();
            view.secondName = o.getSecondName();

            log.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapPerson)
                .collect(Collectors.toList());
    }



}
