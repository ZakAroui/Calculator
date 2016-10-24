/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author lenono
 */
public class Calculator {
    /**
     * @param args the command line arguments
     */
    protected static String usrnm;
    private static JFrame infoFrame;
    
    public static void main(String[] args) {
        // TODO code application logic here
        do {
        usrnm = JOptionPane.showInputDialog("Enter your username");
        usrnm = usrnm.trim();
        if(usrnm.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Please enter a username", "Error!", JOptionPane.PLAIN_MESSAGE);
        } 
        }while(usrnm.equalsIgnoreCase(""));
        
        infoFrame = new Calc();
        infoFrame.setLocation(450, 200);
        infoFrame.setTitle("Calcularot 1.0");
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoFrame.setVisible(true);
        
        //infoFrame.dispatchEvent(new WindowEvent(infoFrame, WindowEvent.WINDOW_CLOSING));
        
    }
    
}
