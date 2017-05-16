package navigacio;

import fajl.FajlAdatok;
import fajl.FajlLista;
import fajl.FajlNezegeto;

import javax.swing.*;
import java.io.*;

public class Navigacio {
    public static void lefele() {
        //Main.ablak.fokuszbanVan.fajlLista.lefele();
    }

    public static void felfele() {
    	//Main.ablak.fokuszbanVan.fajlLista.felfele();
    }

    public static void belelep(File fajl, FajlLista lista) {
        lista.frissit(fajl);
    }

    public static void interakcio(File fajl, FajlLista lista) {
        if (fajl.isDirectory()) {
            belelep(fajl, lista);
        } else if (FajlAdatok.tamogatott.contains(FajlAdatok.getKiterjesztes(fajl))) {
            new FajlNezegeto(fajl.getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(null, "Nem tamogatott fajl!", "Hiba", JOptionPane.ERROR_MESSAGE);
        }
    }
}