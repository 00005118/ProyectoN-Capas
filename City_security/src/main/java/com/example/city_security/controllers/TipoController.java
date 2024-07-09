package com.example.city_security.controllers;

import com.example.city_security.models.dtos.CreateTipoDTO;
import com.example.city_security.models.dtos.FindTiposDTO;
import com.example.city_security.models.entities.Tipos;
import com.example.city_security.services.TiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private TiposService tiposService;

    @PostMapping("/add-tipo")
    public ResponseEntity<?> AddTipo(@RequestBody CreateTipoDTO tipo) {
        tiposService.registerTipo(tipo);
        return ResponseEntity.ok("Tipo added successfully");
    }

    @GetMapping("/all-tipos")
    public ResponseEntity<?> getAllTipos() {
        return ResponseEntity.ok(tiposService.findAll());
    }

    @PostMapping("/find-tipo")
    public ResponseEntity<Tipos> findTipo(@RequestBody FindTiposDTO tipo) {
        Tipos tipofound = tiposService.findTipoByTipo(tipo.getTipo());
        if(tipofound != null) {
            System.out.println("Tipo found");
            return ResponseEntity.ok(tipofound);
        } else {
            System.out.println("Tipo not found");
            return ResponseEntity.notFound().build();
        }
    }

}
