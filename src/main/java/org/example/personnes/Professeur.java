package org.example.personnes;

public class Professeur extends Membre {
    private String matiere;
    private String salle;
    private int heures;

    public Professeur(String id, String nom, String prenom, String email,
                      String matiere, String salle, int heures) {
        super(id, nom, prenom, email);
        this.matiere = matiere;
        this.salle = salle;
        this.heures = heures;
    }

    @Override
    public void participer() {
        System.out.println("Le professeur " + nom + " " + prenom +
                " (" + matiere + ") supervise l'activité");
    }

    @Override
    public String getType() {
        return "PROFESSEUR";
    }

    // Getters
    public String getMatiere() { return matiere; }
    public String getSalle() { return salle; }
    public int getHeures() { return heures; }
}
