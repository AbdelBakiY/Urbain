//package gui;
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//import javax.swing.Timer;
//
//import config.GameConfiguration;
//import engine.map.Block;
//import engine.map.Map;
//import engine.process.GameBuilder;
//import engine.process.NPCmanager;
//import personnage.ChoixPersonnageFenetre;
//import personnage.Personnage;
//import personnage.Personnage.Direction;
//
//public class MainGUI extends JFrame implements Runnable {
//
//	private static final long serialVersionUID = 1L;
//
//	private Map map;
//	private InfoPanel infopanel;
//	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
//
//	private GameDisplay dashboard;
//	private GameDisplay2 dashboard2;
//
//	private Personnage p1;
//	private Personnage p2;
//    private NPCmanager npcManager; 
//    
//    public InfoPanel getInfopanel() {
//		return infopanel;
//	}
//	private int targetX, targetY;
//    private Direction currentDirection = Direction.IDLE;
//    private boolean moving = false;
//
//
//
//
//
//	 public MainGUI(String title,Personnage p1,Personnage p2) {
//	        super(title);
//	        this.p1 = p1;
//	        this.p2=p2;
//
//	        init();
//	    }
//
//	 private void init() {
//		    Container contentPane = getContentPane();
//		    contentPane.setLayout(new BorderLayout());
//	        MouseControls mouseControls = new MouseControls();
//		    addMouseListener(mouseControls);
//		    map = GameBuilder.buildMap();
//		    npcManager = new NPCmanager(map); // Création de l'NPCmanager
//		    dashboard = new GameDisplay(map, p1, npcManager);
//		    dashboard2=new GameDisplay2(npcManager);
//		    infopanel = new InfoPanel(dashboard, p1, p2);
//		    dashboard.setIp(infopanel);
//		    dashboard.setPreferredSize(preferredSize);
//		    dashboard2.setPreferredSize(preferredSize);
//
//		    
//		    infopanel.createMenuBar();
//		    setJMenuBar(infopanel.getMenuBar());
//		    
//	        GameOverWindow gameOverWindow = new GameOverWindow(p1);
//		    if (gameOverWindow.isGameOver(p1)) {
//		        gameOverWindow.setVisible(true); // Afficher la fenêtre de Game Over
//		    }		    
//
//		    contentPane.add(dashboard2, BorderLayout.CENTER);
//		    contentPane.add(dashboard, BorderLayout.CENTER);
//
//		    contentPane.add(infopanel, BorderLayout.EAST);
//
//		    setDefaultCloseOperation(EXIT_ON_CLOSE);
//		    pack();
//		    setVisible(true);
//		    setPreferredSize(preferredSize);
//		    setResizable(false);
//
//		    // Démarrage du mouvement de l'NPC dès la création
//		    //npcManager.startNPCMovement();
//		}
//
//	@Override
//	public void run() {
//	    while (true) {
//	        try {
//	            Thread.sleep(GameConfiguration.GAME_SPEED);
//	        } catch (InterruptedException e) {
//	            System.out.println(e.getMessage());
//	        }
//	        // Redessine le panneau de jeu
//	        dashboard.repaint();
//	        dashboard2.repaint();
//
//	    }
//	}
//    private class MouseControls implements MouseListener {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            // Implémentez la logique de clic de souris ici
//            // Appelez les méthodes appropriées de GameDisplay en conséquence
//           // if (!moving) {
//                int tempTargetX = e.getX() / GameConfiguration.BLOCK_SIZE;
//                int tempTargetY = e.getY() / GameConfiguration.BLOCK_SIZE;
////                System.out.println(e.getX());
////                System.out.println(e.getY());
//                if (tempTargetX >= 0 && tempTargetX < map.getColumnCount() && tempTargetY >= 0 && tempTargetY < map.getLineCount()) {
//                    targetX = tempTargetX;
//                    targetY = tempTargetY;
//                    currentDirection = p1.calculateDirection(targetX, targetY);
//                    moving = true;
//                    dashboard.setTargetX(targetX);
//                    dashboard.setTargetY(targetY);
//                    dashboard.setCurrentDirection(currentDirection);
//                    dashboard.setMoving(moving);
//
//                    dashboard.getMoveTimer().start();
//             //   }
//            }
//        }
//
//        // Implémentez les autres méthodes de MouseListener avec des corps vides
//        @Override
//        public void mousePressed(MouseEvent e) {}
//
//        @Override
//        public void mouseReleased(MouseEvent e) {}
//
//        @Override
//        public void mouseEntered(MouseEvent e) {}
//
//        @Override
//        public void mouseExited(MouseEvent e) {}
//    }
//
//}
//
//
//
//






