package com.zarmas.ninjabackend.service;

import com.zarmas.ninjabackend.entity.Contact;
import com.zarmas.ninjabackend.model.ContactModel;

import java.util.List;

public interface ContactService {
    ContactModel addContact(ContactModel contactModel);
    List<ContactModel> listAllContacts();
    Contact findContactById(int id);
    ContactModel findContactModelById(int id);
    ContactModel updateContact(ContactModel contactModel);
    boolean removeContact(int id);
}
