package ru.bellintegrator.myproject.userdocs.model;

import ru.bellintegrator.myproject.office.model.Office;

import javax.persistence.*;

@Entity
@Table(name = "userdocs")
public class UserDocs {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "docName")
    private String docName;

    @Basic(optional = false)
    @Column(name = "docNumber")
    private String docNumber;

    @Basic(optional = false)
    @Column(name = "docDate")
    private String docDate;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{id:");
        builder.append(getId());
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

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }


}
