package com.example.contactslist.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany
    private List<ContactInfo> contactInformations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ContactInfo> getContactInformations() {
        return contactInformations;
    }

    public void setContactInformations(List<ContactInfo> contactInformations) {
        this.contactInformations = contactInformations;
    }
}
