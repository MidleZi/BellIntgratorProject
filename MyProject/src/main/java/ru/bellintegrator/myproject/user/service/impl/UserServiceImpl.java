package ru.bellintegrator.myproject.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import ru.bellintegrator.myproject.countries.dao.impl.CountriesDAO;
//import ru.bellintegrator.myproject.countries.Countries;
import ru.bellintegrator.myproject.countries.Countries;
import ru.bellintegrator.myproject.countries.CountriesDAO;
import ru.bellintegrator.myproject.docs.Docs;
import ru.bellintegrator.myproject.docs.DocsDAO;
import ru.bellintegrator.myproject.user.dao.impl.UserDAOImpl;
import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserView;
import ru.bellintegrator.myproject.user.service.UserService;
import ru.bellintegrator.myproject.userdocs.model.UserDocs;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDAOImpl DAO;

    private DocsDAO DAODD;

    private CountriesDAO DAOCount;

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
        UserView view = new UserView();
        User user = DAO.getUserById(id);
        view.id = String.valueOf(user.getId());
        view.firstName = String.valueOf(user.getFirstName());
        view.secondName = String.valueOf(user.getSecondName());
        view.midleName = String.valueOf(user.getMidleName());
        view.position = String.valueOf(user.getPosition());
        view.phone = String.valueOf(user.getPhone());
        view.docName = String.valueOf(user.getUserDocs().getDocs().getName());
        view.docNumber = String.valueOf(user.getUserDocs().getDocNumber());
        view.docDate = String.valueOf(user.getUserDocs().getDocDate());
        view.citizenshipCode = String.valueOf(user.getCountries().getCode());
        view.citizenshipName = String.valueOf(user.getCountries().getName());
        view.isIdentified = Boolean.valueOf(user.getIdentified());
        logger.info(view.toString());
        logger.info("User get ID:" + id);
        return view;

    }

    @Override
    @Transactional
    public void update(UserView view) {
        Docs docs = new Docs();
        Countries countries = new Countries(Long.parseLong(view.citizenshipCode), view.citizenshipName);

        List<Docs> docslist = DAODD.allDocs();
            if(docslist.contains(view.docName) == true){
                Docs doc = new Docs(view.docName);
                DAODD.save(doc);
            }

        List<Countries> countrieslist = DAOCount.allCountries();
            if(countrieslist.contains(view.citizenshipCode) == true) {
                Countries countr = new Countries(Long.parseLong(view.citizenshipCode), view.citizenshipName);
                DAOCount.save(countr);
            }

        UserDocs userDocs = new UserDocs(Long.parseLong(view.id), docs, view.docNumber, view.docDate);
        User user = new User(Long.parseLong(view.id), view.firstName, view.secondName, view.midleName, view.position,
                view.phone, userDocs, countries, view.isIdentified);
        logger.info("User update " + user.toString());
        DAO.update(user);
    }

    @Override
    @Transactional
    public void save(UserView view) {
        Docs docs = new Docs(view.docName);
        Countries countries = new Countries(Long.parseLong(view.citizenshipCode), view.citizenshipName);

        List<Docs> docslist = DAODD.allDocs();
            if(docslist.contains(view.docName) == false){
                docs.setName(view.docName);
                DAODD.save(docs);
            }

        List<Countries> countrieslist = DAOCount.allCountries();
            if(countrieslist.contains(view.citizenshipCode) == false){
                countries.setCode(Long.parseLong(view.citizenshipCode));
                countries.setName(view.citizenshipName);
                DAOCount.save(countries);
            }

        UserDocs userDocs = new UserDocs(docs, view.docNumber, view.docDate);
        User user = new User(view.firstName, view.secondName, view.midleName, view.position,
                view.phone, userDocs, countries, view.isIdentified);
        DAO.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        logger.info("User deleted ID:" + id);
        DAO.delete(id);
    }

}
