package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import config.GameConfiguration;
import engine.fixed.Domicile;
import engine.fixed.LieuDivertissement;
import engine.fixed.LieuRegistry;
import engine.fixed.LieuTravail;
import engine.fixed.Position;
import engine.map.Block;
import engine.map.Map;
import personnage.Personnage;
import personnage.Personnage.Direction;

public class PaintStrategy {
    private int animationIndex = 0; 
    private Direction currentDirection = Direction.IDLE;

    private int tempsEnSecondes=0;
    private int minutes=0;
    private MainGUI main;
    private LieuRegistry lieuRegistry ;
	public void paint(InfoPanel ip,Map map, Graphics graphics, Personnage personnage) {

		 lieuRegistry = new LieuRegistry();
		LieuDivertissement lieuDivertissement = new LieuDivertissement("tmp1");
		LieuTravail lieuTravail = new LieuTravail("tmp2");
		Domicile domicile = new Domicile("tmp3");

		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {

				Block block = blocks[lineIndex][columnIndex];
				graphics.setColor(new Color(51, 60, 87));
				graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);

			}
		}
		// Phase 1: Dessin initial de tous les éléments sauf ceux qui doivent être au
		// premier plan
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				// Dessinez la route
				if (matriceValue == 60) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/tr0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
				}
				// Ne pas dessiner le point 17 ici pour l'instant
			}
		}

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if (Map.matrice[lineIndex][columnIndex] == 11) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b01.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 21) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b1.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 22) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b2.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 23) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b3.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 24) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b4.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 25) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b5.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 26) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b6.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 27) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b7.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 28) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b8.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 29) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b9.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 30) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b10.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 31) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b11.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 32) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b12.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 33) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b13.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 34) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b14.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 35) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b15.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				} else if (Map.matrice[lineIndex][columnIndex] == 36) {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/b16.png");
					Image image = imageIcon.getImage();

					int x = block.getColumn() * blockSize;
					int y = block.getLine() * blockSize;

					int width = blockSize * 1; // Largeur du lieu (2 blocs)
					int height = blockSize * 1;

					graphics.drawImage(image, x, y, width, height, null);

				}
				int x = block.getColumn() * blockSize;
				int y = block.getLine() * blockSize;
				int width = blockSize; // Largeur du bloc
				int height = blockSize; // Hauteur du bloc

				// Dessiner la première image

				if (Map.matrice[lineIndex][columnIndex] == 10) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 37) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/fleur02.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 62) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/fleur03.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 63) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/fleur04.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 38) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/Arbre01.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}

				if (Map.matrice[lineIndex][columnIndex] == 39) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/Arbre02.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 40) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/fleur04.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 41) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/herbe.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 42) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/banc.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 43) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trHG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/barreG.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 44) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trH.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/barreM.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					width = blockSize * 1; // Largeur du lieu (2 blocs)
					height = blockSize * 1;
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 46) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trHD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/barreD.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 47) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/barre.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 48) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trBD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/barreD.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 49) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trB.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/barreM.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 50) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trBG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/barreG.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 51) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/barre.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 52) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trHG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 53) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trH.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 54) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trHD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 55) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 59) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trBG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 57) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trB.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 58) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trBD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 61) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 65) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rt.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 64) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rtHB.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 66) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/piet.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
				if (Map.matrice[lineIndex][columnIndex] == 67) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/ligne.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, width, height, null);
				}
