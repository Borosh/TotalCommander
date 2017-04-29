package fajl;

import java.io.File;

public class FajlLista {
    private File file;
    private File[] lista;
    private Fajl[] fajl;

    //getter a listához. Azt sok helyen le kell kérni
    public FajlLista(String direktorium) {
        file = new File(direktorium);
        lista = file.listFiles();
        // esetleges NullException kezelése
        fajl = new Fajl[lista.length];
        for (int i = 0; i < lista.length; i++) {
            fajl[i] = new Fajl();
            fajl[i].setFajl(lista[i].getAbsolutePath());
        }
    }
}
