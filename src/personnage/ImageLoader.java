package personnage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
public class ImageLoader {

    public static ImageIcon loadImage(String path) {
        ImageIcon imageIcon = null;
        File file = new File(path);
		Image image = new ImageIcon(file.getAbsolutePath()).getImage();
		imageIcon = new ImageIcon(image);
        return imageIcon;
    }
}