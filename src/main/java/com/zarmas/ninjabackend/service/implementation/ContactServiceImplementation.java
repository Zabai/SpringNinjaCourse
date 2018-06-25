package com.zarmas.ninjabackend.service.implementation;

import com.zarmas.ninjabackend.converter.ContactConverter;
import com.zarmas.ninjabackend.entity.Contact;
import com.zarmas.ninjabackend.model.ContactModel;
import com.zarmas.ninjabackend.repository.ContactRepository;
import com.zarmas.ninjabackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ContactServiceImplementation")
public class ContactServiceImplementation implements ContactService {
    @Autowired
    @Qualifier("ContactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("ContactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact newContact = contactRepository.save(contactConverter.modelToEntity(contactModel));
        return contactConverter.entityToModel(newContact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        List<ContactModel> contacts = new ArrayList<>();

        contactRepository.findAll()
                .forEach(contact -> contacts.add(contactConverter.entityToModel(contact)));

        return contacts;
    }

    @Override
    public Contact findContactById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public ContactModel findContactModelById(int id) {
        return contactConverter.entityToModel(findContactById(id));
    }

    @Override
    public ContactModel updateContact(ContactModel contactModel) {
        Contact updatedContact = contactRepository.save(contactConverter.modelToEntity(contactModel));
        return contactConverter.entityToModel(updatedContact);
    }

    @Override
    public boolean removeContact(int id) {
        Contact contact = findContactById(id);

        if(contact == null)
            return false;

        contactRepository.delete(contact);
        return true;
    }
}
