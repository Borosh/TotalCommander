package navigacio;

import fajl.FajlAdatok;
import fajl.FajlLista;
import fajl.FajlNezegeto;

import javax.swing.*;
import java.io.*;

public class Navigacio {
    public static void lefele(int helyzet, int hossz) {
        if (helyzet + 1 < hossz) {
            helyzet++;
        } else {
            helyzet = 0;
        }
    }

    public static void felfele(int helyzet, int hossz) {
        if (helyzet - 1 >= 0) {
            helyzet--;
        } else {
            helyzet = hossz - 1;
        }
    }

    public static void belelep(File fajl, FajlLista lista) {
        lista.frissit(fajl);
    }

    public static void interakcio(File fajl, FajlLista lista) {
        if (fajl.isDirectory()) {
            belelep(fajl, lista);
        } else if (FajlAdatok.tamogatott.contains(FajlAdatok.getKiterjesztes(fajl))) {
            new FajlNezegeto(fajl.getAbsolutePath(), FajlAdatok.getKiterjesztes(fajl));
        } else {
            JOptionPane.showMessageDialog(null, "Nem tamogatott fajl!", "Hiba", JOptionPane.ERROR_MESSAGE);

        }
    }
}