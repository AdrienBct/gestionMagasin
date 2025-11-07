package gestionMagasin;

import java.util.ArrayList;
import java.util.List;

public class Magasin {
    private final List<Produit> produits;

    public Magasin() {
        produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void afficherProduitsDisponibles() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit disponible.");
        } else {
            System.out.println("Produits disponibles :");
            for (Produit p : produits) {
                p.afficherDetails();
            }
        }
    }

    public Produit trouverProduitParNom(String nom) {
        for (Produit p : produits) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null;
    }
}
