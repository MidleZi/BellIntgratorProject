package ru.bellintegrator.myproject.office.view;

public class OfficeFilterView {
    public String orgId;

    public String name;

    public String phone;

    public Boolean isActive;

    public OfficeFilterView(){

    }

    public OfficeFilterView(String name){
        this.name = name;
    }
}
