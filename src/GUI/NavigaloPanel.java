package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import fajl.*;

public class NavigaloPanel extends JPanel {

	public FajlLista fajlLista = new FajlLista(new File("C:\\"));
	private ArrayList<DefaultListModel<String>> model = new ArrayList<DefaultListModel<String>>() {
		{
			add(new DefaultListModel<String>());
			add(new DefaultListModel<String>());
			add(new DefaultListModel<String>());
			add(new DefaultListModel<String>());
		}
	};
	private ArrayList<JList<String>> lista = new ArrayList<>();

	public NavigaloPanel() {
		setBorder(BorderFactory.createLoweredBevelBorder());
		setLayout(new GridLayout(1, 4));

		for (File j : fajlLista.lista){
			model.get(0).addElement(FajlAdatok.getNev(j));
			model.get(1).addElement(FajlAdatok.getKiterjesztes(j));
			model.get(2).addElement(FajlAdatok.getMeret(j));
			model.get(3).addElement(FajlAdatok.getDatum(j));
		}	
		
		for(DefaultListModel<String> i : model)
			lista.add(new JList<String>(i));

		lista.get(0).setFixedCellWidth(100);
		lista.get(1).setFixedCellWidth(5);
		lista.get(2).setFixedCellWidth(20);
		lista.get(3).setFixedCellWidth(20);
		
		for (int i = 0; i < 4; ++i) {
			lista.get(i).setFixedCellHeight(20);
			add(lista.get(i));
		}
	}
	
	private abstract class EgerKezelo implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if( e.getClickCount() == 2 && e.getSource() instanceof JList){
				System.out.println("aaa");
			}
			
		}
		
	}
	
}
