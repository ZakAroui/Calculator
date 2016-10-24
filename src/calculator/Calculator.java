
package calculator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Zaki Aroui
 * 
 * main class
 */
public class Calculator {
    
    protected static String usrnm;
    private static JFrame infoFrame;
    
    public static void main(String[] args) {
        //ask the user to enter a username
        do {
        usrnm = JOptionPane.showInputDialog("Enter your username");
        usrnm = usrnm.trim();
        //check that the user entered a correct username
        if(usrnm.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Please enter a username", "Error!", JOptionPane.PLAIN_MESSAGE);
        } 
        }while(usrnm.equalsIgnoreCase(""));
        //display the calculator frame
        infoFrame = new Calc();
        infoFrame.setLocation(450, 200);
        infoFrame.setTitle("Calcularot 1.0");
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoFrame.setVisible(true);
    }
}
