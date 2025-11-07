package gestionMagasin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Magasin magasin = new Magasin();
        magasin.ajouterProduit(new Produit(1, "Pain", 1.5, 100));
        magasin.ajouterProduit(new Produit(2, "Lait", 2.0, 50));
        magasin.ajouterProduit(new Produit(3, "Fromage", 4.5, 30));
        magasin.ajouterProduit(new Produit(3, "Oeuf", 0.5, 150));

        Client client = new Client(1, "Dupont", "dupont@mail.com");
        Panier panier = new Panier();

        int choix;
        do {
            System.out.println("\n--- Menu Magasin ---");
            System.out.println("1. Afficher les produits disponibles");
            System.out.println("2. Ajouter un produit au panier");
            System.out.println("3. Afficher le panier");
            System.out.println("4. Passer la commande");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");
            choix = sc.nextInt();
            sc.nextLine(); // vider le buffer

            switch (choix) {
                case 1 -> magasin.afficherProduitsDisponibles();
                case 2 -> {
                    System.out.print("Nom du produit à ajouter : ");
                    String nom = sc.nextLine();
                    Produit p = magasin.trouverProduitParNom(nom);
                    if (p != null) panier.ajouterProduit(p);
                    else System.out.println("Produit introuvable.");
                }
                case 3 -> panier.afficherPanier();
                case 4 -> {
                    Commande commande = new Commande(client, panier.getProduits());
                    commande.afficherDetailsCommande();
                }
                case 5 -> System.out.println("Merci de votre visite !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 5);

        sc.close();
    }
}
