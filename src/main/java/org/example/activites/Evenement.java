package org.example.activites;




public class Evenement extends Activite {
    private String typeEvenement;
    private boolean publicExterne;
    private double budget;

    @Override
    public void executer() {
        System.out.println("\nÉVÉNEMENT: " + nom);
        System.out.println("- Type: " + typeEvenement);
        System.out.println("- Public externe: " + (publicExterne ? "Oui" : "Non"));
        System.out.println("- Budget: " + budget + "€");
        System.out.println("- Participants inscrits: " + participants.size());
    }

    // Getters et Setters
    public String getTypeEvenement() { return typeEvenement; }
    public void setTypeEvenement(String typeEvenement) { this.typeEvenement = typeEvenement; }

    public boolean isPublicExterne() { return publicExterne; }
    public void setPublicExterne(boolean publicExterne) { this.publicExterne = publicExterne; }

    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
}