package org.example.personnes;

public abstract class Membre {
    protected String id;
    protected String nom;
    protected String prenom;
    protected String email;

    public Membre(String id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Méthodes abstraites
    public abstract void participer();
    public abstract String getType();

    public void contacter() {
        System.out.println("Envoi d'un email à " + email);
    }

    // Getters
    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
}