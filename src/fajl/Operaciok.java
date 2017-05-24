package fajl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Operaciok {

	public static void masol(Path mit, Path hova) throws Exception {
		try {
			if (Files.isDirectory(mit)) {
				if ( mit.equals(hova) )
					throw new IOException("A célmappa megegyezik a másolandó mappával!");
				try{
					new File(hova.toString() + "\\" + mit.getFileName()).mkdir();
				}catch(Exception e1){
					throw new IOException("Hiba a másolás során!");
				}
				for (String file : new File(mit.toString()).list()) {
					masol(Paths.get(mit.toString() + "\\" + file),
							Paths.get(hova.toString() + "\\" + mit.getFileName()));
				}
			} else {
				if ( mit.getParent().equals(hova) )
					throw new IOException("A másolandó fájl már létezik a célmappában!");
				else{
					try{
						Files.copy(mit, hova.resolve(mit.getFileName()));
					}catch(Exception e1){
						throw new IOException("Hiba a másolás során!");
					}
				}
			}
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
	}

	public static void torol(Path mit) throws Exception {
		try {
			if (Files.isDirectory(mit)) {
				for (String fajl : new File(mit.toString()).list()) {
					torol(Paths.get(mit + "\\" + fajl));
				}
				try {
					Files.delete(mit);
				} catch (Exception e1) {
					throw new Exception("Hiba a fájl törlése közben!");
				}
			} else if (Files.exists(mit)) {
				try {
					Files.delete(mit);
				} catch (Exception e1) {
					throw new Exception("Hiba a fájl törlése közben!");
				}
			} else
				throw new Exception("Nem létező fájlt nem lehet törölni!");
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
	}

	public static void athelyez(Path mit, Path hova) throws Exception {
		try {
			masol(mit, hova);
			torol(mit);
		} catch (Exception e) {
			throw new Exception("Hiba az áthelyezés közben!");
		}
	}

	public static void ujMappa(Path nev) throws Exception {
		try {
			if (!(new File(nev.toString()).exists())) {
				try {
					(new File(nev.toString())).mkdirs();
				} catch (Exception e) {
					throw new IOException("Hiba a új mappa létrehozásako!");
				}
			} else {
				throw new IOException("Ez a mappa már létezik");
			}
		} catch (Exception e1) {
			throw new IOException(e1.getMessage());
		}
	}
}
