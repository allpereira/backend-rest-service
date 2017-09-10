package br.com.allpereira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.allpereira.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    public Company findById(@Param("id") Long id);

    public Company findByName(@Param("name") String name);

    public Company findByFederalID(@Param("federalID") String federalID);

}
