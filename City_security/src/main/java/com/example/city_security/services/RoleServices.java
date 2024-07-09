package com.example.city_security.services;

import com.example.city_security.models.dtos.CreateRoleDTO;
import com.example.city_security.models.dtos.CreateUserDTO;
import com.example.city_security.models.entities.Role;

import java.util.List;

public interface RoleServices {
    void AddRole(CreateRoleDTO AddRoleDTO);
    List<Role> findAll();
    Role findByRole(String role);
}
