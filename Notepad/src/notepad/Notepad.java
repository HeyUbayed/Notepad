package notepad;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Notepad extends JFrame {

    private JTextArea area;
    private JScrollPane scpane;

    public Notepad() {
        setTitle("Notepad");
        setSize(1950, 1050);
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        
        JMenuBar menuBar = new JMenuBar(); 
        menuBar.setBackground(Color.LIGHT_GRAY);
        
        JMenu file = new JMenu("File"); 
        JMenu edit = new JMenu("Edit");
        
        area.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        file.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        edit.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        
        JMenuItem newdoc = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem print = new JMenuItem("Print");
        JMenuItem exit = new JMenuItem("Exit");
        
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem selectall = new JMenuItem("Select All");
        
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));               
        
        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        
        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);
        
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectall);
           
        scpane = new JScrollPane(area); 
        add(scpane, BorderLayout.CENTER);
        scpane.setBorder(BorderFactory.createLineBorder(Color.white, 7));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Notepad();
    }
}
