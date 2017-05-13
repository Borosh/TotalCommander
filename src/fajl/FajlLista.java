package fajl;

import javax.swing.*;
import java.io.File;

public class FajlLista {
    private static File file;
    private static File[] lista;
    private static Fajl[] fajl;
    private static int helyzet = 0;

    static void fajlLista(String direktorium) throws Exception {
        file = new File(direktorium);
        lista = file.listFiles();
        fajl = new Fajl[lista.length];
        for (int i = 0; i < lista.length; i++) {
            fajl[i] = new Fajl();
            fajl[i].setFajl(lista[i].getAbsolutePath());
        }
    }

    public static int getHelyzet() {
        return helyzet;
    }

    static Fajl[] getFajlLista() {
        return fajl;
    }

    static void setHelyzet(int ertek) {
        helyzet = ertek;
    }

    static String aktualisHelyzet() {
        String hely = lista[helyzet].getAbsolutePath();
        String[] darabok = hely.split("\\\\");
        String str = "";
        for (int i = 0; i < darabok.length - 1; i++) {
            str += darabok[i] + "\\\\";
        }
        //System.out.println(str);
        return str;
    }

    static void frissit(String utvonal) {
        file = null;
        lista = null;
        fajl = null;
        helyzet = 0;
        try {
            fajlLista(utvonal);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
        }
    }
}
