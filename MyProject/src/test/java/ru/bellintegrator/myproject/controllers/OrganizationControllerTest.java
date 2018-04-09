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

        String body = "{\"name\" : \"BellIntegrator\"}";
        HttpEntity entity = new HttpEntity<>(body, headers);

        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/list", HttpMethod.POST, entity,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();

        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getData());
    }

    @Test
    public void testGetOrganizationBuId() {
        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/1", HttpMethod.GET, null,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();

        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getData());
    }

    @Test
    public void testSaveOrganization() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = "{\"name\" : \"newName\"}";
        HttpEntity entity = new HttpEntity<>(body, headers);

        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/save", HttpMethod.POST, entity,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();

        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getData());
    }

    @Test
    public void testUpdateOrganization() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = "{\"id\" : \"1\","
                + "\"name\" : \"newSomeName\""
                + "}";
        HttpEntity entity = new HttpEntity<>(body, headers);

        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/update", HttpMethod.PUT, entity,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();

        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getData());
    }

    @Test
    public void testDeleteOrganization() {
        ResponseEntity<ResponseViewData> responseEntity =
                restTemplate.exchange(patternURL + "/2", HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<ResponseViewData>(){
                        });
        ResponseViewData responseView = responseEntity.getBody();

        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getData());
    }

}
