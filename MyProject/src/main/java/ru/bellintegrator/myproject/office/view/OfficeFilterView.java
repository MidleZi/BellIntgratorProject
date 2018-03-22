package ru.bellintegrator.myproject.office.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeFilterView {

    @ApiModelProperty(hidden = true)

    public String id;

    public String name;

    public String orgId;

    public OfficeFilterView() {

    }

    public OfficeFilterView(String name, String orgId) {
        this.name = name;
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";orgId" + orgId + "}";
    }
}
