package gui;

import javax.swing.*;

import config.GameConfiguration;
import engine.fixed.Position;
import engine.map.Map;
import engine.process.NPCmanager;
import interactions.ChoixUtilisateur;
import personnage.ImageLoader;
import personnage.Personnage;
import personnage.Personnage.Direction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameDisplay extends JPanel  {
    private static final long serialVersionUID = 1L;
    private Personnage personnage;
    private Personnage personnage2;

    private Map map;
    private PaintStrategy paintStrategy = new PaintStrategy();
    
    public PaintStrategy getPaintStrategy() {
		return paintStrategy;
	}


	private boolean isPersonnageMoving=true;
    private boolean isNPCMoving=true;

    private Timer moveTimer=new Timer(23, e -> moveCharacterStep());
    private int targetX, targetY;
    private boolean moving = false;
    private int lastDialogX = -1; // Initialisation à -1 pour indiquer qu'aucun dialogue n'a été affiché
    private int lastDialogY = -1; // Initialisation à -1 pour indiquer qu'aucun dialogue n'a été affiché
    private int animationIndex = 0; // Déclaration de la variable animationIndex
    private Direction currentDirection = Direction.IDLE;
    private NPCmanager npcManager; 
    private Set<String> displayedDialogues = new HashSet<>();
    private int currentPathIndex=0;
    private InfoPanel ip;
	int loopPosition = 0;



    public InfoPanel getIp() {
		return ip;
	}


	public void setIp(InfoPanel ip) {
		this.ip = ip;
	}


	public GameDisplay(Map map, Personnage personnage2, Personnage personnage,NPCmanager npcManager) {
        this.map = map;
        this.personnage = personnage;
        this.personnage2=personnage2;
        this.npcManager=npcManager;
    }

   
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        paintStrategy.paint(ip,map, g, personnage);
        ImageIcon[] sprites =personnage.getSpriteMap().get(currentDirection);
		ImageIcon currentSprite = sprites[animationIndex];
        g.drawImage(currentSprite.getImage(), personnage.getX(), personnage.getY()-60, this); 
        g.drawImage(personnage2.getSpriteMap().get(Direction.IDLE)[0].getImage(), personnage2.getX(), personnage2.getY()-60, this); 

      
    }

	public void updateCharacterImage(Personnage characterC,Personnage character) {
        personnage = character;
        personnage2 = characterC;
        repaint(); // Redessiner la zone de jeu pour refléter le changement d'image du personnage
    }
	public void moveCharacterStep() {
	    int currentX = personnage.getX() / GameConfiguration.BLOCK_SIZE;
	    int currentY = personnage.getY() / GameConfiguration.BLOCK_SIZE;

	    if (currentX == targetX && currentY == targetY) {
	        isPersonnageMoving = false;
	        moving = false;
	        currentDirection = Direction.IDLE; // Assurez-vous que la direction est réinitialisée
	        //personnage.setImageIcon(personnage.getSpriteMap().get(Direction.IDLE)[0]);
	        handleDestinationReached(currentX, currentY);
	    } else {
	        moving = true;
	        isPersonnageMoving = true;
	        int dx = Integer.compare(targetX, currentX) *2;
	        int dy = Integer.compare(targetY, currentY) *2;
	        personnage.setX(personnage.getX() + dx);
	        personnage.setY(personnage.getY() + dy);

	        // Mise à jour de la direction basée sur le vecteur de mouvement
	        updateDirection(dx, dy);

	        // Mise à jour de l'index d'animation et récupération du sprite approprié
	        animationIndex = (animationIndex + 1) % personnage.getSpriteMap().get(currentDirection).length;
//	        ImageIcon currentSprite = personnage.getSpriteMap().get(currentDirection)[animationIndex];
//	        personnage.setImageIcon(currentSprite);

	        repaint(); // Force le composant à se redessiner
	    }
	}

	private void updateDirection(int dx, int dy) {
	    if (dx > 0) currentDirection = Direction.RIGHT;
	    else if (dx < 0) currentDirection = Direction.LEFT;
	    else if (dy > 0) currentDirection = Direction.DOWN;
	    else if (dy < 0) currentDirection = Direction.UP;
	}
	

    private void handleDestinationReached(int x, int y) {
        // Vérifie si le personnage a atteint un lieu spécifique qui déclenche un dialogue
        // Par exemple, cela pourrait vérifier la valeur de la case sur la carte et afficher un dialogue correspondant
        checkAndDisplayDialog(x, y);
    }

   private boolean foundInterestingThing(int x, int y,int n) {
	   int maxY = map.getMatrice().length; // La hauteur de la matrice
       int maxX = map.getMatrice()[0].length;
       boolean foundInterestingThing = false;
       for (int dy = -3; dy <= 2 && !foundInterestingThing; dy++) {
           for (int dx = -3; dx <= 2; dx++) {
               int checkX = x + dx;
               int checkY = y + dy;
               // Vérifie si les positions calculées sont dans les limites de la matrice
               if (checkX >= 0 && checkX < maxX && checkY >= 0 && checkY < maxY) {
                   // Vérifie si la position contient la valeur spécifique
                   if (map.getMatrice()[checkY][checkX] == n) {
                       foundInterestingThing = true;
                       break;
                   }
               }
           }
       }
       return foundInterestingThing ;
   }
   private void checkAndDisplayDialog(int x, int y) {
	    String positionKey = x + "-" + y;

	    if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 1)) {
	        new ChoixUtilisateur(personnage).afficherDialogueRestaurant();    
	        displayedDialogues.add(positionKey);
	    } else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 2)) {
	        new ChoixUtilisateur(personnage).afficherDialogueCinema();
	        displayedDialogues.add(positionKey);
	    }else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 3)) {
	        new ChoixUtilisateur(personnage).afficherDialogueHopital();
	        displayedDialogues.add(positionKey);
	    }else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 4)) {
	        new ChoixUtilisateur(personnage).afficherDialogueUniversite();
	        displayedDialogues.add(positionKey);
	    }else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 5)) {
	        new ChoixUtilisateur(personnage).afficherDialogueEntreprise();
	        displayedDialogues.add(positionKey);
	    }else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 6)) {
	        new ChoixUtilisateur(personnage).afficherDialogueBoiteDeNuit();
	        displayedDialogues.add(positionKey);
	    }else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 7)) {
	        new ChoixUtilisateur(personnage).afficherDialogueSupermarche();
	        displayedDialogues.add(positionKey);
	    }else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 20)) {
	        new ChoixUtilisateur(personnage).afficherDialogueSalleDeSport();
	        displayedDialogues.add(positionKey);
	    }else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 17)) {
	        new ChoixUtilisateur(personnage).afficherDialogueMaison();
	        displayedDialogues.add(positionKey);
	    }else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 18)) {
	        new ChoixUtilisateur(personnage).afficherDialogueSupermarche();
	        displayedDialogues.add(positionKey);
	    }else if (!displayedDialogues.contains(positionKey) && foundInterestingThing(x, y, 19)) {
	        new ChoixUtilisateur(personnage).afficherDialogueMaison();
	        displayedDialogues.add(positionKey);
	    }
	   
	}
    public void simulerClicVersDestination(int x, int y) {
        if (!moving && x >= 0 && x < map.getColumnCount() && y >= 0 && y < map.getLineCount()) {
            targetX = x;
            targetY = y;
            moving = true;
            moveTimer.start(); // Commence le déplacement vers les coordonnées spécifiées
        }
    }
    public Timer getMoveTimer() {
		return moveTimer;
	}



	public void setMoveTimer(Timer moveTimer) {
		this.moveTimer = moveTimer;
	}



	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

   
    
    public void setTargetX(int targetX) {
		this.targetX = targetX;
	}



	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}



	public void setMoving(boolean moving) {
		this.moving = moving;
	}


    
   
}
