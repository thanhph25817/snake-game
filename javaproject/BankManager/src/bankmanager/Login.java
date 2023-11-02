/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankmanager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 *
 * @author thanh
 */
public class Login extends JFrame{
 Login(){
     setTitle("AUTOMATED MACHINE");
     
     ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
     JLabel label=new JLabel(il);
     add(label);
     setSize(800,400);
     setVisible(true);
     setLocation(350,200);
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Login();
    }
    
}
