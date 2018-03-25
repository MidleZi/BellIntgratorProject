package ru.bellintegrator.myproject.userdocs.model;

import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "userdocs")
public class UserDocs {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docname")
    private User user;

    @Basic(optional = false)
    @Column(name = "docnumber")
    private String docNumber;

    @Basic(optional = false)
    @Column(name = "docdate")
    private String docDate;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{id:");
        builder.append(getId());
        builder.append(";docName:");
        builder.append(getUser());
        builder.append(";docNumber:");
        builder.append(getDocNumber());
        builder.append(";docDate:");
        builder.append(getDocDate());

        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocName(User user) {
        this.user = user;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }


}
