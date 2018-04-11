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
    private OrganizationDAOImpl organizationDAO;

    @Test
    public void test() {
        //test get all
        List<Organization> organizations = organizationDAO.getAllOrganizations();
        Assert.assertNotNull(organizations);
        Assert.assertEquals(3, organizations.size());

        //test getOfficeById
        Organization organization = organizationDAO.getOrganizationById(1L);
        Assert.assertNotNull(organization);
        Assert.assertEquals("BellIntegrator", organization.getName());

        // test list
        OrganizationFilterView criteria = new OrganizationFilterView("офис1");
        List<Organization> officesByCriteria = organizationDAO.list(criteria);
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
        organizationDAO.save(saveTestOrganizations);
        organizations = organizationDAO.getAllOrganizations();
        Assert.assertEquals(5, organizations.size());

        //test update
        Organization updateTestOrganizations = new Organization();
        updateTestOrganizations.setId(1L);
        saveTestOrganizations.setName("Рога и копыта");
        saveTestOrganizations.setFullname("АО \"Рога и копыта\"");
        saveTestOrganizations.setInn("1234567890");
        saveTestOrganizations.setKpp("123456789");
        saveTestOrganizations.setAddress("Санкт-Петербург, Лахтинский пр-т., д.10");
        saveTestOrganizations.setPhone("+7 (812) 857-99-88");
        saveTestOrganizations.setActive(true);
        Assert.assertNotNull(updateTestOrganizations);
        String nameForUpdate = "Офис Рога и копыта";
        updateTestOrganizations.setName(nameForUpdate);
        organizationDAO.update(updateTestOrganizations);
        Organization organizationsAfterUpdate = organizationDAO.getOrganizationByName(nameForUpdate);
        Assert.assertNotNull(organizationsAfterUpdate);

        //test delete
        organizationDAO.delete(3L);
        organizations = organizationDAO.getAllOrganizations();
        Assert.assertEquals(2, organizations.size());
    }


}
