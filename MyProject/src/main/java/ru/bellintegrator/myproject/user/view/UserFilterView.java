package ru.bellintegrator.myproject.user.view;

import io.swagger.annotations.ApiModelProperty;

public class UserFilterView {

    @ApiModelProperty(hidden = true)


    public String office;

    public String firstName;

    public String secondName;

    public UserFilterView() {

    }

    public UserFilterView(String office, String firstName, String secondName) {

        this.office = office;
        this.firstName = firstName;
        this.secondName = secondName;


    }

    @Override
    public String toString() {
        return "{" + "Firstname:" + firstName+ ";SecondName:" + secondName + "}";
    }
}