package fajl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FajlAdatok {
    public static ArrayList<String> tamogatott = new ArrayList<String>() {
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
        if (fajl.isDirectory() || fajl.getAbsolutePath().lastIndexOf(".") < 0) {
            return fajl.getName();
        } else {
            return fajl.getAbsolutePath().substring(fajl.getAbsolutePath().lastIndexOf("\\") + 1,
                    fajl.getAbsolutePath().lastIndexOf("."));
        }
    }

    public static String getKiterjesztes(File fajl) {
        if (fajl.isDirectory()) {
            return "<DIR>";
        } else {
            String str = fajl.getAbsolutePath().substring(fajl.getAbsolutePath().lastIndexOf(".") + 1);
            if (str.equals(fajl.getAbsolutePath())) {
                return "File";
            } else {
                return str;
            }
        }
    }

    public static String getMeret(File fajl) {
        if (fajl.isDirectory()) {
            return "";
        } else {
            return Long.toString(fajl.length());
        }
    }

    public static String getDatum(File fajl) {
        return new SimpleDateFormat("MM/dd/yyyy HH:mm").format(fajl.lastModified());
    }

}
