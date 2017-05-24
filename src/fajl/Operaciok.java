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
                new File(hova.toString() + "\\" + mit.getFileName()).mkdir();
                for (String file : new File(mit.toString()).list()) {
                    masol(Paths.get(mit.toString() + "\\" + file),
                            Paths.get(hova.toString() + "\\" + mit.getFileName()));
                }
            } else {
                Files.copy(mit, hova.resolve(mit.getFileName()));
            }
        } catch (Exception e) {
            throw new IOException("Hiba a másolás során!");
        }
    }

    public static void torol(Path mit) throws Exception {
        try {
            if (Files.isDirectory(mit)) {
                for (String fajl : new File(mit.toString()).list()) {
                    torol(Paths.get(mit + "\\" + fajl));
                }
                Files.delete(mit);
            } else if (Files.exists(mit)) {
                Files.delete(mit);
            } else
                throw new Exception("Nem létező fájlt nem lehet törölni!");
        } catch (Exception e) {
            if (e.getMessage().equals("Nem létező fájlt nem lehet törölni!")) {
                throw new IOException("Nem létező fájlt nem lehet törölni!");
            }
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
        if (!(new File(nev.toString()).exists())) {
            (new File(nev.toString())).mkdirs();
        } else {
            throw new IOException("Ez a mappa már létezik");
        }
    }
}
