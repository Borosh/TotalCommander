package GUI;

import javax.swing.*;
import java.awt.event.*;

public class GombLenyomasKezelo implements KeyListener {

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_F3 || e.getKeyCode() == KeyEvent.VK_ENTER) {
			LabLec.F3.doClick();
		
		} else if (e.getKeyCode() == KeyEvent.VK_F5) {
			LabLec.F5.doClick();
		} else if (e.getKeyCode() == KeyEvent.VK_F6) {
			LabLec.F6.doClick();
		} else if (e.getKeyCode() == KeyEvent.VK_F7) {
			LabLec.F7.doClick();
		} else if (e.getKeyCode() == KeyEvent.VK_F8 || e.getKeyCode() == KeyEvent.VK_DELETE) {
			LabLec.F8.doClick();
		} else if (e.getKeyCode() == KeyEvent.VK_F1) {
			LabLec.F1.doClick();
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && e.getSource() instanceof JList) {
			Ablak.fokuszbanVan.csokkento((JList<String>) (e.getSource()));
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && e.getSource() instanceof JList) {
			Ablak.fokuszbanVan.novelo((JList<String>) (e.getSource()));
		}
	}

	public void keyTyped(KeyEvent e) {
	}

}
