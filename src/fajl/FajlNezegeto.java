package fajl;

import fajl.kepFajlok.*;
import fajl.szovegesFajlok.*;
import javax.swing.*;

public class FajlNezegeto {

    public FajlNezegeto(String file, String kiterjesztes) {
    	JFrame ablak = new JFrame();
        JPanel fajl = null;
    	ablak.setBounds(500,200,600,600);
        ablak.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int x = ablak.getContentPane().getWidth();
        int y = ablak.getContentPane().getHeight();
        
        if (kiterjesztes.equals("rtf")) {
        	fajl = new Rtf(file, x, y);
        }else if (kiterjesztes.equals("jpg")) {
            fajl = new JPG(file, x, y);
        }else if (kiterjesztes.equals("ico")) {
            fajl = new Ikon.megnyit(file, x, y);
        }
        
        System.out.println(fajl);
        ablak.setLayout(null);
        ablak.add(fajl);
        ablak.setVisible(true);
    }
}
