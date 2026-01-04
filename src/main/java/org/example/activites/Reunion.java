package org.example.activites;


import org.example.personnes.Membre;

import java.util.ArrayList;
import java.util.List;

public class Reunion extends Activite {
    private String ordreDuJour;
    private String compteRendu;
    private List<String> decisions;

    public Reunion() {
        super();
        this.decisions = new ArrayList<>();
    }

    @Override
    public void executer() {
        System.out.println("\nDÉBUT DE LA RÉUNION: " + nom);
        System.out.println("- Ordre du jour: " + ordreDuJour);
        System.out.println("- Participants: " + participants.size() + " personnes");

        for (Membre m : participants) {
            System.out.println("  • " + m.getNom() + " " + m.getPrenom() +
                    " (" + m.getType() + ")");
        }
    }

    public void ajouterDecision(String decision) {
        decisions.add(decision);
        System.out.println("Décision ajoutée: " + decision);
    }

    // Getters et Setters
    public String getOrdreDuJour() { return ordreDuJour; }
    public void setOrdreDuJour(String ordreDuJour) { this.ordreDuJour = ordreDuJour; }

    public String getCompteRendu() { return compteRendu; }
    public void setCompteRendu(String compteRendu) { this.compteRendu = compteRendu; }

    public List<String> getDecisions() { return new ArrayList<>(decisions); }
}