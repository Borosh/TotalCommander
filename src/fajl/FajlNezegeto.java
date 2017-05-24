package fajl;

import fajl.kepFajlok.Kep;
import fajl.szovegesFajlok.Rtf;
import fajl.szovegesFajlok.Txt;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.File;

public class FajlNezegeto {

    public FajlNezegeto(String file) {
        String kiterjesztes = FajlAdatok.getKiterjesztes(new File(file));
        JFrame ablak = new JFrame(file);
        JPanel fajl = null;
        ablak.setBounds(200, 50, 800, 700);
        ablak.setVisible(true);
        int x = ablak.getContentPane().getWidth();
        int y = ablak.getContentPane().getHeight();
        try {
            switch (kiterjesztes) {
                case "rtf":
                    fajl = new Rtf(file, x, y);
                    break;
                case "txt":
                    fajl = new Txt(file, x, y);
                    break;
                default:
                    if (FajlAdatok.tamogatott.contains(kiterjesztes)) {
                        fajl = new Kep(file, x, y);
                    } else {
                        throw new Exception();
                    }
                    break;
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
