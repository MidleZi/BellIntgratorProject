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
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.office.service.OfficeService;
import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.office.view.OfficeFilterViewList;
import ru.bellintegrator.myproject.office.view.OfficeView;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeServiceTest {

    @Autowired
    OfficeService officeService;
    @Autowired
    OfficeDAO officeDAOImpl;

    @Test
    public void testGetOfficeById() {
        Office office = officeService.getOfficeById(Long.parseLong("1"));
        Assert.assertNotNull(office);
        Assert.assertEquals("офис1", office.getName());
    }

    @Test
    public void testList() {
        OfficeFilterView filter = new OfficeFilterView("1");
        List<OfficeFilterViewList> list = officeService.list(filter);
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());

        OfficeFilterViewList response = list.get(0);
        Assert.assertEquals("офис1", response.getName());
    }

    @Test
    public void testUpdateOffice() {

        OfficeView body = new OfficeView();
        body.id = 2L;
        body.name = "Офис Рога и копыта";
        body.address = "Санкт-Петербург, Лахтинский пр-т., д.1";
        body.phone = "+7 (812) 857-99-88";
        body.isActive = true;

        officeService.update(body);

        Office office = officeDAOImpl.getOfficeById(2L);

        Assert.assertNotNull(office);
        Assert.assertEquals("Офис Рога и копыта", office.getName());
    }

    @Test
    public void testSaveOffice(){

        OfficeView body = new OfficeView();
        body.name = "Офис Рога и копыта";
        body.address = "Санкт-Петербург, Лахтинский пр-т., д.10";
        body.phone = "+7 (812) 857-99-88";
        body.isActive = true;

        officeService.save(body);

        List<Office> list = officeDAOImpl.getAllOffice();

        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(5, list.size());
    }

    @Test
    public void testDeleteOffice(){

        officeService.delete(4L);

        List<Office> list = officeDAOImpl.getAllOffice();

        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(3, list.size());
    }

}
