package com.example.city_security.controllers;

import com.example.city_security.models.dtos.CreatePeticionDTO;
import com.example.city_security.models.dtos.FindPeticionDTO;
import com.example.city_security.models.dtos.UpdatePeticionDTO;
import com.example.city_security.models.entities.Peticiones;
import com.example.city_security.services.PeticionesService;
import com.example.city_security.services.TiposService;
import com.example.city_security.services.Userservice;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peticiones")
public class PeticionesController {
    @Autowired
    private PeticionesService peticionesService;
    @Autowired
    private Userservice userService;
    @Autowired
    private TiposService tiposService;

    @PostMapping("/add-peticion")
    public ResponseEntity<?> AddPeticion(@RequestBody CreatePeticionDTO peticion) {
        System.out.println("La peticion es:"+peticion);
        peticionesService.registerPeticion(peticion);
        return ResponseEntity.ok("Peticion added successfully");
    }
    @GetMapping("/all-peticiones")
    public List<Peticiones> getAllPeticiones() {
        return peticionesService.findAll();
    }
    @PostMapping("/find-peticion-user")
    public ResponseEntity<?> GetPeticion(@RequestBody FindPeticionDTO correo) {
        List<Peticiones> peticiones = peticionesService.findByPeticionbycorreo(correo);
        if (!peticiones.isEmpty()) {
            System.out.println("Peticion found");
            return ResponseEntity.ok(peticiones);
        } else {
            System.out.println("Peticion not found");
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/find-peticion-tipo")
    public ResponseEntity<?> GetPeticionsByuser(@RequestBody FindPeticionDTO tipo) {
        try {
            List<Peticiones> peticiones = peticionesService.findByPeticionbycorreo(tipo);
            if (peticiones.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No peticion found for user: " + tipo.getCorreo());
            }
            return ResponseEntity.ok(peticiones);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update-status")
    public ResponseEntity<?> updatePeticionStatus(@RequestBody UpdatePeticionDTO estadoDTO) {
        try {
            peticionesService.updatePeticionStatus(estadoDTO);
            return ResponseEntity.ok("Estado updated successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
