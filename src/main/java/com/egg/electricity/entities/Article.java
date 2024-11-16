package com.egg.electricity.entities;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "article")
public class Article {
    @Id
    @Column(name = "id-article")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID idArticle;
    
    @Column(name = "nro-article", nullable = false, unique = true)
    private static final AtomicInteger counter = new AtomicInteger(0);
    private Integer nroArticle = counter.incrementAndGet();

    @Column(name = "name-article", nullable = false )
    private String nameArticle;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name= "id-factory")
    private Factory factory;
    
}
