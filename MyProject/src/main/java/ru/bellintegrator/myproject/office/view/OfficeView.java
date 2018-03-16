package ru.bellintegrator.myproject.office.view;

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

    public OfficeView(String id, String name, String adress, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";address" + adress + ";phone" + phone + ";isActive" + isActive + "}";
    }
}
