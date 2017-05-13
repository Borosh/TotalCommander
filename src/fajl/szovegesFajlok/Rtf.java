package fajl.szovegesFajlok;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;

public class Rtf extends JPanel {

    private static final long serialVersionUID = 1L;

    public Rtf(String path, int x, int y) throws FileNotFoundException, IOException, BadLocationException {
        
        setBounds(0,0,x,y);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        RTFEditorKit rtf = new RTFEditorKit();
        JTextArea szoveg = new JTextArea();
        szoveg.setDocument(rtf.createDefaultDocument());
        szoveg.setBounds(0,0,x-10, y-10);
        szoveg.setMargin(new Insets(5,5,5,5));

        rtf.read(new FileInputStream(path), szoveg.getDocument(), 0);
        JScrollPane csuszka = new JScrollPane (szoveg);
        csuszka.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        csuszka.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        add(csuszka, gbc);

        ++gbc.gridy;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 0;

        JButton mentes = new JButton("Mentés");
        add(mentes, gbc);
        mentes.addActionListener(e -> {
        	try {
				rtf.write(new FileOutputStream(path), szoveg.getDocument(), 0, szoveg.getDocument().getLength());
			} catch (IOException | BadLocationException e1) {
				JOptionPane.showMessageDialog(this, "File mentés közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
			}
        });
    }
}
