package br.com.allpereira;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.allpereira.models.Company;
import br.com.allpereira.models.Privilege;
import br.com.allpereira.models.User;
import br.com.allpereira.services.CompanyService;
import br.com.allpereira.services.PrivilegeService;
import br.com.allpereira.services.UserService;

@Component
public class InitialLoader implements ApplicationListener<ContextRefreshedEvent>{
	
	private Logger log = Logger.getLogger(InitialLoader.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Company company = companyService.findByFederalID("00000000000000"); // 14 zeros
		if(company == null) {
			//Add Company
			company = new Company();
			company.setId(null);
			company.setName("Default Company");
			company.setFederalID("00000000000000");
			company = companyService.save(company);
			
			if(company.getId() != null) {
				log.info("Empresa Default foi criada: "+company.toString());
			} else {
				log.error("Empresa Default não foi criada.");
			}
		}
		
		User user = userService.findByFederalID("00000000000"); // 11 zeros
		if(user == null) {
			
			//Add Privilegies
			List<Privilege> privilegies = new ArrayList<>();
			
			Privilege adminPrivilege = new Privilege(null, "ADMIN");
			privilegeService.save(adminPrivilege);
			
			Privilege userPrivilege = new Privilege(null, "USER");
			privilegeService.save(userPrivilege);
			
			privilegies.add(adminPrivilege);
			privilegies.add(userPrivilege);
			
			//Add User
			user = new User();
			user.setId(null);
			user.setEnabled(true);
			user.setRegistryDate(new Date());
			user.setName("Default Admin User");
			user.setMail("admin@mail.com");
			user.setFederalID("00000000000");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			user.setCompany(company);
			user.setPrivileges(privilegies);
			user = userService.save(user);
				
			if(user.getId() != null) {
				log.info("Usuario Default Admin User foi criado: "+user.toString());
			} else {
				log.error("Usuario Default Admin User não foi criado.");
			}
		}
		
	}

}