package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import config.GameConfiguration;
import engine.map.Map;
import engine.process.GameBuilder;
import engine.process.NPCmanager;
import personnage.Personnage;
import personnage.Personnage.Direction;

public class MainGUI extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private static MainGUI instance; // Instance unique de MainGUI
    private Map map;
    private InfoPanel infopanel;
    private static final Dimension preferredSize = new Dimension(1330, 662);

    private GameDisplay dashboard; // Gère le personnage principal et la map
    private GameDisplay2 dashboard2; // Gère uniquement les NPCs

    private Personnage p1;
    private Personnage p2;
    private NPCmanager npcManager;

    private int targetX, targetY;
    private Direction currentDirection = Direction.IDLE;
    private boolean moving = false;

    // Constructeur privé pour empêcher l'instanciation directe
    private MainGUI(String title, Personnage p1, Personnage p2) {
        super(title);
        this.p1 = p1;
        this.p2 = p2;
        init();
    }

    // Méthode pour obtenir l'instance unique de MainGUI
    public static MainGUI getInstance(String title, Personnage p1, Personnage p2) {
        if (instance == null) {
            instance = new MainGUI(title, p1, p2);
        }
        return instance;
    }

    private void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        MouseControls mouseControls = new MouseControls();
        addMouseListener(mouseControls);
        map = GameBuilder.buildMap();
        npcManager = new NPCmanager(map);
        dashboard = new GameDisplay(map, p2, p1, npcManager);
        dashboard2 = new GameDisplay2(npcManager);
        infopanel = new InfoPanel(dashboard, p1, p2);
        dashboard.setIp(infopanel);

        JLayeredPane layeredPane = new JLayeredPane();
        Dimension dashboardSize = new Dimension(map.getColumnCount() * GameConfiguration.BLOCK_SIZE, (map.getLineCount() + 3) * GameConfiguration.BLOCK_SIZE);
        layeredPane.setPreferredSize(dashboardSize);
        dashboard.setBounds(0, 0, dashboardSize.width, dashboardSize.height);
        dashboard2.setBounds(0, 0, dashboardSize.width, dashboardSize.height);

        layeredPane.add(dashboard, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(dashboard2, JLayeredPane.PALETTE_LAYER);

        contentPane.add(layeredPane, BorderLayout.CENTER);
        contentPane.add(infopanel, BorderLayout.EAST);

        infopanel.createMenuBar();
        setJMenuBar(infopanel.getMenuBar());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(preferredSize); // Forcer la taille de la fenêtre ici
        setResizable(false); // Empêche le redimensionnement de la fenêtre
        setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(GameConfiguration.GAME_SPEED);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            //dashboard.repaint();
            //dashboard2.repaint();
        }
    }

    public class MouseControls implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int tempTargetX = e.getX() / GameConfiguration.BLOCK_SIZE;
            int tempTargetY = e.getY() / GameConfiguration.BLOCK_SIZE;
            if (tempTargetX >= 0 && tempTargetX < map.getColumnCount() && tempTargetY >= 0 && tempTargetY < map.getLineCount()) {
                targetX = tempTargetX;
                targetY = tempTargetY;
                dashboard.setTargetX(targetX);
                dashboard.setTargetY(targetY);
                dashboard.setMoving(true);
                dashboard.getMoveTimer().start();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }

    public void fermerJeu() {
        this.dispose();
    }
}
