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
import ru.bellintegrator.myproject.countries.Countries;
import ru.bellintegrator.myproject.countries.CountriesDAO;
import ru.bellintegrator.myproject.docs.Docs;
import ru.bellintegrator.myproject.docs.DocsDAO;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class CountriesDAOTest {

    @Autowired
    private CountriesDAO dao;

    @Test
    public void test() {
        //test get all

        List<Countries> countries = dao.allCountries();
        Assert.assertNotNull(countries);
        Assert.assertEquals(2, countries.size());

        //test getCountriesByName
        Countries country = dao.getCountriesByName("Российская Федерация");
        Assert.assertNotNull(country);
        Assert.assertEquals("643", country.getCode());

        //test getCountriesByCode
        Countries country1 = dao.getCountriesByCode("643");
        Assert.assertNotNull(country1);
        Assert.assertEquals("Российская Федерация", country1.getName());
    }
}
