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
    private OrganizationDAO organizationDAO;

    List<Organization> orgs = organizationDAO.getAllOrganizations();
    String testName = "testName";
    Organization saveTestOrg = new Organization(testName);

    @Test
    public void testGetAllOrganization() {
        Assert.assertNotNull(orgs);
        Assert.assertEquals(2, orgs.size());
    }

    @Test
    public void testUpdate() {
        Organization updateTestOrg = organizationDAO.getOrganizationByName(testName);
        Assert.assertNotNull(updateTestOrg);
        String nameForUpdate = "newTestName";
        updateTestOrg.setName(nameForUpdate);
        organizationDAO.update(updateTestOrg);
        Organization orgAfterUpdate = organizationDAO.getOrganizationByName(nameForUpdate);
        Assert.assertNotNull(orgAfterUpdate);

    }

    @Test
    public void testSave() {
        organizationDAO.save(saveTestOrg);
        orgs = organizationDAO.getAllOrganizations();
        Assert.assertEquals(3, orgs.size());
    }

    @Test
    public void testList() {
        OrganizationFilterView criteria = new OrganizationFilterView("BellIntegrator");
        List<Organization> orgsByCriteria = organizationDAO.list(criteria);
        Assert.assertNotNull(orgsByCriteria);
        Assert.assertEquals(1, orgsByCriteria.size());
    }

    @Test
    public void testDelete() {
        organizationDAO.delete(1L);
        orgs = organizationDAO.getAllOrganizations();
        Assert.assertEquals(2, orgs.size());
    }


}
