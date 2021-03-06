package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.views.ContactViews;
import com.zarmas.ninjabackend.model.ContactModel;
import com.zarmas.ninjabackend.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", user.getUsername());

        return ContactViews.CONTACTS_LIST;
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/new")
    public String showContactForm(Model model) {
        model.addAttribute("contactModel", new ContactModel());
        return ContactViews.CONTACT_FORM;
    }

    @GetMapping("/edit/{id}")
    public String editContactForm(@PathVariable("id") int id, Model model) {
        ContactModel contactModel = contactService.findContactModelById(id);

        if(contactModel == null)
            return "redirect:/contacts/";

        model.addAttribute("contactModel", contactModel);
        return ContactViews.CONTACT_FORM;
    }


    @PostMapping("/create")
    public String createContact(@ModelAttribute(name = "contactModel") ContactModel contactModel) {
        log.info("Method: 'createContact' --- Params: contactModel='" + contactModel.toString() + "'");

        if(contactModel.getId() != 0)
            return updateContact(contactModel);

        if(contactService.addContact(contactModel) != null)
            return "redirect:/contacts/?result=1";
        else
            return "redirect:/contacts/?result=0";
    }

    private String updateContact(ContactModel contactModel) {
        contactService.updateContact(contactModel);
        return "redirect:/contacts/";
    }

    @GetMapping("/delete")
    public String removeContact(@RequestParam(name = "id", required = true) int id) {
        contactService.removeContact(id);
        return "redirect:/contacts/";
    }
}
