package org.example.strategies;


import org.example.clubs.Club;

import java.util.ArrayList;
import java.util.List;

public class PlanningRegulier implements PlanningStrategy {
    private List<String> creneauxHebdomadaires;
    private String jourFixe;
    private String heureFixe;

    public PlanningRegulier(String jourFixe, String heureFixe) {
        this.jourFixe = jourFixe;
        this.heureFixe = heureFixe;
        this.creneauxHebdomadaires = new ArrayList<>();
        initialiserCreneaux();
    }

    private void initialiserCreneaux() {
        // Créer 12 semaines de créneaux
        for (int semaine = 1; semaine <= 12; semaine++) {
            creneauxHebdomadaires.add("Semaine " + semaine + " - " + jourFixe + " à " + heureFixe);
        }
    }

    @Override
    public void genererPlanning(Club club) {
        System.out.println("\nPLANNING RÉGULIER - " + club.getNom());
        System.out.println("Type: Planning hebdomadaire fixe");
        System.out.println("Jour: " + jourFixe);
        System.out.println("Heure: " + heureFixe);
        System.out.println("Durée: 12 semaines");
        System.out.println("\nCréneaux planifiés:");

        for (String creneau : creneauxHebdomadaires) {
            System.out.println("  -->  " + creneau);
        }
    }

    @Override
    public boolean verifierDisponibilite(String jour, String heure) {
        return !jour.equals(jourFixe) || !heure.equals(heureFixe);
    }

    @Override
    public List<String> getCreneaux() {
        return new ArrayList<>(creneauxHebdomadaires);
    }

    // Ajouter un créneau supplémentaire
    public void ajouterCreneauSupplementaire(String description) {
        creneauxHebdomadaires.add(description);
        System.out.println("Créneau supplémentaire ajouté: " + description);
    }
}
