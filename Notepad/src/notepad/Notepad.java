package notepad;

import java.awt.*;
import javax.swing.*;

public class Notepad extends JFrame {

    private JTextArea area;
    
    public Notepad() {
        setTitle("Notepad");
        setSize(1950, 1050);
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        
        JMenuBar menuBar = new JMenuBar(); 
        
        JMenu file = new JMenu("File"); 
        JMenu edit = new JMenu("Edit");
        
        JMenuItem newdoc = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem print = new JMenuItem("Print");
        JMenuItem exit = new JMenuItem("Exit");
        
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem selectall = new JMenuItem("Select All");
        
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
        
        add(area);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Notepad();
    }
}