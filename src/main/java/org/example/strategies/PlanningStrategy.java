package org.example.strategies;


import java.util.List;

public interface PlanningStrategy {
    void genererPlanning(Club club);
    boolean verifierDisponibilite(String jour, String heure);
    List<String> getCreneaux();
}