package gui;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import config.GameConfiguration;
import engine.fixed.Position;
import engine.map.Map;
import engine.process.NPCmanager;
import personnage.Personnage;
import personnage.Personnage.Direction;

public class GameDisplay2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private Personnage personnage;
	private Map map;
	private PaintStrategy paintStrategy = new PaintStrategy();

	private boolean isPersonnageMoving = true;
	private boolean isNPCMoving = true;

	private Timer npcTimer = new Timer(33, e -> moveAlongPath());
	private boolean moving = false;
	private int lastDialogX = -1; // Initialisation à -1 pour indiquer qu'aucun dialogue n'a été affiché
	private int lastDialogY = -1; // Initialisation à -1 pour indiquer qu'aucun dialogue n'a été affiché
	private int animationIndex = 0; // Déclaration de la variable animationIndex
	private Direction currentDirection = Direction.IDLE;
	private NPCmanager npcManager;
	private Set<String> displayedDialogues = new HashSet<>();
	private int currentPathIndex = 0;
	private InfoPanel ip;
	int loopPosition = 0;
	Direction newDirection=Direction.IDLE;
	public GameDisplay2(NPCmanager npcManager) {
		setOpaque(false);
		this.npcManager = npcManager;
		npcTimer.start();
	}

	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    for (Personnage personnage : npcManager.getPersonnages()) {
	        ImageIcon[] sprites = personnage.getSpriteMap().get(personnage.getCurrentDirection());
	        ImageIcon currentSprite = sprites[animationIndex];
	        g.drawImage(currentSprite.getImage(), personnage.getX(), personnage.getY()-60, this);
	    }
	}

	public void moveAlongPath() {
		for (Personnage personnage : npcManager.getPersonnages()) {

			if (loopPosition < personnage.getPath().size()) {
				Position nextPosition = personnage.getPath().get(loopPosition);
				int currentX = personnage.getX() / GameConfiguration.BLOCK_SIZE;
				int currentY = personnage.getY() / GameConfiguration.BLOCK_SIZE;
				int nextX = nextPosition.getX() / GameConfiguration.BLOCK_SIZE;
				int nextY = nextPosition.getY() / GameConfiguration.BLOCK_SIZE;
				//currentDirection = personnage.calculateDirection(nextX, nextY);

				if (currentX == nextX && currentY == nextY) {
					// Si le personnage NPC est déjà à la position suivante, arrêtez le parcours
					if (loopPosition == personnage.getPath().size() - 1) {
						loopPosition = 0;
					} else {
						loopPosition++;
					}
					// System.out.println("ok");
				} else {
					moveCharacterStepNPC(personnage,nextPosition);
// System.out.println("not ok");
				}
			}
		}

	}

	public void moveCharacterStepNPC(Personnage personnage, Position position) {
	    int currentX = personnage.getX() / GameConfiguration.BLOCK_SIZE;
	    int currentY = personnage.getY() / GameConfiguration.BLOCK_SIZE;
	    int nextX = position.getX() / GameConfiguration.BLOCK_SIZE;
	    int nextY = position.getY() / GameConfiguration.BLOCK_SIZE;

	    Direction newDirection = personnage.calculateDirection(nextX, nextY);
	    personnage.setCurrentDirection(newDirection);  // Mettre à jour la direction du personnage

	    if (currentX == nextX && currentY == nextY) {
	        currentPathIndex++;
	        isNPCMoving = false;
	        moving = false;
	        ImageIcon[] spritesForDirection = personnage.getSpriteMap().get(Direction.IDLE);
	        ImageIcon currentSprite = spritesForDirection[animationIndex];
	        personnage.setImageIcon(currentSprite);
	    } else {
	        moving = true;
	        isNPCMoving = true;
	        int dx = Integer.compare(nextX, currentX) * 2;
	        int dy = Integer.compare(nextY, currentY) * 2;
	        personnage.setX(personnage.getX() + dx);
	        personnage.setY(personnage.getY() + dy);
	        animationIndex = (animationIndex + 1) % 2;
	        ImageIcon[] spritesForDirection = personnage.getSpriteMap().get(newDirection);
	        ImageIcon currentSprite = spritesForDirection[animationIndex];
	        personnage.setImageIcon(currentSprite);
	        repaint();
	    }

	    if (!moving) {
	        animationIndex = 0;
	    }
	}
}
