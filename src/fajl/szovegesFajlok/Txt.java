package fajl.szovegesFajlok;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Txt extends JPanel {

    private static final long serialVersionUID = 1L;

    public Txt(String path, int x, int y) throws Exception {

        setBounds(0, 0, x, y);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        JTextArea szoveg = new JTextArea();
        szoveg.setBounds(0, 0, x - 10, y - 10);
        szoveg.setMargin(new Insets(5, 5, 5, 5));
        BufferedReader brf = new BufferedReader(new FileReader(new File(path)));
        String str = null;
        while ((str = brf.readLine()) != null)
            szoveg.append(str);
        brf.close();

        JScrollPane csuszka = new JScrollPane(szoveg);
        csuszka.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        csuszka.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(csuszka, gbc);

        ++gbc.gridy;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 0;

        JButton mentes = new JButton("Mentés");
        add(mentes, gbc);
        mentes.addActionListener(e -> {
            try {
                BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(path)));
                bfw.write(szoveg.getText());
                bfw.close();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(this, "File mentés közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
