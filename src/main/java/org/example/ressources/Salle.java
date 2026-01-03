package org.example.ressources;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Salle {
    private String numero;
    private int capacite;
    private List<String> equipements;
    private Map<String, Map<String, Boolean>> disponibilite; // jour -> heure -> disponible

    public Salle(String numero, int capacite) {
        this.numero = numero;
        this.capacite = capacite;
        this.equipements = new ArrayList<>();
        this.disponibilite = new HashMap<>();
        initialiserDisponibilite();
    }

    private void initialiserDisponibilite() {
        String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
        String[] heures = {"8h-9h", "9h-10h", "10h-11h", "11h-12h",
                "14h-15h", "15h-16h", "16h-17h", "17h-18h"};

        for (String jour : jours) {
            Map<String, Boolean> creneaux = new HashMap<>();
            for (String heure : heures) {
                creneaux.put(heure, true); // Toutes les salles sont disponibles par défaut
            }
            disponibilite.put(jour, creneaux);
        }
    }

    public void ajouterEquipement(String equipement) {
        if (!equipements.contains(equipement)) {
            equipements.add(equipement);
            System.out.println("Équipement ajouté à la salle " + numero + ": " + equipement);
        }
    }

    public boolean reserver(String jour, String heure) {
        if (disponibilite.containsKey(jour) &&
                disponibilite.get(jour).containsKey(heure)) {
            if (disponibilite.get(jour).get(heure)) {
                disponibilite.get(jour).put(heure, false);
                System.out.println("Salle " + numero + " réservée: " + jour + " " + heure);
                return true;
            } else {
                System.out.println("Salle " + numero + " non disponible: " + jour + " " + heure);
                return false;
            }
        }
        return false;
    }

    public void liberer(String jour, String heure) {
        if (disponibilite.containsKey(jour) &&
                disponibilite.get(jour).containsKey(heure)) {
            disponibilite.get(jour).put(heure, true);
            System.out.println("Salle " + numero + " libérée: " + jour + " " + heure);
        }
    }

    public boolean estDisponible(String jour, String heure) {
        return disponibilite.containsKey(jour) &&
                disponibilite.get(jour).containsKey(heure) &&
                disponibilite.get(jour).get(heure);
    }

    public void afficherInfos() {
        System.out.println("SALLE: " + numero);
        System.out.println("Capacité: " + capacite + " personnes");
        System.out.println("Équipements: " + equipements.size());
        for (String eq : equipements) {
            System.out.println("==> " + eq);
        }
    }

    // Getters
    public String getNumero() { return numero; }
    public int getCapacite() { return capacite; }
    public List<String> getEquipements() { return new ArrayList<>(equipements); }
}