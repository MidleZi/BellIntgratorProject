package ru.bellintegrator.myproject.user.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.myproject.office.model.Office;

public class UserView {

    @ApiModelProperty(hidden = true)

    public String id;

    public Office office;

    public String firstName;

    public String secondName;

    public String midleName;

    public String position;

    public String phone;

    public String docName;

    public String docNumber;

    public String docDate;

    public String citizenshipName;

    public String citizenshipCode;

    public Boolean isIdentified;

    public UserView() {

    }

    public UserView(String id, String firstName, String secondName, String midleName, String position, String phone,
                    String userDoc, String citizenshipCode, Boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.midleName = midleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
    }

    public UserView(String docName, String docNumber, String docDate){
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public UserView(String citizenshipCode, String citizenshipName){
        this.citizenshipCode = citizenshipCode;
        this.citizenshipName = citizenshipName;
    }

    @Override
    public String toString() {
        return "{id: " + id + "; Firstname: " + firstName+ "; SecondName: " + secondName + "; midleName: " + midleName +
                "; position: " + position + "; phone " + phone + "; docName " + docName + "; docNumber " + docNumber +
                "; docDate " + docDate + "; citizenshipCode " + citizenshipCode + "; citizenshipName " + citizenshipName +
                "; isIdentified " + isIdentified + "}";
    }

    public void setId(String id){
        this.id = id;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

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

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}

