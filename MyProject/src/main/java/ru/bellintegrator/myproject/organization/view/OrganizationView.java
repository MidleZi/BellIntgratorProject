package ru.bellintegrator.myproject.organization.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationView {

    @ApiModelProperty(hidden = true)

    public Long id;

    public String name;

    public String fullname;

    public String inn;

    public String kpp;

    public String address;

    public String phone;

    public Boolean isActive;

    public OrganizationView() {

    }

    public OrganizationView(String id, String name, String fullname, String inn, String kpp, String address, String phone,
                            Boolean isActive) {
        this.id = Long.parseLong(id);
        this.name = name;
        this.fullname = fullname;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OrganizationView(String name, String fullname, String inn, String kpp, String address, String phone,
                            Boolean isActive) {
        this.name = name;
        this.fullname = fullname;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name+ ";fullName:" + fullname + ";INN:" + inn + ";KPP:" + kpp +
                ";address" + address + ";phone:" + phone + ";isActive : " + isActive + "}";
    }
}

