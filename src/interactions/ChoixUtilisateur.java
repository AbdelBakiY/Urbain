package interactions;

import javax.swing.*;

import personnage.Personnage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoixUtilisateur {
	private Personnage personnage;
	public ChoixUtilisateur(Personnage personnage) {
	    this.personnage = personnage;
	}


    public void afficherDialogueCinema() {
        // Options pour la boîte de dialogue
        Object[] options = {"Regarder un film", "Aller au toilette", "Acheter de la nourriture"};
        int choix = JOptionPane.showOptionDialog(null, "Que voulez-vous faire ?", "Choix d'action",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

        switch (choix) {
            case 0: // Regarder un film
            	 personnage.modifyEnergy(15, "bonheur");
                break;
            case 1: // Aller au toilette
            	personnage.modifyEnergy(15, "hygiene");

                break;
            case 2: // Acheter de la nourriture
            	personnage.modifyEnergy(-15, "faim");                
                break;
            default:
                System.out.println("Aucune action choisie.");
                break;
        }
    }
    public void afficherDialogueHopital() {
        Object[] options = {"Consulter pour un bilan de santé (Santé +10%)", "Visiter un ami malade (Bonheur +15%)", "Faire un don de sang (Santé -25%)"};
        int choix = JOptionPane.showOptionDialog(null, "Que voulez-vous faire à l'hôpital ?", "Choix d'action",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (choix) {
            case 0:
                personnage.modifyEnergy(10, "sante");
                break;
            case 1:
                personnage.modifyEnergy(15, "bonheur");
                break;
            case 2:
               
                personnage.modifyEnergy(-25, "sante");
                break;
            default:
                System.out.println("Aucune action choisie.");
                break;
        }
    }
    
    public void afficherDialogueSalleDeSport() {
        Object[] options = {"Entraînement intensif ( sommeil -15%)", "Participer à une classe de groupe (Bonheur +15%)"};
        int choix = JOptionPane.showOptionDialog(null, "Que voulez-vous faire à la salle de sport ?", "Choix d'action",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (choix) {
            case 0:
                personnage.modifyEnergy(-15, "sommeil");

               break;
            case 1:
                personnage.modifyEnergy(15, "bonheur");
                break;
            default:
                System.out.println("Aucune action choisie.");
                break;
        }
    }




    public void afficherDialogueUniversite() {
        Object[] options = {"Assister à un cours (sommeil -10%)", "Emprunter des livres (Bonheur +10%)", "Participer à une conférence (Bonheur +20%)"};
        int choix = JOptionPane.showOptionDialog(null, "Que voulez-vous faire à l'université ?", "Choix d'action",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        switch (choix) {
            case 0:
                personnage.modifyEnergy(-10, "sommeil");
                break;
            case 1:
                personnage.modifyEnergy(10, "bonheur");
                break;
            case 2:
                personnage.modifyEnergy(20, "bonheur");
                break;
            default:
                System.out.println("Aucune action choisie.");
                break;
        }
    }


    
    public void afficherDialogueRestaurant() {
        Object[] options = {"Commander un repas (Faim -15%)", "Réserver une table (Bonheur +10%)", "Participer à un événement culinaire (Bonheur +20%)"};
        int choix = JOptionPane.showOptionDialog(null, "Que voulez-vous faire au restaurant ?", "Choix d'action",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (choix) {
            case 0:
                personnage.modifyEnergy(-15, "faim");
                break;
            case 1:
                personnage.modifyEnergy(10, "bonheur");
                break;
            case 2:
                personnage.modifyEnergy(20, "bonheur");
                break;
            default:
                System.out.println("Aucune action choisie.");
                break;
        }
    }


    
    public void afficherDialogueSupermarche() {
        Object[] options = {"Acheter des provisions (Faim -10%)", "Demander des informations (Bonheur +5%)", "Retourner un article (Bonheur +15%)"};
        int choix = JOptionPane.showOptionDialog(null, "Que voulez-vous faire au supermarché ?", "Choix d'action",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (choix) {
            case 0:
                personnage.modifyEnergy(-10, "faim");
                break;
            case 1:
                personnage.modifyEnergy(5, "bonheur");
                break;
            case 2:
                personnage.modifyEnergy(15, "bonheur");
                break;
            default:
                System.out.println("Aucune action choisie.");
                break;
        }
    }



    public void afficherDialogueMaison() {
        Object[] options = {"Se reposer (sommeil +20%)", "Prendre une douche (Hygiène +15%)", "Inviter des amis (Bonheur +30%)"};
        int choix = JOptionPane.showOptionDialog(null, "Que voulez-vous faire à la maison ?", "Choix d'action",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (choix) {
            case 0:
                personnage.modifyEnergy(20, "sommeil");
                break;
            case 1:
                personnage.modifyEnergy(15, "hygiene");
                break;
            case 2:
                personnage.modifyEnergy(30, "bonheur");
                break;
            default:
                System.out.println("Aucune action choisie.");
                break;
        }
    }
    
    public void afficherDialogueEntreprise() {
        Object[] options = {"Travailler (sommeil -15%, Bonheur -10%)", "Prendre une pause café (Énergie globale +10%, Bonheur +5%)"};
        int choix = JOptionPane.showOptionDialog(null, "Que voulez-vous faire à l'entreprise ?", "Choix d'action",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (choix) {
            case 0:
                personnage.modifyEnergy(-15, "sommeil");
                personnage.modifyEnergy(-10, "bonheur");
                break;
            case 1:
                personnage.modifyEnergy(15, "sommeil");
                personnage.modifyEnergy(5, "bonheur");
                break;
            default:
                System.out.println("Aucune action choisie.");
                break;
        }
    }

    public void afficherDialogueBoiteDeNuit() {
        Object[] options = {"Danser toute la nuit (sommeil -20%, Bonheur +30%)", "Prendre un verre au bar (sante -5%, Bonheur +10%)"};
        int choix = JOptionPane.showOptionDialog(null, "Que voulez-vous faire à la boîte de nuit ?", "Choix d'action",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (choix) {
            case 0:
                personnage.modifyEnergy(-20, "sommeil");
                personnage.modifyEnergy(30, "bonheur");
                break;
            case 1:
                personnage.modifyEnergy(20, "sommeil");
            	personnage.modifyEnergy(15, "faim");                

            	personnage.modifyEnergy(10, "bonheur");
                break;
            default:
                System.out.println("Aucune action choisie.");
                break;
        }
    }




    	
}

