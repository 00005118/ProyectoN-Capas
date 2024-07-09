package com.example.city_security.controllers;

import com.example.city_security.models.dtos.*;
import com.example.city_security.models.entities.User;
import com.example.city_security.services.Userservice;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Userservice userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> AddUser(@RequestBody CreateUserDTO user) {

        userService.registerUser(user);
        return ResponseEntity.ok("User added successfully");
    }

    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/find-user")
    public ResponseEntity<User> GetUser(@RequestBody FindUserDTO correo) {
        User user = userService.findUserByCorreo(correo.getCorreo());
        if (user != null) {
            System.out.println("User found");
            return ResponseEntity.ok(user);
        } else {
            System.out.println("User not found");
            return ResponseEntity.notFound().build();
        }
    }

    //Modificando el role de un usuario, solo necesita el dui y el nuevo rol
    @PostMapping("/update-role")
    public ResponseEntity<?> updateUserRole(@RequestBody UpdateRoleDTO updateRoleDTO) {
        try {
            userService.updateUserRole(updateRoleDTO);
            return ResponseEntity.ok("User role updated successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/find-by-role")
    public ResponseEntity<?> getUsersByRole(@RequestBody FindUserByRole roleDTO) {
        try {
            List<User> users = userService.findByRole(roleDTO);
            if (users.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found for role: " + roleDTO.getRole());
            }
            return ResponseEntity.ok(users);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete-user")
    public ResponseEntity<?> deleteUser(@RequestBody FindUserDTO correo) {
        try {
            userService.deleteUser(correo);
            return ResponseEntity.ok("User deleted successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Rutas de HogarXUsuario

    @PostMapping("/add-hogarXuser")
    public ResponseEntity<?> addRoleXUser(@RequestBody CreateHogarXUserDTO info ){
        User user = userService.findUserByCorreo(info.getCorreo());
        if (user == null){
            return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, "User not found");
        }
        userService.AddHogarToUser(user, info.getDireccion());
        return GeneralResponse.getResponse(HttpStatus.OK, "Hogar added with user successfully");
    }
}
