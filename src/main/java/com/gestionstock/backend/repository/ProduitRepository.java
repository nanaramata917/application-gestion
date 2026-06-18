package com.gestionstock.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionstock.backend.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
