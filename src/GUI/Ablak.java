package GUI;

import java.awt.*;
import javax.swing.*;

import fajl.*;

public class Ablak extends JFrame{
	
	public static NavigaloPanel fokuszbanVan;
	public static NavigaloPanel nincsFokuszban;
	private NavigaloPanel balPanel = new NavigaloPanel();
	private NavigaloPanel jobbPanel = new NavigaloPanel();
	private LabLec also = new LabLec();
	private JPanel kozepso = new JPanel(new GridLayout(1, 2));
	private JPanel foAblak = new JPanel(new BorderLayout());
	private JPanel fejLecek = new JPanel(new GridLayout(1, 2));
	
	public Ablak(String nev){
		setTitle(nev);
		setLayout(new BorderLayout());
		setBounds(500, 200, 850, 750);
		fokuszbanVan = balPanel;
		nincsFokuszban = jobbPanel;
		fejLecek.add(balPanel.fejLec);
		fejLecek.add(jobbPanel.fejLec);
		kozepso.add(new JScrollPane(balPanel.fajlok));
		kozepso.add(new JScrollPane(jobbPanel.fajlok));
		foAblak.add(fejLecek, BorderLayout.NORTH);
		foAblak.add(kozepso, BorderLayout.CENTER);
		foAblak.add(also, BorderLayout.PAGE_END);
		add(foAblak,BorderLayout.CENTER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void fokuszValtas(){
		NavigaloPanel temp = fokuszbanVan;
		fokuszbanVan = nincsFokuszban;
		nincsFokuszban = temp;
	}

}
