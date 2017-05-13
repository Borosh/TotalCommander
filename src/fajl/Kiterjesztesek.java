package fajl;

import java.io.File;
import java.util.ArrayList;

public class Kiterjesztesek {
	public static ArrayList<String> tamogatott = new ArrayList<String>();
	private static String utvonal = "";
	private static String[] darabok;
	private static String str = "";
	
	public static void tamogatottTipusok() {
		tamogatott.add("txt");
        tamogatott.add("rtf");
        tamogatott.add("jpg");
        tamogatott.add("icon");
        tamogatott.add("<DIR>");
	}
	
	public static String kiterjesztes(File fajl) {		
		if(fajl.isDirectory()) {
			return "<DIR>";
		}
		else {
			utvonal = fajl.getAbsolutePath();
			darabok = utvonal.split("\\.");
			str = darabok[darabok.length-1];
			if (tamogatott.contains(str)){
				return str;
			}
			else {
				return " ";
			}
		}
	}
	    
	public static String nev(File fajl) {
		String resz;
		str = "";
		utvonal = fajl.getAbsolutePath();
	    darabok = utvonal.split("\\\\");
	    resz = darabok[darabok.length-1];
	    if(fajl.isDirectory()) {
	    	str = resz;
	    }
	    else {
	    	String[] darabok1 = resz.split("\\.");
	    	for(int i=0; i<darabok1.length-1; i++) {
	    		str += darabok1[i] + ".";
	    	}
	    	try {
	    		str = str.substring(0, str.length()-1);
	    	}
	    	catch (StringIndexOutOfBoundsException e) {
	    	}
	    }
	    return str;
	}
}
