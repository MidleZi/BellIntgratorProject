package ru.bellintegrator.myproject.office.view;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.PathVariable;
import ru.bellintegrator.myproject.organization.model.Organization;

public class OfficeView {

    @ApiModelProperty(hidden = true)

    public Long id;

    public String name;

    public String orgId;

    public String address;

    public String phone;

    public Boolean isActive;


    public OfficeView() {

    }

    public OfficeView(String id, String name, String address, String phone, Boolean isActive) {
        this.id = Long.parseLong(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OfficeView(String name, String address, String phone, Boolean isActive) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";address" + address + ";phone" + phone + ";isActive" + isActive + "}";
    }
}
