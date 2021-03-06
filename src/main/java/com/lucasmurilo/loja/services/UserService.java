package com.lucasmurilo.loja.services;

import com.lucasmurilo.loja.dominio.User;
import com.lucasmurilo.loja.repositories.UserRepository;
import com.lucasmurilo.loja.services.exceptions.DataBaseExcption;
import com.lucasmurilo.loja.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseExcption(e.getMessage());
        }

    }

    public User update(Long id, User obj){
       try {
           User entity = userRepository.getById(id);
           updateData(entity, obj);
           return userRepository.save(entity);
       }catch(EntityNotFoundException e){
           throw new ResourceNotFoundException(id);
       }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}



