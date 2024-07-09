package com.example.city_security.controllers;

import com.example.city_security.Repository.HogarRepository;
import com.example.city_security.models.dtos.CreateHogarDTO;
import com.example.city_security.models.entities.Hogar;
import com.example.city_security.services.HogarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Hogar")
public class HogarController {
    @Autowired
    private HogarService hogarService;

    @PostMapping("add-hogar")
    public ResponseEntity<?> CreateHogar(@RequestBody CreateHogarDTO  createHogarDTO){
        hogarService.registerHogar(createHogarDTO);
        return ResponseEntity.ok("Hogar added successfully");
    }
}
