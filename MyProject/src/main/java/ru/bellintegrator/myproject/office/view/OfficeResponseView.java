package ru.bellintegrator.myproject.office.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeResponseView {
    @ApiModelProperty(hidden = true)

    public String id;

    public String name;

    public String orgId;

    public String adress;

    public String phone;

    public boolean isActive;

    public OfficeResponseView() {

    }

    public OfficeResponseView(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";address" + adress + ";phone" + phone + ";isActive" + isActive + "}";
    }
}
