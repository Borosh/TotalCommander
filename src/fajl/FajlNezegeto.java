package fajl;

import fajl.kepFajlok.*;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FajlNezegeto {
    static JFrame ablak = new JFrame();

    public FajlNezegeto(String file, String kiterjesztes) {
        JFrame ablak = new JFrame();
        JPanel fajl = null;
        ablak.setBounds(500, 200, 600, 600);
        ablak.setVisible(true);
        int x = ablak.getContentPane().getWidth();
        int y = ablak.getContentPane().getHeight();

        if (kiterjesztes.equals("rtf")) {
            //  fajl = new Rtf(file, x, y);
        } else if (kiterjesztes.equals("jpg")) {
            fajl = new JPG(file, x, y);
        } else if (kiterjesztes.equals("ico")) {
            fajl = new Ikon.megnyit(file, x, y);
        }

        ablak.add(fajl);
        ablak.setVisible(true);
        ablak.setResizable(false);
        ablak.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
