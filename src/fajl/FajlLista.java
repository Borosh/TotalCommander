package fajl;
import java.io.File;

public class FajlLista {
	public File file;
	public File[] lista;
	public Fajl[] fajl;
	
	public FajlLista(String utvonal) {
		file = new File(utvonal);
		lista = file.listFiles();
		fajl = new Fajl[lista.length];
		for(int i=0; i<lista.length; i++) {
			fajl[i] = new Fajl();
			fajl[i].setFajl(lista[i].getAbsolutePath());
		}
	}
}
