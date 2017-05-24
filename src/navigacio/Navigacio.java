package navigacio;

import GUI.Ablak;
import fajl.FajlAdatok;
import fajl.FajlNezegeto;

import javax.swing.*;
import java.io.File;

public class Navigacio {

    public static void belelep(File fajl) {
        Ablak.fokuszbanVan.fajlLista.frissit(fajl);
    }

    public static void interakcio(File fajl) {
        if (fajl.isDirectory()) {
            belelep(fajl);
        } else if (FajlAdatok.tamogatott.contains(FajlAdatok.getKiterjesztes(fajl))) {
            new FajlNezegeto(fajl.getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(null, "Nem tamogatott fajl!", "Hiba", JOptionPane.ERROR_MESSAGE);
        }
    }
}