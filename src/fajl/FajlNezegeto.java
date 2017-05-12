package fajl;

import fajl.kepFajlok.*;
import fajl.szovegesFajlok.*;
import javax.swing.*;

public class FajlNezegeto {
    private JFrame ablak = new JFrame();
    private JPanel fajl = null;
    private final int x = ablak.getContentPane().getWidth();
    private final int y = ablak.getContentPane().getHeight();

    public FajlNezegeto(String file, String kiterjesztes) {
        
        init();
        
        if (kiterjesztes.equals("rtf")) {
        	fajl = new Rtf(file, x, y);
        }else if (kiterjesztes.equals("jpg")) {
            fajl = new JPG(file, x, y);
        }else if (kiterjesztes.equals("ico")) {
            fajl = new Ikon.megnyit(file, x, y);
        }
        
        ablak.setLayout(null);
        ablak.add(fajl, 0);
    }

    private void init() {
    	ablak.setSize(600, 600);
        ablak.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ablak.setVisible(true);
    }
}
