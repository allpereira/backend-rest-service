package br.com.allpereira.security;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.allpereira.models.User;
import br.com.allpereira.services.UserService;

@Service
public class CredentialsSecurityService {
	
    @Autowired
    UserService userService;
    
	private User authorizedUser;
	
	/**
	 * Verify federalID and password of user.
	 * 
	 * @param user
	 * @return
	 */
	public User authorize(User user) {
    	this.authorizedUser = null;
    	
    	if(user != null) {    		
    		if(user.getFederalID() != null && user.getPassword()  != null) {
    			this.authorizedUser = userService.findByFederalID(user.getFederalID());
    			
    			if(this.authorizedUser != null) {
    				if(new BCryptPasswordEncoder().matches(user.getPassword(), this.authorizedUser.getPassword())) {    		    		
    					return this.authorizedUser;
    				}	
    			}
    			
    		}
    	}
		
    	
    	return null;
	}
	
}
