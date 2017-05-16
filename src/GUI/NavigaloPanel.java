package GUI;

import java.awt.GridLayout;
import java.io.*;
import java.util.*;

import javax.swing.*;
import fajl.*;

public class NavigaloPanel extends JPanel{
	
	public FajlLista fajlLista = new FajlLista(new File("C:\\"));
	private List<DefaultListModel<String>> model = new ArrayList<DefaultListModel<String>>(){{
		add(new DefaultListModel<String>());
		add(new DefaultListModel<String>());
		add(new DefaultListModel<String>());
		add(new DefaultListModel<String>());
	}};
	private List<JList<String>> lista = new ArrayList<>();
	
	public NavigaloPanel(){

        JPanel egySor = new JPanel(new GridLayout(1, 4));
        for(int i = 0; i < 4; ++i){
        	for(File j : fajlLista.lista )
        		model.get(i).addElement(j.getName());

        	lista.add(new JList<String>(model.get(i)));
        }
        
        for( int i = 0; i < 4; ++i ){
        	lista.get(i).setFixedCellWidth(5);
        	add(lista.get(i));
        }
	}
}
