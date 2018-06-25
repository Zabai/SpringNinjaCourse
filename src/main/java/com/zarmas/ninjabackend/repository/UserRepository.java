package com.zarmas.ninjabackend.repository;

import com.zarmas.ninjabackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {
    User findByUsername(String username);
}
