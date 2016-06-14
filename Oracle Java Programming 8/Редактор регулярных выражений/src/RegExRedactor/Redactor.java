/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegExRedactor;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author DENNNN
 */
public class Redactor {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> 
        {
            FrameRegExRedactor frame = new FrameRegExRedactor("RegEx");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setSize(frame.getDimension());
            frame.setVisible(true);
        } 
        );
    }
}
