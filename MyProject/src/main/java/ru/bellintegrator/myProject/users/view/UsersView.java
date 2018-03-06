package ru.bellintegrator.myProject.users.view;

import io.swagger.annotations.ApiModelProperty;

public class UsersView {

    @ApiModelProperty(hidden = true)

    public String id;

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

    public boolean isIdentified;

    public UsersView() {

    }

    public UsersView(String firstName, String secondName ) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";Firstname:" + firstName+ ";SecondName:" + secondName + ";midleName:" + midleName +
                ";position:" + position + ";phone" + phone + ";DocName" + docName + ";DocNumber" + docNumber +
                ";DocDate" + docDate + ";citizenshipName" + citizenshipName + ";citizenshipCode" + citizenshipCode +
                ";isIdentified" + isIdentified + "}";
    }
}
