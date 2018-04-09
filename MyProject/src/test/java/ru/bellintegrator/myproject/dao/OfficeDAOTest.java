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
import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.organization.model.Organization;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeDAOTest {

    @Autowired
    private OfficeDAO officeDAO;

    @Autowired
    private OrganizationDAO organizationDAO;

    List<Office> offices = officeDAO.getAllOffice();
    String testName = "testName";
    Office office = new Office(testName);


    @Test
    public void testList() {
        OfficeFilterView criteria = new OfficeFilterView("#1");
        List<Office> officesByCriteria = officeDAO.list(criteria);
        Assert.assertNotNull(officesByCriteria);
        Assert.assertEquals(1, officesByCriteria.size());
    }

    @Test
    public void testSave() {

        Organization org = organizationDAO.getOrganizationById(1L);
        office.setOrganization(org);
        officeDAO.save(office);
        offices = officeDAO.getAllOffice();
        Assert.assertEquals(3, offices.size());
    }

    @Test
    public void testUpdate() {
        Office updateTestOffice = officeDAO.getOfficeByName(testName);
        Assert.assertNotNull(updateTestOffice);
        String nameForUpdate = "newTestName";
        updateTestOffice.setName(nameForUpdate);
        officeDAO.update(updateTestOffice);
        Office officeAfterUpdate = officeDAO.getOfficeByName(nameForUpdate);
        Assert.assertNotNull(officeAfterUpdate);
    }

    @Test
    public void testDelete() {
        officeDAO.delete(office);
        offices = officeDAO.getAllOffice();
        Assert.assertEquals(2, offices.size());
    }

}
