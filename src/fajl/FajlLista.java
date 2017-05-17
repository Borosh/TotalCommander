package fajl;

import GUI.*;

import java.util.*;
import java.io.*;

public class FajlLista {

	public ArrayList<File> lista = new ArrayList<>();
	public File os = null;
	public File helyzet = null;

	public FajlLista(File helyzet) {
		lista = new ArrayList<>();
		this.helyzet = helyzet;
		if (helyzet.getParentFile() != null) {
			os = helyzet.getParentFile();
			lista.add(os);
		} else {
			os = null;
		}
		try {
			Collections.addAll(lista, helyzet.listFiles());
		} catch (Exception e) {
		}
	}

	public void frissit(File helyzet) {
		lista = new ArrayList<>();
		this.helyzet = helyzet;
		if (helyzet.getParentFile() != null) {
			os = helyzet.getParentFile();
			lista.add(os);
		} else {
			os = null;
		}
		try {
			Collections.addAll(lista, helyzet.listFiles());
		} catch (Exception e) {
		}
		Ablak.fokuszbanVan.frissit();
		Ablak.nincsFokuszban.frissit();
	}
}
