package ru.bellintegrator.myproject.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myproject.countries.dao.impl.CountriesDAOImpl;
import ru.bellintegrator.myproject.countries.model.Countries;
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

    @Autowired
    public UserServiceImpl(UserDAOImpl dao) {
        this.DAO = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserView> list() {
        UserView view = new UserView();
        return (List<UserView>) view;

    }

    @Override
    @Transactional
    public UserView getUserById(Long id) {
        logger.info("User get ID:" + id);
        UserView view = new UserView();
        User user = DAO.getUserById(id);
        view.id = String.valueOf(user.getId());
        view.firstName = String.valueOf(user.getFirstName());
        view.secondName = String.valueOf(user.getSecondName());
        view.midleName = String.valueOf(user.getMidlleName());
        view.position = String.valueOf(user.getPosition());
        view.phone = String.valueOf(user.getPhone());
        view.docName = String.valueOf(user.getUserDocs().getDocs().getName());
        view.docNumber = String.valueOf(user.getUserDocs().getDocNumber());
        view.docDate = String.valueOf(user.getUserDocs().getDocDate());
        view.citizenshipCode = String.valueOf(user.getCountries().getCode());
        view.citizenshipName = String.valueOf(user.getCountries().getName());
        view.isIdentified = Boolean.valueOf(user.getIdentified());

        logger.info(view.toString());
        return view;
    }

    @Override
    @Transactional
    public void update(UserView view) {
       /* User user = new User(Long.parseLong(view.id), view.firstName, view.secondName, view.midleName, view.position, view.phone, view.isIdentified);
        logger.info("User update " + user.toString());
        DAO.update(user);*/
    }

    @Override
    @Transactional
    public void save(UserView view) {
      /*  User user = new User(view.firstName, view.secondName, view.midleName, view.position, view.phone, view.isIdentified);
        UserDocs userDocs = new UserDocs(view.docName, view.docNumber, view.docDate);
        logger.info("User save " + user.toString());
        DAO.save(user);
        DAOUD.save(userDocs);*/
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = new User(id);
        DAO.delete(user);
        logger.info("User deleted ID:" + id);
    }

}
