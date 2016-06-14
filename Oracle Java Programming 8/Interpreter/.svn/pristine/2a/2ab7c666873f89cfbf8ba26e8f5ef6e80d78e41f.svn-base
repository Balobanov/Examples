package ua.org.ao.balobanov;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import javax.swing.*;

public class InterpreterFrame extends JFrame{
    
    private int DEFAULT_WIDTH = 600;
    private int DEFAULT_HEIGHT = 600;
    
    private JLabel jTitle, jFrom, jTo;               
    private JButton jTranslate;
    private JComboBox<String> jFromTrans, jToTrans;
    private JTextArea fromTetx, toText;
    
    private boolean fromChanged = false;
    private boolean toChanged = false;
    
    List<String> From = new ArrayList<>(20000); // Словарь, исходный язык
	List<String> To = new ArrayList<>(20000); // Словарь, целевой язык
    
    public InterpreterFrame(String title) throws HeadlessException {
        super(title);
        
        setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);
        this.setLayout(new GridBagLayout());
        
        DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>();
        
        jTitle = new JLabel("ПЕРЕВОДЧИК");
        jFrom = new JLabel("С:");
        jTo = new JLabel("НА:");
        fromTetx = new JTextArea();
        toText = new JTextArea();

        jTranslate = new JButton("Перевести");
        
        /*
         * Получает список файлов в корневом каталоге проекта
         * и добавляет их в списки
         */
		File dir = new File(".");
        String files[] = dir.list();
        for (String file : files) {
        	if(file.lastIndexOf(".") != -1)
        		if(file.substring(file.lastIndexOf("."), file.length()).equals(".txt"))
        		{
        			model1.addElement(file.substring(0, file.lastIndexOf(".")));
        			model2.addElement(file.substring(0, file.lastIndexOf(".")));
        		}
		}
        
        jFromTrans = new JComboBox<>(model1);
        jToTrans = new JComboBox<>(model2);
        
        jFromTrans.setSelectedIndex(1);
        
        // Загружает словари по умолчанию
        loadFile("English.txt", From);
        loadFile("Deutsch.txt", To);
        
        /*
         * Если был выбран другой язык в списке очистить словарь и загрузить другой.
         */
        jFromTrans.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				From.clear();
				loadFile(((String)jFromTrans.getSelectedItem()) + ".txt", From);
			}
		});
        
        jToTrans.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				To.clear();
				loadFile(((String)jToTrans.getSelectedItem()) + ".txt", To);
			}
		});
        
        
        /*
         * При нажатии на кнопку "Перевести" считывается текс из текстовой области,
         * разбивается на слова.
         * Ищем индекс слова, на исходном языке, в словаре. после по этому индексу выбираем 
         * из словаря целевого языка переведенное слово. если такого слова нет оставить его не переведенным
         */
        jTranslate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = fromTetx.getText();
				
				Scanner st = new Scanner(str).useDelimiter(" ");
				String trans = "";
				String word = "";
				
				while (st.hasNext()) 
				{
					word = st.next();
					
					if(From.lastIndexOf(word.toLowerCase()) != -1)
					{
						trans += (To.get(From.lastIndexOf(word.toLowerCase())) + " ");
					}
					else
					{
						trans += word + " ";
					}
				}
				
				toText.setText(trans);
			}
		});
        
        
       this.add(jTitle, new GBC(0,0,2,1).setWeight(0, 0).setFill(GBC.NONE).setInsets(20));
       this.add(jFrom, new GBC(0,1,1,1).setWeight(0, 0).setFill(GBC.BOTH).setAnchor(GBC.WEST));
       this.add(jFromTrans, new GBC(1,1,1,1).setWeight(1, 0).setFill(GBC.HORIZONTAL));
       this.add(new JScrollPane(fromTetx), new GBC(0,2,2,1).setWeight(0, 1).setFill(GBC.BOTH).setInsets(15));
       
       this.add(jTo, new GBC(0,3,1,1).setWeight(0, 0).setFill(GBC.NONE));
       this.add(jToTrans, new GBC(1,3,1,1).setWeight(0, 0).setFill(GBC.HORIZONTAL));
       this.add(new JScrollPane(toText), new GBC(0,4,2,1).setWeight(0, 1).setFill(GBC.BOTH).setInsets(15));
       
       this.add(jTranslate, new GBC(0,5,2,1).setWeight(1, 0).setFill(GBC.HORIZONTAL).setInsets(10));
    }
    
    public Dimension getDimension()
    {
        return new Dimension(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }
    
    // Загружает слова
    private void loadFile(String file, List<String> list)
    {
    	try(FileReader freader = new FileReader(file);
				BufferedReader breader = new BufferedReader(freader);
				Scanner scan = new Scanner(breader))
				{
					while(scan.hasNext() )
					{
						list.add(scan.nextLine());
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showConfirmDialog(this, "ERROR");
				}
    }
}
