package org.example.ressources;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Budget {
    private double montant;
    private List<Transaction> depenses;
    private List<Transaction> recettes;
    private double solde;

    // Classe interne pour les transactions
    public static class Transaction {
        Date date;
        String description;
        double montant;
        String categorie;

        public Transaction(String description, double montant, String categorie) {
            this.date = new Date();
            this.description = description;
            this.montant = montant;
            this.categorie = categorie;
        }

        @Override
        public String toString() {
            return date + " - " + description + ": " + montant + "€ [" + categorie + "]";
        }
    }

    public Budget(double montantInitial) {
        this.montant = montantInitial;
        this.solde = montantInitial;
        this.depenses = new ArrayList<>();
        this.recettes = new ArrayList<>();
        System.out.println("💰 Budget initialisé: " + montantInitial + "€");
    }

    public boolean ajouterDepense(String description, double montant, String categorie) {
        if (montant > solde) {
            System.out.println("Dépense refusée: solde insuffisant");
            System.out.println("   Montant demandé: " + montant + "€");
            System.out.println("   Solde actuel: " + solde + "€");
            return false;
        }

        Transaction depense = new Transaction(description, montant, categorie);
        depenses.add(depense);
        solde -= montant;
        System.out.println("Dépense enregistrée: " + montant + "€ - " + description);
        System.out.println("   Nouveau solde: " + solde + "€");
        return true;
    }

    public void ajouterRecette(String description, double montant, String categorie) {
        Transaction recette = new Transaction(description, montant, categorie);
        recettes.add(recette);
        solde += montant;
        System.out.println("💵 Recette enregistrée: " + montant + "€ - " + description);
        System.out.println("   Nouveau solde: " + solde + "€");
    }

    public void afficherBilan() {
        System.out.println("          BILAN FINANCIER               ");
        System.out.println("Budget initial: " + montant + "€");
        System.out.println("Recettes totales: " + getTotalRecettes() + "€");
        System.out.println("Dépenses totales: " + getTotalDepenses() + "€");
        System.out.println("Solde actuel: " + solde + "€");

        System.out.println("RECETTES (" + recettes.size() + "):");
        for (Transaction r : recettes) {
            System.out.println(r.montant + "€ - " + r.description);
        }

        System.out.println("DÉPENSES (" + depenses.size() + "):");
        for (Transaction d : depenses) {
            System.out.println(d.montant + "€ - " + d.description);
        }
    }

    private double getTotalRecettes() {
        return recettes.stream().mapToDouble(t -> t.montant).sum();
    }

    private double getTotalDepenses() {
        return depenses.stream().mapToDouble(t -> t.montant).sum();
    }

    // Getters
    public double getMontant() { return montant; }
    public double getSolde() { return solde; }
    public List<Transaction> getDepenses() { return new ArrayList<>(depenses); }
    public List<Transaction> getRecettes() { return new ArrayList<>(recettes); }
}