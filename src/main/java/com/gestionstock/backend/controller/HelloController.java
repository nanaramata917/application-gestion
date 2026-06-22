package com.gestionstock.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String accueil() {
        return "Bienvenue dans mon application de gestion de stock";
    }
}
