package engine.process;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import config.GameConfiguration;
import engine.fixed.Position;
import engine.map.Map;
import personnage.ImageLoader;
import personnage.Personnage;
import personnage.Personnage.Direction;

public class NPCmanager {
	private Personnage personnageNPC;
	private Personnage personnageNPC2;
	private Personnage personnageNPC3;
	private Personnage personnageNPC4;
	private Personnage personnageNPC5;
	private Personnage personnageNPC6;
	private Map map;
	private Direction currentDirection = Direction.IDLE;
	private int animationIndex = 0; // Déclaration de la variable animationIndex
	private Timer npcTimer;
	private List<Position> path = new ArrayList<>(); // Initialisez la liste de chemin en dehors de la méthode
	private List<Position> path2 = new ArrayList<>(); // Initialisez la liste de chemin en dehors de la méthode
	private List<Position> path3 = new ArrayList<>(); // Initialisez la liste de chemin en dehors de la méthode
	private List<Position> path4 = new ArrayList<>(); // Initialisez la liste de chemin en dehors de la méthode
	private List<Position> path9 = new ArrayList<>(); // Initialisez la liste de chemin en dehors de la méthode
	private List<Position> path10 = new ArrayList<>(); // Initialisez la liste de chemin en dehors de la méthode

    private List<Personnage> personnages = new ArrayList<>();

	private int currentPathIndex;

	public List<Position> getPath() {
		return path;
	}

