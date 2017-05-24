package GUI;

import javax.swing.*;
import java.awt.*;

public class Ablak extends JFrame {

    public static NavigaloPanel fokuszbanVan;
    public static NavigaloPanel nincsFokuszban;

    public Ablak(String nev) {
        setTitle(nev);
        setLayout(new BorderLayout());
        setBounds(50, 50, 800, 600);
        NavigaloPanel balPanel = new NavigaloPanel();
        fokuszbanVan = balPanel;
        NavigaloPanel jobbPanel = new NavigaloPanel();
        nincsFokuszban = jobbPanel;
        JPanel fejLecek = new JPanel(new GridLayout(1, 2));
        fejLecek.add(balPanel.fejLec);
        fejLecek.add(jobbPanel.fejLec);
        JPanel kozepso = new JPanel(new GridLayout(1, 2));
        kozepso.add(new JScrollPane(balPanel.fajlok));
        kozepso.add(new JScrollPane(jobbPanel.fajlok));
        JPanel foAblak = new JPanel(new BorderLayout());
        foAblak.add(fejLecek, BorderLayout.NORTH);
        foAblak.add(kozepso, BorderLayout.CENTER);
        LabLec also = new LabLec();
        foAblak.add(also, BorderLayout.PAGE_END);
        add(foAblak, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void fokuszValtas() {
        NavigaloPanel temp = fokuszbanVan;
        fokuszbanVan = nincsFokuszban;
        nincsFokuszban = temp;

    }

}
