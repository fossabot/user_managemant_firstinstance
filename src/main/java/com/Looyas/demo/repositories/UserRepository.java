package com.Looyas.demo.repositories;

import com.Looyas.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserId(String userId );
    Optional<User> findByUsername(String username );
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