	public void setPath(List<Position> path) {
		this.path = path;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	public int getAnimationIndex() {
		return animationIndex;
	}

	public void setAnimationIndex(int animationIndex) {
		this.animationIndex = animationIndex;
	}

	public void startNPCMovement() {
		npcTimer.start();
	}

	public NPCmanager(Map map) {
		this.map = map;
		path.add(new Position(960, 487));
		path.add(new Position(973, 338));
		path.add(new Position(976, 314));
		path.add(new Position(655, 331));
		path.add(new Position(622, 326));
		path.add(new Position(600, 327));
		path.add(new Position(616, 291));
		path.add(new Position(542, 289));
		path.add(new Position(519, 349));
		path.add(new Position(627, 370));
		path.add(new Position(628, 294));
		path.add(new Position(675, 322));
		path.add(new Position(804, 335));
		path.add(new Position(791, 134));
		path.add(new Position(561, 149));
		path.add(new Position(390, 172));
		path.add(new Position(129, 175));
		path.add(new Position(202, 265));
		path.add(new Position(215, 402));
		path.add(new Position(212, 480));
		path.add(new Position(301, 453));
		path.add(new Position(393, 473));
		path.add(new Position(390, 551));
		path.add(new Position(503, 553));
		path.add(new Position(549, 590));
		path.add(new Position(650, 553));
		path.add(new Position(801, 557));
		path.add(new Position(806, 475));
		path.add(new Position(883, 481));
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
		personnageNPC = new Personnage(new Position(867, 486),path,"NPC", "Description du NPC", new ImageIcon("src/images/image1.png"), sprites4);
		
		path2.add(new Position(667, 325));
		path2.add(new Position(660, 399));
		path2.add(new Position(366, 395));
		path2.add(new Position(347, 395));
		path2.add(new Position(370, 328));
		path2.add(new Position(216, 330));
		path2.add(new Position(218, 234));
		path2.add(new Position(237, 222));
		path2.add(new Position(142, 240));
		path2.add(new Position(178, 109));
		path2.add(new Position(317, 136));
		path2.add(new Position(326, 180));
		path2.add(new Position(662, 207));
		path2.add(new Position(642, 112));
		path2.add(new Position(813, 138));
		path2.add(new Position(813, 197));
		path2.add(new Position(925, 203));
		path2.add(new Position(926, 332));
		path2.add(new Position(780, 325));
		ImageIcon[] sprites5 = new ImageIcon[9];
		sprites5[0] = ImageLoader.loadImage("src/clients/client0/client_down1.png");
		sprites5[1] = ImageLoader.loadImage("src/clients/client0/client_down2.png");
		sprites5[2] = ImageLoader.loadImage("src/clients/client0/client_left1.png");
		sprites5[3] = ImageLoader.loadImage("src/clients/client0/client_left2.png");
		sprites5[4] = ImageLoader.loadImage("src/clients/client0/client_right1.png");
		sprites5[5] = ImageLoader.loadImage("src/clients/client0/client_right2.png");
		sprites5[6] = ImageLoader.loadImage("src/clients/client0/client_up1.png");
		sprites5[7] = ImageLoader.loadImage("src/clients/client0/client_up2.png");
		sprites5[8] = ImageLoader.loadImage("src/clients/client0/client.png");
		personnageNPC2 = new Personnage(new Position(895, 327),path2,"NPC", "Description du NPC", new ImageIcon("src/images/image1.png"), sprites5);
		
		//path3.add(new Position(932, 580));
		path3.add(new Position(933, 506));
		path3.add(new Position(813, 504));
		path3.add(new Position(808, 557));
		path3.add(new Position(646, 557));
		path3.add(new Position(509, 551));
		path3.add(new Position(403, 543));
		path3.add(new Position(396, 436));
		path3.add(new Position(198, 440));
		path3.add(new Position(202, 330));
		path3.add(new Position(370, 330));
		path3.add(new Position(361, 216));
		path3.add(new Position(636, 227));
		path3.add(new Position(632, 126));
		path3.add(new Position(803, 146));
		path3.add(new Position(815, 201));
		path3.add(new Position(926, 210));
		path3.add(new Position(940, 567));
		ImageIcon[] sprites6 = new ImageIcon[9];
		sprites6[0] = ImageLoader.loadImage("src/clients/client2/client_down1.png");
		sprites6[1] = ImageLoader.loadImage("src/clients/client2/client_down2.png");
		sprites6[2] = ImageLoader.loadImage("src/clients/client2/client_left1.png");
		sprites6[3] = ImageLoader.loadImage("src/clients/client2/client_left2.png");
		sprites6[4] = ImageLoader.loadImage("src/clients/client2/client_right1.png");
		sprites6[5] = ImageLoader.loadImage("src/clients/client2/client_right2.png");
		sprites6[6] = ImageLoader.loadImage("src/clients/client2/client_up1.png");
		sprites6[7] = ImageLoader.loadImage("src/clients/client2/client_up2.png");
		sprites6[8] = ImageLoader.loadImage("src/clients/client2/client.png");
		personnageNPC3 = new Personnage(new Position(932, 580),path3,"NPC", "Description du NPC", new ImageIcon("src/images/image1.png"), sprites6);
		
		path4.add(new Position(159, 466));
		path4.add(new Position(376, 472));
		path4.add(new Position(384, 558));
		path4.add(new Position(503, 566));
		path4.add(new Position(661, 589));
		path4.add(new Position(675, 540));
		path4.add(new Position(810, 577));
		path4.add(new Position(819, 435));
		path4.add(new Position(814, 294));
		path4.add(new Position(817, 155));
		path4.add(new Position(638, 153));
		path4.add(new Position(317, 174));
		path4.add(new Position(298, 181));
		path4.add(new Position(318, 116));
		path4.add(new Position(172, 114));
		path4.add(new Position(174, 194));
		path4.add(new Position(189, 363));
		ImageIcon[] sprites7 = new ImageIcon[9];
		sprites7[0] = ImageLoader.loadImage("src/clients/client1/client_down1.png");
		sprites7[1] = ImageLoader.loadImage("src/clients/client1/client_down2.png");
		sprites7[2] = ImageLoader.loadImage("src/clients/client1/client_left1.png");
		sprites7[3] = ImageLoader.loadImage("src/clients/client1/client_left2.png");
		sprites7[4] = ImageLoader.loadImage("src/clients/client1/client_right1.png");
		sprites7[5] = ImageLoader.loadImage("src/clients/client1/client_right2.png");
		sprites7[6] = ImageLoader.loadImage("src/clients/client1/client_up1.png");
		sprites7[7] = ImageLoader.loadImage("src/clients/client1/client_up2.png");
		sprites7[8] = ImageLoader.loadImage("src/clients/client1/client.png");
		personnageNPC4 = new Personnage(new Position(185, 367),path4,"NPC", "Description du NPC", new ImageIcon("src/images/image1.png"), sprites7);
        
		
		path10.add(new Position(558, 326));
		// Aucune action choisie.
		path10.add(new Position(551, 357));
		// Aucune action choisie.
		path10.add(new Position(395, 363));
		path10.add(new Position(363, 331));
		path10.add(new Position(366, 299));
		path10.add(new Position(211, 321));
		path10.add(new Position(28, 478));
		path10.add(new Position(61, 581));
		path10.add(new Position(378, 586));
		path10.add(new Position(495, 542));
		path10.add(new Position(629, 592));
		path10.add(new Position(652, 516));
		path10.add(new Position(802, 556));
		// Aucune action choisie.
		path10.add(new Position(803, 328));
		// Aucune action choisie.
		path10.add(new Position(599, 331));
		path10.add(new Position(563, 312));
		path10.add(new Position(526, 291));
		ImageIcon[] sprites8 = new ImageIcon[9];
		sprites8[0] = ImageLoader.loadImage("src/clients/client1/client_down1.png");
		sprites8[1] = ImageLoader.loadImage("src/clients/client1/client_down2.png");
		sprites8[2] = ImageLoader.loadImage("src/clients/client1/client_left1.png");
		sprites8[3] = ImageLoader.loadImage("src/clients/client1/client_left2.png");
		sprites8[4] = ImageLoader.loadImage("src/clients/client1/client_right1.png");
		sprites8[5] = ImageLoader.loadImage("src/clients/client1/client_right2.png");
		sprites8[6] = ImageLoader.loadImage("src/clients/client1/client_up1.png");
		sprites8[7] = ImageLoader.loadImage("src/clients/client1/client_up2.png");
		sprites8[8] = ImageLoader.loadImage("src/clients/client1/client.png");
		personnageNPC5 = new Personnage(new Position(185, 367),path10,"NPC", "Description du NPC", new ImageIcon("src/images/image1.png"), sprites8);
		
		
		
		path9.add(new Position(570, 373));
		// Aucune action choisie.
		path9.add(new Position(381, 369));
		path9.add(new Position(380, 301));
		path9.add(new Position(207, 331));
		path9.add(new Position(205, 391));
		path9.add(new Position(43, 376));
		// Aucune action choisie.
		path9.add(new Position(59, 484));
		// Aucune action choisie.
		path9.add(new Position(66, 592));
		path9.add(new Position(368, 597));
		path9.add(new Position(378, 517));
		path9.add(new Position(501, 517));
		// Aucune action choisie.
		path9.add(new Position(508, 592));
		path9.add(new Position(656, 594));
		path9.add(new Position(657, 534));
		path9.add(new Position(810, 536));
		// Aucune action choisie.
		path9.add(new Position(810, 312));
		// Aucune action choisie.
		path9.add(new Position(579, 313));
		path9.add(new Position(574, 288));

		ImageIcon[] sprites9 = new ImageIcon[9];
		sprites9[0] = ImageLoader.loadImage("src/clients/client2/client_down1.png");
		sprites9[1] = ImageLoader.loadImage("src/clients/client2/client_down2.png");
		sprites9[2] = ImageLoader.loadImage("src/clients/client2/client_left1.png");
		sprites9[3] = ImageLoader.loadImage("src/clients/client2/client_left2.png");
		sprites9[4] = ImageLoader.loadImage("src/clients/client2/client_right1.png");
		sprites9[5] = ImageLoader.loadImage("src/clients/client2/client_right2.png");
		sprites9[6] = ImageLoader.loadImage("src/clients/client2/client_up1.png");
		sprites9[7] = ImageLoader.loadImage("src/clients/client2/client_up2.png");
		sprites9[8] = ImageLoader.loadImage("src/clients/client2/client.png");
		personnageNPC6 = new Personnage(new Position(570, 283),path9,"NPC", "Description du NPC", new ImageIcon("src/images/image1.png"), sprites9);
		
		
		
		
		personnages.add(personnageNPC4);
        personnages.add(personnageNPC);
        personnages.add(personnageNPC2);
        personnages.add(personnageNPC3);
        personnages.add(personnageNPC5);
      //  personnages.add(personnageNPC6);


	}
	public List<Personnage> getPersonnages() {
        return personnages;
    }
	public Personnage getPersonnageNPC() {
		return personnageNPC;
	}

	public void setPersonnageNPC(Personnage personnageNPC) {
		this.personnageNPC = personnageNPC;
	}
}
