package com.example.city_security.controllers;

import com.example.city_security.models.dtos.CreateRoleDTO;
import com.example.city_security.models.entities.Role;
import com.example.city_security.models.entities.User;
import com.example.city_security.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServices roleServices;

    @PostMapping("/add-role")
    public void addRole(@RequestBody CreateRoleDTO infoRole) {
        if(infoRole.getRole() == null) {
            throw new RuntimeException("Role is required");
        }else {
            roleServices.AddRole(infoRole);
        }
    }

    @GetMapping("/all-roles")
    public List<Role> getAllRoless(){
        return roleServices.findAll();
    }
    @PostMapping("/find-role")
    public ResponseEntity<?> getRoleByRole(@RequestBody CreateRoleDTO role) {
        Role findRole = roleServices.findByRole(role.getRole());
        if (findRole != null) {
            return ResponseEntity.ok(findRole);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
        }
    }
}