package org.example.communication;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationSystem {
    private List<Observateur> observateurs;
    private List<String> historiqueNotifications;

    public NotificationSystem() {
        this.observateurs = new ArrayList<>();
        this.historiqueNotifications = new ArrayList<>();
    }

    // Attacher un observateur
    public void attacher(Observateur observateur) {
        if (!observateurs.contains(observateur)) {
            observateurs.add(observateur);
            System.out.println(" Observateur ajouté: " + observateur.getIdentifiant());
        }
    }

    // Détacher un observateur
    public void detacher(Observateur observateur) {
        if (observateurs.remove(observateur)) {
            System.out.println(" Observateur retiré: " + observateur.getIdentifiant());
        }
    }

    // Notifier tous les observateurs
    public void notifier(String message, String type) {
        String notification = "[" + new Date() + "] [" + type + "] " + message;
        historiqueNotifications.add(notification);

        System.out.println("\nNOTIFICATION ENVOYÉE");
        System.out.println("Type: " + type);
        System.out.println("Message: " + message);
        System.out.println("Destinataires: " + observateurs.size());

        for (Observateur obs : observateurs) {
            obs.update(message, type);
        }
    }

    // Notifier un groupe spécifique
    public void notifierGroupe(String message, String type, List<Observateur> groupe) {
        String notification = "[" + new Date() + "] [" + type + "] " + message;
        historiqueNotifications.add(notification);

        System.out.println("\nNOTIFICATION CIBLÉE");
        System.out.println("Message: " + message);
        System.out.println("Destinataires: " + groupe.size());

        for (Observateur obs : groupe) {
            if (observateurs.contains(obs)) {
                obs.update(message, type);
            }
        }
    }

    // Afficher l'historique
    public void afficherHistorique() {
        System.out.println("\nHISTORIQUE DES NOTIFICATIONS");
        for (int i = 0; i < historiqueNotifications.size(); i++) {
            System.out.println((i + 1) + ". " + historiqueNotifications.get(i));
        }
    }

    // Getters
    public int getNombreObservateurs() {
        return observateurs.size();
    }

    public List<String> getHistorique() {
        return new ArrayList<>(historiqueNotifications);
    }
}