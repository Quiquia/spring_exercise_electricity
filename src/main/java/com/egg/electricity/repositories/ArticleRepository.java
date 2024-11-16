package com.egg.electricity.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.electricity.entities.Article;

public interface ArticleRepository extends JpaRepository< Article, UUID> {
    
}
