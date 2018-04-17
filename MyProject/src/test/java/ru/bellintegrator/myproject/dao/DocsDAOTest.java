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
import ru.bellintegrator.myproject.docs.Docs;
import ru.bellintegrator.myproject.docs.DocsDAO;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class DocsDAOTest {

    @Autowired
    private DocsDAO dao;

    @Test
    public void test() {
        //test get all

        List<Docs> docs = dao.allDocs();
        Assert.assertNotNull(docs);
        Assert.assertEquals(12, docs.size());

        //test getDocumentByName
        Docs doc = dao.getDocumentByName("Военный билет");
        Assert.assertNotNull(doc);
        Assert.assertEquals("07", doc.getCode());

        //test getDocumentByCode
        Docs doc1 = dao.getDocumentByCode("07");
        Assert.assertNotNull(doc1);
        Assert.assertEquals("Военный билет", doc1.getName());
    }
}
