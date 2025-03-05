package gui;
import javax.swing.*;

import personnage.Personnage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;



public class EnergyDetailsWindow extends JFrame implements EnergyUpdateListener {
    private Personnage currentCharacter;
    private List<JProgressBar> energyBars = new ArrayList<>();

    public EnergyDetailsWindow(Personnage currentCharacter) {
        this.currentCharacter = currentCharacter;
        this.currentCharacter.addUpdateListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Détails des énergies");
        setSize(300, 200);
        setLayout(new GridLayout(6, 1)); // Layout pour 6 barres d'énergie
        
        // Initialisation et ajout des barres d'énergie
        addEnergyBar("Faim", 0);
        addEnergyBar("Sommeil", 100);
        addEnergyBar("Hygiène", 100);
        addEnergyBar("Santé", 100);
        addEnergyBar("Bonheur", 100);
        addEnergyBar("Énergie Globale", 100);

        setVisible(true);
    }

    // Ajoute une barre d'énergie à l'interface
    private void addEnergyBar(String label, int initialValue) {
        JLabel barLabel = new JLabel(label);
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(initialValue);
        progressBar.setForeground(new Color(0, 128, 0)); // Couleur verte
        progressBar.setStringPainted(true); // Afficher la valeur numérique
        this.energyBars.add(progressBar);
        
        this.add(barLabel);
        this.add(progressBar);
    }


    @Override
    public void onEnergyUpdate() {
        SwingUtilities.invokeLater(() -> {
            if (energyBars.size() >= 6) { // Assurez-vous que la liste est pleinement peuplée
                energyBars.get(0).setValue(currentCharacter.getFaim());
                energyBars.get(1).setValue(currentCharacter.getSommeil());
                energyBars.get(2).setValue(currentCharacter.getHygiene());
                energyBars.get(3).setValue(currentCharacter.getSante());
                energyBars.get(4).setValue(currentCharacter.getBonheur());
                energyBars.get(5).setValue(currentCharacter.getEnergieGlobale());
            }
            
        });
    }

}
