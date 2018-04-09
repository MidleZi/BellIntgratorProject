package ru.bellintegrator.myproject.dao;

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
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.user.dao.UserDAO;
import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserFilterView;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OfficeDAO officeDAO;

    String testName = "testName";
    User saveTestUser = new User(testName);
    List<User> users = userDAO.getAllUser();


    @Test
    public void testList() {
        UserFilterView criteria = new UserFilterView("Василий");
        List<User> usersByCriteria = userDAO.list(criteria);
        Assert.assertNotNull(usersByCriteria);
        Assert.assertEquals(1, usersByCriteria.size());
    }
    @Test
    public void testSave() {
        Office office = officeDAO.getOfficeById(1L);
        saveTestUser.setOffice(office);
        userDAO.save(saveTestUser);
        users = userDAO.getAllUser();
        Assert.assertEquals(3, users.size());
    }

    @Test
    public void testUpdate() {
        User updateTestUser = userDAO.getUserByName(testName);
        Assert.assertNotNull(updateTestUser);
        String nameForUpdate = "newTestName";
        updateTestUser.setFirstName(nameForUpdate);
        userDAO.update(updateTestUser);
        User userAfterUpdate = userDAO.getUserByName(nameForUpdate);
        Assert.assertNotNull(userAfterUpdate);
    }

    @Test
    public void testDelete() {
        userDAO.delete(1L);
        users = userDAO.getAllUser();
        Assert.assertEquals(2, users.size());
    }
}
