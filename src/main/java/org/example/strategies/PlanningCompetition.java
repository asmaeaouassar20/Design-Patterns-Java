package org.example.strategies;


import org.example.clubs.Club;

import java.util.*;

public class PlanningCompetition implements PlanningStrategy {
    private List<Phase> phases;
    private Map<String, Date> datesFixees;

    public PlanningCompetition() {
        this.phases = new ArrayList<>();
        this.datesFixees = new HashMap<>();
    }

    // Classe interne pour les phases
    public static class Phase {
        String nom;
        String periode;
        List<String> objectifs;

        public Phase(String nom, String periode) {
            this.nom = nom;
            this.periode = periode;
            this.objectifs = new ArrayList<>();
        }

        public void ajouterObjectif(String objectif) {
            objectifs.add(objectif);
        }
    }

    @Override
    public void genererPlanning(Club club) {
        System.out.println("--- Génération du planning  --- ");
        System.out.println("\nPLANNING COMPÉTITION - " + club.getNom());
        System.out.println("Type: Planning par phases avec dates fixes");
        System.out.println("\nPhases programmées:");

        for (Phase phase : phases) {
            System.out.println("\n  ▸ " + phase.nom + " (" + phase.periode + ")");
            for (String objectif : phase.objectifs) {
                System.out.println("    • " + objectif);
            }
        }

        System.out.println("\nDates fixes importantes:");
        for (Map.Entry<String, Date> entry : datesFixees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public boolean verifierDisponibilite(String jour, String heure) {
        // Vérifier si le créneau ne chevauche pas une date fixée
        return true; // Logique simplifiée
    }

    @Override
    public List<String> getCreneaux() {
        List<String> creneaux = new ArrayList<>();
        for (Phase phase : phases) {
            creneaux.add(phase.nom + " - " + phase.periode);
        }
        return creneaux;
    }

    // Ajouter une phase
    public void ajouterPhase(String nom, String periode) {
        Phase phase = new Phase(nom, periode);
        phases.add(phase);
        System.out.println(">> Phase ajoutée: " + nom + " (" + periode + ")");
    }

    // Ajouter un objectif à une phase
    public void ajouterObjectif(String nomPhase, String objectif) {
        for (Phase phase : phases) {
            if (phase.nom.equals(nomPhase)) {
                phase.ajouterObjectif(objectif);
                System.out.println(">> Objectif ajouté à la phase " + nomPhase);
                return;
            }
        }
    }

    // Fixer une date importante
    public void fixerDate(String evenement, Date date) {
        datesFixees.put(evenement, date);
        System.out.println(">> Date fixée: " + evenement + " le " + date);
    }
}