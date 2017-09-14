package br.com.allpereira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allpereira.models.Company;
import br.com.allpereira.models.Privilege;
import br.com.allpereira.models.User;
import br.com.allpereira.repositories.PrivilegeRepository;
import br.com.allpereira.repositories.UserRepository;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeRepository privilegeRepository;

    public Privilege findById(Long id) {
        return privilegeRepository.findById(id);
    }

    public Privilege findByName(String name) {
        return privilegeRepository.findByName(name);
    }
    
    public List<Privilege> findAll() {
        return privilegeRepository.findAll();
    }

    public Privilege save(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

    public Privilege update(Long id, Privilege privilege) {
    	privilege.setId(id);
        return privilegeRepository.save(privilege);
    }
    
    public void delete(Long id) {
    	privilegeRepository.delete(id);
    }
    
    public boolean exists(Long id){
    	return privilegeRepository.exists(id);
    }
    
}
