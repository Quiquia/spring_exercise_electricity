package com.egg.electricity.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.electricity.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    
} 