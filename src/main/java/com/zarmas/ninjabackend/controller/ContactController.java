package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.constant.ViewConstant;
import com.zarmas.ninjabackend.model.ContactModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private final Log log = LogFactory.getLog(ContactController.class);

    @GetMapping("/")
    public String showContacts(Model model, @RequestParam(name = "result", required = false) String result) {
        model.addAttribute("result", result);
        return ViewConstant.CONTACTS_LIST;
    }

    @GetMapping("/new")
    public String showContactForm(Model model) {
        model.addAttribute("contactModel", new ContactModel());
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/create")
    public String createContact(Model model, @ModelAttribute(name = "contactModel") ContactModel contactModel) {
        log.info("Method: 'createContact' --- Params: contactModel='" + contactModel.toString() + "'");

        model.addAttribute("result", 1);
        return "redirect:/contacts/?result";
    }
}
