package com.zarmas.ninjabackend.service;

import com.zarmas.ninjabackend.model.ContactModel;

import java.util.List;

public interface ContactService {
    ContactModel addContact(ContactModel contactModel);
    List<ContactModel> listAllContacts();
}
