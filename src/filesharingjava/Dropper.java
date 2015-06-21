/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesharingjava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import static java.sql.JDBCType.NULL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPSClient;

public class Dropper extends javax.swing.JFrame {

    //private javax.swing.JTextArea jTextArea;
    /**
     * Creates new form Dropper
     */
    public Dropper(String title) {
        super(title);
        
         //Add drag and drop pane
      	JComponent cp = (JComponent)getContentPane();
      	cp.setBorder(BorderFactory.createTitledBorder("hello"));
      	cp.setTransferHandler(new MyFileTransferHandler()); // see below
      	cp.setBounds(30, 20, 60, 61);
        cp.setVisible(true);
        initComponents();
         FTPSClient ftpClient = new FTPSClient(false);
   try{
         ftpClient.connect("ftp.webdomain_url.com", 21);
   boolean login = ftpClient.login("username@webdomain_url.com", "password");  
            System.out.println("value of login" + login);
   if (login) {  
            System.out.println("Connection established...");  
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setAutodetectUTF8(true);

            String s = null;
            DefaultListModel model = new DefaultListModel();
            FTPFile[]  ftpFiles = ftpClient.listFiles("/filesharing/upload_pics/"); //Directory where all pics are uploaded
            for (FTPFile ftpFile : ftpFiles) 
                 {
                      s = ftpFile.getName();
                     model.addElement(s);
                 }
                jList1.setModel(model);
            }
        }
   catch(Exception e){
            }
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        label1 = new java.awt.Label();
        view = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jList1.setFont(new java.awt.Font("Century", 3, 14)); // NOI18N
        jScrollPane1.setViewportView(jList1);
        jList1.getAccessibleContext().setAccessibleName("list");

        jButton1.setText("Download");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);
        textArea.getAccessibleContext().setAccessibleParent(textArea);

        label1.setText("Drop Your File here!!!!");

        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(view)
                        .addGap(55, 55, 55)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        label1.getAccessibleContext().setAccessibleName("Drop File here!!!!");
        label1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       String sd = "";
        FTPSClient ftpClient = new FTPSClient(false);
  try {  
   
            // Connect to host
            ftpClient.connect("ftp.webdomain_url.com", 21);
         boolean login = ftpClient.login("username@webdomain_url.com", "password");    

         if (login) {  
                        System.out.println("Connection established...");  
                        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                        ftpClient.enterLocalPassiveMode();
                        ftpClient.setAutodetectUTF8(true);

                        List s = jList1.getSelectedValuesList();

                        String strarray;
                        strarray = s.toString();

                        int l = strarray.length();

                        sd = strarray.substring(1, l-1);


                        //Create an InputStream to the File Data and use FileOutputStream to write it
                        InputStream inputStream = ftpClient.retrieveFileStream("/filesharing/upload_pics/" + sd);

                        FileOutputStream fileOutputStream = new FileOutputStream("E:"+ sd);

                        //Using org.apache.commons.io.IOUtils
                        IOUtils.copy(inputStream, fileOutputStream);
                        fileOutputStream.flush();
                        //IOUtils.closeQuietly(fileOutputStream);
                        //IOUtils.closeQuietly(inputStream);
                        boolean commandOK = ftpClient.completePendingCommand();
                        fileOutputStream.close();
                        inputStream.close();
                        ftpClient.disconnect();
               }
   else {  
     JOptionPane.showMessageDialog(this, "Connection Failed !!!");
    }  
   
  } catch (SocketException e) {  
   JOptionPane.showMessageDialog(this, "Invalid filename!! Please re-enter filename");
  } catch (IOException e) {  
   JOptionPane.showMessageDialog(this, "Invalid filename!! Please re-enter filename");
  } finally {  
   try {  
    ftpClient.disconnect();  
   } catch (IOException e) {  
    JOptionPane.showMessageDialog(this, "Invalid filename!! Please re-enter filename");
            }
  }
  
            JOptionPane.showMessageDialog(this, "You have successfully downloaded " + "'" + sd + "'" + " ! Please check in Downloads");
 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
         List s = jList1.getSelectedValuesList();
            
          String strarray;
          strarray = s.toString();
       
        int l = strarray.length();
       
        String sd = strarray.substring(1, l-1);
         String url = "http://Url_path_to_upload/filesharing/upload_pics/" + sd;
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            //Logger.getLogger(Logon.class.getName()).log(Level.SEVERE, null, ex);
      }
 
    }//GEN-LAST:event_viewActionPerformed

    
   
    public static void fttp()
    {
       FTPSClient ftpClient = new FTPSClient(false);
       try{
            ftpClient.connect("ftp.webdomain_url.com", 21);
            boolean login = ftpClient.login("username@webdomain_url.com", "password");    

            System.out.println("value of login" + login);
        if (login) {  
                  System.out.println("Connection established...");  
                  ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                  ftpClient.enterLocalPassiveMode();
                  ftpClient.setAutodetectUTF8(true);

                  String s = null;
                  DefaultListModel model = new DefaultListModel();
                  FTPFile[]  ftpFiles = ftpClient.listFiles("/filesharing/upload_pics/");
                  for (FTPFile ftpFile : ftpFiles) {
                           s = ftpFile.getName();
                          model.addElement(s);
                     }
                   jList1.setModel(model);
             }
        }
   catch(Exception e){
  }
 }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    public static javax.swing.JTextArea textArea;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}