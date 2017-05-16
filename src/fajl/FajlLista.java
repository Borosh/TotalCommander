package fajl;

import javax.swing.*;
import java.util.*;
import java.io.*;

public class FajlLista {

    public ArrayList<File> lista = new ArrayList<>();
    File os = null;
    public File helyzet = null;
    public int aktualisFajl = 0;

    public FajlLista(File helyzet) {
        frissit(helyzet);
        aktualisFajl = 0;
    }

    public void lefele() {
        if (aktualisFajl + 1 < lista.size()) {
            aktualisFajl++;
        } else {
            aktualisFajl = 0;
        }
    }

    public void felfele() {
        if (aktualisFajl - 1 >= 0) {
            aktualisFajl--;
        } else {
            aktualisFajl = lista.size() - 1;
        }
    }

    public void frissit(File helyzet) {
        lista = new ArrayList<>();
        this.helyzet = helyzet;
        if (helyzet.getParentFile() != null) {
            os = helyzet.getParentFile();
            lista.add(os);
        } else {
            os = null;
        }
        try {
            Collections.addAll(lista, helyzet.listFiles());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hiba megnyitás közben!", "Hiba", JOptionPane.ERROR_MESSAGE);
        }
    }
}
