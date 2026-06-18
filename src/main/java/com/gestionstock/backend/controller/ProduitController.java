package com.gestionstock.backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestionstock.backend.entity.Produit;
import com.gestionstock.backend.service.ProduitService;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin("*")
public class ProduitController {

    @Autowired
    private ProduitService produitService;


//fonction pour voir la liste des produits
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
// fonction pour ajouter un produit
    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit) {
        return produitService.ajouterProduit(produit);
    }

//fonction pour supprimer un produit


@DeleteMapping("/{id}")
public String deleteProduit(@PathVariable Long id) {
    return produitService.deleteProduit(id);
}


}

