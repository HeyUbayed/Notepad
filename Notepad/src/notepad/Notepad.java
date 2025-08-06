package notepad;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame implements ActionListener{

    private JTextArea area;
    private JScrollPane scpane;
    String text = "";
    
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
        
        newdoc.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        cut.addActionListener(this);
        selectall.addActionListener(this);
        
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
        
        JButton zoomIn = new JButton("+");
        zoomIn.setBackground(Color.LIGHT_GRAY);
        zoomIn.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        zoomIn.setBorderPainted(false);
        zoomIn.setFocusPainted(false);
        menuBar.add(zoomIn);
        
        JButton zoomOut = new JButton("-");
        zoomOut.setBackground(Color.LIGHT_GRAY);
        zoomOut.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        zoomOut.setBorderPainted(false);
        zoomOut.setFocusPainted(false);
        menuBar.add(zoomOut);
        
        scpane = new JScrollPane(area); 
        add(scpane, BorderLayout.CENTER);
        scpane.setBorder(BorderFactory.createLineBorder(Color.white, 8));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    	if (ae.getActionCommand().equals("New")) {
            area.setText("");
        
        } else if (ae.getActionCommand().equals("Open")) {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false); 
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt"); 
            chooser.addChoosableFileFilter(restrict);
            int result = chooser.showOpenDialog(this);
            
            if(result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
				
                try{
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    area.read( br, null );
                    br.close();
                    area.requestFocus();
                }catch(Exception e){
                    System.out.print(e);
                }
            }
        } else if(ae.getActionCommand().equals("Save")){
            final JFileChooser SaveAs = new JFileChooser();
            SaveAs.setApproveButtonText("Save");
            int actionDialog = SaveAs.showOpenDialog(this);
            
            if (actionDialog != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File fileName = new File(SaveAs.getSelectedFile() + ".txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(fileName));
                area.write(outFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(ae.getActionCommand().equals("Print")){
            try{
                area.print();
            }catch(Exception e){}
        }else if (ae.getActionCommand().equals("Exit")) {
            System.exit(0);
        }else if (ae.getActionCommand().equals("Copy")) {
            text = area.getSelectedText();
        }else if (ae.getActionCommand().equals("Paste")) {
            area.insert(text, area.getCaretPosition());
        }else if (ae.getActionCommand().equals("Cut")) {
            text = area.getSelectedText();
            area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
        }else if (ae.getActionCommand().equals("Select All")) {
            area.selectAll();
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }

}
