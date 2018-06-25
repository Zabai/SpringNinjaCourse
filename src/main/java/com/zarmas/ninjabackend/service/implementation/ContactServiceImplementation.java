package com.zarmas.ninjabackend.service.implementation;

import com.zarmas.ninjabackend.converter.ContactConverter;
import com.zarmas.ninjabackend.entity.Contact;
import com.zarmas.ninjabackend.model.ContactModel;
import com.zarmas.ninjabackend.repository.ContactRepository;
import com.zarmas.ninjabackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
