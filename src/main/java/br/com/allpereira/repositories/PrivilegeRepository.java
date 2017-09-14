package br.com.allpereira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.allpereira.models.Company;
import br.com.allpereira.models.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    public Privilege findById(@Param("id") Long id);

    public Privilege findByName(@Param("name") String name);

}
