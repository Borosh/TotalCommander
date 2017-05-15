package fajl;

import java.io.*;
import java.nio.file.*;

public class Operaciok {

    public static void masol(Path mit, Path hova) throws Exception {
        try {
            Files.copy(mit, hova.resolve(mit), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new IOException("Hiba a másolás közben!");
        }
    }

    public static void torol(Path mit) throws Exception {
        try {
            if (!Files.deleteIfExists(mit)) {
                throw new IOException("Nem létező elemet nem lehet törölni!");
            }
        } catch (Exception e) {
            if (e.getMessage().equals("Nem létező fájlt nem lehet törölni!")) {
                throw new IOException("Nem létező fájlt nem lehet törölni!");
            }
            throw new IOException("Nem törölhető a kijelölt elem!");
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
        if (!(new File(nev.toUri()).exists())) {
            (new File(nev.toUri())).mkdirs();
        } else
            throw new IOException("Ez a mappa már létezik");
    }
}
