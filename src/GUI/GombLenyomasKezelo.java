package GUI;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fajl.Operaciok;
import navigacio.Navigacio;

public class GombLenyomasKezelo implements KeyListener {

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_F3) {
			Navigacio.interakcio(
					(Ablak.fokuszbanVan.fajlLista.lista.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex())));
			Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
			Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
		} else if (e.getKeyCode() == KeyEvent.VK_F5) {
			try {
				Operaciok.masol(
						Paths.get(Ablak.fokuszbanVan.fajlLista.lista
								.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()),
						Paths.get(Ablak.nincsFokuszban.fajlLista.helyzet.getAbsolutePath()));
				Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
				Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "File másolása közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_F6) {
			try {
				Operaciok.athelyez(
						Paths.get(Ablak.fokuszbanVan.fajlLista.lista
								.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()),
						Paths.get(Ablak.nincsFokuszban.fajlLista.helyzet.getAbsolutePath()));
				Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
				Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "File áthelyez közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_F7) {
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
					Operaciok
							.ujMappa(Paths.get(Ablak.fokuszbanVan.fajlLista.helyzet.getAbsolutePath() + "\\" + nev[0]));
					Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
					Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Új mappa létrhezása közbeni hiba!", "Hiba",
							JOptionPane.ERROR_MESSAGE);
				}
			});
		} else if (e.getKeyCode() == KeyEvent.VK_F8) {
			try {
				Operaciok.torol(Paths.get(Ablak.fokuszbanVan.fajlLista.lista
						.get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()));
				Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
				Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "File törlés közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_F1) {
			Ablak.fokuszValtas();
			System.out.println("br");
			Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
			Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
			for(JList<String> i: Ablak.fokuszbanVan.lista)
				i.setSelectedIndex(0);

		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && e.getSource() instanceof JList) {
			Ablak.fokuszbanVan.csokkento((JList<String>)(e.getSource()));
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && e.getSource() instanceof JList) {
			Ablak.fokuszbanVan.novelo((JList<String>)(e.getSource()));
		}
	}

	public void keyTyped(KeyEvent e) {
	}

}
