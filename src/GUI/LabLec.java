import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by FANNI on 2017.05.16..
 */
public class LabLec extends JPanel {

    public static JButton F3 = new JButton("F3 Nézőke");
    public static JButton F5 = new JButton("F5 Másolás ");
    public static JButton F6 = new JButton("F6 Áthelyez");
    public static JButton F7 = new JButton("F7 Új mappa");
    public static JButton F8 = new JButton("F8 Törlés");
    public static JButton TAB = new JButton("TAB");
    private JPanel labLec = new JPanel();


    public LabLec() {
        setLayout(new GridLayout(1, 5));
        setMinimumSize(new Dimension(400, 50));
        add(F3);
        add(F5);
        add(F6);
        add(F7);
        add(F8);
        add(TAB);

        F3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FajlNezegeto(Main.ablak.fokuszbanVan.fajlLista.helyzet);
            }
        });
        F5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operaciok.masol(Main.ablak.fokuszbanVan.fajlLista.aktualisFajl, Main.ablak.nincsFokuszban.helyzet);
            }
        });
        F6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operaciok.athelyez(Main.ablak.fokuszbanVan.fajlLista.aktualisFajl, Main.ablak.nincsFokuszban.helyzet);

            }
        });
        F8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operaciok.torol(Main.ablak.fokuszbanVan.fajlLista.aktualisFajl);
            }
        })
        F7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String[] nev = new String[1];
                JFrame frameUjMappa = new JFrame();
                frameUjMappa.setLayout(new GridLayout(1, 3));
                frameUjMappa.setSize(400, 80);
                JLabel ujmappa = new JLabel("Új mappa neve: ");
                JTextField mappaNev = new JTextField();
                JButton ok = new JButton("OK");
                frameUjMappa.add(ujmappa);
                frameUjMappa.add(mappaNev);
                frameUjMappa.add(ok);
                frameUjMappa.setVisible(true);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nev[0] = mappaNev.getText();
                        frameUjMappa.dispatchEvent(new WindowEvent(frameUjMappa, WindowEvent.WINDOW_CLOSING));
                        Operaciok.ujMappa(Main.ablak.fokuszbanVan.fajlLista.helyzet.getAbsolutePath() + "\\" + nev[0]);
                    }
                });

            }
        });

        TAB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ablak.fokuszValtas();
            }
        });

    }

}
