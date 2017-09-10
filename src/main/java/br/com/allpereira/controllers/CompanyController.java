package br.com.allpereira.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.allpereira.models.Company;
import br.com.allpereira.services.CompanyService;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {
	
	private Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Company find(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Company> create(@RequestBody Company company) {
        
        if(company != null){
            companyService.save(company);
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(company, HttpStatus.I_AM_A_TEAPOT);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Company> update(@PathVariable("id") Long id, @RequestBody Company company) {
        
        if(company != null){
        	companyService.update(id, company);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(company, HttpStatus.NOT_FOUND);
        }
    	
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        companyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
