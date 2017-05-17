package fajl;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FajlAdatok {
    // private ImageIcon ikon;

    public static ArrayList<String> tamogatott = new ArrayList<String>() {
        private static final long serialVersionUID = 1L;

        {
            add("txt");
            add("rtf");
            add("jpg");
            add("bmp");
            add("png");
            add("wbmp");
            add("jpeg");
        }
    };

    public static String getNev(File fajl) {
        if (fajl.isDirectory()) {
            return fajl.getName();
        } else
            return fajl.getAbsolutePath().substring(fajl.getAbsolutePath().lastIndexOf("\\") + 1,
                    fajl.getAbsolutePath().lastIndexOf("."));
    }

    public static String getKiterjesztes(File fajl) {
        if (fajl.isDirectory())
            return "<DIR>";
        else {
            String str = fajl.getAbsolutePath().substring(fajl.getAbsolutePath().lastIndexOf(".") + 1);
            if (tamogatott.contains(str))
                return str;
            else
                return "";
        }
    }

    public static String getMeret(File fajl) {
        if (fajl.isDirectory())
            return "";
        else
            return Long.toString(fajl.length());
    }

    public static String getDatum(File fajl) {
        return new SimpleDateFormat("MM/dd/yyyy HH:mm").format(fajl.lastModified());
    }

    public static PrintStream getAdatok(File fajl, FajlLista lista) {
        if (lista.os == fajl) {
            return System.out.printf("..\n");
        }
        return System.out.printf("%-50s%-25s%-25s%-25s\n", getNev(fajl), getKiterjesztes(fajl), getMeret(fajl),
                getDatum(fajl));
    }
}
