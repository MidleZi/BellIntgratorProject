package ru.bellintegrator.myproject.userdocs.model;

import ru.bellintegrator.myproject.docs.Docs;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "userdocs")
public class UserDocs {

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docname")
    private Docs docs;

    @Basic(optional = false)
    @Column(name = "docnumber")
    private String docNumber;

    @Basic(optional = false)
    @Column(name = "docdate")
    private String docDate;

    public UserDocs(){}

    public UserDocs(Long id,Docs docs, String docNumber, String docDate){
        this.id = id;
        this.docs = docs;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public UserDocs(Docs docs, String docNumber, String docDate) {
        this.docs = docs;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{id:");
        builder.append(getId());
        builder.append(";docName:");
        builder.append(getDocs());
        builder.append(";docNumber:");
        builder.append(getDocNumber());
        builder.append(";docDate:");
        builder.append(getDocDate());

        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public Docs getDocs() {
        return docs;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDocName(Docs docName) {
        this.docs = docName;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

}
