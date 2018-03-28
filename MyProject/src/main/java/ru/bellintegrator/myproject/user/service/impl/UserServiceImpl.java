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

    UserDocsDAOImpl DAOUD = new UserDocsDAOImpl();
    CountriesDAOImpl DAOCOU = new CountriesDAOImpl();



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
        Countries countries = DAOCOU.getCountriesByCode(user.getCitizenshipCode());
        view.id = String.valueOf(user.getId());
        view.firstName = String.valueOf(user.getFirstName());
        view.secondName = String.valueOf(user.getSecondName());
        view.midleName = String.valueOf(user.getMidlleName());
        view.position = String.valueOf(user.getPosition());
        view.phone = String.valueOf(user.getPhone());
        view.docName = String.valueOf(userDocs.getDocName());
        view.docNumber = String.valueOf(userDocs.getDocNumber());
        view.docDate = String.valueOf(userDocs.getDocDate());
        view.citizenshipCode = String.valueOf(user.getCitizenshipCode());
        view.citizenshipName = countries.getName();
        view.isIdentified = Boolean.valueOf(user.getIdentified());

        logger.info(view.toString());
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
