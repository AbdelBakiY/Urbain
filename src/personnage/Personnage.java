package personnage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import gui.EnergyUpdateListener ;
import gui.GameOverWindow;

import javax.swing.*;

import config.GameConfiguration;
import engine.fixed.LieuRegistry;
import engine.fixed.Position;
import engine.map.*;

public class Personnage {
	private int x, y;
    private String nom;
    private String description;
    private Map map;
    private ImageIcon imageIcon;
    private boolean selected;
    private LieuRegistry lieuRegistry;
    
    private boolean gameOverWindowOpened = false; 

    
  
	

	private int faim;
    private int sommeil;
    private int hygiene;
    private int sante;
    private int energieGlobale;
    private int bonheur;
    
    private Timer timerFaim;
    private Timer timerHygiene;
    private Timer timerSommeil;
    private Timer timerBonheur;
    private Position depart;
	private List<Position> path = new ArrayList<>(); // Initialisez la liste de chemin en dehors de la méthode
    public enum Direction {
        UP, DOWN, LEFT, RIGHT, IDLE
    }
    private HashMap<Direction, ImageIcon[]> spriteMap;
    private List<EnergyUpdateListener> updateListeners = new ArrayList<>();
    private Direction currentDirection = Direction.IDLE; // Initialise avec IDLE ou toute autre valeur par défaut
    // Autres attributs existants...

    // Getters et Setters
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    
    public void setNom(String nom) {
		this.nom = nom;
	}
	public HashMap<Direction, ImageIcon[]> getSpriteMap() {
		return spriteMap;
	}

