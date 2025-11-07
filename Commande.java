package gestionMagasin;

import java.util.List;

public class Commande {
    private static int compteur = 0;
    private final int idCommande;
    private final Client client;
    private final List<Produit> produitsCommandes;
    private final double total;

    public Commande(Client client, List<Produit> produitsCommandes) {
        this.idCommande = ++compteur;
        this.client = client;
        this.produitsCommandes = produitsCommandes;
        this.total = calculerTotal();
    }

    private double calculerTotal() {
        double somme = 0;
        for (Produit p : produitsCommandes) {
            somme += p.getPrix();
        }
        return somme;
    }

    public void afficherDetailsCommande() {
        System.out.println("\n--- Détails de la commande n°" + idCommande + " ---");
        client.afficherDetails();
        for (Produit p : produitsCommandes) {
            p.afficherDetails();
        }
        System.out.println("Total à payer : " + total + "€");
    }
}
