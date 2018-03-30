package ru.bellintegrator.myproject.user.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.myproject.countries.model.Countries;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.userdocs.model.UserDocs;

public class UserView {

    @ApiModelProperty(hidden = true)

    public String id;

    //public Office office;

    public String firstName;

    public String secondName;

    public String midleName;

    public String position;

    public String phone;

    public String docName;

    public String docNumber;

    public String docDate;

    public String citizenshipCode;

    public String citizenshipName;

    public Boolean isIdentified;

    public UserView() {

    }

    public UserView(String id, String firstName, String secondName, String midleName, String position, String phone,
                    String docName, String docNumber, String docDate, String citizenshipCode, String citizenshipName, Boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.midleName = midleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipCode = citizenshipCode;
        this.citizenshipName = citizenshipName;
        this.isIdentified = isIdentified;
    }

    @Override
    public String toString() {
        return "{id: " + id + /*"; office" + office.getName() +*/ "; Firstname: " + firstName+ "; SecondName: " + secondName + "; midleName: " + midleName +
                "; position: " + position + "; phone " + phone + /*"; docName " + userDoc.getDocName() + "; countries " + countries.getName() +*/
                "; isIdentified " + isIdentified + "}";
    }

    public void setId(String id){
        this.id = id;
    }

   /* public void setOffice(Office office) {
        this.office = office;
    }*/

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMidlleName(String midlleName) {
        this.midleName = midlleName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}

