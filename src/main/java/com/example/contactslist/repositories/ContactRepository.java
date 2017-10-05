package com.example.contactslist.repositories;

import com.example.contactslist.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
