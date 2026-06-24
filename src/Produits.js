import React, { useState, useEffect } from "react";
import axios from "axios";

function Produits() {
  const [produits, setProduits] = useState([]);
  const [nom, setNom] = useState("");
  const [quantite, setQuantite] = useState("");
  const [prix, setPrix] = useState("");

  useEffect(() => {
    loadProduits();
  }, []);

  const loadProduits = () => {
    axios.get("http://localhost:8080/api/produits")
      .then(res => setProduits(res.data));
  };

  const ajouterProduit = () => {
    axios.post("http://localhost:8080/api/produits", {
      nom,
      quantite,
      prix
    }).then(() => {
      loadProduits();
      setNom("");
      setQuantite("");
      setPrix("");
    });
  };

  const supprimerProduit = (id) => {
    axios.delete(`http://localhost:8080/api/produits/${id}`)
      .then(() => loadProduits());
  };

  return (
    <div className="container mt-4">

      <h2 className="text-center mb-4">Gestion de Stock</h2>

      {/* FORMULAIRE */}
      <div className="card p-3 mb-4">
        <input className="form-control mb-2"
          placeholder="Nom"
          value={nom}
          onChange={(e) => setNom(e.target.value)}
        />

        <input className="form-control mb-2"
          placeholder="Quantité"
          value={quantite}
          onChange={(e) => setQuantite(e.target.value)}
        />

        <input className="form-control mb-2"
          placeholder="Prix"
          value={prix}
          onChange={(e) => setPrix(e.target.value)}
        />

        <button className="btn btn-primary" onClick={ajouterProduit}>
          Ajouter
        </button>
      </div>

      {/* TABLE */}
      <table className="table table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Quantité</th>
            <th>Prix</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {produits.map((p) => (
            <tr key={p.id}>
              <td>{p.id}</td>
              <td>{p.nom}</td>
              <td>{p.quantite}</td>
              <td>{p.prix}</td>
              <td>
                <button
                  className="btn btn-danger btn-sm"
                  onClick={() => supprimerProduit(p.id)}
                >
                  Supprimer
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

    </div>
  );
}

export default Produits;