package fajl.kepFajlok;

import fajl.FajlNezegeto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Boros on 4/25/2017.
 */
public class JPG {


    public static JPanel megnyit(File fajl, int x, int y) {
        final JPanel showPictureFrame = new JPanel();
        try {
            JLabel pictureLabel = new JLabel();

            BufferedImage img = ImageIO.read(fajl);
            Image scaledImg = img.getScaledInstance(x, y, Image.SCALE_DEFAULT);

            pictureLabel.setIcon(new ImageIcon(scaledImg));
            showPictureFrame.add(pictureLabel);
        } catch (IOException ex) {
            System.err.println("Some IOException accured (d" +
                    "id you set the right path?): ");
            System.err.println(ex.getMessage());
        }
        return showPictureFrame;
    }
}
