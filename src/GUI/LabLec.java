package GUI;

import fajl.*;
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
				Navigacio.interakcio(
						(Ablak.fokuszbanVan.fajlLista.lista.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex())));
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
					Operaciok.torol(Paths.get(Ablak.fokuszbanVan.fajlLista.lista
							.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()));
					Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
					Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

					Ablak.fokuszbanVan.fajlok.transferFocus();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "File törlés közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		F7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				final String[] nev = new String[1];
				JFrame frameUjMappa = new JFrame();
				frameUjMappa.setLayout(new GridLayout(1, 3));
				frameUjMappa.setSize(400, 80);
				JLabel ujmappa = new JLabel("Új mappa neve: ");
				JTextField mappaNev = new JTextField();
				JButton ok = new JButton("OK");
				frameUjMappa.add(ujmappa);
				frameUjMappa.add(mappaNev);
				frameUjMappa.add(ok);
				frameUjMappa.setVisible(true);
				ok.addActionListener(lambda -> {
					nev[0] = mappaNev.getText();
					frameUjMappa.dispatchEvent(new WindowEvent(frameUjMappa, WindowEvent.WINDOW_CLOSING));
					try {
						Operaciok.ujMappa(
								Paths.get(Ablak.fokuszbanVan.fajlLista.helyzet.getAbsolutePath() + "\\" + nev[0]));
						Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
						Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

						Ablak.fokuszbanVan.fajlok.transferFocus();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Új mappa létrhezása közbeni hiba!", "Hiba",
								JOptionPane.ERROR_MESSAGE);
					}
				});

			}
		});

		F1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ablak.fokuszValtas();
				Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
				Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

				Ablak.fokuszbanVan.fajlok.transferFocus();
				for (JList<String> i : Ablak.fokuszbanVan.lista)
					i.setSelectedIndex(0);
			}
		});
	}

}
