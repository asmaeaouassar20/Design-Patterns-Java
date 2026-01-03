package org.example.activites;


import org.example.ressources.Materiel;
import org.example.ressources.Salle;

import java.util.Date;

public class ActiviteBuilder {
    private Activite activite;

    // Constructeur privé
    private ActiviteBuilder(Activite activite) {
        this.activite = activite;
    }

    // Méthodes statiques pour créer le builder
    public static ActiviteBuilder creerReunion() {
        return new ActiviteBuilder(new Reunion());
    }

    public static ActiviteBuilder creerEvenement() {
        return new ActiviteBuilder(new Evenement());
    }

    // Méthodes de construction
    public ActiviteBuilder setNom(String nom) {
        activite.setNom(nom);
        return this;
    }

    public ActiviteBuilder setDate(Date date) {
        activite.setDate(date);
        return this;
    }

    public ActiviteBuilder setLieu(Salle lieu) {
        activite.setLieu(lieu);
        return this;
    }

    public ActiviteBuilder setResponsable(Professeur responsable) {
        activite.setResponsable(responsable);
        return this;
    }

    public ActiviteBuilder addParticipant(Membre membre) {
        activite.ajouterParticipant(membre);
        return this;
    }

    public ActiviteBuilder addMateriel(Materiel materiel) {
        activite.ajouterMateriel(materiel);
        return this;
    }

    // Méthodes spécifiques pour Réunion
    public ActiviteBuilder setOrdreDuJour(String ordre) {
        if (activite instanceof Reunion) {
            ((Reunion) activite).setOrdreDuJour(ordre);
        }
        return this;
    }

    // Méthodes spécifiques pour Événement
    public ActiviteBuilder setTypeEvenement(String type) {
        if (activite instanceof Evenement) {
            ((Evenement) activite).setTypeEvenement(type);
        }
        return this;
    }

    public ActiviteBuilder setPublicExterne(boolean publicExterne) {
        if (activite instanceof Evenement) {
            ((Evenement) activite).setPublicExterne(publicExterne);
        }
        return this;
    }

    public ActiviteBuilder setBudget(double budget) {
        if (activite instanceof Evenement) {
            ((Evenement) activite).setBudget(budget);
        }
        return this;
    }

    // Construire l'activité finale
    public Activite build() {
        System.out.println("✓ Activité construite: " + activite.getNom());
        return activite;
    }
}