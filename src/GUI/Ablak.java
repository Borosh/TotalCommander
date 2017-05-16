package GUI;

import java.awt.*;
import javax.swing.*;
import fajl.*;

public class Ablak extends JFrame{
	
	public FajlLista fokuszbanVan;
	public FajlLista nincsFokuszban;
	private NavigaloPanel balPanel = new NavigaloPanel();
	private NavigaloPanel jobbPanel = new NavigaloPanel();
	private LabLec also = new LabLec();
	private FejLec felso = new FejLec();
	
	
	public Ablak(String nev){
		super(nev);
		setBounds(500, 200, 800, 750);
		setLayout(new BorderLayout());
		fokuszbanVan = balPanel.fajlLista;
		nincsFokuszban = jobbPanel.fajlLista;
		add(felso, BorderLayout.PAGE_START);
		add(balPanel, BorderLayout.LINE_START);
		add(jobbPanel, BorderLayout.LINE_END);
		add(also, BorderLayout.PAGE_END);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
