package ru.bellintegrator.myproject.user.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.LoggerFactory;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myproject.countries.Countries;
import ru.bellintegrator.myproject.countries.CountriesDAO;
import ru.bellintegrator.myproject.docs.Docs;
import ru.bellintegrator.myproject.docs.DocsDAO;
import ru.bellintegrator.myproject.office.dao.impl.OfficeDAOImpl;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.user.controller.impl.UserControllerImpl;
import ru.bellintegrator.myproject.user.dao.impl.UserDAOImpl;
import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserFilterView;
import ru.bellintegrator.myproject.user.view.UserFilterViewList;
import ru.bellintegrator.myproject.user.view.UserView;
import ru.bellintegrator.myproject.user.service.UserService;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    protected static Logger logger = Logger.getLogger(UserControllerImpl.class.getName());

    private final UserDAOImpl dao;
    private final DocsDAO daoDD;
    private final CountriesDAO daoCount;
    private final OfficeDAOImpl daoOffice;

    @Autowired
    public UserServiceImpl(UserDAOImpl dao, DocsDAO daoDD, CountriesDAO daoCout, OfficeDAOImpl daoOffice) {
        this.dao = dao;
        this.daoDD = daoDD;
        this.daoCount = daoCout;
        this.daoOffice = daoOffice;
    }


    @Override
    @Transactional(readOnly = true)
    public List<UserFilterViewList> list(UserFilterView filterView) {
        List<User> users = dao.list(filterView);
        List<UserFilterViewList> outList = new ArrayList();

        for (int i = 0; i < users.size() ; i++) {
            UserFilterViewList listOut = new UserFilterViewList();
            listOut.setId(users.get(i).getId());
            listOut.setFirstName(users.get(i).getFirstName());
            listOut.setSecondName(users.get(i).getSecondName());
            listOut.setMidleName(users.get(i).getMidleName());
            listOut.setPosition(users.get(i).getPosition());

            outList.add(i, listOut);

        }

        return outList;
    }



    @Override
    @Transactional
    public UserView getUserById(Long id) {

        UserView view = new UserView();
        User user = dao.getUserById(id);

        if(user == null) throw new ServiceException("Сотрудника с  id " + id + " не существует");

        view.id = String.valueOf(user.getId());
        view.firstName = String.valueOf(user.getFirstName());
        view.secondName = String.valueOf(user.getSecondName());
        view.midleName = String.valueOf(user.getMidleName());
        view.position = String.valueOf(user.getPosition());
        view.phone = String.valueOf(user.getPhone());
        view.docName = String.valueOf(user.getDocs().getName());
        view.docNumber = String.valueOf(user.getDocNumber());
        view.docDate = user.getDocDate();
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
        Long updateID = Long.parseLong(view.id);
        if (updateID == null) throw new ServiceException("Не указан id");

        User user = dao.getUserById(updateID);
        if (user == null) throw new ServiceException("Сотрудника с ID " + updateID + " нету в базе");

        Docs docs = null;
        if (view.docName != null) {
            List<Docs> docslist = daoDD.allDocs();
            if (docslist.contains(view.docName) == true) {
                Docs doc = new Docs(view.docName);
                daoDD.save(doc);
            }

            docs = daoDD.getDocumentByName(view.docName);
        }

        Countries countries = null;
        if (view.citizenshipCode != null){
            List<Countries> countrieslist = daoCount.allCountries();
            if (countrieslist.contains(view.citizenshipCode) == true) {
                Countries countr = new Countries (view.citizenshipCode, view.citizenshipName);
                daoCount.save(countr);
            }

            countries = daoCount.getCountriesByName(view.citizenshipName);
        }


        user = view.toConvertUserEntity(user,docs,countries);
        logger.info("User update " + user.toString());
        dao.update(user);
    }

    @Override
    @Transactional
    public void save(UserView view) {

        Docs docs = null;
        if (view.docName != null) docs = daoDD.getDocumentByName(view.docName);

        Countries countries = null;
        if (view.citizenshipCode != null) countries = daoCount.getCountriesByName(view.citizenshipName);

        User user = view.toConvertUserEntity(/*office,*/ docs, countries);
        logger.info("User save " + user.toString());
        dao.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = dao.getUserById(id);
        if(user == null) throw new ServiceException("Сотрудника с id " + id + " не существует");
        logger.info("User deleted ID:" + id);
        dao.delete(id);
    }

}
