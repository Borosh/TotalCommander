package fajl;

import java.io.File;
import java.util.ArrayList;

public class Kiterjesztesek {
    static ArrayList<String> tamogatott = new ArrayList<String>();
    private static String utvonal = "";
    private static String[] darabok;
    private static String str = "";

    public static void tamogatottTipusok() {
        tamogatott.add("txt");
        tamogatott.add("rtf");
        tamogatott.add("jpg");
        tamogatott.add("bmp");
        tamogatott.add("gif");
        tamogatott.add("png");
        tamogatott.add("wbmp");
        tamogatott.add("jpeg");
        tamogatott.add("<DIR>");
    }

    static String kiterjesztes(File fajl) {
        if (fajl.isDirectory()) {
            return "<DIR>";
        } else {
            utvonal = fajl.getAbsolutePath();
            darabok = utvonal.split("\\.");
            str = darabok[darabok.length - 1];
            if (tamogatott.contains(str)) {
                return str;
            } else {
                return " ";
            }
        }
    }

    static String nev(File fajl) throws Exception {
        String resz;
        str = "";
        utvonal = fajl.getAbsolutePath();
        darabok = utvonal.split("\\\\");
        resz = darabok[darabok.length - 1];
        if (fajl.isDirectory()) {
            str = resz;
        } else {
            String[] darabok1 = resz.split("\\.");
            for (int i = 0; i < darabok1.length - 1; i++) {
                str += darabok1[i] + ".";
            }
            str = str.substring(0, str.length() - 1);

        }
        return str;
    }
}
