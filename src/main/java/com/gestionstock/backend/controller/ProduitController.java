package com.gestionstock.backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

//@GetMapping("/{id}")
//public Produit getProduitById(@PathVariable Long id) {
  //  return produitService.getProduitById(id);
//}

//@GetMapping("/{id}")
//public String getProduitById(@PathVariable Long id) {
   // return "ID reçu : " + id;
//}

//@GetMapping("/{id}")
//public Produit getProduitById(@PathVariable Long id) {
    //return produitService.getProduitById(id);
//}


//VERSION PRO OPTION API REST
@GetMapping("/{id}")
public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
    Produit produit = produitService.getProduitById(id);
    return ResponseEntity.ok(produit);
}


@PutMapping("/{id}")
public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
    Produit updated = produitService.updateProduit(id, produit);
    return ResponseEntity.ok(updated);
}

}

