package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.constant.ViewConstant;
import com.zarmas.ninjabackend.model.ContactModel;
import com.zarmas.ninjabackend.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private final Log log = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("ContactServiceImplementation")
    private ContactService contactService;

    @GetMapping("/")
    public String showContacts(Model model, @RequestParam(name = "result", required = false) String result) {
        log.info("Method: 'showContacts()' --- Params: result='" + result + "'");

        model.addAttribute("result", result);
        model.addAttribute("contacts", contactService.listAllContacts());

        return ViewConstant.CONTACTS_LIST;
    }

    @GetMapping("/new")
    public String showContactForm(Model model) {
        model.addAttribute("contactModel", new ContactModel());
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/create")
    public String createContact(@ModelAttribute(name = "contactModel") ContactModel contactModel) {
        log.info("Method: 'createContact' --- Params: contactModel='" + contactModel.toString() + "'");

        if(contactService.addContact(contactModel) != null)
            return "redirect:/contacts/?result=1";
        else
            return "redirect:/contacts/?result=0";
    }
}
