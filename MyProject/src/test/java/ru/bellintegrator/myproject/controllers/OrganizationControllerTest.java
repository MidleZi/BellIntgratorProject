package ru.bellintegrator.myproject.controllers;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.myproject.MyApplication;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import ru.bellintegrator.myproject.utils.ResponseViewData;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationControllerTest {
    RestTemplate restTemplate = new RestTemplate();
    String patternURL = "http://localhost:8888/api/organization";

    @Test
    public void testList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        OrganizationFilterView body = new OrganizationFilterView();
        body.name = "BellIntegrator";
        body.inn = "7777777777";
        body.isActive = true;
        HttpEntity entity = new HttpEntity<>(body, headers);

        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/list", HttpMethod.POST, entity,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);

        Object data = responseView.getData();
        Assert.assertNotNull(data);

        String waitingResponse = "[{id=1, name=BellIntegrator, isActive=true}]";
        Assert.assertEquals(waitingResponse, data.toString());
    }

    @Test
    public void testGetOrganizationBuId() {
        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/1", HttpMethod.GET, null,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);

        Object data = responseView.getData();
        Assert.assertNotNull(data);

        String waitingResponse = "{id=1, name=BellIntegrator, fullname=ООО \"Белл Интегратор\", inn=7777777777, kpp=777777777, address=Москва, " +
                 "phone=+7 (495) 777-77-77, isActive=true}";
        Assert.assertEquals(waitingResponse, data.toString());
    }

    @Test
    public void testSaveOrganization() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        OrganizationView body = new OrganizationView();
        body.name = "Подсолнухи";
        body.fullname = "ООО \"Подсолнухи\"";
        body.inn = "123456789012";
        body.kpp = "123456789";
        body.address = "Волгоград, Московский пр-т., д.1";
        body.phone = "+7 (8442) 57-99-88";
        body.isActive = true;

        HttpEntity entity = new HttpEntity<>(body, headers);

        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/save", HttpMethod.POST, entity,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);

        Object data = responseView.getData();
        Assert.assertNotNull(data);

        String waitingResponse = "success";
        Assert.assertEquals(waitingResponse, data.toString());
    }

    @Test
    public void testUpdateOrganization() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        OrganizationView body = new OrganizationView();
        body.id = 2L;
        body.name = "Рога и копыта";
        body.fullname = "АО \"Рога и копыта\"";
        body.inn = "1234567890";
        body.kpp = "123456789";
        body.address = "Санкт-Петербург, Лахтинский пр-т., д.1";
        body.phone = "+7 (812) 857-99-88";
        body.isActive = true;
        HttpEntity entity = new HttpEntity<>(body, headers);

        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/update", HttpMethod.POST, entity,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });

        ResponseViewData responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);

        Object data = responseView.getData();
        Assert.assertNotNull(data);

        String waitingResponse = "success";
        Assert.assertEquals(waitingResponse, data.toString());
    }

    @Test
    public void testDeleteOrganization() {
        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/3", HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);

        Object data = responseView.getData();
        Assert.assertNotNull(data);

        String waitingResponse = "success";
        Assert.assertEquals(waitingResponse, data.toString());
    }


}
