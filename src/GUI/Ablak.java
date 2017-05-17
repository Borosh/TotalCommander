package GUI;

import java.awt.*;
import javax.swing.*;

import fajl.*;

public class Ablak extends JFrame{
	
	public static FajlLista fokuszbanVan;
	public static FajlLista nincsFokuszban;
	private NavigaloPanel balPanel = new NavigaloPanel();
	private NavigaloPanel jobbPanel = new NavigaloPanel();
	private LabLec also = new LabLec();
	private FejLec felso = new FejLec();
	private JPanel kozepso = new JPanel(new GridLayout(1, 2));
	private JPanel foAblak = new JPanel(new BorderLayout());
	
	public Ablak(String nev){
		setTitle(nev);
		setLayout(new BorderLayout());
		setBounds(500, 200, 850, 750);
		fokuszbanVan = balPanel.fajlLista;
		nincsFokuszban = jobbPanel.fajlLista;
		foAblak.add(felso, BorderLayout.PAGE_START);
		kozepso.add(new JScrollPane(balPanel));
		kozepso.add(new JScrollPane(jobbPanel));
		foAblak.add(kozepso, BorderLayout.CENTER);
		foAblak.add(also, BorderLayout.PAGE_END);
		add(foAblak,BorderLayout.CENTER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void fokuszValtas(){
		
	}

}
