package org.example.communication;





public interface Observateur {
    void update(String message, String type);
    String getIdentifiant();
}
