package br.com.allpereira.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.allpereira.models.User;
import br.com.allpereira.services.UserService;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String federalID) throws UsernameNotFoundException {
		User user = userService.findByFederalID(federalID);

		if (user != null) {
			return new AppUserDetails(user);
		} else {
			throw new UsernameNotFoundException(federalID);
		}
		
	}

}
