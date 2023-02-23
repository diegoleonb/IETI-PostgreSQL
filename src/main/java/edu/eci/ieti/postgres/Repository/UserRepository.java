package edu.eci.ieti.postgres.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eci.ieti.postgres.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(long id);
    
}
