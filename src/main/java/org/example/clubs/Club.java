package org.example.clubs;

import org.example.personnes.Membre;
import org.example.personnes.Professeur;
import java.util.ArrayList;
import java.util.List;

public abstract class Club {
    protected String nom;
    protected String description;
    protected Professeur responsable;
    protected List<Membre> membres;

    public Club(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.membres = new ArrayList<>();
    }

    // Ajouter un membre
    public void ajouterMembre(Membre membre) {
        if (membre != null && !membres.contains(membre)) {
            membres.add(membre);
            System.out.println( membre.getNom() + " " + membre.getPrenom() +
                    " ajouté(e) au club " + nom);
        }
    }

    // Supprimer un membre
    public void supprimerMembre(Membre membre) {
        if (membres.remove(membre)) {
            System.out.println( membre.getNom() + " " + membre.getPrenom() +
                    " retiré(e) du club " + nom);
        }
    }

    // Obtenir l'effectif
    public int getEffectif() {
        return membres.size();
    }

    // Méthode abstraite pour organiser une activité
    public abstract void organiserActivite();

    // Afficher les informations du club
    public void afficherInfos() {
        System.out.println("CLUB: " + nom);
        System.out.println(" Description: " + description);
        System.out.println(" Responsable: " + (responsable != null ?
                responsable.getNom() + " " + responsable.getPrenom() : "Non assigné"));
        System.out.println(" Effectif: " + getEffectif() + " membres");
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Professeur getResponsable() {
        return responsable;
    }

    public void setResponsable(Professeur responsable) {
        this.responsable = responsable;
    }

    public List<Membre> getMembres() {
        return new ArrayList<>(membres);
    }
}

