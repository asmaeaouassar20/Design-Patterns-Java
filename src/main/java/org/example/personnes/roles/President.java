package org.example.personnes.roles;

import org.example.personnes.Membre;
import java.util.Arrays;
import java.util.List;

public class President extends RoleDecorator {

    public President(Membre membre) {
        super(membre);
    }

    @Override
    public List<String> getRoles() {
        return Arrays.asList("PRÉSIDENT");
    }

    @Override
    public List<String> getResponsabilites() {
        return Arrays.asList(
                "Représenter le club",
                "Organiser les réunions",
                "Prendre les décisions importantes",
                "Coordonner les activités"
        );
    }

    public void gerer() {
        System.out.println( nom + " " + prenom + " gère les affaires du club");
    }

    public void decider(String decision) {
        System.out.println("  Décision prise par le président: " + decision);
    }

    @Override
    public void participer() {
        super.participer();
        System.out.println(" ─> En tant que Président du club");
    }
}
