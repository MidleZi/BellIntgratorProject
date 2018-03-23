package ru.bellintegrator.myproject.organization;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.bellintegrator.myproject.office.dao.impl.OfficeDAOImpl;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.organization.model.Organization;

import java.util.Iterator;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

public class OfficeTest {

  /*  public void getOfficeByIdWhenSuccessfulTest() {

        OfficeDAOImpl officeDAO = new OfficeDAOImpl();

        Office office = new Office("name", "address");
        Organization organization = new Organization();
        office.setOrgId(String.valueOf(organization.getId()));
        officeDAO.save(office);
        String id = getOfficeIdFromDB(office);
        String url = "/api/office/" + id;

        Object headers;
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String result = response.getBody();
        String expected = "{\"data\":" +
                "{\"id\":" + id + "," +
                "\"name\":\"officeName\"," +
                "\"address\":\"officeAddress\"," +
                "\"phone\":\"89057456321\"," +
                "\"isActive\":true}}";
        assertThat(result, is(expected));
    }

    private String getOfficeIdFromDB(Office office) {
        Iterable<Office> iterable = officeDAO.findAll();
        Iterator<Office> iterator = iterable.iterator();
        Long id = null;
        while(iterator.hasNext()) {
            Office officeInDB = iterator.next();
            if (office.equals(officeInDB)) id = officeInDB.getId();
        }
        return id;
    }*/
}
