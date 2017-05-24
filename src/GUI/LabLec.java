package GUI;

import fajl.Operaciok;
import navigacio.Navigacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Paths;

/**
 * Created by FANNI on 2017.05.16..
 */
public class LabLec extends JPanel {

	public static JButton F3 = new JButton("F3 Nézőke");
	public static JButton F5 = new JButton("F5 Másolás ");
	public static JButton F6 = new JButton("F6 Áthelyez");
	public static JButton F7 = new JButton("F7 Új mappa");
	public static JButton F8 = new JButton("F8 Törlés");
	public static JButton F1 = new JButton("F1 Ablak váltás");

	public LabLec() {
		setLayout(new GridLayout(1, 5));
		setMinimumSize(new Dimension(400, 50));

		add(F1);
		add(F3);
		add(F5);
		add(F6);
		add(F7);
		add(F8);

		F3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Navigacio.interakcio((Ablak.fokuszbanVan.fajlLista.lista
							.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex())));
				} catch (Exception e1) {
				}
				Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
				Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

				Ablak.fokuszbanVan.fajlok.transferFocus();
			}

		});
		F5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Operaciok.masol(
							Paths.get(Ablak.fokuszbanVan.fajlLista.lista
									.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()),
							Paths.get(Ablak.nincsFokuszban.fajlLista.helyzet.getAbsolutePath()));
					Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
					Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

					Ablak.fokuszbanVan.fajlok.transferFocus();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "File másolása közbeni hiba!", "Hiba",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		F6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Operaciok.athelyez(
							Paths.get(Ablak.fokuszbanVan.fajlLista.lista
									.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()),
							Paths.get(Ablak.nincsFokuszban.fajlLista.helyzet.getAbsolutePath()));
					Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
					Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

					Ablak.fokuszbanVan.fajlok.transferFocus();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "File áthelyez közbeni hiba!", "Hiba",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		F8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					int hibaUzenet = JOptionPane.showConfirmDialog(null,
							"Biztos ki szeretné törölni a \"" + Ablak.fokuszbanVan.fajlLista.lista
									.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getName()+"\" nevű elemet?",
							"Törlés", JOptionPane.YES_NO_OPTION);
					if (hibaUzenet == JOptionPane.YES_OPTION) {
						Operaciok.torol(Paths.get(Ablak.fokuszbanVan.fajlLista.lista
								.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()));
						Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
						Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

						Ablak.fokuszbanVan.fajlok.transferFocus();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "File törlés közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		F7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					String nev = JOptionPane.showInputDialog(null, "Az új mappa neve", "Új mappa", JOptionPane.QUESTION_MESSAGE);
					if (nev != null) {
						Operaciok.ujMappa(
								Paths.get(Ablak.fokuszbanVan.fajlLista.helyzet.getAbsolutePath() + "\\" + nev));
						Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
						Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
						Ablak.fokuszbanVan.fajlok.transferFocus();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Új mappa létrhezása közbeni hiba!", "Hiba",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		F1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ablak.fokuszValtas();
				Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
				Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
				for (JList<String> i : Ablak.fokuszbanVan.lista)
					i.setSelectedIndex(0);
				Ablak.fokuszbanVan.fajlok.transferFocus();
			}
		});
	}

}
