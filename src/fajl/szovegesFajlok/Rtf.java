package fajl.szovegesFajlok;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;

public class Rtf extends JPanel{

	private static final long serialVersionUID = 1L;

	public Rtf(String path){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10,10,10,10);
		
		RTFEditorKit rtf = new RTFEditorKit();
		JTextArea szoveg = new JTextArea();
		szoveg.setDocument(rtf.createDefaultDocument());
		szoveg.setMinimumSize(new Dimension(600, 600));
		szoveg.setBorder(BorderFactory.createEtchedBorder());
		szoveg.setMargin(new Insets(20,20,20,20));
		
		JButton mentes = new JButton("Mentés");
		
		try{
			rtf.read(new FileInputStream(path), szoveg.getDocument(), 0);
		}
		catch(BadLocationException e){} 
		catch (IOException e) {}
		
		JFrame ablak = new JFrame();
		ablak.setLayout(new GridBagLayout());
		ablak.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ablak.add(szoveg, gbc);
		
		++gbc.gridy;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weighty = 0;
		ablak.add(mentes, gbc);
		mentes.addActionListener(e->{
			try{
				rtf.write(new FileOutputStream(path), szoveg.getDocument(), 0, szoveg.getDocument().getLength());
			}
			catch(BadLocationException e1){}
			catch (IOException e2) {}
		});
		
		ablak.setLocation(600,200);
		ablak.setSize(ablak.getMinimumSize());
		ablak.setVisible(true);
		
	}
}
