package org.example.strategies;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanningProjet implements PlanningStrategy {
    private List<Etape> etapes;
    private List<Jalon> jalons;

    public PlanningProjet() {
        this.etapes = new ArrayList<>();
        this.jalons = new ArrayList<>();
    }

    // Classe interne pour les étapes
    public static class Etape {
        String nom;
        String description;
        Date dateDebut;
        Date dateFin;
        boolean completee;

        public Etape(String nom, String description, Date dateDebut, Date dateFin) {
            this.nom = nom;
            this.description = description;
            this.dateDebut = dateDebut;
            this.dateFin = dateFin;
            this.completee = false;
        }
    }

    // Classe interne pour les jalons
    public static class Jalon {
        String nom;
        Date date;
        boolean atteint;

        public Jalon(String nom, Date date) {
            this.nom = nom;
            this.date = date;
            this.atteint = false;
        }
    }

    @Override
    public void genererPlanning(Club club) {
        System.out.println("\nPLANNING PROJET - " + club.getNom());
        System.out.println("════════════════════════════════════════");
        System.out.println("Type: Planning par étapes avec jalons");

        System.out.println("\n🔹 ÉTAPES DU PROJET:");
        for (int i = 0; i < etapes.size(); i++) {
            Etape etape = etapes.get(i);
            String statut = etape.completee ? "ok" : "pas encore";
            System.out.println("  " + (i + 1) + ". " + statut + " " + etape.nom);
            System.out.println("     " + etape.description);
            System.out.println("     Du " + etape.dateDebut + " au " + etape.dateFin);
        }

        System.out.println("\n🎯 JALONS IMPORTANTS:");
        for (Jalon jalon : jalons) {
            String statut = jalon.atteint ? "ok" : "en cours";
            System.out.println("  " + statut + " " + jalon.nom + " - " + jalon.date);
        }
    }

    @Override
    public boolean verifierDisponibilite(String jour, String heure) {
        return true; // Logique simplifiée
    }

    @Override
    public List<String> getCreneaux() {
        List<String> creneaux = new ArrayList<>();
        for (Etape etape : etapes) {
            creneaux.add(etape.nom + " (" + etape.dateDebut + " - " + etape.dateFin + ")");
        }
        return creneaux;
    }

    // Ajouter une étape
    public void ajouterEtape(String nom, String description, Date dateDebut, Date dateFin) {
        Etape etape = new Etape(nom, description, dateDebut, dateFin);
        etapes.add(etape);
        System.out.println("Étape ajoutée: " + nom);
    }

    // Ajouter un jalon
    public void ajouterJalon(String nom, Date date) {
        Jalon jalon = new Jalon(nom, date);
        jalons.add(jalon);
        System.out.println("Jalon ajouté: " + nom + " pour le " + date);
    }

    // Marquer une étape comme complétée
    public void completerEtape(String nomEtape) {
        for (Etape etape : etapes) {
            if (etape.nom.equals(nomEtape)) {
                etape.completee = true;
                System.out.println("Étape complétée: " + nomEtape);
                return;
            }
        }
    }

    // Marquer un jalon comme atteint
    public void atteindreJalon(String nomJalon) {
        for (Jalon jalon : jalons) {
            if (jalon.nom.equals(nomJalon)) {
                jalon.atteint = true;
                System.out.println("Jalon atteint: " + nomJalon);
                return;
            }
        }
    }
}