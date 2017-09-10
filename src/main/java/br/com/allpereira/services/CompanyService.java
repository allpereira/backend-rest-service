package br.com.allpereira.services;

import br.com.allpereira.models.Company;
import br.com.allpereira.repositories.CompanyRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company findById(Long id) {
        return companyRepository.findById(id);
    }

    public Company findByName(String name) {
        return companyRepository.findByName(name);
    }

    public Company findByFederalID(String federalID) {
        return companyRepository.findByFederalID(federalID);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company update(Long id, Company company) {
        company.setId(id);
        return companyRepository.save(company);
    }
    
    public void delete(Long id) {
        companyRepository.delete(id);
    }
}
