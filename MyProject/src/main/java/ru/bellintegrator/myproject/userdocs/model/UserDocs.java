package ru.bellintegrator.myproject.userdocs.model;

import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "userdocs")
public class UserDocs {

    @Id
    //@ManyToOne(fetch = FetchType.EAGER)
    @Basic(optional = false)
    @JoinColumn(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "docname")
    private String docName;

    @Basic(optional = false)
    @Column(name = "docnumber")
    private String docNumber;

    @Basic(optional = false)
    @Column(name = "docdate")
    private String docDate;

    public UserDocs(){}

    public UserDocs(String docName, String docNumber, String docDate) {
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{id:");
        //builder.append(getId());
        builder.append(";docName:");
        builder.append(getDocName());
        builder.append(";docNumber:");
        builder.append(getDocNumber());
        builder.append(";docDate:");
        builder.append(getDocDate());

        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }


}
