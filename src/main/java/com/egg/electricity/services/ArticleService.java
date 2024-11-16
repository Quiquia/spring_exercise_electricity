package com.egg.electricity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.electricity.entities.Article;
import com.egg.electricity.entities.Factory;
import com.egg.electricity.exceptions.MiException;
import com.egg.electricity.repositories.ArticleRepository;
import com.egg.electricity.repositories.FactoryRepository;

@Service
public class ArticleService {

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private ArticleRepository articleRepository;


    public void createArticle(String nameArticle, String description,
            UUID idFactory) {

        Article article = new Article();
        Factory factory = factoryRepository.findById(idFactory).get();

        article.setNameArticle(nameArticle);
        article.setDescription(description);
        article.setFactory(factory);

        articleRepository.save(article);

    }
    
    @Transactional(readOnly = true)
    public List<Article> listArticles() {

        List<Article> articles = new ArrayList<>();
        articles = articleRepository.findAll();
        return articles;
    }
    

    public void validate(String nameArticle, String description,
            UUID idFactory) throws MiException {
        
        if (nameArticle.isEmpty() || nameArticle == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacio.");
        }

        if (description.isEmpty() || description == null) {
            throw new MiException("la descripción no puede ser nulo o estar vacio.");
        }

        if ( idFactory == null) {
            throw new MiException("el número de la fabrica no puede ser nulo o estar vacio.");
        }
        
    }
}
