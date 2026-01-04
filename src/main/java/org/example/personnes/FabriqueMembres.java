package org.example.personnes;

public class FabriqueMembres {
    private static int compteurEleve = 1;
    private static int compteurProfesseur = 1;
    private static int compteurIntervenant = 1;

    // Créer un élève
    public static Eleve creerEleve(String nom, String prenom, String email,
                                   String classe, String niveau, String tuteur) {
        System.out.println("--- Création d'un élève ---");
        String id = "E" + String.format("%04d", compteurEleve++);
        Eleve eleve = new Eleve(id, nom, prenom, email, classe, niveau, tuteur);
        System.out.println("Élève créé: " + id + " - " + nom + " " + prenom);
        return eleve;
    }

    // Créer un professeur
    public static Professeur creerProfesseur(String nom, String prenom, String email,
                                             String matiere, String salle, int heures) {
        System.out.println("--- Création d'un professeur ---");
        String id = "P" + String.format("%04d", compteurProfesseur++);
        Professeur prof = new Professeur(id, nom, prenom, email, matiere, salle, heures);
        System.out.println("Professeur créé: " + id + " - " + nom + " " + prenom);
        return prof;
    }

    // Créer un intervenant
    public static Intervenant creerIntervenant(String nom, String prenom, String email,
                                               String specialite, String organisme, String contrat) {
        String id = "I" + String.format("%04d", compteurIntervenant++);
        Intervenant intervenant = new Intervenant(id, nom, prenom, email,
                specialite, organisme, contrat);
        System.out.println("Intervenant créé: " + id + " - " + nom + " " + prenom);
        return intervenant;
    }

    // Réinitialiser les compteurs (utile pour les tests)
    public static void reinitialiserCompteurs() {
        compteurEleve = 1;
        compteurProfesseur = 1;
        compteurIntervenant = 1;
    }
}