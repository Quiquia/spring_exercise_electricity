package com.egg.electricity.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "factory")
public class Factory {
     @Id
    @Column(name = "id-factory")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID idFactory;
    
    @Column(name = "name-factory", nullable = false)
    private String nameFactory;

    
}
