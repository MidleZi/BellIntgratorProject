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
import ru.bellintegrator.myproject.userdocs.dao.impl.UserDocsDAOImpl;
import ru.bellintegrator.myproject.userdocs.model.UserDocs;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {


    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDAOImpl DAO;
    private final UserDocsDAOImpl DAOUD;

    @Autowired
    public UserServiceImpl(UserDAOImpl dao, UserDocsDAOImpl daoud) {
        this.DAO = dao;
        DAOUD = daoud;
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

            logger.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapUser)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserView getUserById(Long id) {
        logger.info("User get ID:" + id);
        UserView view = new UserView();
        User user = DAO.getUserById(id);
        UserDocs userDocs = DAOUD.getUserDocsById(id);
        view.id = String.valueOf(user.getId());
        view.firstName = String.valueOf(user.getFirstName());
        view.docName = String.valueOf(userDocs.getDocName());
        return view;
    }

    @Override
    @Transactional
    public void update(UserView view) {
        User user = new User(Long.parseLong(view.id), view.firstName, view.secondName, view.midleName, view.position, view.phone, view.isIdentified);
        logger.info("User update " + user.toString());
        DAO.update(user);
    }

    @Override
    @Transactional
    public void save(UserView view) {
        User user = new User(view.firstName, view.secondName, view.midleName, view.position, view.phone, view.isIdentified);
        UserDocs userDocs = new UserDocs(view.docName, view.docNumber, view.docDate);
        logger.info("User save " + user.toString());
        DAO.save(user);
        DAOUD.save(userDocs);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = new User(id);
        DAO.delete(user);
        logger.info("User deleted ID:" + id);
    }



}
