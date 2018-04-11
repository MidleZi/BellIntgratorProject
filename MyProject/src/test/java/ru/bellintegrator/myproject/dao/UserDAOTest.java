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
import ru.bellintegrator.myproject.countries.Countries;
import ru.bellintegrator.myproject.countries.CountriesDAO;
import ru.bellintegrator.myproject.docs.Docs;
import ru.bellintegrator.myproject.docs.DocsDAO;
import ru.bellintegrator.myproject.office.dao.OfficeDAO;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.user.dao.UserDAO;
import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserFilterView;

import java.util.List;

import static org.assertj.core.util.DateUtil.parse;

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
    @Autowired
    private DocsDAO DAODD;
    @Autowired
    private CountriesDAO DAOCount;
    @Autowired
    private OrganizationDAO DAOorg;



    @Test
    public void testAll() {
        //test get all
        List<User> users = userDAO.getAllUser();
        Assert.assertNotNull(users);
        Assert.assertEquals(8, users.size());
    }

  /*  @Test
    public void test() {
        //test get all
        List<User> users = userDAO.getAllUser();
        Assert.assertNotNull(users);
        Assert.assertEquals(8, users.size());

        // test get all with criteria
        UserFilterView criteria = new UserFilterView();

        criteria.officeId = "1";
        criteria.firstName = "Василий";
        criteria.secondName = "Васильев";
        criteria.midleName = "Васильевич";
        criteria.position = "Менеджер";
        criteria.docCode = "21";
        criteria.citizenshipCode = "643";

        List<User> usersByCriteria = userDAO.list(criteria);
        Assert.assertNotNull(usersByCriteria);
        Assert.assertEquals(1, usersByCriteria.size());

        //test save
        User saveTestUser = new User();

        saveTestUser.setFirstName("Гимли");
        saveTestUser.setSecondName("Гномов");
        saveTestUser.setMidleName("Гном");
        saveTestUser.setPosition("Мастер");
        saveTestUser.setPhone("+7 (333) 333-33-33");
        saveTestUser.setDocNumber("9999 999999");
        saveTestUser.setDocDate(parse("2004-08-06"));
        saveTestUser.setDocs(DAODD.getDocumentByCode("21"));
        saveTestUser.setCountries(DAOCount.getCountriesByCode("643"));
        saveTestUser.setIdentified(true);

        userDAO.save(saveTestUser);
        users = userDAO.getAllUser();
        Assert.assertEquals(9, users.size());

        //test update
        User updateTestUser = new User();

        updateTestUser.setId(2L);
        updateTestUser.setFirstName("Гимли");
        updateTestUser.setSecondName("Гномов");
        updateTestUser.setMidleName("Гном");
        updateTestUser.setPosition("Мастер");
        updateTestUser.setPhone("+7 (333) 333-33-33");
        updateTestUser.setDocNumber("9999 999999");
        updateTestUser.setDocDate(parse("2004-08-06"));
        updateTestUser.setDocs(DAODD.getDocumentByCode("21"));
        updateTestUser.setCountries(DAOCount.getCountriesByCode("643"));
        updateTestUser.setIdentified(true);

        Assert.assertNotNull(updateTestUser);
        String nameForUpdate = "Гимли";
        updateTestUser.setFirstName(nameForUpdate);
        userDAO.update(updateTestUser);
        User userAfterUpdate = userDAO.getUserByName(nameForUpdate);
        Assert.assertNotNull(userAfterUpdate);

        //test delete
        userDAO.delete(9L);
        users = userDAO.getAllUser();
        Assert.assertEquals(8, users.size());
    }*/

/*    String testName = "testName";
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
        Assert.assertEquals(9, users.size());
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
        Assert.assertEquals(8, users.size());
    }*/
}
