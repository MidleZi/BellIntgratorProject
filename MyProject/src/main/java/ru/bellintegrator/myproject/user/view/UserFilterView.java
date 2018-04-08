package ru.bellintegrator.myproject.user.view;

public class UserFilterView {

    public String officeId;

    public String firstName;

    public String secondName;

    public String midleName;

    public String position;

    public String docCode;

    public String citizenshipCode;

    public UserFilterView() {
    }

    public UserFilterView(String firstName) {
        this.firstName = firstName;
    }
}
