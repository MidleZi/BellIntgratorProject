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

    public String userDoc;

    public String citizenshipCode;

    public boolean isIdentified;

    public UserView() {

    }

    public UserView(String id, Office office, String firstName, String secondName, String midleName, String position, String phone,
                    String userDoc, String citizenshipCode, boolean isIdentified) {
        this.id = id;
        this.office = office;
        this.firstName = firstName;
        this.secondName = secondName;
        this.midleName = midleName;
        this.position = position;
        this.phone = phone;
        this.userDoc = userDoc;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;

    }

    @Override
    public String toString() {
        return "{id:" + id + ";Firstname:" + firstName+ ";SecondName:" + secondName + ";midleName:" + midleName +
                ";position:" + position + ";phone" + phone + ";userDoc" + userDoc  +
                ";citizenshipCode" + citizenshipCode + ";isIdentified" + isIdentified + "}";
    }
}
