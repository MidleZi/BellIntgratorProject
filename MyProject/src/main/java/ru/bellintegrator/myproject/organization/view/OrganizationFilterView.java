package ru.bellintegrator.myproject.organization.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationFilterView {

    @ApiModelProperty(hidden = true)

    public String name;

    public String inn;

    public boolean isActive;

    public OrganizationFilterView() {

    }

    public OrganizationFilterView(String name, String inn, boolean isActive) {
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "{name:" + name + ";INN:" + inn + ";isActive" + isActive + "}";
    }
}