//				

			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 17) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trHG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/m1.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 6, blockSize * 6, null);
					domicile.ajouterBatiment("maison1", new Position(lineIndex, columnIndex));

				}
			}
		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 18) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/m2.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 6, blockSize * 6, null);
					domicile.ajouterBatiment("maison2", new Position(lineIndex, columnIndex));

				}
			}
		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 19) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/m3.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 6, blockSize * 6, null);
					domicile.ajouterBatiment("maison3", new Position(lineIndex, columnIndex));

				}
			}
		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 20) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/m4.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 6, blockSize * 6, null);
					domicile.ajouterBatiment("maison4", new Position(lineIndex, columnIndex));

				}
			}
		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 1) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trH.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/restaurant.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 5, blockSize * 5, null);
					lieuDivertissement.ajouterBatiment("restaurant ", new Position(lineIndex, columnIndex));

				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 2) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trH.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/cinema.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 5, blockSize * 5, null);
					lieuDivertissement.ajouterBatiment("cinema", new Position(lineIndex, columnIndex));

				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 3) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trH.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/hospital.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 5, blockSize * 5, null);
					lieuTravail.ajouterBatiment("hopital", new Position(lineIndex, columnIndex));

				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 4) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trH.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/university.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 6, blockSize * 6, null);
					lieuTravail.ajouterBatiment("université", new Position(lineIndex, columnIndex));

				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 5) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/tr0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/Mall.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 6, blockSize * 6, null);
					lieuDivertissement.ajouterBatiment("Mall", new Position(lineIndex, columnIndex));

				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 6) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/tr0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/boite.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 5, blockSize * 6, null);
					lieuDivertissement.ajouterBatiment("boite", new Position(lineIndex, columnIndex));

				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 7) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trH.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images_places/entreprise.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 5, blockSize * 6, null);
					lieuTravail.ajouterBatiment("entreprise", new Position(lineIndex, columnIndex));
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 68) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/birka/f.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 2, blockSize *2, null);
				}
			}

		}
		/////////////////////////////////////////////////////////////

		int tempsActuelEnMinutes = ip.getTempsSimulation().getMinutes();
		
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
	        for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
	            int x = columnIndex * blockSize;
	            int y = lineIndex * blockSize;
	            int matriceValue = Map.matrice[lineIndex][columnIndex];

	            if (matriceValue == 69) {
	                ImageIcon imageIconBase = new ImageIcon("src/images/birka/tr0.png");
	                Image imageBase = imageIconBase.getImage();
	                graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
	                // Vérifie si le temps actuel est égal à 3 minutes
	                if (tempsActuelEnMinutes == 3) {
	                    // Si oui, dessine une autre image à la place de "L1.png"
	                    ImageIcon imageIconNew = new ImageIcon("src/images/birka/L1A.png");
	                    Image imageNew = imageIconNew.getImage();
	                    graphics.drawImage(imageNew, x, y, blockSize * 2, blockSize * 2, null);
	                } else {
	                    // Sinon, dessine l'image normale
	                    ImageIcon imageIcon = new ImageIcon("src/images/birka/L1.png");
	                    Image image = imageIcon.getImage();
	                    graphics.drawImage(image, x, y, blockSize * 2, blockSize * 2, null);
	                }

	            }
	        }
	    }
	
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 70) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					
					if (tempsActuelEnMinutes == 3) {
	                    // Si oui, dessine une autre image à la place de "L1.png"
	                    ImageIcon imageIconNew = new ImageIcon("src/images/birka/LA.png");
	                    Image imageNew = imageIconNew.getImage();
	                    graphics.drawImage(imageNew, x, y, blockSize * 2, blockSize * 2, null);
	                } else {
	                	ImageIcon imageIcon = new ImageIcon("src/images/birka/L.png");
						Image image = imageIcon.getImage();
						graphics.drawImage(image, x, y, blockSize * 2, blockSize *2, null);
	                }
	                
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 71) {
					if (tempsActuelEnMinutes == 3) {
	                    // Si oui, dessine une autre image à la place de "L1.png"
	                    ImageIcon imageIconNew = new ImageIcon("src/images/birka/L1A.png");
	                    Image imageNew = imageIconNew.getImage();
	                    graphics.drawImage(imageNew, x, y, blockSize * 2, blockSize * 2, null);
	                } else {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/L1.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 2, blockSize *2, null);
	                }
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 72) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trB.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					
					if (tempsActuelEnMinutes == 3) {
	                    // Si oui, dessine une autre image à la place de "L1.png"
	                    ImageIcon imageIconNew = new ImageIcon("src/images/birka/LA.png");
	                    Image imageNew = imageIconNew.getImage();
	                    graphics.drawImage(imageNew, x, y, blockSize * 2, blockSize * 2, null);
	                }else {
	                	ImageIcon imageIcon = new ImageIcon("src/images/birka/L.png");
						Image image = imageIcon.getImage();
						graphics.drawImage(image, x, y, blockSize * 2, blockSize *2, null);
	                }
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 73) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/trG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					if (tempsActuelEnMinutes == 3) {
	                    // Si oui, dessine une autre image à la place de "L1.png"
	                    ImageIcon imageIconNew = new ImageIcon("src/images/birka/OLA.png");
	                    Image imageNew = imageIconNew.getImage();
	                    graphics.drawImage(imageNew, x, y, blockSize * 2, blockSize * 2, null);
					}else {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/OL.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 2, blockSize *2, null);
	                }
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 74) {
					if (tempsActuelEnMinutes == 3) {
	                    // Si oui, dessine une autre image à la place de "L1.png"
	                    ImageIcon imageIconNew = new ImageIcon("src/images/birka/OLA.png");
	                    Image imageNew = imageIconNew.getImage();
	                    graphics.drawImage(imageNew, x, y, blockSize * 2, blockSize * 2, null);
	                } else {
					ImageIcon imageIcon = new ImageIcon("src/images/birka/OL.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 2, blockSize *2, null);
	                }
				}
			}

		}
		
	/////////////////////////////////////////////////////////////////////////////	
		
		
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 76) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rH.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/birka/barreM.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 78) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/birka/barrett.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 77) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/birka/barreD.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 79) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/birka/barreD.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 80) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/birka/barreM.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 81) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/birka/barreG.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 82) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/b0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/birka/barret.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/Arbre01.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, blockSize * 1,blockSize * 1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 83) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rHG.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/Arbre02.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, blockSize * 1,blockSize * 1, null);
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 84) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rH.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/banc.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, blockSize * 1,blockSize * 1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 85) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rHD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/Arbre02.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, blockSize * 1,blockSize * 1, null);
					
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 86) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rMD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/Arbre02.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, blockSize * 1,blockSize * 1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 87) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rBD.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIconOverlay = new ImageIcon("src/images/birka/Arbre02.png");
					Image imageOverlay = imageIconOverlay.getImage();
					// Dessiner la deuxième image par-dessus la première
					graphics.drawImage(imageOverlay, x, y, blockSize * 1,blockSize * 1, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 88) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rMB.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 89) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rGB.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
				}
			}

		}for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 90) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rGM.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
				}
			}
		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];
				
				if (matriceValue == 91) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rM.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
				}
				
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 92) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rGM.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/v1.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 93) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rM.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/v2.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 94) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rM.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/v3.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 95) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rGM.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/v4.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *2, null);
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 96) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/rM.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					ImageIcon imageIcon = new ImageIcon("src/images/v1.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 1, blockSize *1, null);
				}
			}

		}
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				int x = columnIndex * blockSize;
				int y = lineIndex * blockSize;
				int matriceValue = Map.matrice[lineIndex][columnIndex];

				if (matriceValue == 98) {
					ImageIcon imageIconBase = new ImageIcon("src/images/birka/tr0.png");
					Image imageBase = imageIconBase.getImage();
					graphics.drawImage(imageBase, x, y, blockSize, blockSize, null);
					
					ImageIcon imageIconBase1 = new ImageIcon("src/images/birka/rMB.png");
					Image imageBase1 = imageIconBase1.getImage();
					graphics.drawImage(imageBase1, x, y, blockSize, blockSize, null);
					if (tempsActuelEnMinutes == 3) {
	                    // Si oui, dessine une autre image à la place de "L1.png"
	                    ImageIcon imageIconNew = new ImageIcon("src/images/birka/L1A.png");
	                    Image imageNew = imageIconNew.getImage();
	                    graphics.drawImage(imageNew, x, y, blockSize * 2, blockSize * 2, null);
	                }else {	
					ImageIcon imageIcon = new ImageIcon("src/images/birka/L1.png");
					Image image = imageIcon.getImage();
					graphics.drawImage(image, x, y, blockSize * 2, blockSize *2, null);
	                }
				}
			}

		}
//        ImageIcon[] sprites =personnage.getSpriteMap().get(currentDirection);
//		ImageIcon currentSprite = sprites[animationIndex];
//		graphics.drawImage(currentSprite.getImage(), personnage.getX(), personnage.getY(), null); 
        
//        ImageIcon[] sprites1 = npcManager.getPersonnageNPC().getSpriteMap().get(currentDirection);
//        ImageIcon currentSprite1 = sprites1[animationIndex];
//        g.drawImage(currentSprite1.getImage(), npcManager.getPersonnageNPC().getX(), npcManager.getPersonnageNPC().getY(), this);
		
		lieuRegistry.ajouterLieuTravail(lieuTravail);
		lieuRegistry.ajouterLieuDivertissement(lieuDivertissement);
		lieuRegistry.ajouterDomicile(domicile);
	}
	public LieuRegistry getLieuRegistry() {
		return lieuRegistry;
	}

}
