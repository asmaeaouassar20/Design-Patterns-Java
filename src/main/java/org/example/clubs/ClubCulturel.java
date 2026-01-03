package org.example.clubs;

import java.util.ArrayList;
import java.util.List;

public class ClubCulturel extends Club {
    private String domaine;
    private String typeActivite;
    private List<String> materielSpecial;

    public ClubCulturel(String nom, String description, String domaine, String typeActivite) {
        super(nom, description);
        this.domaine = domaine;
        this.typeActivite = typeActivite;
        this.materielSpecial = new ArrayList<>();
    }

    public void ajouterMaterielSpecial(String materiel) {
        materielSpecial.add(materiel);
    }

    @Override
    public void organiserActivite() {
        System.out.println("Organisation d'une activité " + typeActivite +
                " dans le domaine " + domaine);
        System.out.println("   Matériel spécial requis: " + materielSpecial);
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("  → Type: Club Culturel");
        System.out.println("  → Domaine: " + domaine);
        System.out.println("  → Type d'activité: " + typeActivite);
        System.out.println("  → Matériel spécial: " + materielSpecial.size());
    }

    // Getters
    public String getDomaine() {
        return domaine;
    }

    public String getTypeActivite() {
        return typeActivite;
    }
}
