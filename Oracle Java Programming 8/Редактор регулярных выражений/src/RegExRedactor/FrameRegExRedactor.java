/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegExRedactor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.FontMetrics;

/**
 *
 * @author DENNNN
 */
public class FrameRegExRedactor extends JFrame{
    
    private int DEFAULT_WIDTH = 600;
    private int DEFAULT_HEIGHT = 600;

    JTextArea regEx;
    JTextArea text;
    JTextArea matcher;
    JLabel reg = new JLabel("Регулярное выражение");
    JLabel textl = new JLabel("Текст");
    JLabel result = new JLabel("Результат");
    JComboBox<String> jFonts;
    JComboBox<Integer> jFontsSize;
    JPanel pane;
    
    public FrameRegExRedactor(String title) throws HeadlessException {
        super(title);
        
        setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);
        
        reg.setBackground(Color.GREEN);
        textl.setBackground(Color.GREEN);
        result.setBackground(Color.GREEN);
        
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        jFonts = new JComboBox<>(fonts);
        jFontsSize = new JComboBox<>(new Integer[]{8,10,12,14,16,18,20,22,24,26,28,30});
        

         pane = new JPanel();
        RegExParse rep = new RegExParse();
        regEx = new JTextArea(10, 40);
        text = new JTextArea(10, 40);
        matcher = new JTextArea(10, 40);
        
        regEx.getDocument().addDocumentListener
        (
           new DocumentListener()
           {

            @Override
            public void insertUpdate(DocumentEvent e) {
               rep.matcher();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                rep.matcher();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
               
           }
        );
        
        jFonts.addActionListener((a)->{setFonts();});
        jFontsSize.addActionListener((a)->{  setFonts();});

        pane.setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(Color.yellow, 10);
        Border titile = BorderFactory.createTitledBorder(border, "RegEx");
        pane.setBorder(titile);
        pane.setLayout(new GridBagLayout());
       
        pane.add(jFonts, new GBC(0, 0).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setWeight(0, 0).setInsets(10));
        
        pane.add(reg, new GBC(0, 1).setAnchor(GBC.CENTER).setFill(GBC.NONE).setWeight(0, 0));
        pane.add(new JScrollPane(regEx), new GBC(0, 2).setAnchor(GBC.WEST).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5).setIpad(300, 150));
        
        pane.add(jFontsSize, new GBC(1, 0).setAnchor(GBC.CENTER).setFill(GBC.HORIZONTAL).setWeight(0, 0).setInsets(10));
        
        pane.add(textl, new GBC(1, 1).setAnchor(GBC.CENTER).setFill(GBC.NONE).setWeight(0, 0));
        pane.add(new JScrollPane(text), new GBC(1, 2).setAnchor(GBC.WEST).setFill(GBC.BOTH).setWeight(1, 0).setInsets(5).setIpad(300, 150));
        
        pane.add(result, new GBC(0, 3, 2, 1).setAnchor(GBC.CENTER).setFill(GBC.NONE));
        pane.add(new JScrollPane(matcher), new GBC(0, 4, 2, 1).setAnchor(GBC.WEST).setFill(GBC.BOTH).setWeight(1, 1).setInsets(5).setIpad(150, 150));
       
        //pane.add(new JButton("awdaw"), new GBC(2, 0, 1, 1).setAnchor(GBC.WEST).setFill(GBC.BOTH).setWeight(0, 0).setInsets(5));
        
        add(pane, BorderLayout.CENTER);
        /*try {
            URL url = new URL("http://logicgames.besaba.com/shulte.html");
            URLConnection con = url.openConnection();
            
            InputStream in = con.getInputStream();
            BufferedInputStream buf = new BufferedInputStream(in);
            Scanner scan = new Scanner(buf);
             String s = "";
             
            while(scan.hasNext())
            {
                s += scan.nextLine() + '\n';
            }
            
             matcher.setText(s);
        } catch (Exception e) {
            matcher.setText(e.toString());
        }*/
        
    }
    
    
    
    public Dimension getDimension()
    {
        return new Dimension(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }
    
    
    class RegExParse
    {
        public void matcher()
        {
            try
            {
            Pattern pat = Pattern.compile(regEx.getText());
            Matcher mat = pat.matcher(text.getText());
	
            String s = "";
            while(mat.find())
            {
               s = s + mat.group() + '\n';
            }
            
            matcher.setText(s);
            }
            catch(Exception e)
            {
               matcher.setText("Ошибка");
            }
        }
    }
    
    private void setFonts()
    {
                regEx.setFont(new Font((String)jFonts.getSelectedItem(), 0, (Integer)jFontsSize.getSelectedItem()));
                text.setFont(new Font((String)jFonts.getSelectedItem(), 0, (Integer)jFontsSize.getSelectedItem()));
                matcher.setFont(new Font((String)jFonts.getSelectedItem(), 0, (Integer)jFontsSize.getSelectedItem()));
    }
}
