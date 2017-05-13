package fajl;

import java.io.File;

public class FajlLista {
    private static File file;
    private static File[] lista;
    private static Fajl[] fajl;
    private static int helyzet = 0;
    

    public static void fajlLista(String direktorium) {
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
    
    public static Fajl[] getFajlLista() {
    	return fajl;
    }
    
    public static int getHelyzet() {
    	return helyzet;
    }
    
    public static void setHelyzet(int ertek) {
    	helyzet = ertek;
    }
    
    public static String aktualisHelyzet() {
    	String hely = lista[helyzet].getAbsolutePath();
    	String[] darabok = hely.split("\\\\");
    	String str = "";
    	for(int i=0; i<darabok.length-1; i++) {
    		str += darabok[i] + "\\\\";
    	}
    	//System.out.println(str);
    	return str;
    }
}
