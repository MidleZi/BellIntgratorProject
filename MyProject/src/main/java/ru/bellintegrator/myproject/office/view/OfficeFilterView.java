package ru.bellintegrator.myproject.office.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.myproject.organization.model.Organization;

public class OfficeFilterView {

    @ApiModelProperty(hidden = true)

    public Long id;

    public String name;

    public Organization orgId;

    public OfficeFilterView() {

    }

    public OfficeFilterView(String name, Organization orgId) {
        this.name = name;
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";orgId" + orgId + "}";
    }
}
