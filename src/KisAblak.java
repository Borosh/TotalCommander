import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by FANNI on 2017.04.25..
 */
public class KisAblak extends JFrame{
    public static Font eleresiUtBetuTipus = new Font("Futura", Font.ITALIC, 14);
    public static Font eszkozBetuTipus = new Font("Futura", Font.BOLD, 14);
    public static Font fazisBetuTipus = new Font("Futura", Font.BOLD, 20);

    JButton eleresiUt = new JButton("C:honnan jott ez a fajl");


    public static JButton fajlNev = new JButton("Nev");
    public static JButton kiterjesztes = new JButton("Kiterjesztes ");
    public static JButton meret = new JButton("Meret");
    public static JButton datum = new JButton("Datum");

    public KisAblak(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel eleresiUtSav = new JPanel();
        eleresiUtSav.setLayout(new FlowLayout(FlowLayout.LEFT));
        eleresiUtSav.setBackground(Color.black.brighter());
        eleresiUtSav.setPreferredSize(new Dimension(600, 30));
        eleresiUt.setBackground(Color.black);
        eleresiUt.setForeground(Color.WHITE);
        eleresiUt.setFont(eleresiUtBetuTipus);
        eleresiUtSav.add(eleresiUt);
        eleresiUtSav.setVisible(true);

        JPanel tulajdonsag = new JPanel();
        tulajdonsag.setLayout(new GridLayout(1, 4));
        tulajdonsag.setBackground(Color.WHITE);

        final JPopupMenu popup = new JPopupMenu();
        popup.add(new JMenuItem(new AbstractAction("Option 1") {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 1 selected");
            }
        }));
        popup.add(new JMenuItem(new AbstractAction("Option 2") {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 2 selected");
            }
        }));

        eleresiUt.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        fajlNev.setHorizontalAlignment(SwingConstants.LEFT);
        kiterjesztes.setHorizontalAlignment(SwingConstants.LEFT);
        datum.setHorizontalAlignment(SwingConstants.LEFT);
        meret.setHorizontalAlignment(SwingConstants.LEFT);
        fajlNev.setFont(eszkozBetuTipus);
        datum.setFont(eszkozBetuTipus);
        kiterjesztes.setFont(eszkozBetuTipus);
        meret.setFont(eszkozBetuTipus);
        fajlNev.setForeground(Color.BLACK);
        kiterjesztes.setForeground(Color.BLACK);
        datum.setForeground(Color.BLACK);
        meret.setForeground(Color.BLACK);
        tulajdonsag.add(fajlNev);
        tulajdonsag.add(kiterjesztes);
        tulajdonsag.add(datum);
        tulajdonsag.add(meret);

        JPanel lista = new JPanel();
        lista.setLayout(new GridLayout(1, 5));
        lista.setPreferredSize(new Dimension(600, 400));
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(lista.getPreferredSize());


        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        frame.setContentPane(content);
        content.add(eleresiUtSav, BorderLayout.NORTH);
        content.add(tulajdonsag, BorderLayout.CENTER);
        content.add(lista, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}