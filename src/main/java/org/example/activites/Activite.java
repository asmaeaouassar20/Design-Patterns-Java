package org.example.activites;


import org.example.personnes.Membre;
import org.example.personnes.Professeur;
import org.example.ressources.Materiel;
import org.example.ressources.Salle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Activite {
    protected String nom;
    protected Date date;
    protected Salle lieu;
    protected Professeur responsable;
    protected List<Membre> participants;
    protected List<Materiel> materiel;

    public Activite() {
        this.participants = new ArrayList<>();
        this.materiel = new ArrayList<>();
    }

    // Méthode abstraite
    public abstract void executer();

    // Afficher les détails
    public void afficherDetails() {
        System.out.println("ACTIVITÉ: " + nom);
        System.out.println("- Date: " + date);
        System.out.println("- Lieu: " + (lieu != null ? lieu.getNumero() : "Non défini"));
        System.out.println("- Responsable: " + (responsable != null ?
                responsable.getNom() + " " + responsable.getPrenom() : "Non assigné"));
        System.out.println("- Participants: " + participants.size());
        System.out.println("- Matériel requis: " + materiel.size() + " items");
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Salle getLieu() { return lieu; }
    public void setLieu(Salle lieu) { this.lieu = lieu; }

    public Professeur getResponsable() { return responsable; }
    public void setResponsable(Professeur responsable) { this.responsable = responsable; }

    public List<Membre> getParticipants() { return new ArrayList<>(participants); }
    public void ajouterParticipant(Membre membre) {
        if (membre != null && !participants.contains(membre)) {
            participants.add(membre);
        }
    }

    public List<Materiel> getMateriel() { return new ArrayList<>(materiel); }
    public void ajouterMateriel(Materiel mat) {
        if (mat != null) {
            materiel.add(mat);
        }
    }
}