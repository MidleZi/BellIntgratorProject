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
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.organization.dao.OrganizationDAO;
import ru.bellintegrator.myproject.organization.dao.impl.OrganizationDAOImpl;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.service.OrganizationService;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterViewList;
import ru.bellintegrator.myproject.organization.view.OrganizationView;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationServiceTest {

    @Autowired
    OrganizationService orgService;
    OrganizationDAO organizationDAO;

    @Test
    public void testGetOrganizationById() {
        Organization org = orgService.getOrganizationById(Long.parseLong("1"));
        Assert.assertNotNull(org);
        Assert.assertEquals("BellIntegrator", org.getName());
    }

    @Test
    public void testList() {
        OrganizationFilterView filter = new OrganizationFilterView("B");
        List<OrganizationFilterViewList> list = orgService.list(filter);
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());

        OrganizationFilterViewList response = list.get(0);
        Assert.assertEquals("BellIntegrator", response.getName());
    }

    @Test
    public void testUpdateOrganization() {

        OrganizationView body = new OrganizationView();
        body.id = 2L;
        body.name = "Рога и копыта";
        body.fullname = "АО \"Рога и копыта\"";
        body.inn = "1234567890";
        body.kpp = "123456789";
        body.address = "Санкт-Петербург, Лахтинский пр-т., д.1";
        body.phone = "+7 (812) 857-99-88";
        body.isActive = true;

        orgService.update(body);

        Organization organization = organizationDAO.getOrganizationById(2L);

        Assert.assertNotNull(organization);
        Assert.assertEquals("АО \"Рога и копыта\"", organization.getName());
    }

    @Test
    public void testSaveOrganization(){

        OrganizationView view = new OrganizationView();
        view.name = "Подсолнухи";
        view.fullname = "ООО \"Подсолнухи\"";
        view.inn = "123456789012";
        view.kpp = "123456789";
        view.address = "Волгоград, Московский пр-т., д.1";
        view.phone = "+7 (8442) 57-99-88";
        view.isActive = true;

        orgService.save(view);

        List<Organization> list = organizationDAO.getAllOrganizations();

        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void testDeleteOrganization(){

        orgService.delete(3L);

        List<Organization> list = organizationDAO.getAllOrganizations();

        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(2, list.size());
    }

}
