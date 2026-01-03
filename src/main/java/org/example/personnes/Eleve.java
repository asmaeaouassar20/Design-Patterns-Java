package org.example.personnes;

public class Eleve extends Membre {
    private String classe;
    private String niveau;
    private String tuteur;

    public Eleve(String id, String nom, String prenom, String email,
                 String classe, String niveau, String tuteur) {
        super(id, nom, prenom, email);
        this.classe = classe;
        this.niveau = niveau;
        this.tuteur = tuteur;
    }

    @Override
    public void participer() {
        System.out.println(" L'élève " + nom + " " + prenom +
                " (classe " + classe + ") participe à l'activité");
    }

    @Override
    public String getType() {
        return "ÉLÈVE";
    }

    // Getters
    public String getClasse() { return classe; }
    public String getNiveau() { return niveau; }
    public String getTuteur() { return tuteur; }
}
