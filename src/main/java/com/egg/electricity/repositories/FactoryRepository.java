package com.egg.electricity.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.electricity.entities.Factory;

public interface FactoryRepository extends JpaRepository<Factory , UUID> {

    
} 
