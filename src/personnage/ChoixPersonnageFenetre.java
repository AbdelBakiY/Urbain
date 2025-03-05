package personnage;

import accueil.PageAccueil;
import gui.GameDisplay;
import gui.InfoPanel;
import gui.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import engine.fixed.Position;

public class ChoixPersonnageFenetre extends JFrame {
    public Personnage getPersonnage1() {
		return personnage1;
	}

	public void setPersonnage1(Personnage personnage1) {
		this.personnage1 = personnage1;
	}

	public Personnage getPersonnage2() {
		return personnage2;
	}

	public void setPersonnage2(Personnage personnage2) {
		this.personnage2 = personnage2;
	}

	private JButton lancerJeuButton;
    private Queue<Personnage> personnagesSelectionnes = new LinkedList<>();
    private static final int MAX_PERSONNAGES_SELECTIONNES = 2;
    private Personnage personnage1;
    private Personnage personnage2;
    private class PersonnageButtonListener implements ActionListener {
        private final JButton button;
        private final Personnage personnage;

        public PersonnageButtonListener(JButton button, Personnage personnage) {
            this.button = button;
            this.personnage = personnage;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!personnagesSelectionnes.contains(personnage)) {
                if (personnagesSelectionnes.size() < MAX_PERSONNAGES_SELECTIONNES) {
                    personnagesSelectionnes.add(personnage);
                    personnage.setSelected(true);
                    button.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

                    if (personnagesSelectionnes.size() == MAX_PERSONNAGES_SELECTIONNES) {
                        lancerJeuButton.setEnabled(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(ChoixPersonnageFenetre.this,
                            "Vous ne pouvez choisir que deux personnages.",
                            "Erreur de sélection",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Annuler le choix du personnage
                personnagesSelectionnes.remove(personnage);
                personnage.setSelected(false);
                button.setBorder(BorderFactory.createEmptyBorder());

                // Désactiver le bouton de lancer le jeu si nécessaire
                if (personnagesSelectionnes.size() < MAX_PERSONNAGES_SELECTIONNES) {
                    lancerJeuButton.setEnabled(false);
                }
            }
        }
    }

    private class LancerJeuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (personnagesSelectionnes.size() == MAX_PERSONNAGES_SELECTIONNES) {
                 personnage1 = personnagesSelectionnes.poll();
                 personnage2 = personnagesSelectionnes.poll();

                 SwingUtilities.invokeLater(() -> MainGUI.getInstance("urbain",personnage1,personnage2));

                dispose();
            } else {
                JOptionPane.showMessageDialog(ChoixPersonnageFenetre.this,
                        "Veuillez sélectionner deux personnages pour jouer.",
                        "Erreur de sélection",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class RetourAccueilListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            SwingUtilities.invokeLater(() -> new PageAccueil().setVisible(true));        }
    }

    public ChoixPersonnageFenetre() {
        setTitle("Choix de Personnage");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem retourAccueilItem = new JMenuItem("Retour à l'accueil");
        retourAccueilItem.addActionListener(new RetourAccueilListener());
        menu.add(retourAccueilItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 5, 10, 10));
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        // Exemple de Personnage avec l'attribut selected
        ImageIcon[] sprites = new ImageIcon[9];
        sprites[0] = ImageLoader.loadImage("src/clients/client0/client_down1.png");
        sprites[1] = ImageLoader.loadImage("src/clients/client0/client_down2.png");
        sprites[2] = ImageLoader.loadImage("src/clients/client0/client_left1.png");
        sprites[3] = ImageLoader.loadImage("src/clients/client0/client_left2.png");
        sprites[4] = ImageLoader.loadImage("src/clients/client0/client_right1.png");
        sprites[5] = ImageLoader.loadImage("src/clients/client0/client_right2.png");
        sprites[6] = ImageLoader.loadImage("src/clients/client0/client_up1.png");
        sprites[7] = ImageLoader.loadImage("src/clients/client0/client_up2.png");
        sprites[8] = ImageLoader.loadImage("src/clients/client0/client.png");
        ImageIcon[] sprites2 = new ImageIcon[9];
        sprites2[0] = ImageLoader.loadImage("src/clients/client1/client_down1.png");
        sprites2[1] = ImageLoader.loadImage("src/clients/client1/client_down2.png");
        sprites2[2] = ImageLoader.loadImage("src/clients/client1/client_left1.png");
        sprites2[3] = ImageLoader.loadImage("src/clients/client1/client_left2.png");
        sprites2[4] = ImageLoader.loadImage("src/clients/client1/client_right1.png");
        sprites2[5] = ImageLoader.loadImage("src/clients/client1/client_right2.png");
        sprites2[6] = ImageLoader.loadImage("src/clients/client1/client_up1.png");
        sprites2[7] = ImageLoader.loadImage("src/clients/client1/client_up2.png");
        sprites2[8] = ImageLoader.loadImage("src/clients/client1/client.png");
        ImageIcon[] sprites3 = new ImageIcon[9];
        sprites3[0] = ImageLoader.loadImage("src/clients/client2/client_down1.png");
        sprites3[1] = ImageLoader.loadImage("src/clients/client2/client_down2.png");
        sprites3[2] = ImageLoader.loadImage("src/clients/client2/client_left1.png");
        sprites3[3] = ImageLoader.loadImage("src/clients/client2/client_left2.png");
        sprites3[4] = ImageLoader.loadImage("src/clients/client2/client_right1.png");
        sprites3[5] = ImageLoader.loadImage("src/clients/client2/client_right2.png");
        sprites3[6] = ImageLoader.loadImage("src/clients/client2/client_up1.png");
        sprites3[7] = ImageLoader.loadImage("src/clients/client2/client_up2.png");
        sprites3[8] = ImageLoader.loadImage("src/clients/client2/client.png");
        ImageIcon[] sprites4 = new ImageIcon[9];
        sprites4[0] = ImageLoader.loadImage("src/clients/client3/client_down1.png");
        sprites4[1] = ImageLoader.loadImage("src/clients/client3/client_down2.png");
        sprites4[2] = ImageLoader.loadImage("src/clients/client3/client_left1.png");
        sprites4[3] = ImageLoader.loadImage("src/clients/client3/client_left2.png");
        sprites4[4] = ImageLoader.loadImage("src/clients/client3/client_right1.png");
        sprites4[5] = ImageLoader.loadImage("src/clients/client3/client_right2.png");
        sprites4[6] = ImageLoader.loadImage("src/clients/client3/client_up1.png");
        sprites4[7] = ImageLoader.loadImage("src/clients/client3/client_up2.png");
        sprites4[8] = ImageLoader.loadImage("src/clients/client3/client.png");
        Personnage[] personnages = {
        		
            new Personnage(new Position(901,179),"Zinou", "Un sportif passionné, adorant suer et les défis.", new ImageIcon("src/images/image1.png"),sprites),
            new Personnage(new Position(901,179),"Camille", "Une étudiante exceptionnellement brillante, passionnée par la science et les énigmes.", new ImageIcon("src/images/image2.png"),sprites2),
            new Personnage(new Position(901,179),"Youcef", "Un individu charismatique mais dérangé, qui manipule les autres pour son plaisir personnel.", new ImageIcon("src/images/image3.png"),sprites3),
            new Personnage(new Position(901,179),"Nina", "Une brillante chercheuse scientifique spécialisée dans la génétique.", new ImageIcon("src/images/image4.png"),sprites4),
            new Personnage(new Position(901,179),"Rosa", "Une artiste de rue talentueuse qui utilise les murs de la ville comme toile.", new ImageIcon("src/images/image5.png"),sprites),
            new Personnage(new Position(901,179),"Akli", "Un chirurgien renommé, respecté pour ses compétences exceptionnelles.", new ImageIcon("src/images/image6.png"),sprites2),
            new Personnage(new Position(901,179),"Tahar", "Un détective privé astucieux et déterminé, spécialisé dans la résolution de mystères complexes.", new ImageIcon("src/images/image7.png"),sprites3),
            new Personnage(new Position(901,179),"Yacine", "Un musicien de rue talentueux qui égaye la ville avec sa musique envoûtante.", new ImageIcon("src/images/image8.png"),sprites4),
            new Personnage(new Position(901,179),"Bouzid", "Une archéologue passionnée par la découverte de civilisations anciennes.", new ImageIcon("src/images/image9.png"),sprites),
            new Personnage(new Position(901,179),"Idir", "Un bénévole dévoué, travaillant sans relâche pour améliorer la vie des autres.", new ImageIcon("src/images/image10.png"),sprites3)
        };

        for (Personnage personnage : personnages) {
            JPanel buttonPanel = new JPanel(new BorderLayout());
            JButton button = new JButton();

            button.addActionListener(new PersonnageButtonListener(button, personnage));

            button.setToolTipText(personnage.getDescription());
            button.setIcon(personnage.getImageIcon());

            buttonPanel.add(button, BorderLayout.CENTER);
            buttonPanel.add(new JLabel(personnage.getNom()), BorderLayout.SOUTH);

            mainPanel.add(buttonPanel);
        }

        lancerJeuButton = new JButton("Lancer le Jeu");
        lancerJeuButton.setEnabled(false);
        lancerJeuButton.addActionListener(new LancerJeuButtonListener());

        add(mainPanel, BorderLayout.CENTER);
        add(lancerJeuButton, BorderLayout.SOUTH);
        setIconImage(new ImageIcon("src/logoGL.png").getImage());

        setVisible(true);
    }
}

