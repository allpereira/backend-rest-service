package br.com.allpereira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allpereira.models.User;
import br.com.allpereira.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByFederalID(String federalID) {
        return userRepository.findByFederalID(federalID);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    
    public User update(Long id, User user) {
    	user.setId(id);
    	
    	return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}
