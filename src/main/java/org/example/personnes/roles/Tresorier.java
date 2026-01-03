package org.example.personnes.roles;

import org.example.personnes.Membre;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tresorier extends RoleDecorator {
    private Map<String, Double> budget;

    public Tresorier(Membre membre) {
        super(membre);
        this.budget = new HashMap<>();
        budget.put("solde", 0.0);
    }

    @Override
    public List<String> getRoles() {
        return Arrays.asList("TRÉSORIER");
    }

    @Override
    public List<String> getResponsabilites() {
        return Arrays.asList(
                "Gérer le budget du club",
                "Suivre les dépenses",
                "Enregistrer les recettes",
                "Établir le bilan financier"
        );
    }

    public void gererBudget(double montant, String description) {
        double solde = budget.get("solde");
        solde += montant;
        budget.put("solde", solde);

        String operation = montant > 0 ? "Recette" : "Dépense";
        System.out.println(operation + ": " + Math.abs(montant) + "€ - " + description);
        System.out.println("   Nouveau solde: " + solde + "€");
    }

    public void afficherComptes() {
        System.out.println("\n ÉTAT DES COMPTES");
        System.out.println("   Solde actuel: " + budget.get("solde") + "€");
    }

    @Override
    public void participer() {
        super.participer();
        System.out.println("   ─> En tant que Trésorier du club");
    }
}
