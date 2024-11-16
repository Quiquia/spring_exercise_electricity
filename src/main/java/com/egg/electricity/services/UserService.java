package com.egg.electricity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.electricity.entities.User;
import com.egg.electricity.enums.Rol;
import com.egg.electricity.exceptions.MiException;
import com.egg.electricity.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    
    public void crearUser(String userName, String name, String lastname, Rol rol) {
        User user = new User();

        user.setUserName(userName);
        user.setName(name);
        user.setLastname(lastname);
        user.setRol(rol);

        userRepository.save(user);

    }
    

    @Transactional(readOnly = true)
    public List<User> listUsers() {
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        return users;
    }


    public void validate(String userName, String name, String lastname, Rol rol) throws MiException {

        if (userName.isEmpty() || userName == null) {
            throw new MiException("el gmail no puede ser nulo o estar vacio.");
        }

        if (name.isEmpty() || name == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacio.");
        }
        
        if (lastname.isEmpty() || lastname == null) {
            throw new MiException("el apellido no puede ser nulo o estar vacio.");
        }
        
        if (rol == null) {
            throw new MiException("el rol no puede ser nulo.");
        }
    }

    
}
