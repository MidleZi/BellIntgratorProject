package ru.bellintegrator.myproject.services;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.myproject.MyApplication;
import ru.bellintegrator.myproject.office.dao.OfficeDAO;
import ru.bellintegrator.myproject.user.dao.UserDAO;
import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.service.UserService;
import ru.bellintegrator.myproject.user.view.UserFilterView;
import ru.bellintegrator.myproject.user.view.UserFilterViewList;
import ru.bellintegrator.myproject.user.view.UserView;

import java.util.List;

import static org.assertj.core.util.DateUtil.parse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserServiceTest {


    @Autowired
    UserService userService;
    @Autowired
    UserDAO userDAO;



    @Test
    public void testGetUserById() {
        UserView view = userService.getUserById(Long.parseLong("1"));
        Assert.assertNotNull(view);
        Assert.assertEquals("Василий", view.firstName);
    }

    @Test
    public void testList() {
        UserFilterView filter = new UserFilterView("Василий");
        List<UserFilterViewList> list = userService.list(filter);
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());

        UserFilterViewList response = list.get(0);
        Assert.assertEquals("Василий", response.getFirstName());
    }

    @Test
    public void testSaveUser(){
        UserView view = new UserView();

        view.firstName = "Гимли";
        view.secondName = "Гномов";
        view.midleName = "Гном";
        view.position = "Мастер";
        view.phone = "+7 (333) 333-33-33";
        view.docCode = 21L;
        view.docName = "Паспорт гражданина Российской Федерации";
        view.docNumber = "9999 999999";
        view.docDate = parse("2004-08-06");
        view.citizenshipName = "Российская Федерация";
        view.citizenshipCode = "643";
        view.isIdentified = true;

        userService.save(view);

        List<User> list = userDAO.getAllUser();

        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(9, list.size());
    }

    @Test
    public void testUpdateUser() {

        UserView view = new UserView();
        view.id = "1";
        view.firstName = "Гимли";
        view.secondName = "Гномов";
        view.midleName = "Гном";
        view.position = "Мастер";
        view.phone = "+7 (333) 333-33-33";
        view.docCode = 21L;
        view.docName = "Паспорт гражданина Российской Федерации";
        view.docNumber = "9999 999999";
        view.docDate = parse("2004-08-06");
        view.citizenshipName = "Российская Федерация";
        view.citizenshipCode = "643";
        view.isIdentified = true;

        userService.update(view);

        User user = userDAO.getUserById(1L);

        Assert.assertNotNull(user);
        Assert.assertEquals("Гимли", user.getFirstName());
    }

    @Test
    public void testDeleteUser(){

        userService.delete(4L);

        List<User> list = userDAO.getAllUser();

        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(8, list.size());
    }
}
