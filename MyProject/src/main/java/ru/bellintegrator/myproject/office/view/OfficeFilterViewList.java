package ru.bellintegrator.myproject.office.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModelProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OfficeFilterViewList {


    @ApiModelProperty(hidden = true)

    private Long id;

    private String name;

    private Boolean isActive;

    public OfficeFilterViewList() {

    }

    public OfficeFilterViewList(String name) {
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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";isActive : " + isActive + "}";
    }


}