	public void setSpriteMap(HashMap<Direction, ImageIcon[]> spriteMap) {
		this.spriteMap = spriteMap;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	
	public Direction calculateDirection(int targetX, int targetY) {
	    int currentX = x / GameConfiguration.BLOCK_SIZE;
	    int currentY = y / GameConfiguration.BLOCK_SIZE;

	    if (currentX < targetX) {
	        return Direction.RIGHT;
	    } else if (currentX > targetX) {
	        return Direction.LEFT;
	    } else if (currentY < targetY) {
	        return Direction.DOWN;
	    } else if (currentY > targetY) {
	        return Direction.UP;
	    } else {
	        return Direction.IDLE; // Le personnage est immobile
	    }
	}
    public Personnage(String nom, String description, ImageIcon imageIcon,ImageIcon[] sprites) {
        this.nom = nom;
        this.description = description;
        this.imageIcon = imageIcon;
        this.selected = false;
        this.faim = 0;
        this.sommeil = 100;
        this.hygiene = 100;
        this.sante = 100;
        this.energieGlobale = 100;
        this.bonheur = 100;
        this.spriteMap = new HashMap<>();
        spriteMap.put(Direction.DOWN, new ImageIcon[] {sprites[0], sprites[1]});
        spriteMap.put(Direction.LEFT, new ImageIcon[] {sprites[2], sprites[3]});
        spriteMap.put(Direction.RIGHT, new ImageIcon[] {sprites[4], sprites[5]});
        spriteMap.put(Direction.UP, new ImageIcon[] {sprites[6], sprites[7]});
        spriteMap.put(Direction.IDLE, new ImageIcon[] {sprites[8],sprites[8]});
        
        initTimers();
    }
    public List<Position> getPath() {
		return path;
	}
	public void setPath(List<Position> path) {
		this.path = path;
	}
	
	public Personnage(Position depart, List<Position> path,String nom, String description, ImageIcon imageIcon,ImageIcon[] sprites) {
        this.nom = nom;
        this.description = description;
        this.imageIcon = imageIcon;
        this.selected = false;
        this.faim = 0;
        this.sommeil = 100;
        this.hygiene = 100;
        this.sante = 100;
        this.energieGlobale = 100;
        this.bonheur = 100;
        this.spriteMap = new HashMap<>();
        this.path=path;
        this.depart=depart;
        this.x=depart.getX();
        this.y=depart.getY();
        spriteMap.put(Direction.DOWN, new ImageIcon[] {sprites[0], sprites[1]});
        spriteMap.put(Direction.LEFT, new ImageIcon[] {sprites[2], sprites[3]});
        spriteMap.put(Direction.RIGHT, new ImageIcon[] {sprites[4], sprites[5]});
        spriteMap.put(Direction.UP, new ImageIcon[] {sprites[6], sprites[7]});
        spriteMap.put(Direction.IDLE, new ImageIcon[] {sprites[8],sprites[8]});
        
        initTimers();
    }
	public Personnage(Position depart,String nom, String description, ImageIcon imageIcon,ImageIcon[] sprites) {
        this.nom = nom;
        this.description = description;
        this.imageIcon = imageIcon;
        this.selected = false;
        this.faim = 0;
        this.sommeil = 100;
        this.hygiene = 100;
        this.sante = 100;
        this.energieGlobale = 100;
        this.bonheur = 100;
        this.spriteMap = new HashMap<>();
        this.depart=depart;
        this.x=depart.getX();
        this.y=depart.getY();
        spriteMap.put(Direction.DOWN, new ImageIcon[] {sprites[0], sprites[1]});
        spriteMap.put(Direction.LEFT, new ImageIcon[] {sprites[2], sprites[3]});
        spriteMap.put(Direction.RIGHT, new ImageIcon[] {sprites[4], sprites[5]});
        spriteMap.put(Direction.UP, new ImageIcon[] {sprites[6], sprites[7]});
        spriteMap.put(Direction.IDLE, new ImageIcon[] {sprites[8],sprites[8]});
        
        initTimers();
    }
	
    public Personnage(String nom, String description, ImageIcon imageIcon) {
        this.nom = nom;
        this.description = description;
        this.imageIcon = imageIcon;
        this.selected = false;
        this.faim = 0;
        this.sommeil = 100;
        this.hygiene = 100;
        this.sante = 100;
        this.energieGlobale = 100;
        this.bonheur = 100;
        
        initTimers();
    }
    public ImageIcon getImage(Direction direction) {
        return spriteMap.get(direction)[0]; // Retourne la première image du tableau pour la direction donnée
    }
    public Personnage(Map map) {
        this.map=map;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public  ImageIcon getImageIcon() {
        return imageIcon;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void deplacerVersRestaurant() {
        Position restaurantPosition = lieuRegistry.getPositionByLieuName("Restaurant");
        if (restaurantPosition != null) {
            this.x = restaurantPosition.getX();
            this.y = restaurantPosition.getY();
        }
    }

    // Méthode pour déplacer le personnage vers l'hôpital
    public void deplacerVersHopital() {
        Position hopitalPosition = lieuRegistry.getPositionByLieuName("hopital");
        if (hopitalPosition != null) {
            this.x = hopitalPosition.getX();
            this.y = hopitalPosition.getY();
        }
    }

    // Méthode pour déplacer le personnage vers le cinéma
    public void deplacerVersCinema() {
        Position cinemaPosition = lieuRegistry.getPositionByLieuName("Cinema");
        if (cinemaPosition != null) {
            this.x = cinemaPosition.getX();
            this.y = cinemaPosition.getY();
        }
    }
    public int getFaim() { return faim; }
    public int getSommeil() { return sommeil; }
    public int getHygiene() { return hygiene; }
    public int getSante() { return sante; }
    public int getEnergieGlobale() { return energieGlobale; }
    public int getBonheur() { return bonheur; }
    
    private void initTimers() {
        // Timer pour la faim
        timerFaim = new Timer(800, e -> { // Ici, 5000 millisecondes = 5 secondes
            modifyEnergy(1, "faim");
        });
        timerFaim.start();

        // Timer pour l'hygiène
        timerHygiene = new Timer(2000, e -> { // Ici, 7000 millisecondes = 7 secondes
            modifyEnergy(-1, "hygiene");
        });
        timerHygiene.start();

        // Timer pour le sommeil
        timerSommeil = new Timer(1500, e -> { // Ici, 12000 millisecondes = 12 secondes
            modifyEnergy(-1, "sommeil");
        });
        timerSommeil.start();

        // Timer pour le bonheur
        timerBonheur = new Timer(1000, e -> { // Ici, 5000 millisecondes = 5 secondes
            modifyEnergy(-1, "bonheur");
        });
        timerBonheur.start();
    }
    
    
    

    
    
    public void addUpdateListener(EnergyUpdateListener listener) {
        updateListeners.add(listener);
    }

    private void notifyEnergyUpdate() {
        updateListeners.forEach(EnergyUpdateListener::onEnergyUpdate);
    }

    private void updateSante() {
        sante = ((100 - faim) + hygiene + sommeil) / 3;
        if (sante == 0 && !gameOverWindowOpened) {
            gameOverWindowOpened = true;
            JLabel messageLabel = new JLabel("Votre personnage a rencontré son destin. Le jeu est terminé!");
            GameOverWindow.getInstance(messageLabel).setVisible(true);
        }
    }

    private void updateEnergieGlobale() {
        energieGlobale = ((100 - faim) + hygiene + sommeil + bonheur + sante) / 5;
        if (energieGlobale == 0 && !gameOverWindowOpened) {
            gameOverWindowOpened = true;
            JLabel messageLabel = new JLabel("Votre personnage a rencontré son destin. Le jeu est terminé!");
            GameOverWindow.getInstance(messageLabel).setVisible(true);
        }
    }

    public void modifyEnergy(int amount, String type) {
        switch (type) {
            case "faim":
                faim = Math.max(0, faim + amount);
                if (faim == 100 && !gameOverWindowOpened) {
                    gameOverWindowOpened = true;
                    JLabel messageLabel = new JLabel("Votre personnage est affamé et s'est transformé en zombie! Game over!");
                    GameOverWindow.getInstance(messageLabel).setVisible(true);
                }
                break;
            case "hygiene":
                hygiene = Math.max(0, hygiene + amount);
                if (hygiene == 0 && !gameOverWindowOpened) {
                    gameOverWindowOpened = true;
                    JLabel messageLabel = new JLabel("Oh non! Vous avez laissé votre hygiène de côté. Ça sent mauvais!");
                    GameOverWindow.getInstance(messageLabel).setVisible(true);
                }
                break;
            case "sommeil":
                sommeil = Math.max(0, sommeil + amount);
                if (sommeil == 0 && !gameOverWindowOpened) {
                    gameOverWindowOpened = true;
                    JLabel messageLabel = new JLabel("Zzz... Trop peu de sommeil. Vous vous êtes endormi sur le champ!");
                    GameOverWindow.getInstance(messageLabel).setVisible(true);
                }
                break;
            case "bonheur":
                bonheur = Math.max(0, bonheur + amount);
                if (bonheur == 0 && !gameOverWindowOpened) {
                    gameOverWindowOpened = true;
                    JLabel messageLabel = new JLabel("La vie sans bonheur est comme un jeu sans fin. Oh wait...");
                    GameOverWindow.getInstance(messageLabel).setVisible(true);
                }
                break;
            case "sante":
                sante = Math.max(0, sante + amount);
                if (sante == 0 && !gameOverWindowOpened) {
                    gameOverWindowOpened = true;
                    JLabel messageLabel = new JLabel("Votre personnage a rencontré son destin. Le jeu est terminé!");
                    GameOverWindow.getInstance(messageLabel).setVisible(true);
                }
                break;
        }
        // Mettre à jour les valeurs de l'énergie, de la santé, etc.
        updateSante();
        updateEnergieGlobale();
        notifyEnergyUpdate();
    }

}

