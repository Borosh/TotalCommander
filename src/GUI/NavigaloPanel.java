package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import fajl.*;
import navigacio.Navigacio;

public class NavigaloPanel {

	public FajlLista fajlLista = new FajlLista(new File("C:\\"));
	private ArrayList<DefaultListModel<String>> model = new ArrayList<DefaultListModel<String>>() {
		{
			add(new DefaultListModel<String>());
			add(new DefaultListModel<String>());
			add(new DefaultListModel<String>());
			add(new DefaultListModel<String>());
		}
	};
	public ArrayList<JList<String>> lista = new ArrayList<>();
	private JComboBox<String> particio = new JComboBox<>();
	private JLabel aktualisMappa = new JLabel();
	public JPanel fajlok = new JPanel(new GridLayout(1, 4));
	public JPanel fejLec = new JPanel(new GridLayout(1, 2));

	public NavigaloPanel() {
		for (File j : File.listRoots())
			if (!FileSystemView.getFileSystemView().getSystemDisplayName(j).equals(""))
				particio.addItem(FileSystemView.getFileSystemView().getSystemDisplayName(j));
		aktualisMappa.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		fejLec.add(particio);
		fejLec.add(aktualisMappa);

		fajlok.setBorder(BorderFactory.createLoweredBevelBorder());
		frissit();
		for (DefaultListModel<String> i : model)
			lista.add(new JList<String>(i));

		lista.get(0).setFixedCellWidth(100);
		lista.get(1).setFixedCellWidth(1);
		lista.get(2).setFixedCellWidth(20);
		lista.get(3).setFixedCellWidth(20);

		for (int i = 0; i < 4; ++i) {
			lista.get(i).setFixedCellHeight(20);
			lista.get(i).addMouseListener(this.new EgerKezelo());
			fajlok.add(lista.get(i));
		}

	}

	public NavigaloPanel getOuter() {
		return this;
	}

	public void frissit() {
		for (DefaultListModel<String> i : model) {
			i.removeAllElements();
		}
		boolean elso = true;

		for (File j : fajlLista.lista) {
			if (elso && fajlLista.os != null) {
				model.get(0).addElement("[ .. ]");
				model.get(1).addElement("");
				model.get(2).addElement("");
				model.get(3).addElement("");
				elso = false;
			} else {
				model.get(0).addElement(FajlAdatok.getNev(j));
				model.get(1).addElement(FajlAdatok.getKiterjesztes(j));
				model.get(2).addElement(FajlAdatok.getMeret(j));
				model.get(3).addElement(FajlAdatok.getDatum(j));
			}
		}
		aktualisMappa.setText(fajlLista.helyzet.getAbsolutePath());
	}

	class EgerKezelo implements MouseListener {

		public EgerKezelo() {
		}

		public void mouseClicked(MouseEvent e) {

			if (e.getSource() instanceof JList) {

				if (Ablak.fokuszbanVan != getOuter())
					Ablak.fokuszValtas();
				JList<String> tempList = (JList<String>) (e.getSource());
				for (JList<String> j : lista) {
					j.setSelectedIndex(tempList.getSelectedIndex());
				}
				for (JList<String> j : Ablak.nincsFokuszban.lista) {
					j.clearSelection();
				}
				if (e.getClickCount() == 2) {
					Navigacio.interakcio(Ablak.fokuszbanVan.fajlLista.lista.get(tempList.getSelectedIndex()));
					frissit();
				}
			}
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}

}
