package com.Looyas.demo.repositories;

import com.Looyas.demo.models.RoleName;
import com.Looyas.demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(RoleName roleName);
}
