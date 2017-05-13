package fajl;

import java.io.File;
import java.text.SimpleDateFormat;
//import javax.swing.ImageIcon;

public class Fajl {
    private String nev;
    private String kiterjesztes;
    private String meret;
    private String datum;
    //private ImageIcon ikon;


    public void setFajl(String utvonal) {
        File fajl = new File(utvonal);
        Kiterjesztesek.tamogatottTipusok();
        nev = Kiterjesztesek.nev(fajl);
        kiterjesztes = Kiterjesztesek.kiterjesztes(fajl);
        if(fajl.isDirectory()) {
        	meret = "";
        }
        else {
        	meret = Long.toString(fajl.length());
        }
        datum = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(fajl.lastModified());
 
        //System.out.println(nev + "		" + kiterjesztes + "	" + meret + "	" + datum);
    }

    public String getNev() {
        return nev;
    }

    public String getKiterjesztes() {
        return kiterjesztes;
    }

    public String getMeret() {
        return meret;
    }

    public String getDatum() {
        return datum;
    }
}
