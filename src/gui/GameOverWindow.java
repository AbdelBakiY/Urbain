package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import accueil.PageAccueil;
import personnage.ChoixPersonnageFenetre;
import personnage.Personnage;

public class GameOverWindow extends JFrame {

    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 700;
    private static GameOverWindow instance;
    private static JLabel label ;

    private GameOverWindow(JLabel label) {
        super("Game Over");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension buttonSize = new Dimension(200, 50);
        JPanel gameOverPanel = new JPanel();
        gameOverPanel.setLayout(new BoxLayout(gameOverPanel, BoxLayout.Y_AXIS));
        gameOverPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        gameOverPanel.setBackground(Color.DARK_GRAY); // Fond sombre

        // Titre "GAME OVER" en rouge
        JLabel gameOverLabel = new JLabel("GAME OVER");
        gameOverLabel.setForeground(Color.RED);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Police en très gras et grande taille
        gameOverLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameOverPanel.add(gameOverLabel);
        
        gameOverPanel.add(Box.createVerticalStrut(20));

        this.label = label;
        this.label.setForeground(Color.WHITE);
        this.label.setFont(new Font("Arial", Font.BOLD, 23));
        this.label.setAlignmentX(Component.CENTER_ALIGNMENT);

        gameOverPanel.add(this.label); // Ajoute le label au panel

        JButton restartButton = new JButton("Recommencer");
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restartButton.addActionListener(new restartButtonListener());
        restartButton.setPreferredSize(buttonSize);
        restartButton.setMaximumSize(buttonSize); // Définir la taille maximale
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        gameOverPanel.add(Box.createVerticalStrut(50));
        gameOverPanel.add(restartButton);
        gameOverPanel.add(Box.createVerticalStrut(15));

        JButton retourneAc = new JButton("retourner a l'accueil");
        retourneAc.setAlignmentX(Component.CENTER_ALIGNMENT);
        retourneAc.addActionListener(new retourneAcListener());
        retourneAc.setPreferredSize(buttonSize);
        retourneAc.setMaximumSize(buttonSize); // Définir la taille maximale
        retourneAc.setAlignmentX(Component.CENTER_ALIGNMENT); 
        gameOverPanel.add(retourneAc);

        // Ajoute le panel à la fenêtre
        add(gameOverPanel);
        setVisible(true); // Rend la fenêtre visible
    }
    


    public static GameOverWindow getInstance(JLabel label) {
        if (instance == null) {
            instance = new GameOverWindow(label);
        }
        return instance;
    }

    public boolean isGameOver(Personnage personnage) {
        return personnage.getFaim() == 100 || personnage.getEnergieGlobale() == 0 || personnage.getBonheur() == 0
                || personnage.getHygiene() == 0 || personnage.getSante() == 0 || personnage.getSommeil() == 0;
    }
   
    
    

    private class restartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	dispose();
        	MainGUI.getInstance(getTitle(), null, null).fermerJeu();
        	SwingUtilities.invokeLater(() -> new ChoixPersonnageFenetre().setVisible(true));
        }
    }

    private class retourneAcListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	dispose();
        	MainGUI.getInstance(getTitle(), null, null).fermerJeu();
            new PageAccueil().setVisible(true); 
        }
    }
}
