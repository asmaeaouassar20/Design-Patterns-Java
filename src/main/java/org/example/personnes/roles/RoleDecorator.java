package org.example.personnes.roles;

import org.example.personnes.Membre;
import java.util.ArrayList;
import java.util.List;

/**
 * Pattern Decorator - Classe de base pour décorer les membres avec des rôles
 */
public abstract class RoleDecorator extends Membre {
    protected Membre membre;

    public RoleDecorator(Membre membre) {
        super(membre.getId(), membre.getNom(), membre.getPrenom(), membre.getEmail());
        this.membre = membre;
    }

    // Méthodes abstraites pour les rôles
    public abstract List<String> getRoles();
    public abstract List<String> getResponsabilites();

    @Override
    public void participer() {
        membre.participer();
    }

    @Override
    public String getType() {
        return membre.getType();
    }

    // Afficher les informations avec le rôle
    public void afficherRoleEtResponsabilites() {
        System.out.println(" --- Afficher le rôle et les responsabilités ---");
        System.out.println("- MEMBRE: " + nom + " " + prenom);
        System.out.println("- ID: " + id);
        System.out.println("- Type: " + getType());
        System.out.println("- Rôles: " + String.join(", ", getRoles()));
        System.out.println("- Responsabilités:");
        for (String resp : getResponsabilites()) {
            System.out.println(resp);
        }
    }
}

