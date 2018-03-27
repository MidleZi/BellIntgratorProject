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

    public Boolean isActive;

    public OrganizationView() {

    }

    public OrganizationView(String id, String name, String fullName, String inn, String kpp, String adress, String phone,
                            Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.adress = adress;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "{id:" /*+ id*/ + ";name:" + name+ ";fullName:" + fullName + ";INN:" + inn + ";KPP:" + kpp +
                ";address" + adress + ";phone" + phone + ";isActive" + isActive + "}";
    }
}

