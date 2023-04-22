/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainLinker;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Omage Micheal
 */
public class notifypt {
    notifypt(){
        JFrame nt =  new JFrame();
        nt.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/domainLinker/db_logo.png")));
        nt.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        final ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/domainLinker/tanks.gif")));
        
        Runnable Rd = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(wel.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print("Command Executed\n");
            nt.dispose();
        };
        
        Thread Td = new Thread(Rd);
        Td.start();
        
        JOptionPane.showMessageDialog(nt, "<html> <h1><strong>Redirecting!!!</strong>" +
                "</h1><p>official website will be opening in few seconds <br/><br/>Thanks for donating</p>"+
                " </html>"
                ,"Hey "+usr,JOptionPane.PLAIN_MESSAGE,icon);
        
    }
    public String usr = System.getProperty("user.name");
}
