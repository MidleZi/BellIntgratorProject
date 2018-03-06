package ru.bellintegrator.myProject.office.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeView {

    @ApiModelProperty(hidden = true)

    public String id;

    public String name;

    public String adress;

    public String phone;

    public boolean isActive;

    public OfficeView() {

    }

    public OfficeView(String name, String adress ) {
        this.name = name;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";address" + adress + ";phone" + phone + ";isActive" + isActive + "}";
    }
}
