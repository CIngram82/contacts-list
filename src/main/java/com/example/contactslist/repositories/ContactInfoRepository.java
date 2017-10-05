package com.example.contactslist.repositories;

import com.example.contactslist.models.ContactInfo;
import org.springframework.data.repository.CrudRepository;

public interface ContactInfoRepository extends CrudRepository<ContactInfo, Integer> {
}
