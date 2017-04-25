package fajl;

//import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Fajl {
	private String nev;
	private String kiterjesztes;
	private long meret;
	private String datum;
	private ImageIcon ikon;
	private int pont;
	
	public Fajl() {
	}
	
	public void setFajl(String ut) {
		File fajl = new File(ut);
		nev = fajl.getName();
		pont = nev.length();
		for(int i=nev.length()-1; i>=0; i--) {
			if(nev.charAt(i) == '.') {
				pont = i;
				break;
			}
		}
		nev = nev.substring(0, pont);
		kiterjesztes = kiterjesztesCsinal(fajl);
		meret = fajl.length();
		datum = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(fajl.lastModified());
		//ikon = ;
		if(!(kiterjesztes.equals(" "))) {
			System.out.println(nev + "		" + kiterjesztes + "	" + meret + "	" + datum);
		}
	}
	
	public String kiterjesztesCsinal(File fajl) {
		ArrayList<String> tamogatott = new ArrayList<String>();
		tamogatott.add("txt");
		tamogatott.add("rtf");
		tamogatott.add("jpg");
		tamogatott.add("icon");
		tamogatott.add("<DIR>");
		String utvonal = fajl.getAbsolutePath();
		String str = "";
		//int pont = utvonal.length()-1;
		for(int i=utvonal.length()-1; i>=0; i--) {
			if(utvonal.charAt(i) == '.' && i != 0) {
				pont = i;
				break;
			}
		}
		if(pont != utvonal.length()-1) {
			for(int i=pont+1; i<utvonal.length(); i++) {
				str += utvonal.charAt(i);
			}
		}
		else {
			str = "<DIR>";
		}
		if(tamogatott.contains(str)) {
			return str;
		}
		else {
			return " ";
		}
	}
	
	public String getNev() {
		return nev;
	}
	
	public String getKiterjesztes() {
		return kiterjesztes;
	}
	
	public long getMeret() {
		return meret;
	}

	public String getDatum() {
		return datum;
	}
}
