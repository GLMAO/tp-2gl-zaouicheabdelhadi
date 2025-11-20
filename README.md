[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/rGfOobSC)

zaouiche abdelhadi
cyber security
n:26

(bonus2):le code ne respecte pas principe solide :
preuve :
1. SRP (Single Responsibility Principle) - VIOLÉ
La classe a trop de responsabilités :

Gestion de la liste des cours
Gestion des observateurs (pattern Observer)
Logique métier (ajout/modification de cours)
Affichage console (System.out.println)
Vérification du type d'observateur (instanceof Etudiant)


2. OCP (Open/Closed Principle) - VIOLÉ dans la classe GestionnaireEmploiDuTemp
   
   ici la methode est notifier juste les etudiants

     public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        // TODO: C'est ici qu'il faudrait notifier les étudiants (Observer pattern)
        for (Observer o : observers) {
            if (o instanceof Etudiant) {   // Vérifie que l'observateur est un Etudiant
                o.update(cours.getDescription());
            }
        }
        
    }

