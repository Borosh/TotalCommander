package fajl;

import fajl.kepFajlok.*;
import fajl.szovegesFajlok.*;

import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.*;

public class FajlNezegeto {

    public FajlNezegeto(String file) {
        String kiterjesztes = FajlAdatok.getKiterjesztes(new File(file));
        JFrame ablak = new JFrame(file);
        JPanel fajl = null;
        ablak.setBounds(200, 50, 600, 600);
        ablak.setVisible(true);
        int x = ablak.getContentPane().getWidth();
        int y = ablak.getContentPane().getHeight();
        try {
            if (kiterjesztes.equals("rtf")) {
                fajl = new Rtf(file, x, y);
            } else if (kiterjesztes.equals("txt")) {
                fajl = new Txt(file, x, y);
            } else if (FajlAdatok.tamogatott.contains(kiterjesztes)) {
                fajl = new Kep(file, x, y);
            } else {
                throw new Exception();
            }
            ablak.add(fajl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ablak, "Hiba megnyitás közben!", "Hiba", JOptionPane.ERROR_MESSAGE);
            ablak.dispatchEvent(new WindowEvent(ablak, WindowEvent.WINDOW_CLOSING));
        }
        ablak.setResizable(false);
        ablak.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
