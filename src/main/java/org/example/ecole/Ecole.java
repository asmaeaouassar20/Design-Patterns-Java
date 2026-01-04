package org.example.ecole;


import org.example.clubs.Club;
import java.util.ArrayList;
import java.util.List;


public class Ecole {
    // Instance unique (Singleton)
    private static Ecole instance;

    // Attributs
    private String nom;
    private String anneeScolaire;
    private List<Club> listeClubs;

    // Constructeur privé pour empêcher l'instanciation directe
    private Ecole() {
        this.listeClubs = new ArrayList<>();
    }

    // Méthode pour obtenir l'instance unique (thread-safe)
    public static synchronized Ecole getInstance() {
        if (instance == null) {
            instance = new Ecole();
        }
        return instance;
    }

    // Initialisation de l'école
    public void initialiser(String nom, String anneeScolaire) {
        this.nom = nom;
        this.anneeScolaire = anneeScolaire;
    }

    // Créer un club
    public void ajouterClub(Club club) {
        System.out.println("--- Ajout d'un club --- ");
        if (club != null && !listeClubs.contains(club)) {
            listeClubs.add(club);
            System.out.println("Club '" + club.getNom() + "' ajouté à l'école");
        }
    }

    // Lister tous les clubs
    public List<Club> listerClubs() {
        return new ArrayList<>(listeClubs);
    }

    // Trouver un club par nom
    public Club trouverClub(String nomClub) {
        return listeClubs.stream()
                .filter(club -> club.getNom().equalsIgnoreCase(nomClub))
                .findFirst()
                .orElse(null);
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    // Afficher les statistiques
    public void afficherStatistiques() {
        System.out.println("> Informations sur l'école : ");
        System.out.println("École: " + nom);
        System.out.println("Année: " + anneeScolaire);
        System.out.println("Nombre de clubs: " + listeClubs.size());
    }
}
