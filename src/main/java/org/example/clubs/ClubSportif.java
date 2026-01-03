package org.example.clubs;

import java.util.ArrayList;
import java.util.List;

public class ClubSportif extends Club {
    private String sport;
    private String niveau;
    private List<String> equipements;

    public ClubSportif(String nom, String description, String sport, String niveau) {
        super(nom, description);
        this.sport = sport;
        this.niveau = niveau;
        this.equipements = new ArrayList<>();
    }

    public void ajouterEquipement(String equipement) {
        equipements.add(equipement);
    }

    @Override
    public void organiserActivite() {
        System.out.println("Organisation d'une séance de " + sport +
                " (niveau: " + niveau + ")");
        System.out.println("   Équipements nécessaires: " + equipements);
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("  → Type: Club Sportif");
        System.out.println("  → Sport: " + sport);
        System.out.println("  → Niveau: " + niveau);
        System.out.println("  → Équipements: " + equipements.size());
    }

    // Getters
    public String getSport() {
        return sport;
    }

    public String getNiveau() {
        return niveau;
    }
}
