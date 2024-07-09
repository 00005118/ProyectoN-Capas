package com.example.city_security.services.serviceImpl;

import com.example.city_security.Repository.HogarRepository;
import com.example.city_security.Repository.RoleRepository;
import com.example.city_security.Repository.UserRepository;
import com.example.city_security.models.dtos.*;
import com.example.city_security.models.entities.Hogar;
import com.example.city_security.models.entities.Role;
import com.example.city_security.models.entities.User;
import com.example.city_security.services.Userservice;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements Userservice {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private HogarRepository hogarRepository;

    @Override
    public void registerUser(CreateUserDTO userRegisterDTO) {
        findUserByCorreo(userRegisterDTO.getCorreo());
        if(userRepository.findByCorreo(userRegisterDTO.getCorreo()) != null){
            throw new EntityNotFoundException("User already exists with correo: " + userRegisterDTO.getCorreo());
        }else{
        User user = new User();
        user.setNombre(userRegisterDTO.getNombre());
        user.setContrasena(null);
        user.setCorreo(userRegisterDTO.getCorreo());
        user.setDui(null);
        user.setTelefono(null);
        user.setRole(roleRepository.findByRole("USER"));
        userRepository.save(user);
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByCorreo(String correo) {
        return userRepository.findByCorreo(correo);
    }

    @Override
    public void updateUserRole(UpdateRoleDTO updateRoleDTO) {
        User user = userRepository.findByCorreo(updateRoleDTO.getCorreo());
        if (user == null) {
            throw new EntityNotFoundException("User not found with correo: " + updateRoleDTO.getCorreo());
        }
        Role newRole = roleRepository.findByRole(updateRoleDTO.getNewRole());
        if (newRole == null) {
            throw new EntityNotFoundException("Role not found: " + updateRoleDTO.getNewRole());
        }
        user.setRole(newRole);
        userRepository.save(user);
    }

    @Override
    public List<User> findByRole(FindUserByRole roleDTO) {
        Role role = roleRepository.findByRole(roleDTO.getRole());
        if (role == null) {
            throw new EntityNotFoundException("Role not found: " + roleDTO.getRole());
        }
        return userRepository.findByRole(role);
    }

    @Override
    public void deleteUser(FindUserDTO info) {
        User user = userRepository.findByCorreo(info.getCorreo());
        if (user == null) {
            throw new EntityNotFoundException("User not found with correo: " + info.getCorreo());
        }
        userRepository.delete(user);
    }

    @Override
    public void AddHogarToUser(User info, List<String> hogar) {
        List<Hogar> hogares = new ArrayList<>();
        hogar.forEach(h -> {
            Hogar hogar1 = hogarRepository.findByDireccion(h);
            if(hogar1 != null) {
                hogares.add(hogar1); //Agregando a la lista de hogares
            }
        });
        info.setHogares(hogares);
        userRepository.save(info);
    }

}
