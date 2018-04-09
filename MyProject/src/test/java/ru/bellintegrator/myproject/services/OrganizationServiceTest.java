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
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.service.OrganizationService;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterViewList;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationServiceTest {

    @Autowired
    OrganizationService orgService;

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

}
