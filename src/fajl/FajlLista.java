package fajl;

import java.io.File;

public class FajlLista {
    private File file;
    private File[] lista;
    private Fajl[] fajl;
    private int helyzet = 0;
    

    public FajlLista(String direktorium) {
        file = new File(direktorium);
        lista = file.listFiles();
        try {
        	fajl = new Fajl[lista.length];
        	for (int i = 0; i < lista.length; i++) {
        		fajl[i] = new Fajl();
        		fajl[i].setFajl(lista[i].getAbsolutePath());
        	}
        }
        catch(NullPointerException e) {
        }
    }
    
    public Fajl[] getFajlLista() {
    	return fajl;
    }
    
    public int getHelyzet() {
    	return helyzet;
    }
    
    public void setHelyzet(int ertek) {
    	helyzet = ertek;
    }
}
