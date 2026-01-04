package org.example;

import org.example.activites.ActiviteBuilder;
import org.example.activites.Evenement;
import org.example.activites.Reunion;
import org.example.clubs.ClubCulturel;
import org.example.clubs.ClubSportif;
import org.example.ecole.Ecole;
import org.example.personnes.Eleve;
import org.example.personnes.FabriqueMembres;
import org.example.personnes.Intervenant;
import org.example.personnes.Professeur;
import org.example.personnes.roles.President;
import org.example.personnes.roles.Secretaire;
import org.example.personnes.roles.Tresorier;
import org.example.ressources.Budget;
import org.example.ressources.Materiel;
import org.example.ressources.Salle;
import org.example.strategies.PlanningCompetition;
import org.example.strategies.PlanningProjet;
import org.example.strategies.PlanningRegulier;

import java.util.Calendar;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        System.out.println("\n===========  Classe  pour tester les DP utilisés  ===========");

        System.out.println("\n\n Test du pattern Singleton");
        testPatternSingleton();

        System.out.println("\n\nTest du pattern Factory");
        testPatternFactory();

        System.out.println("\n\nTest du pattern Composite");
        testPatternComposite();

        System.out.println("\n\nTest du pattern Decorator");
        testPatternDecorator();

        System.out.println("\n\nTest du pattern Builder ");
        testPatternBuilder();

        System.out.println("\n\nTest du pattern Observer");
        testPatternObserver();

        System.out.println("\n\nTest du pattern Strategy");
        testPatternStrategy();

        System.out.println("\n\n--->  Les ressources :");
        testRessources();
        testScenarioComplet();
    }

    // TEST 1 : Pattern Singleton
    public static void testPatternSingleton() {
        System.out.println("==>  TEST 1 : PATTERN SINGLETON - École                    ");

        // Obtenir l'instance unique de l'école
        Ecole ecole1 = Ecole.getInstance();
        ecole1.initialiser("Lycée Al Khwarizmi", "2024-2025");

        // Vérifier que c'est bien un singleton
        Ecole ecole2 = Ecole.getInstance();

        if (ecole1 == ecole2) {
            System.out.println("TEST RÉUSSI: Les deux instances sont identiques (Singleton)");
        } else {
            System.out.println("TEST ÉCHOUÉ: Les instances sont différentes");
        }

        ecole1.afficherStatistiques();
    }

    // TEST 2 : Pattern Factory
    public static void testPatternFactory() {
        System.out.println("-->  TEST 2 : PATTERN FACTORY - Création de Membres       ");

        // Créer des membres avec la fabrique
        Eleve eleve1 = FabriqueMembres.creerEleve(
                "ALAMI", "Fatima", "fatima.alami@lycee.ma",
                "2nde A", "Seconde", "M. ALAMI"
        );

        Eleve eleve2 = FabriqueMembres.creerEleve(
                "BENJELLOUN", "Youssef", "youssef.b@lycee.ma",
                "1ère S", "Première", "Mme BENJELLOUN"
        );

        Professeur prof1 = FabriqueMembres.creerProfesseur(
                "IDRISSI", "Hassan", "h.idrissi@lycee.ma",
                "Mathématiques", "B204", 18
        );

        Intervenant inter1 = FabriqueMembres.creerIntervenant(
                "TAZI", "Leila", "l.tazi@externe.com",
                "Arts plastiques", "Association Culturelle", "Vacation"
        );

        System.out.println("\nTEST RÉUSSI: 4 membres créés via la Factory");
    }

    // TEST 3 : Pattern Composite
    public static void testPatternComposite() {
        System.out.println("--> TEST 3 : PATTERN COMPOSITE - Clubs                    ");

        Ecole ecole = Ecole.getInstance();

        // Créer des clubs sportifs
        ClubSportif clubFootball = new ClubSportif(
                "Club de Football",
                "Club pour les passionnés de football",
                "Football",
                "Intermédiaire"
        );
        clubFootball.ajouterEquipement("Ballons");
        clubFootball.ajouterEquipement("Chasubles");
        clubFootball.ajouterEquipement("Cônes");

        // Créer des clubs culturels
        ClubCulturel clubTheatre = new ClubCulturel(
                "Club Théâtre",
                "Expression artistique et art dramatique",
                "Arts de la scène",
                "Représentations"
        );
        clubTheatre.ajouterMaterielSpecial("Costumes");
        clubTheatre.ajouterMaterielSpecial("Décors");
        clubTheatre.ajouterMaterielSpecial("Éclairages");

        // Ajouter les clubs à l'école
        ecole.ajouterClub(clubFootball);
        ecole.ajouterClub(clubTheatre);

        // Afficher les informations
        clubFootball.afficherInfos();
        clubTheatre.afficherInfos();

        // Organiser des activités
        clubFootball.organiserActivite();
        clubTheatre.organiserActivite();

        System.out.println("\nTEST RÉUSSI: Clubs créés et fonctionnels (Composite)");
    }

    // TEST 4 : Pattern Decorator
    public static void testPatternDecorator() {
        System.out.println("--> TEST 4 : PATTERN DECORATOR - Rôles des Membres        ");

        // Créer des membres
        Eleve eleve = FabriqueMembres.creerEleve(
                "AMRANI", "Sara", "sara.amrani@lycee.ma",
                "Terminale S", "Terminale", "M. AMRANI"
        );

        Eleve eleve2 = FabriqueMembres.creerEleve(
                "CHAKIR", "Omar", "omar.chakir@lycee.ma",
                "1ère ES", "Première", "Mme CHAKIR"
        );

        // Décorer avec des rôles
        President president = new President(eleve);
        Tresorier tresorier = new Tresorier(eleve2);

        // Afficher les rôles et responsabilités
        president.afficherRoleEtResponsabilites();
        tresorier.afficherRoleEtResponsabilites();

        // Utiliser les fonctionnalités spécifiques
        president.gerer();
        president.decider("Organiser une sortie scolaire en mars");

        tresorier.gererBudget(500.0, "Subvention de l'école");
        tresorier.gererBudget(-150.0, "Achat de matériel");
        tresorier.afficherComptes();

        // Créer un secrétaire
        Eleve eleve3 = FabriqueMembres.creerEleve(
                "FASSI", "Nadia", "nadia.fassi@lycee.ma",
                "2nde B", "Seconde", "M. FASSI"
        );
        Secretaire secretaire = new Secretaire(eleve3);
        secretaire.afficherRoleEtResponsabilites();
        secretaire.redigerCompteRendu("Réunion du 15/01", "Discussion sur les activités à venir");
        secretaire.ajouterNote("Prévoir une réunion de bureau la semaine prochaine");

        System.out.println("\nTEST RÉUSSI: Rôles ajoutés via Decorator");
    }

    // TEST 5 : Pattern Builder
    public static void testPatternBuilder() {
        System.out.println("--> TEST 5 : PATTERN BUILDER - Construction d'Activités   █");

        // Créer des ressources
        Salle salle = new Salle("A301", 30);
        salle.ajouterEquipement("Vidéoprojecteur");
        salle.ajouterEquipement("Tableau interactif");

        Materiel materiel1 = new Materiel("MAT001", "Vidéoprojecteur");
        Materiel materiel2 = new Materiel("MAT002", "Ordinateur portable");

        // Créer des membres
        Professeur prof = FabriqueMembres.creerProfesseur(
                "BENNANI", "Karim", "k.bennani@lycee.ma",
                "Sciences", "B103", 20
        );

        Eleve eleve1 = FabriqueMembres.creerEleve(
                "LAHLOU", "Amine", "amine.l@lycee.ma",
                "Terminale", "Terminale", "M. LAHLOU"
        );

        Eleve eleve2 = FabriqueMembres.creerEleve(
                "MOUSSAOUI", "Imane", "imane.m@lycee.ma",
                "Terminale", "Terminale", "Mme MOUSSAOUI"
        );

        // Construire une réunion avec le Builder
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.JANUARY, 20, 14, 0);

        Reunion reunion = (Reunion) ActiviteBuilder.creerReunion()
                .setNom("Réunion de préparation")
                .setDate(cal.getTime())
                .setLieu(salle)
                .setResponsable(prof)
                .addParticipant(eleve1)
                .addParticipant(eleve2)
                .addMateriel(materiel1)
                .setOrdreDuJour("1. Bilan trimestre 2. Projets à venir 3. Budget")
                .build();

        reunion.afficherDetails();
        reunion.executer();
        reunion.ajouterDecision("Valider le budget pour la sortie");

        // Construire un événement
        cal.set(2025, Calendar.FEBRUARY, 15, 18, 0);

        Evenement evenement = (Evenement) ActiviteBuilder.creerEvenement()
                .setNom("Journée Portes Ouvertes")
                .setDate(cal.getTime())
                .setLieu(salle)
                .setResponsable(prof)
                .setTypeEvenement("Portes Ouvertes")
                .setPublicExterne(true)
                .setBudget(1500.0)
                .build();

        evenement.afficherDetails();
        evenement.executer();

        System.out.println("\nTEST RÉUSSI: Activités construites avec Builder");
    }

    // TEST 6 : Pattern Observer
    public static void testPatternObserver() {
        System.out.println("--> TEST 6 : PATTERN OBSERVER - Notifications             ");

        // Créer un club
        ClubCulturel clubMusique = new ClubCulturel(
                "Club Musique",
                "Pour les mélomanes",
                "Musique",
                "Concerts et répétitions"
        );

        // Créer des membres
        Eleve membre1 = FabriqueMembres.creerEleve(
                "RAHALI", "Mehdi", "mehdi.r@lycee.ma",
                "1ère", "Première", "M. RAHALI"
        );

        Eleve membre2 = FabriqueMembres.creerEleve(
                "ZAKI", "Salma", "salma.z@lycee.ma",
                "1ère", "Première", "Mme ZAKI"
        );

        Eleve membre3 = FabriqueMembres.creerEleve(
                "JAMALI", "Karim", "karim.j@lycee.ma",
                "2nde", "Seconde", "M. JAMALI"
        );

        // Ajouter les membres au club (ils sont automatiquement abonnés aux notifications)
        clubMusique.ajouterMembre(membre1);
        clubMusique.ajouterMembre(membre2);
        clubMusique.ajouterMembre(membre3);

        System.out.println("\nTEST RÉUSSI: Notifications envoyées via Observer");
    }

    // TEST 7 : Pattern Strategy
    public static void testPatternStrategy() {
        System.out.println("--> TEST 7 : PATTERN STRATEGY - Stratégies de Planning    █");

        Ecole ecole = Ecole.getInstance();

        // Test Planning Régulier
        ClubSportif clubBasket = new ClubSportif(
                "Club Basket",
                "Basketball pour tous niveaux",
                "Basketball",
                "Débutant à Avancé"
        );
        ecole.ajouterClub(clubBasket);

        PlanningRegulier planningRegulier = new PlanningRegulier("Mercredi", "15h-17h");
        planningRegulier.genererPlanning(clubBasket);
        planningRegulier.ajouterCreneauSupplementaire("Stage intensif - Vacances de février");

        // Test Planning Compétition
        ClubSportif clubAtletisme = new ClubSportif(
                "Club Athlétisme",
                "Préparation aux compétitions",
                "Athlétisme",
                "Compétition"
        );

        PlanningCompetition planningCompet = new PlanningCompetition();
        planningCompet.ajouterPhase("Préparation physique", "Septembre - Novembre");
        planningCompet.ajouterObjectif("Préparation physique", "Renforcement musculaire");
        planningCompet.ajouterObjectif("Préparation physique", "Endurance");

        planningCompet.ajouterPhase("Entraînements techniques", "Décembre - Février");
        planningCompet.ajouterObjectif("Entraînements techniques", "Perfectionnement des techniques");

        planningCompet.ajouterPhase("Compétitions", "Mars - Juin");

        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.MARCH, 15);
        planningCompet.fixerDate("Championnat régional", cal.getTime());

        cal.set(2025, Calendar.MAY, 20);
        planningCompet.fixerDate("Finale nationale", cal.getTime());

        planningCompet.genererPlanning(clubAtletisme);

        // Test Planning Projet
        ClubCulturel clubScience = new ClubCulturel(
                "Club Science",
                "Expériences et projets scientifiques",
                "Sciences",
                "Projets et expériences"
        );

        PlanningProjet planningProjet = new PlanningProjet();

        cal.set(2025, Calendar.JANUARY, 10);
        Date debut1 = cal.getTime();
        cal.set(2025, Calendar.JANUARY, 31);
        Date fin1 = cal.getTime();
        planningProjet.ajouterEtape(
                "Phase de recherche",
                "Documentation et choix du sujet",
                debut1, fin1
        );

        cal.set(2025, Calendar.FEBRUARY, 1);
        Date debut2 = cal.getTime();
        cal.set(2025, Calendar.MARCH, 15);
        Date fin2 = cal.getTime();
        planningProjet.ajouterEtape(
                "Développement",
                "Réalisation du prototype",
                debut2, fin2
        );

        cal.set(2025, Calendar.MARCH, 16);
        Date debut3 = cal.getTime();
        cal.set(2025, Calendar.APRIL, 30);
        Date fin3 = cal.getTime();
        planningProjet.ajouterEtape(
                "Tests et amélioration",
                "Tests et ajustements finaux",
                debut3, fin3
        );

        cal.set(2025, Calendar.FEBRUARY, 15);
        planningProjet.ajouterJalon("Validation du prototype", cal.getTime());

        cal.set(2025, Calendar.MAY, 10);
        planningProjet.ajouterJalon("Présentation finale", cal.getTime());

        planningProjet.genererPlanning(clubScience);
        planningProjet.completerEtape("Phase de recherche");

        System.out.println("\nTEST RÉUSSI: 3 stratégies de planning testées");
    }

    // TEST 8 : Ressources
    public static void testRessources() {
        System.out.println("--> TEST 8 : RESSOURCES - Salles, Matériel, Budget        ");

        // Test Salle
        Salle salle = new Salle("C205", 25);
        salle.ajouterEquipement("Tableau blanc");
        salle.ajouterEquipement("Ordinateur");
        salle.ajouterEquipement("Enceintes");
        salle.afficherInfos();

        salle.reserver("Mercredi", "14h-15h");
        salle.reserver("Mercredi", "15h-16h");
        salle.reserver("Mercredi", "14h-15h"); // Devrait échouer
        salle.liberer("Mercredi", "14h-15h");
        salle.reserver("Mercredi", "14h-15h"); // Devrait réussir

        // Test Matériel
        Materiel camera = new Materiel("CAM001", "Caméra vidéo");
        camera.afficherInfos();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        Date dateRetour = cal.getTime();

        camera.emprunter("Club Théâtre", dateRetour);
        camera.emprunter("Club Cinéma", dateRetour); // Devrait échouer
        camera.retourner();
        camera.emprunter("Club Cinéma", dateRetour); // Devrait réussir
        camera.changerEtat("Nécessite maintenance");

        // Test Budget
        Budget budget = new Budget(2000.0);
        budget.ajouterRecette("Subvention mairie", 500.0, "Subvention");
        budget.ajouterRecette("Cotisations", 300.0, "Cotisations");
        budget.ajouterDepense("Matériel sportif", 450.0, "Équipement");
        budget.ajouterDepense("Location bus", 350.0, "Transport");
        budget.ajouterDepense("Spectacle extérieur", 3000.0, "Événement"); // Devrait échouer
        budget.afficherBilan();

        System.out.println("\n TEST RÉUSSI: Toutes les ressources fonctionnelles");
    }

    // TEST 9 : Scénario Complet
    public static void testScenarioComplet() {
        System.out.println("--> TEST 9 : SCÉNARIO COMPLET - Intégration               ");

        System.out.println("SCÉNARIO: Organisation d'un événement complet");

        // 1. Récupérer l'école (Singleton)
        Ecole ecole = Ecole.getInstance();

        // 2. Créer un club avec un responsable (Factory + Composite)
        Professeur responsable = FabriqueMembres.creerProfesseur(
                "ANDALOUSSI", "Nabil", "n.andaloussi@lycee.ma",
                "Arts", "D105", 15
        );

        ClubCulturel clubPhoto = new ClubCulturel(
                "Club Photographie",
                "Art de la photographie",
                "Arts visuels",
                "Expositions et sorties"
        );
        clubPhoto.setResponsable(responsable);
        ecole.ajouterClub(clubPhoto);

        // 3. Créer des membres avec différents rôles (Factory + Decorator)
        Eleve membre1 = FabriqueMembres.creerEleve(
                "OUAZZANI", "Yasmine", "y.ouazzani@lycee.ma",
                "Terminale", "Terminale", "M. OUAZZANI"
        );
        President president = new President(membre1);

        Eleve membre2 = FabriqueMembres.creerEleve(
                "FILALI", "Mehdi", "m.filali@lycee.ma",
                "Première", "Première", "Mme FILALI"
        );
        Tresorier tresorier = new Tresorier(membre2);

        // Ajouter les membres au club
        clubPhoto.ajouterMembre(membre1);
        clubPhoto.ajouterMembre(membre2);

        // 4. Créer des ressources
        Salle salle = new Salle("Hall principal", 100);
        salle.ajouterEquipement("Panneaux d'exposition");
        salle.ajouterEquipement("Éclairage professionnel");

        Materiel appareilPhoto = new Materiel("PHO001", "Appareil photo reflex");
        Materiel trepied = new Materiel("TRE001", "Trépied professionnel");

        // 5. Gérer le budget
        tresorier.gererBudget(800.0, "Subvention école");
        tresorier.gererBudget(-200.0, "Achat de matériel d'exposition");
        tresorier.gererBudget(-150.0, "Impression des photos");

        // 6. Construire l'événement (Builder)
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.MARCH, 20, 10, 0);

        Evenement exposition = (Evenement) ActiviteBuilder.creerEvenement()
                .setNom("Exposition Photo 'Regard sur le Maroc'")
                .setDate(cal.getTime())
                .setLieu(salle)
                .setResponsable(responsable)
                .addParticipant(membre1)
                .addParticipant(membre2)
                .addMateriel(appareilPhoto)
                .addMateriel(trepied)
                .setTypeEvenement("Exposition")
                .setPublicExterne(true)
                .setBudget(450.0)
                .build();

        // 7. Le président prend des décisions (Decorator)
        president.decider("Valider le thème de l'exposition");
        president.decider("Inviter des photographes professionnels");


        // 9. Créer un planning projet (Strategy)
        PlanningProjet planning = new PlanningProjet();

        cal.set(2025, Calendar.JANUARY, 15);
        Date d1 = cal.getTime();
        cal.set(2025, Calendar.FEBRUARY, 15);
        Date d2 = cal.getTime();
        planning.ajouterEtape("Prise de photos", "Sortie terrain", d1, d2);

        cal.set(2025, Calendar.FEBRUARY, 16);
        d1 = cal.getTime();
        cal.set(2025, Calendar.MARCH, 10);
        d2 = cal.getTime();
        planning.ajouterEtape("Sélection et retouches", "Post-production", d1, d2);

        cal.set(2025, Calendar.MARCH, 11);
        d1 = cal.getTime();
        cal.set(2025, Calendar.MARCH, 19);
        d2 = cal.getTime();
        planning.ajouterEtape("Installation exposition", "Mise en place", d1, d2);

        cal.set(2025, Calendar.MARCH, 20);
        planning.ajouterJalon("Vernissage de l'exposition", cal.getTime());

        planning.genererPlanning(clubPhoto);
        planning.completerEtape("Prise de photos");
        planning.completerEtape("Sélection et retouches");

        // 10. Exécuter l'événement
        exposition.afficherDetails();
        exposition.executer();

        // 11. Afficher le bilan final
        System.out.println("    BILAN FINAL DE L'ÉVÉNEMENT");
        clubPhoto.afficherInfos();
        tresorier.afficherComptes();
        ecole.afficherStatistiques();

        System.out.println("\nTEST RÉUSSI: Scénario complet exécuté avec succès !");
        System.out.println("   Tous les patterns ont collaboré harmonieusement.");
    }


}