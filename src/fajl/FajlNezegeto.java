package fajl;

import fajl.kepFajlok.*;
import fajl.szovegesFajlok.*;
import javax.swing.*;

public class FajlNezegeto {
	
    public FajlNezegeto(String file, String kiterjesztes) {
        JFrame ablak = new JFrame(file);
        JPanel fajl = null;
        ablak.setBounds(500, 200, 600, 600);
        ablak.setVisible(true);
        int x = ablak.getContentPane().getWidth();
        int y = ablak.getContentPane().getHeight();
        
        try{
        	if (kiterjesztes.equals("rtf")) {
        		fajl = new Rtf(file, x, y);
        	} else if(kiterjesztes.equals("txt")){
        		fajl = new Txt(file, x, y);
        	} else if (kiterjesztes.equals("jpg")) {
        		fajl = new JPG(file, x, y);
        	} else if (kiterjesztes.equals("ico")) {
        		fajl = new Ikon(file, x, y);
        	}
        	ablak.add(fajl);
        }catch(Exception e){
        	JOptionPane.showMessageDialog(ablak, "File megnyitás közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
        	ablak.dispose();
        }
        ablak.setResizable(false);
        ablak.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
