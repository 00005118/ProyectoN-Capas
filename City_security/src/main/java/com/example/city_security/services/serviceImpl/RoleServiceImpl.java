package com.example.city_security.services.serviceImpl;

import com.example.city_security.Repository.RoleRepository;
import com.example.city_security.models.dtos.CreateRoleDTO;
import com.example.city_security.models.entities.Role;
import com.example.city_security.services.RoleServices;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleServices {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void AddRole(CreateRoleDTO infoRole) {
        Role role = new Role();
        role.setRole(infoRole.getRole());
        roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
