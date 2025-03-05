package gui;

import javax.swing.*;

import accueil.PageAccueil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import personnage.Personnage;

public class InfoPanel extends JPanel implements EnergyUpdateListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JButton switchCharacterButton;
    private GameDisplay gameDisplay;
    private JLabel characterNameLabel;
    private JLabel characterPhotoLabel;

    private JProgressBar globalEnergyBar;
    private JProgressBar hungerBar;
    private JProgressBar happinessBar;
    private JPanel energyPanel;

    private JButton openEnergyDetailsButton;

    private JPanel infoPanel;

    private Personnage personnageNPC;

    private Personnage currentCharacter;
    private Personnage OtherCurrentCharacter;

    private Personnage character1;
    private Personnage character2;
    //private TempsSimulation tempsSimulation; // Déclaration de la classe TempsSimulation
    private Timer timer;

    private JComboBox<String> cbDestinations;
    private JLabel tempsLabel;

	public TempsSimulation getTempsSimulation() {
		return tempsSimulation;
	}
	private int tempsEnSecondes=0;
    private int minutes=0;
    private TempsSimulation tempsSimulation= new TempsSimulation(minutes,tempsEnSecondes);
    public int getMinutes() {
		return minutes;
	}
	public InfoPanel(GameDisplay gameDisplay, Personnage character1, Personnage character2) {
        this.character1 = character1;
        this.character2 = character2;
        this.currentCharacter = character1;
        this.OtherCurrentCharacter=character2;
        this.gameDisplay = gameDisplay;


        this.currentCharacter.addUpdateListener(this);

        setLayout(new BorderLayout());

        characterNameLabel = new JLabel(currentCharacter.getNom());
        characterNameLabel.setForeground(new Color(218, 255, 243));
        characterNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 38, 5, 10));
        characterNameLabel.setFont(new Font(characterNameLabel.getFont().getName(), Font.PLAIN, 30));
        characterPhotoLabel = new JLabel(resizeImageIcon(currentCharacter.getImageIcon(), 120, 120));
        characterPhotoLabel.setBorder(BorderFactory.createEmptyBorder(5, 30, 10, 10));
        JPanel characterPanel = new JPanel();
        characterPanel.setLayout(new BoxLayout(characterPanel, BoxLayout.Y_AXIS));
        characterPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Marge autour du panneau du personnage
        characterPanel.setBackground(new Color(104, 136, 156));

        characterPanel.add(characterNameLabel);
        characterPanel.add(characterPhotoLabel);
        Dimension buttonSize = new Dimension(200, 30);


        switchCharacterButton = new JButton("Changer de personnage");

        switchCharacterButton.addActionListener(new SwitchCharacterListener());
        switchCharacterButton.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 30));
        switchCharacterButton.setPreferredSize(buttonSize);
        switchCharacterButton.setMaximumSize(buttonSize); // Définir la taille maximale

        energyPanel = new JPanel(); // Initialisez energyPanel avant d'appeler initializeEnergyBars()


        energyPanel.setLayout(new BoxLayout(energyPanel, BoxLayout.Y_AXIS));
        energyPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 30, 20));
        energyPanel.setBackground(new Color(104, 136, 156));

        initializeEnergyBars();
        updateEnergyBars();


        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));


        infoPanel.add(characterPanel);
        infoPanel.add(switchCharacterButton);
        infoPanel.add(energyPanel);

        initialiserComboBoxDestinations();


        infoPanel.setBackground(new Color(104, 136, 156));
        tempsSimulation.setTempsLabel(new JLabel("Temps dans Urbain : 0"));

        tempsSimulation.getTempsLabel().setForeground(Color.WHITE);
        tempsSimulation.getTempsLabel().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tempsSimulation.demarrerMiseAJourTemps();
        infoPanel.add(tempsSimulation.getTempsLabel());
        add(infoPanel, BorderLayout.EAST);

    }
    
    public void createMenuBar() {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        //JMenuItem pauseItem = new JMenuItem("Pause");
        JMenuItem returnHomeItem = new JMenuItem("Retour à l'accueil");
        JMenuItem helpItem = new JMenuItem("Aide");

        returnHomeItem.addActionListener(new ReturnHomeListener());
        helpItem.addActionListener(new HelpListener());

       // menu.add(pauseItem);
        menu.add(returnHomeItem);
        menu.add(helpItem);
        menuBar.add(menu);

        // Set menu bar for the parent frame
       
    }


    public JMenuBar getMenuBar() {
		return menuBar;
	}


	private class HelpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(InfoPanel.this,
                    "Voici de l'aide...",
                    "Aide",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class ReturnHomeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(InfoPanel.this);
            parentFrame.dispose();
            new PageAccueil().setVisible(true);
        }
    }

    private class SwitchCharacterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Changer de personnage
            if (currentCharacter == character1) {
                currentCharacter = character2;
                OtherCurrentCharacter=character1;
            } else {
                currentCharacter = character1;
                OtherCurrentCharacter=character2;
            }

            characterNameLabel.setText(currentCharacter.getNom());
            characterPhotoLabel.setIcon(resizeImageIcon(currentCharacter.getImageIcon(), 120, 120));

            // Mettre à jour l'image du personnage dans la zone de jeu
            gameDisplay.updateCharacterImage(OtherCurrentCharacter,currentCharacter);


            updateEnergyBars();
        }
    }

    private class EnergyDetailsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new EnergyDetailsWindow(currentCharacter).setVisible(true);
        }
    }
    private void allerAuRestaurant() {
        int x = 4;
        int y = 2;
        gameDisplay.simulerClicVersDestination(x, y);
    }

    private void allerAuCinema() {
        int x = 18;
        int y = 2;
        gameDisplay.simulerClicVersDestination(x, y);
    }

    private void allerALaBoiteDeNuit() {
        int x = 15;
        int y = 25;
        gameDisplay.simulerClicVersDestination(x, y);
    }

    private void allerALEntreprise() {
        int x = 4;
        int y = 25;
        gameDisplay.simulerClicVersDestination(x, y);
    }

    private void allerALHopital() {
        int x = 26;
        int y = 2;
        gameDisplay.simulerClicVersDestination(x, y);
    }

    private void allerALaMaison() {
        int x = 41;
        int y = 3;
        gameDisplay.simulerClicVersDestination(x, y);
    }

    private void allerALaMaisonDuVoisin() {
        int x = 41;
        int y = 16;
        gameDisplay.simulerClicVersDestination(x, y);
    }

    private void allerALUniversite() {
        int x = 4;
        int y = 11;
        gameDisplay.simulerClicVersDestination(x, y);
    }

    private void allerAuSupermarche() {
        int x = 28;
        int y =24;
        gameDisplay.simulerClicVersDestination(x, y);
    }

    private void allerAuGym() {
        int x =41;
        int y =25;
        gameDisplay.simulerClicVersDestination(x, y);
    }


    private void initialiserComboBoxDestinations() {
        String[] destinations = {"Choisir une action", "Aller au restaurant", "Aller au cinéma",
                "Aller à la boîte de nuit", "Aller à l'entreprise", "Aller à l'hôpital",
                "Aller à la maison", "Aller à la maison du voisin", "Aller à l'université",
                "Aller au supermarché", "Aller au gym"};
        cbDestinations = new JComboBox<>(destinations);
        cbDestinations.addActionListener(e -> executerActionDestination(cbDestinations.getSelectedIndex()));
        int width = 200; // Largeur réduite
        int height = cbDestinations.getPreferredSize().height; // Hauteur préservée
        cbDestinations.setMaximumSize(new Dimension(width, height));

        infoPanel.add(cbDestinations, BorderLayout.CENTER);
    }


    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }


    private void initializeEnergyBars() {
        Dimension preferredSize = new Dimension(10, 20); // Largeur de 200 et hauteur de 20

        // Label et barre pour l'Énergie Globale
        JLabel globalEnergyLabel = new JLabel("Énergie Globale:");
        globalEnergyBar = new JProgressBar(0, 100);
        globalEnergyBar.setValue(0); // Assurez-vous d'initialiser la valeur
        globalEnergyBar.setStringPainted(true);
        globalEnergyBar.setForeground(Color.GREEN); // Couleur verte
        globalEnergyBar.setPreferredSize(preferredSize);

        energyPanel.add(globalEnergyLabel);
        energyPanel.add(globalEnergyBar);

        // Label et barre pour la Faim
        JLabel hungerLabel = new JLabel("Faim:");
        hungerBar = new JProgressBar(0, 100);
        hungerBar.setValue(0); // Assurez-vous d'initialiser la valeur
        hungerBar.setStringPainted(true);
        hungerBar.setForeground(Color.ORANGE); // Couleur orange
        hungerBar.setPreferredSize(preferredSize);

        energyPanel.add(hungerLabel);
        energyPanel.add(hungerBar);

        // Label et barre pour le Bonheur
        JLabel happinessLabel = new JLabel("Bonheur:");
        happinessBar = new JProgressBar(0, 100);
        happinessBar.setValue(0); // Assurez-vous d'initialiser la valeur
        happinessBar.setStringPainted(true);
        happinessBar.setForeground(Color.BLUE); // Couleur bleue
        happinessBar.setPreferredSize(preferredSize);

        energyPanel.add(happinessLabel);
        energyPanel.add(happinessBar);

        // Ajout du bouton "Détails des énergies" dans energyPanel
        openEnergyDetailsButton = new JButton("Détails des énergies");
        openEnergyDetailsButton.addActionListener(new EnergyDetailsListener());
        Dimension buttonSize = new Dimension(200, 30);

        openEnergyDetailsButton.setPreferredSize(buttonSize);
        openEnergyDetailsButton.setMaximumSize(buttonSize);

        energyPanel.add(openEnergyDetailsButton);

        // Assurez-vous que le panel est correctement mis à jour
        energyPanel.revalidate();
        energyPanel.repaint();
    }


 // Met à jour les valeurs des barres d'énergie
    public void updateEnergyBars() {
        globalEnergyBar.setValue(currentCharacter.getEnergieGlobale());
        hungerBar.setValue(currentCharacter.getFaim());
        happinessBar.setValue(currentCharacter.getBonheur());
    }
    
    public void onEnergyUpdate() {
        updateEnergyBars();
    }
    private void executerActionDestination(int choix) {
        switch (choix) {
            case 1: allerAuRestaurant(); break;
            case 2: allerAuCinema(); break;
            case 3: allerALaBoiteDeNuit(); break;
            case 4: allerALEntreprise(); break;
            case 5: allerALHopital(); break;
            case 6: allerALaMaison(); break;
            case 7: allerALaMaisonDuVoisin(); break;
            case 8: allerALUniversite(); break;
            case 9: allerAuSupermarche(); break;
            case 10: allerAuGym(); break;
            default: break; // Cas pour "Choisir une action" ou tout autre choix non valide
        }
    }

}