package ru.bellintegrator.myproject.user.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.myproject.countries.Countries;
import ru.bellintegrator.myproject.docs.Docs;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.user.model.User;

import java.util.Date;

public class UserView {

    @ApiModelProperty(hidden = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String id;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Office office;

    @JsonIgnore
    public String officeId;

    public String firstName;

    public String secondName;

    public String midleName;

    public String position;

    public String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long docCode;

    public String docName;

    public String docNumber;

    public Date docDate;

    public String citizenshipCode;

    public String citizenshipName;

    public Boolean isIdentified;

    public UserView() {

    }

    public UserView(String fistName, String officeId) {
        this.firstName = fistName;
        this.officeId = officeId;
    }

    public UserView(String id, String firstName, String officeId) {
        this.id = id;
        this.firstName = firstName;
        this.officeId = officeId;
    }

    @Override
    public String toString() {
        return "{id: " + id + "; Firstname: " + firstName+ "; SecondName: " + secondName + "; midleName: " + midleName +
                "; position: " + position + "; phone " + phone + "; docName " + docName + "; docNumber :" + docNumber + "; docDate :" + docDate + "; citizenshipCode "
                + citizenshipCode + "; citizenshipName: " + citizenshipName + "; isIdentified " + isIdentified + "}";
    }

    public String toString1() {
        return "{ Firstname: " + firstName+ "; SecondName: " + secondName + "; midleName: " + midleName +
                "; position: " + position + "; phone " + phone + ";docCode " + docCode + "; docName " + docName + "; docNumber :" + docNumber + "; docDate :" + docDate + "; citizenshipCode "
                + citizenshipCode + "; citizenshipName: " + citizenshipName + "; isIdentified " + isIdentified + "}";
    }

    public User toConvertUserEntity(User user, Docs docs, Countries countries) {

        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMidleName(midleName);
        user.setPosition(position);
        user.setPhone(phone);
        user.setDocs(docs);
        user.setDocNumber(docNumber);
        user.setDocDate(docDate);
        user.setIdentified(isIdentified);
        user.setDocs(docs);
        user.setCountries(countries);

        return user;
    }

    public User toConvertUserEntity(Docs docs, Countries countries) {

        User user = new User();

        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMidleName(midleName);
        user.setPosition(position);
        user.setPhone(phone);
        user.setDocNumber(docNumber);
        user.setDocDate(docDate);
        user.setIdentified(isIdentified);
        user.setDocs(docs);
        user.setCountries(countries);

        return user;
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

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public String getId() {
        return id;
    }
}

