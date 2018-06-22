package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.constant.ViewConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @GetMapping("/")
    public String showContacts() {
        return ViewConstant.CONTACTS_LIST;
    }

    @GetMapping("/new")
    public String showContactForm() {
        return ViewConstant.CONTACT_FORM;
    }
}
