package accueil;
import javax.swing.*;

import personnage.ChoixPersonnageFenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PageAccueil extends JFrame {

    public PageAccueil() {
        // Paramètres de la fenêtre
        setTitle("Page d'Accueil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Augmentation de la taille de la fenêtre
        setLocationRelativeTo(null); // Centrer la fenêtre
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon("src/logoGL.png").getImage());
        // Panneau avec l'arrière-plan d'image
        ImagePanel imagePanel = new ImagePanel("src/images/background.png");
        setContentPane(imagePanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Panneau principal pour organiser les composants
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false); // Rendre le panneau transparent

        // Ajouter une marge entre le haut et le texte "Bienvenue"
        mainPanel.add(Box.createVerticalStrut(60));

        // Texte de bienvenue
        JLabel bienvenueLabel = new JLabel("Bienvenue !");
        bienvenueLabel.setForeground(new Color(0, 180, 180)); // Définir la couleur du texte en blanc
        bienvenueLabel.setFont(new Font("Arial", Font.BOLD, 55)); // Définir la police et la taille du texte
        bienvenueLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrer le texte horizontalement
        mainPanel.add(bienvenueLabel);
        mainPanel.add(Box.createVerticalStrut(20)); // Ajouter un espace vertical entre les boutons

        // Texte d'instruction
        JLabel instructionLabel = new JLabel("<html><p style='width: 700px;'>"
                + "Explorez une ville dynamique et faites évoluer votre personnage dans notre jeu de simulation urbaine captivant. "
                + "Prenez des décisions cruciales, "
                + "interagissez avec la carte et façonnez le destin de votre "
                + "avatar dans cette expérience immersive."
                + "</p></html>");
        instructionLabel.setForeground(new Color(100, 0, 130));
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 23));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(instructionLabel);

        // Ajouter un espace vertical entre le texte d'instruction et les boutons

        // Définir une taille uniforme pour les boutons
        Dimension buttonSize = new Dimension(300, 80);

        // Ajouter les boutons centrés
        JButton boutonCommencer = new JButton("Commencer le match");
        JButton boutonCommentJouer = new JButton("Découvrir l'univers du jeu");

        boutonCommencer.setPreferredSize(buttonSize);
        boutonCommencer.setMaximumSize(buttonSize); // Définir la taille maximale
        boutonCommencer.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrer le bouton horizontalement
        boutonCommencer.setBackground(new Color(104, 136, 156));
        boutonCommentJouer.setBackground(new Color(104, 136, 156));
        
        
        
        boutonCommentJouer.setPreferredSize(buttonSize);
        boutonCommentJouer.setMaximumSize(buttonSize);
        boutonCommentJouer.setAlignmentX(Component.CENTER_ALIGNMENT);

        

        boutonCommencer.setBackground(imagePanel.getBackground());
        boutonCommentJouer.setBackground(imagePanel.getBackground());
        mainPanel.add(Box.createVerticalStrut(85)); // Ajouter un espace vertical entre les boutons

        mainPanel.add(boutonCommencer);
        mainPanel.add(Box.createVerticalStrut(20)); // Ajouter un espace vertical entre les boutons
        mainPanel.add(boutonCommentJouer);

        add(mainPanel, BorderLayout.CENTER);

        boutonCommencer.addActionListener(new CommencerMatchListener());
        boutonCommentJouer.addActionListener(new CommentJouerListener());
    }

    // Classe interne pour le panneau d'image en tant que fond
    class ImagePanel extends JPanel {
        private Image image;

        public ImagePanel(String imagePath) {
            this.image = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Classe interne pour gérer l'action du bouton "Commencer le match"
    private class CommencerMatchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose(); // Ferme la fenêtre d'accueil
            new ChoixPersonnageFenetre(); // Ouvre la fenêtre de choix de personnage
        }
    }

    // Classe interne pour gérer l'action du bouton "Comment jouer"
    private class CommentJouerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvre le navigateur Web par défaut avec le lien spécifié
            try {
                Desktop.getDesktop().browse(new URI("https://kafiz.alwaysdata.net/Urbain/index.html"));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Classe interne pour gérer l'action du bouton "À propos de nous"
    private class AProposListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(PageAccueil.this, "À propos de nous...");
        }
    }
    public static void main(String[] args) {
        // Exemple d'utilisation
        SwingUtilities.invokeLater(() -> new PageAccueil().setVisible(true));
    }
}

