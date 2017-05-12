package fajl.kepFajlok;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JPG {

    public static class megnyit extends JPanel {
        public megnyit(String fajl, int x, int y) {
            try {
                JLabel pictureLabel = new JLabel();
                File file = new File(fajl);
                BufferedImage img = ImageIO.read(file);
                Image scaledImg = img.getScaledInstance(x, y, Image.SCALE_DEFAULT);

                pictureLabel.setIcon(new ImageIcon(scaledImg));
                this.add(pictureLabel);
            } catch (IOException ex) {
                System.err.println("Some IOException accured (d" +
                        "id you set the right path?): ");
                System.err.println(ex.getMessage());
            }
        }
    }
}
