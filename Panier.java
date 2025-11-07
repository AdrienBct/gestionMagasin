package gestionMagasin;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private final List<Produit> produits;

    public Panier() {
        produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
        produit.setQuantite(produit.getQuantite() - 1);
        System.out.println(produit.getNom() + " ajouté au panier.");
    }

    public void supprimerProduit(Produit produit) {
        produits.remove(produit);
        System.out.println(produit.getNom() + " supprimé du panier.");
    }

    public void afficherPanier() {
        if (produits.isEmpty()) {
            System.out.println("Le panier est vide.");
        } else {
            System.out.println("Contenu du panier :");
            for (Produit p : produits) {
                p.afficherDetails();
            }
            System.out.println("Total : " + calculerTotal() + "€");
        }
    }

    public double calculerTotal() {
        double total = 0;
        for (Produit p : produits) {
            total += p.getPrix();
        }
        return total;
    }

    public List<Produit> getProduits() {
        return produits;
    }
}
