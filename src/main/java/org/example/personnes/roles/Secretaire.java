package org.example.personnes.roles;

import org.example.personnes.Membre;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Secretaire extends RoleDecorator {
    private List<String> comptesRendus;
    private List<String> notes;

    public Secretaire(Membre membre) {
        super(membre);
        this.comptesRendus = new ArrayList<>();
        this.notes = new ArrayList<>();
    }

    @Override
    public List<String> getRoles() {
        return Arrays.asList("SECRÉTAIRE");
    }

    @Override
    public List<String> getResponsabilites() {
        return Arrays.asList(
                "Rédiger les comptes-rendus",
                "Tenir les registres",
                "Gérer les communications écrites",
                "Archiver les documents"
        );
    }

    public void redigerCompteRendu(String titre, String contenu) {
        System.out.println("--- Rédaction du compte rendu ---");
        String cr = "[" + new java.util.Date() + "] " + titre + ": " + contenu;
        comptesRendus.add(cr);
        System.out.println("Compte-rendu rédigé: " + titre);
    }

    public void ajouterNote(String note) {
        notes.add(note);
        System.out.println("--> Note ajoutée: " + note);
    }

    public void afficherComptes() {
        System.out.println("\nCOMPTES-RENDUS (" + comptesRendus.size() + ")");
        for (int i = 0; i < comptesRendus.size(); i++) {
            System.out.println("   " + (i + 1) + ". " + comptesRendus.get(i));
        }
    }

    @Override
    public void participer() {
        super.participer();
        System.out.println(" ─> En tant que Secrétaire du club");
    }
}
