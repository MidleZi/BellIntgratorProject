package ru.bellintegrator.myproject.organization.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationFilterViewList {

    @ApiModelProperty(hidden = true)

    private Long id;

    private String name;

    private Boolean isActive;

    public OrganizationFilterViewList() {
    }

    public OrganizationFilterViewList(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";isActive : " + isActive + "}";
    }
}
