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
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.organization.dao.impl.OrganizationDAOImpl;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationDAOTest {


    @Autowired
    private OrganizationDAOImpl dao;

    @Test
    public void test() {
        //test get all
        List<Organization> organizations = dao.getAllOrganizations();
        Assert.assertNotNull(organizations);
        Assert.assertEquals(3, organizations.size());

        // test list
        OrganizationFilterView criteria = new OrganizationFilterView("BellIntegrator");
        List<Organization> officesByCriteria = dao.list(criteria);
        Assert.assertNotNull(officesByCriteria);
        Assert.assertEquals(1, officesByCriteria.size());

        //test save
        Organization saveTestOrganizations = new Organization();
        saveTestOrganizations.setName("Подсолнухи");
        saveTestOrganizations.setFullname("ООО \"Подсолнухи\"");
        saveTestOrganizations.setInn("123456789012");
        saveTestOrganizations.setKpp("123456789");
        saveTestOrganizations.setAddress("Волгоград, Московский пр-т., д.1");
        saveTestOrganizations.setPhone("+7 (8442) 57-99-88");
        saveTestOrganizations.setActive(true);
        dao.save(saveTestOrganizations);
        organizations = dao.getAllOrganizations();
        Assert.assertEquals(4, organizations.size());


        //test delete
        dao.delete(3L);
        organizations = dao.getAllOrganizations();
        Assert.assertEquals(3, organizations.size());


        //test update
        Organization updateTestOrganizations = new Organization();
        updateTestOrganizations.setId(1L);
        updateTestOrganizations.setName("Рога и копыта");
        updateTestOrganizations.setFullname("АО \"Рога и копыта\"");
        updateTestOrganizations.setInn("1234567890");
        updateTestOrganizations.setKpp("123456789");
        updateTestOrganizations.setAddress("Санкт-Петербург, Лахтинский пр-т., д.10");
        updateTestOrganizations.setPhone("+7 (812) 857-99-88");
        updateTestOrganizations.setActive(true);
        Assert.assertNotNull(updateTestOrganizations);
        String nameForUpdate = "Офис Рога и копыта";
        updateTestOrganizations.setName(nameForUpdate);
        dao.update(updateTestOrganizations);
        Organization organizationsAfterUpdate = dao.getOrganizationByName(nameForUpdate);
        Assert.assertNotNull(organizationsAfterUpdate);


    }


}
