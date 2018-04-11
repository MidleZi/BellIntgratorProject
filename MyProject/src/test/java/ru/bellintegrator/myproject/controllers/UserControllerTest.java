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
import ru.bellintegrator.myproject.user.view.UserFilterView;
import ru.bellintegrator.myproject.user.view.UserView;
import ru.bellintegrator.myproject.utils.ResponseViewData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.util.DateUtil.parse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserControllerTest {

    RestTemplate restTemplate = new RestTemplate();
    String patternURL = "http://localhost:8888/api/user";


    @Test
    public void testList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserFilterView body = new UserFilterView();

        body.officeId = "1";
        body.firstName = "Василий";
        body.secondName = "Васильев";
        body.midleName = "Васильевич";
        body.position = "Менеджер";
        body.docCode = "21";
        body.citizenshipCode = "643";
        HttpEntity entity = new HttpEntity<>(body, headers);

        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/list", HttpMethod.POST, entity,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);

        Object data = responseView.getData();
        Assert.assertNotNull(data);

        String waitingResponse = "[{id=1, firstName=Василий, secondName=Васильев, midleName=Васильевич, position=Менеджер}]";
        Assert.assertEquals(waitingResponse, data.toString());
    }

    @Test
    public void testGetUserById() {
        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/4", HttpMethod.GET, null,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);

        Object data = responseView.getData();
        Assert.assertNotNull(data);

        String waitingResponse = "{id=4, firstName=Владимир, secondName=Путин, midleName=Владимирович, position=Менеджер, " +
                "phone=+7 (222) 222-22-22, docName=Паспорт гражданина Российской Федерации, docNumber=4658 987654, docDate=2009-05-06, " +
                "citizenshipCode=643, citizenshipName=Российская Федерация, isIdentified=true}";
        Assert.assertEquals(waitingResponse, data.toString());
    }

    @Test
    public void testSaveUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserView body = new UserView();

        body.firstName = "Гимли";
        body.secondName = "Гномов";
        body.midleName = "Гном";
        body.position = "Мастер";
        body.phone = "+7 (333) 333-33-33";
        body.docCode = 21L;
        body.docName = "Паспорт гражданина Российской Федерации";
        body.docNumber = "9999 999999";
        body.docDate = parse("2004-08-06");
        body.citizenshipName = "Российская Федерация";
        body.citizenshipCode = "643";
        body.isIdentified = true;
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
    public void testUpdateUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserView body = new UserView();

        body.id = "1";
        body.firstName = "Гимли";
        body.secondName = "Гномов";
        body.midleName = "Гном";
        body.position = "Мастер";
        body.phone = "+7 (333) 333-33-33";
        body.docCode = 21L;
        body.docName = "Паспорт гражданина Российской Федерации";
        body.docNumber = "9999 999999";
        body.docDate = parse("2004-08-06");
        body.citizenshipName = "Российская Федерация";
        body.citizenshipCode = "643";
        body.isIdentified = true;

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
    public void testDeleteUser() {
        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/8", HttpMethod.DELETE, null,
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
