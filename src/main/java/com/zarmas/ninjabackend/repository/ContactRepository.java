package com.zarmas.ninjabackend.repository;

import com.zarmas.ninjabackend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("ContactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable> {
    Contact findById(int id);
}
