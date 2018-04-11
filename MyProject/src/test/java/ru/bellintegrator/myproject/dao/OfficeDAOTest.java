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
import ru.bellintegrator.myproject.office.view.OfficeView;
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

    @Test
    public void test() {
        //test get all

        Assert.assertNotNull(offices);
        Assert.assertEquals(4, offices.size());

        //test getOfficeById
        Office office = officeDAO.getOfficeById(1L);
        Assert.assertNotNull(office);
        Assert.assertEquals("офис1", office.getName());

        // test list
        OfficeFilterView criteria = new OfficeFilterView("офис1");
        List<Office> officesByCriteria = officeDAO.list(criteria);
        Assert.assertNotNull(officesByCriteria);
        Assert.assertEquals(1, officesByCriteria.size());

        //test save
        Office saveTestOffice = new Office();
        saveTestOffice.setName("Подсолнухи");
        saveTestOffice.setAddress("Санкт-Петербург, Лахтинский пр-т., д.12");
        saveTestOffice.setPhone("+7 (812) 857-99-77");
        saveTestOffice.setActive(true);
        officeDAO.save(saveTestOffice);
        offices = officeDAO.getAllOffice();
        Assert.assertEquals(5, offices.size());

        //test update
        Office updateTestOffice = new Office();
        updateTestOffice.setId(2L);
        updateTestOffice.setName("Офис Рога и копыта");
        updateTestOffice.setAddress("Санкт-Петербург, Лахтинский пр-т., д.10");
        updateTestOffice.setPhone("+7 (812) 857-99-88");
        updateTestOffice.setActive(true);
        Assert.assertNotNull(updateTestOffice);
        String nameForUpdate = "Офис Рога и копыта";
        updateTestOffice.setName(nameForUpdate);
        officeDAO.update(updateTestOffice);
        Office officeAfterUpdate = officeDAO.getOfficeByName(nameForUpdate);
        Assert.assertNotNull(officeAfterUpdate);

        //test delete
        officeDAO.delete(officeAfterUpdate);
        offices = officeDAO.getAllOffice();
        Assert.assertEquals(5, offices.size());
    }

}
