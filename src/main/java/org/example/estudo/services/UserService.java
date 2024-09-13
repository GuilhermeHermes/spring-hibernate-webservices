package org.example.estudo.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.estudo.repositories.UserRepository;
import org.example.estudo.services.exceptions.DatabaseException;
import org.example.estudo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.example.estudo.entities.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();

    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insertUser(User user){ return userRepository.save(user);}

    public void deleteUser(Long id){
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

    try {
        userRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
        throw new DatabaseException(e.getMessage());
    }
    }

    public User updateUser(Long id, User user){
       try {
           User entity = userRepository.getReferenceById(id);
           updateData(entity, user);
           return userRepository.save(entity);
       } catch (EntityNotFoundException e) {
           throw new ResourceNotFoundException(id);
       }
    }

    private void updateData(User entity, User user){
        entity.setName(user.getName());
        entity.setPhone(user.getPhone());
        entity.setEmail(user.getEmail());
    }
}
