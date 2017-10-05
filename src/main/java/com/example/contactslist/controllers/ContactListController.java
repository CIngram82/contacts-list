package com.example.contactslist.controllers;

import com.example.contactslist.models.*;
import com.example.contactslist.repositories.ContactInfoRepository;
import com.example.contactslist.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ContactListController {
    @Autowired
    ContactRepository contactsRepo;

    @Autowired
    ContactInfoRepository contactInfoRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("contactsList", contactsRepo.findAll());

        RestTemplate template = new RestTemplate();

        String randomQuote =
                template.getForObject("http://api.icndb.com/jokes/random", ChuckNorrisRequest.class)
                        .getValue()
                        .getJoke();

        model.addAttribute("randomQuote", randomQuote);
        return "index";
    }

    @PostMapping("/add-contact")
    public String addContact(Contact input) {
        contactsRepo.save(input);

        return "redirect:/";
    }

    @GetMapping("/add-contact-info/{id}")
    public String addContactInfo(Model model, @PathVariable("id") int id) {
        // do stuff

        model.addAttribute("id", id);
        model.addAttribute("infotypes", ContactInfoType.values());
        return "add-contact-information";
    }

    @PostMapping("/add-contact-info/{contactId}")
    public String postContactInfo(@PathVariable("contactId") int id, ContactInfo info) {
        // find the contact with teh id specified
        Contact c = contactsRepo.findOne(id);

        // save the contactInfo
        contactInfoRepository.save(info);

        // add the contanctinfo to the contact's contactinfo arraylist
        c.getContactInformations().add(info);

        // save the contact
        contactsRepo.save(c);

        return "redirect:/";
    }

    @GetMapping("/edit-contact-info/{infoId}")
    public String editContactInf(@PathVariable("infoId") int id, Model model) {
        model.addAttribute("info", contactInfoRepository.findOne(id));
        model.addAttribute("infotypes", ContactInfoType.values());
        return "edit-contact-information";
    }

    @PostMapping("/edit-contact-info")
    public String editContactInfo(ContactInfo info) {
        contactInfoRepository.save(info);

        return "redirect:/";
    }
}
