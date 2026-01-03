package org.example.personnes;

public class Intervenant extends Membre {
    private String specialite;
    private String organisme;
    private String contrat;

    public Intervenant(String id, String nom, String prenom, String email,
                       String specialite, String organisme, String contrat) {
        super(id, nom, prenom, email);
        this.specialite = specialite;
        this.organisme = organisme;
        this.contrat = contrat;
    }

    @Override
    public void participer() {
        System.out.println("L'intervenant " + nom + " " + prenom +
                " (spécialité: " + specialite + ") anime l'activité");
    }

    @Override
    public String getType() {
        return "INTERVENANT";
    }

    // Getters
    public String getSpecialite() { return specialite; }
    public String getOrganisme() { return organisme; }
    public String getContrat() { return contrat; }
}

