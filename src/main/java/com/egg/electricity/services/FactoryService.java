package com.egg.electricity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.electricity.entities.Factory;
import com.egg.electricity.exceptions.MiException;
import com.egg.electricity.repositories.FactoryRepository;

@Service
public class FactoryService {

    @Autowired
    private FactoryRepository factoryRepository;

    public void createFactory(String nameFactory) {

        Factory factory = new Factory();
        factory.setNameFactory(nameFactory);
        factoryRepository.save(factory);
    }

    //lectura
    @Transactional(readOnly = true)
    public List<Factory> listFactories() {
        List<Factory> factories = new ArrayList<>();
        factories = factoryRepository.findAll();
        return factories;
    }


    public void validate(String nameFactory) throws MiException {
        if(nameFactory.isEmpty() || nameFactory == null){
            throw new MiException("El nombre de la fabrica no puede ser NULO o VACÍO");
        }
        
    }

    
}
