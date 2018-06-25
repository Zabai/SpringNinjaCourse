package com.zarmas.ninjabackend.converter;

import com.zarmas.ninjabackend.entity.Contact;
import com.zarmas.ninjabackend.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("ContactConverter")
public class ContactConverter {

    public Contact modelToEntity(ContactModel contactModel) {
        Contact contact = new Contact();

        contact.setId(contactModel.getId());
        contact.setFirstName(contactModel.getFirstName());
        contact.setLastName(contactModel.getLastName());
        contact.setCity(contactModel.getCity());
        contact.setTelephone(contactModel.getTelephone());

        return contact;
    }

    public ContactModel entityToModel(Contact contact) {
        ContactModel contactModel = new ContactModel();

        contactModel.setId(contact.getId());
        contactModel.setFirstName(contact.getFirstName());
        contactModel.setLastName(contact.getLastName());
        contactModel.setCity(contact.getCity());
        contactModel.setTelephone(contact.getTelephone());

        return contactModel;
    }
}
