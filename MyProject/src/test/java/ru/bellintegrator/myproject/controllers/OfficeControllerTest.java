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
import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.office.view.OfficeView;
import ru.bellintegrator.myproject.utils.ResponseViewData;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeControllerTest {

    RestTemplate restTemplate = new RestTemplate();
    String patternURL = "http://localhost:8888/api/office";

    @Test
    public void testList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        OfficeFilterView body = new OfficeFilterView();
        body.orgId = "1";
        body.name = "офис1";
        body.phone = "+7(495) 777-77-77";
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

        String waitingResponse = "[{id=1, name=офис1, isActive=true}]";
        Assert.assertEquals(waitingResponse, data.toString());
    }

    @Test
    public void testGetOfficeById() {
        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/1", HttpMethod.GET, null,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);

        Object data = responseView.getData();
        Assert.assertNotNull(data);

        String waitingResponse = "{id=1, name=офис1, address=Москва, phone=+7(495) 777-77-77, isActive=true}";
        Assert.assertEquals(waitingResponse, data.toString());
    }

    @Test
    public void testSaveOffice() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        OfficeView body = new OfficeView();
        body.name = "Офис Рога и копыта";
        body.address = "Санкт-Петербург, Лахтинский пр-т., д.10";
        body.phone = "+7 (812) 857-99-88";
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
    public void testUpdateOffice() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        OfficeView body = new OfficeView();
        body.id = 2L;
        body.name = "Офис Рога и копыта";
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
    public void testDeleteOffice() {
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
