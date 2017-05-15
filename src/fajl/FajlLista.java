package fajl;

import javax.swing.*;
import java.util.*;
import java.io.*;

public class FajlLista {

    public ArrayList<File> lista = new ArrayList<>();
    File os = null;
    File helyzet = null;

    public FajlLista(File helyzet) {
        frissit(helyzet);
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
