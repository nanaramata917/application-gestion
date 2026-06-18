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
}