package fajl;

import GUI.Ablak;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FajlLista {

    public ArrayList<File> lista = new ArrayList<>();
    public File os = null;
    public File helyzet = null;

    public FajlLista(File helyzet) {
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
        }
        Ablak.fokuszbanVan.frissit();
        Ablak.nincsFokuszban.frissit();
    }
}
