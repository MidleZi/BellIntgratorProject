package ru.bellintegrator.myproject.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myproject.user.dao.impl.UserDAOImpl;
import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserView;
import ru.bellintegrator.myproject.user.service.UserService;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {


    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDAOImpl DAO;

    @Autowired
    public UserServiceImpl(UserDAOImpl dao) {
        this.DAO = dao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<UserView> all() {
        List<User> all = DAO.all();

        Function<User, UserView> mapUser = p->{
            UserView view = new UserView();
            view.office = p.getOffice();
            view.firstName = p.getFirstName();
            view.secondName = p.getSecondName();

            log.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapUser)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
       return DAO.getUserById(id);

    }

    @Override
    @Transactional
    public void update(UserView view) {
        User user = new User();
        DAO.update(user);
    }

    @Override
    @Transactional
    public void save(UserView view) {
        User user = new User();
        DAO.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = new User();
        DAO.delete(user);
    }



}
