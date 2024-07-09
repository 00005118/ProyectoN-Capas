package com.example.city_security.Repository;

import com.example.city_security.models.entities.Role;
import com.example.city_security.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByCorreo(String dui);
    List<User> findByRole(Role role);
}
