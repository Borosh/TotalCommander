package fajl;

import fajl.kepFajlok.*;

import javax.swing.*;
import java.io.File;

public class FajlNezegeto {
    JFrame ablak = new JFrame();

    public FajlNezegeto(File fajl) {
        switch (fajl.getKiterjesztes()) {
            case "jpg": new JPG(fajl);
            break;
            case "icon": new Ikon(fajl);
        }

    }

    private void init() {
        ablak.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ablak.setSize(ablak.getPreferredSize());
        ablak.setVisible(true);
    }
}
