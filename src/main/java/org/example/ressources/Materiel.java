package org.example.ressources;


import java.util.Date;

public class Materiel {
    private String id;
    private String type;
    private String etat;
    private String empruntePar;
    private Date dateRetour;
    private boolean disponible;

    public Materiel(String id, String type) {
        this.id = id;
        this.type = type;
        this.etat = "Bon état";
        this.disponible = true;
    }

    public boolean emprunter(String emprunteur, Date dateRetour) {
        if (disponible) {
            this.empruntePar = emprunteur;
            this.dateRetour = dateRetour;
            this.disponible = false;
            System.out.println("Matériel " + id + " emprunté par " + emprunteur);
            System.out.println("  Date de retour prévue: " + dateRetour);
            return true;
        } else {
            System.out.println("✗ Matériel " + id + " non disponible");
            System.out.println("  Emprunté par: " + empruntePar);
            System.out.println("  Retour prévu: " + dateRetour);
            return false;
        }
    }

    public void retourner() {
        if (!disponible) {
            System.out.println("Matériel " + id + " retourné par " + empruntePar);
            this.empruntePar = null;
            this.dateRetour = null;
            this.disponible = true;
        }
    }

    public void changerEtat(String nouvelEtat) {
        this.etat = nouvelEtat;
        System.out.println("État du matériel " + id + " mis à jour: " + nouvelEtat);
    }

    public void afficherInfos() {
        System.out.println("MATÉRIEL: " + id);
        System.out.println("Type: " + type);
        System.out.println("État: " + etat);
        System.out.println("Disponible: " + (disponible ? "Oui" : "Non"));
        if (!disponible) {
            System.out.println("│ Emprunté par: " + empruntePar);
            System.out.println("│ Retour prévu: " + dateRetour);
        }
    }

    // Getters
    public String getId() { return id; }
    public String getType() { return type; }
    public String getEtat() { return etat; }
    public String getEmpruntePar() { return empruntePar; }
    public Date getDateRetour() { return dateRetour; }
    public boolean isDisponible() { return disponible; }
}
