package com.example.city_security.controllers;

import com.example.city_security.models.dtos.RegisterCodeQRDTO;
import com.example.city_security.services.CodigoqrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigoqr")
public class CodigoQRController {
    @Autowired
    private CodigoqrService codigoqrService;

    @PostMapping("/add-codeqr")
    public ResponseEntity<?> AddCodeQR(@RequestBody RegisterCodeQRDTO codeQR) {
        codigoqrService.registerCodeQR(codeQR);
        return ResponseEntity.ok("CodeQR added successfully");
    }
}
