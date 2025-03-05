package gui;
import javax.swing.Timer;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TempsSimulation{
    private Timer timer;

    protected JLabel tempsLabel;

    public int getMinutes() {
		return minutes;
	}
	public JLabel getTempsLabel() {
		return tempsLabel;
	}
	public void setTempsLabel(JLabel tempsLabel) {
		this.tempsLabel = tempsLabel;
	}
	private int tempsEnSecondes=0;
    private int minutes=0;
	public TempsSimulation(int minutes,int tempsEnSecondes) {
		this.minutes=minutes;
		this.tempsEnSecondes=tempsEnSecondes;
	}
public void demarrerMiseAJourTemps() {
        // Crée un Timer pour mettre à jour le temps toutes les 1 seconde
        Timer timer = new Timer(1000, e -> {
            // Incrémente le temps
            incrementerTemps();

            // Met à jour l'affichage du temps
            tempsLabel.setText("Temps passé dans Urbain : " + tempsActuelEnMinutes());
        });

        // Démarre le timer
        timer.start();
    }
    public void incrementerTemps() {
        // Incrémente le temps en secondes
        tempsEnSecondes++;

        // Si une journée représente 4 minutes (soit 240 secondes)
        final int DUREE_JOURNEE_EN_SECONDES = 240;

        // Si le temps dépasse la durée d'une journée, on réinitialise le temps
        if (tempsEnSecondes >= DUREE_JOURNEE_EN_SECONDES) {
            tempsEnSecondes = 0;
            // Ici tu peux ajouter d'autres actions à effectuer à chaque nouvelle journée, comme réinitialiser certains éléments du jeu
        }
    }
    public String tempsActuelEnMinutes() {
        // Convertit le temps en minutes
    	minutes = tempsEnSecondes / 60;
        return tempsEnSecondes + " : " + minutes;
    }
}