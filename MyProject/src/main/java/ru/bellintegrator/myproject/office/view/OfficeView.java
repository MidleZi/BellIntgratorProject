package ru.bellintegrator.myproject.office.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.myproject.organization.model.Organization;

public class OfficeView {

    @ApiModelProperty(hidden = true)

    public Long id;

    public String name;

    public Organization orgId;

    public String adress;

    public String phone;

    public boolean isActive;

    public OfficeView() {

    }

    public OfficeView(Long id, String name, String adress, String phone, boolean isActive) {
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
