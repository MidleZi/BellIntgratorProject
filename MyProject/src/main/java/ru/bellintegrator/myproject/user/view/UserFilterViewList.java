package ru.bellintegrator.myproject.user.view;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserFilterViewList {

    private Long id;

    private String firstName;

    private String secondName;

    private String midleName;

    private String position;

    public UserFilterViewList() {

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMidleName() {
        return midleName;
    }

    public String getPosition() {
        return position;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
