package navigacio;

import fajl.*;

import javax.swing.*;

import GUI.Ablak;

import java.io.*;

public class Navigacio {
	public static void lefele() {
		// Main.ablak.fokuszbanVan.fajlLista.lefele();
	}

	public static void felfele() {
		// Main.ablak.fokuszbanVan.fajlLista.felfele();
	}

	public static void belelep(File fajl) {
		Ablak.fokuszbanVan.fajlLista.frissit(fajl);
	}

	public static void interakcio(File fajl) {
		if (fajl.isDirectory()) {
			belelep(fajl);
		} else if (FajlAdatok.tamogatott.contains(FajlAdatok.getKiterjesztes(fajl))) {
			new FajlNezegeto(fajl.getAbsolutePath());
		} else {
			JOptionPane.showMessageDialog(null, "Nem tamogatott fajl!", "Hiba", JOptionPane.ERROR_MESSAGE);
		}
	}
}