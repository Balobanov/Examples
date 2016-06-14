package ua.org.ao.balobanov;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

    	EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				InterpreterFrame frame = new InterpreterFrame("RegEx");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setVisible(true);
			}
		}); 	
    }
}
