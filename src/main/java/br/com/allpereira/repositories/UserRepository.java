package br.com.allpereira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.allpereira.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findById(@Param("id") Long id);

    public User findByName(@Param("name") String name);

    public User findByLogin(@Param("login") String login);

    public User findByFederalID(@Param("federalID") String federalID);
}
