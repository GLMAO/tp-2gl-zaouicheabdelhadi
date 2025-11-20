package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject{
     
    private List<Observer> observers = new ArrayList<>();
    private List<ICours> listeCours = new ArrayList<>();

    //implementer methode attach
    public void attach(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    //implemnter detach
    public void detach(Observer o) {
        observers.remove(o);
    }

    //implementer notify()
    public void notifyObservers(String state) {
        for (Observer o : observers) {
            o.update(state);
        }
    }

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

    public void modifierCours(ICours cours, String message) {
        // Logique de modification...
        System.out.println("Cours modifié : " + message);
        // TODO: Notifier les observateurs ici aussi
        notifyObservers(message);
    }

    public void setChangement(String string) {
        // TODO Auto-generated method stub
        
        
        notifyObservers(string);
    }
}