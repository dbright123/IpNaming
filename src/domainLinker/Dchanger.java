
package domainLinker;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omage Micheal
 */
public class Dchanger extends javax.swing.JFrame {

    /**
     * Creates new form Dchanger
     */
    public Dchanger() {           
        initComponents();
        this.getContentPane().setBackground( Color.white );
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("db_logo.png")));
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        this.jButton4.addActionListener((ActionEvent e) -> {
            donate Donate = new donate();
            
            Donate.setVisible(true);
        });
        this.jButton3.addActionListener((ActionEvent e) -> {
            //new wel();
            help Help = new help();
            
            Help.setVisible(true);
            
        });
        //int dot = 0;
        this.jButton2.addActionListener((ActionEvent e) -> {
            Dchanger.val2 = jTextField2.getText();
            if(val2.isEmpty() || " ".equals(val2) || dot !=3){
                jLabel4.setText("Please something went wrong try the assign button again");
            }
            else{
                int d1 = 0;
                for (int x1 = 0; x1 < val1.length(); x1++) {
                    String y1 = String.valueOf(val1.charAt(x1));
                    if (".".equals(y1)) {
                        //ip += "";
                        d1 = 1;
                    }
                }
                if(d1 == 1){
                    int d2 = 0;
                    for (int x1 = 0; x1 < val2.length(); x1++) {
                        String y2 = String.valueOf(val2.charAt(x1));
                        if (".".equals(y2)) {
                            //ip += "";
                            d2 = 1;
                            
                        }
                    }
                    if(d2 == 1){
                        String url = "http://" + val2 + "/";
                        
                        if(Desktop.isDesktopSupported()){
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                desktop.browse(new URI(url));
                            } catch (IOException | URISyntaxException E) {
                                // TODO Auto-generated catch block
                                
                            }
                        }else{
                            Runtime runtime = Runtime.getRuntime();
                            try {
                                runtime.exec("xdg-open " + url);
                            } catch (IOException E) {
                                // TODO Auto-generated catch block
                                
                            }
                        }
                    }
                    else{
                        String url = "http://" + val2 + ".site/";
                    
                        if(Desktop.isDesktopSupported()){
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                desktop.browse(new URI(url));
                            } catch (IOException | URISyntaxException E) {
                                // TODO Auto-generated catch block

                            }
                        }else{
                            Runtime runtime = Runtime.getRuntime();
                            try {
                                runtime.exec("xdg-open " + url);
                            } catch (IOException E) {
                                // TODO Auto-generated catch block

                            }
                        }
                    }
                    
                    
                }
                else{
                    jLabel4.setText("Please something went wrong try the assign button again");
                }
                
            }
        });
        
        this.jButton1.addActionListener((ActionEvent e) -> {
            Dchanger.val1 = jTextField1.getText();
            Dchanger.val2 = jTextField2.getText();
            if (val1.isEmpty() || " ".equals(val1)) {
                jLabel5.setVisible(false);
                jLabel4.setText("Please enter an Ip Address");
            } else if (val2.isEmpty() || " ".equals(val2)) {
                jLabel6.setVisible(false);
                jLabel4.setText("Please enter an domain name");
            } else if (!(val1.isEmpty() && val2.isEmpty() || " ".equals(val2) && " ".equals(val1))) {
                jLabel5.setVisible(true);
                jLabel6.setVisible(true);
                dot = 0;
                //String ip = "";
                for (int x1 = 0; x1 < val1.length(); x1++) {
                    String y1 = String.valueOf(val1.charAt(x1));
                    if (".".equals(y1)) {
                        //ip += "";
                        dot += 1;
                    }
                };
                if (dot == 3) {
                    String sweb = "false";
                    for (int x2 = 0; x2 < val2.length(); x2++) {
                        String z = String.valueOf(val2.charAt(x2));
                        if( ".".equals(z) ){
                            sweb = "true";
                        }
                    }
                    if("false".equals(sweb)){
                        val2 += ".site/";
                    }
                    System.out.println(val1 + "       " + val2 + "\n");
                    jLabel4.setText(val2 + " is successfully done, click the test domain to test local domain");
                    // Creating a backup file
                    
                    File f = new File(Wdir);
                    f.setReadable(true);
                    f.setWritable(true);
                    
                    f.setExecutable(true);
                    
                    if(f.exists() && !f.isDirectory()) { // checking if file exists
                        //upcoming scanning algorithm
                        // do something
                        // Appending the file
                        System.out.println("The file in mention exists");
                        //Backup file
                        // i will soon start the main file , I am almost done
                        
                        try(BufferedReader br = new BufferedReader(new FileReader(Wdir))) {
                            StringBuilder sb = new StringBuilder();
                            String line = br.readLine();
                            
                            while (line != null) {
                                sb.append(line);
                                sb.append(System.lineSeparator());
                                line = br.readLine();
                            } // Itx wants to know whether that file is empty or not
                            String check = sb.toString();
                            System.out.println(check);
                            if(check.isEmpty()){
                                System.out.println("the text has been written");
                                Writer writer = null;
                                
                                try {
                                    writer = new BufferedWriter(new OutputStreamWriter(
                                            new FileOutputStream(Tdir), "utf-8"));
                                    int sl = 0;
                                    for (int x1 = 0; x1 < val2.length(); x1++) {
                                        String y2 = String.valueOf(val2.charAt(x1));
                                        
                                        if ("/".equals(y2)) {
                                            //ip += "";
                                            sl += 1;
                                        }
                                    }
                                    if(sl == 1){
                                        writer.write(val1 + "       " + val2 + "\n");
                                    }
                                    else{
                                        writer.write(val1 + "       " + val2 + "\n");
                                    }
                                    
                                } catch (IOException ex) {
                                    // Report
                                } finally {
                                    try {writer.close();} catch (IOException ex) {}
                                };
                                
                            }
                            else{
                                System.out.println("The text has gone through append");
                                String[] c = check.split("\n");
                                System.out.print( c.length + "\n");// if i get a number then this line of code is working
                                // This line of code
                                int sl = 0;
                                //String ip = "";
                                for (int x1 = 0; x1 < val2.length(); x1++) {
                                    String y2 = String.valueOf(val2.charAt(x1));
                                    if ("/".equals(y2)) {
                                        //ip += "";
                                        sl += 1;
                                    }
                                };
                                String cV;
                                
                                if(sl == 1){
                                    cV = val2;
                                    cV = cV.replace(" ","");
                                    cV = cV.replace("\n",",");
                                }
                                
                                else{
                                    cV = val2 + "/";
                                    cV = cV.replace(" ","");
                                    cV = cV.replace("\n",",");
                                };
                                System.out.println(Arrays.toString(c));
                                for (String c1 : c) {
                                    if (c1.equals(cV)) {
                                        System.out.println("Itz working");
                                    } else {
                                        Df =1;
                                    }
                                };
                                if(Df == 1){
                                    try {
                                        try (FileWriter fw = new FileWriter(Wdir,true) //the true will append the new data
                                                ) {
                                            fw.write(val1 + "       " + val2 + "\n");//appends the string to the file
                                        } //appends the string to the file
                                    }
                                    catch(IOException ioe)
                                    {
                                        System.err.println("IOException: " + ioe.getMessage());
                                    }
                                    
                                    try {
                                        try (FileWriter fw1 = new FileWriter(Wdir,true) //the true will append the new data
                                                ) {
                                            String cl = val2.replace("//","");
                                            fw1.write(val1 + "       " + cl + "\n");//appends the string to the file
                                        } //appends the string to the file
                                    }
                                    catch(IOException ioe)
                                    {
                                        System.err.println("IOException: " + ioe.getMessage());
                                    }
                                    
                                    jLabel4.setText("Hey " + usr + ", it is successfully assigned please click on test domain");
                                    System.out.println("The Appending part has loaded");
                                }
                            };
                            
                            // to this place is a failure
                            System.out.println("To check which line was skipped");
                            
                            
                            
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Dchanger.class.getName()).log(Level.SEVERE, null, ex);
                        }   catch (IOException ex) {
                            Logger.getLogger(Dchanger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        // Read the file
                        try(BufferedReader br = new BufferedReader(new FileReader(Wdir))) {
                            StringBuilder sb = new StringBuilder();
                            String line = br.readLine();
                            
                            while (line != null) {
                                sb.append(line);
                                sb.append(System.lineSeparator());
                                line = br.readLine();
                            }
                            String everything = sb.toString();
                            System.out.println(everything);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Dchanger.class.getName()).log(Level.SEVERE, null, ex);
                        }   catch (IOException ex) {
                            Logger.getLogger(Dchanger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    else{
                       
                        try {
                            try (FileWriter fw1 = new FileWriter(Wdir,true) //the true will append the new data
                                    ) {
                                String cl = val2.replace("//","");
                                fw1.write(val1 + "       " + cl + "\n");//appends the string to the file
                            } //appends the string to the file
                        }
                        catch(IOException ioe)
                        {
                            System.err.println("IOException: " + ioe.getMessage());
                        }
                        
                        // Read the file
                        try(BufferedReader br = new BufferedReader(new FileReader(Wdir))) {
                            StringBuilder sb = new StringBuilder();
                            String line = br.readLine();
                            
                            while (line != null) {                            
                                sb.append(line);
                                sb.append(System.lineSeparator());
                                line = br.readLine();
                            }
                            String everything = sb.toString();
                            System.out.println(everything);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Dchanger.class.getName()).log(Level.SEVERE, null, ex);
                        }   catch (IOException ex) {
                            Logger.getLogger(Dchanger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                    }
                } else {
                    jLabel4.setText("An IPv4 must contain at least 3 dots");
                    jLabel5.setVisible(false);
                }
                
            }
        });
        //this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ipnaming/Dtime.png")));
        
        this.setTitle(title);
        
        
        
    };
    //coming back
    //Calendar calendar = Calendar.getInstance();
    Date d = new Date(); 
    
    public String cName(){
        try{
            String computername=InetAddress.getLocalHost().getHostName();
            //System.out.println(computername);
            return computername;
            }
        catch (UnknownHostException e){
            System.out.println("Exception caught ="+e.getMessage());
            return "";
            }       
    }
    public String usrName = cName();
    public String usr = System.getProperty("user.name");
    public static String Mdir = System.getenv("USERPROFILE");
    public String Cdir = System.getProperty("user.dir");
    public String Wdir = System.getenv("windir") + "\\System32\\drivers\\etc\\hosts";
    public String Tdir = System.getProperty("user.home") + "\\Desktop\\"+"backup.dbri";
     //this was all the error i noticed dat killed my dream application
    static String val1  = "";
    static String val2 = "";
    int dot = 0;
    public String notice = greetin() + " " + usr + " Welcome to the application";
    public String title = "IpNaming" + " ( " + usr + " )"; 
    public int Df = 0;
   // int hours = calendar.get(Calendar.HOUR_OF_DAY);
    //int minutes = calendar.get(Calendar.MINUTE);
    //int seconds = calendar.get(Calendar.SECOND);
    
    public String greetin(){
        String greetinz = "";
        int DHours = d.getHours();
        if(DHours <= 12){
            greetinz = "Good Morning";
            
        }
        else if(DHours > 12 && DHours <= 16){
            greetinz = "Good Afternoon";
        }   
        else{
            greetinz = "Good Evening";
            
        }
        return greetinz;
    }
    
    /**
     *
     * @param text
     */
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIpChanger");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Fugaz One", 0, 18)); // NOI18N
        setForeground(new java.awt.Color(108, 105, 105));
        setLocation(new java.awt.Point(500, 400));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IP Address :");
        jLabel1.setToolTipText("");
        jLabel1.setAlignmentX(6.0F);
        jLabel1.setAutoscrolls(true);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setToolTipText("Enter IP Address to clone with a name");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Local Domain Address:");
        jLabel3.setToolTipText("");
        jLabel3.setAlignmentX(6.0F);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setToolTipText("Enter any Web Address of your choice to assign to the local server ip");
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domainLinker/ipv4.gif"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(notice);
        jLabel4.setName("wel"); // NOI18N

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("Assign");
        jButton1.setToolTipText("Click herre to assign name to ip");
        jButton1.setActionCommand("");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jButton2.setText("Test Local Domain");
        jButton2.setToolTipText("Test the domain with a browser ");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("OK");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("OK");

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("Help");
        jButton3.setToolTipText("Incase if you are having difficulty in operating the application");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Donate");
        jButton4.setToolTipText("Incase if you want to assist me with money, i will so appreciate");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Please incase if you like the app you can please donate by clicking this button=->>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(12, 12, 12)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2)
        );

        jLabel1.getAccessibleContext().setAccessibleName("IP Address ");

        setSize(new java.awt.Dimension(1284, 433));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dchanger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        new wel();
        //new donate().setVisible(true);
        //new notifypt();
        //jLabel5.setVisible(false);
        java.awt.EventQueue.invokeLater(new RunnableImpl());
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private static class RunnableImpl implements Runnable {
        
        public RunnableImpl() {
        }

        @Override
        public void run() {
            
            System.out.println(Mdir);
            
            new Dchanger().setVisible(true);
            
        }
    }

    
}
