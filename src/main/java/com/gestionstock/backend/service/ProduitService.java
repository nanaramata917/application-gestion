package com.gestionstock.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionstock.backend.entity.Produit;
import com.gestionstock.backend.repository.ProduitRepository;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }



public String deleteProduit(Long id) {
    if (produitRepository.existsById(id)) {
        produitRepository.deleteById(id);
        return "Produit supprimé";
    }
    return "Produit introuvable";
}

//FONCTION POUR RECHERCHER UN PRODUIT

//public Produit getProduitById(Long id) {
   // return produitRepository.findById(id).orElse(null);
//}
public Produit getProduitById(Long id) {
    return produitRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produit introuvable"));
}


//FONCTION MODIFIER PRODUIT
public Produit updateProduit(Long id, Produit newProduit) {
    return produitRepository.findById(id).map(produit -> {

        produit.setNom(newProduit.getNom());
        produit.setQuantite(newProduit.getQuantite());
        produit.setPrix(newProduit.getPrix());

        return produitRepository.save(produit);

    }).orElseThrow(() -> new RuntimeException("Produit introuvable"));
}




}