package ru.bellintegrator.myproject.organization.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationView {

    @ApiModelProperty(hidden = true)

    public String id;

    public String name;

    public String fullName;

    public String inn;

    public String kpp;

    public String adress;

    public String phone;

    public boolean isActive;

    public OrganizationView() {

    }

    public OrganizationView(String name, String inn ) {
        this.name = name;
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name+ ";fullName:" + fullName + ";INN:" + inn + ";KPP:" + kpp + ";address" + adress + ";phone" + phone + ";isActive" + isActive + "}";
    }
}
