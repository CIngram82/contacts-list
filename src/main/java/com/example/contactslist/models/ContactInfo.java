package com.example.contactslist.models;

import javax.persistence.*;

@Entity
@Table(name = "contact_informations")
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String label;

    @Column
    private String value;

    @Column
    private ContactInfoType infoType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ContactInfoType getInfoType() {
        return infoType;
    }

    public void setInfoType(ContactInfoType infoType) {
        this.infoType = infoType;
    }
}
