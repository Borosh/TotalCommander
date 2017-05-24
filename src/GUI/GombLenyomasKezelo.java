package GUI;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GombLenyomasKezelo implements KeyListener {

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F3:
            case KeyEvent.VK_ENTER:
                LabLec.F3.doClick();
                break;
            case KeyEvent.VK_F5:
                LabLec.F5.doClick();
                break;
            case KeyEvent.VK_F6:
                LabLec.F6.doClick();
                break;
            case KeyEvent.VK_F7:
                LabLec.F7.doClick();
                break;
            case KeyEvent.VK_F8:
            case KeyEvent.VK_DELETE:
                LabLec.F8.doClick();
                break;
            case KeyEvent.VK_F1:
                LabLec.F1.doClick();
                break;
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
