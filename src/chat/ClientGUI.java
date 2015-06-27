/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Myro
 */
public class ClientGUI extends javax.swing.JFrame {

    private boolean connected;
    private Client client;
    private int defaultPort;
    private String defaultHost;
    private JFileChooser chooser;
    private File file;
    private Map<String, Integer> userList;

    public ClientGUI(String host, int port) {
        initComponents();
        defaultPort = port;
        defaultHost = host;
        userList = new HashMap<>();
    }

    void append(String text) {
        if (text.charAt(1) == ')') {
            String[] splitted = text.split("\\s+");
            cmbUserList.addItem(splitted[1]);
            cmbSendFileTo.addItem(splitted[1]);
            userList.put(splitted[1], Integer.parseInt(splitted[2]));
        }

        txtMainArea.append(text);
        txtMainArea.setCaretPosition(txtMainArea.getText().length() - 1);
    }

    void connectionFailed() {
        btnLogin.setEnabled(true);
        btnLogout.setEnabled(false);
        btnUserList.setEnabled(false);
        cmbUserList.setEnabled(false);
        cmbSendFileTo.setEnabled(false);
        btnSendFile.setEnabled(false);
        label.setText("Enter username:");
        this.setTitle("Client");
        txtPortNumber.setText("" + defaultPort);
        txtServerAddress.setText(defaultHost);
        txtServerAddress.setEditable(false);
        txtPortNumber.setEditable(false);
        connected = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblServerAddress = new javax.swing.JLabel();
        txtServerAddress = new javax.swing.JTextField();
        lblPortNumber = new javax.swing.JLabel();
        txtPortNumber = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        textField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMainArea = new javax.swing.JTextArea();
        btnLogin = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnUserList = new javax.swing.JButton();
        cmbUserList = new javax.swing.JComboBox();
        lblSendTo = new javax.swing.JLabel();
        btnSendFile = new javax.swing.JButton();
        lblSendFileTo = new javax.swing.JLabel();
        cmbSendFileTo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        lblServerAddress.setText("Server Address:");

        txtServerAddress.setText("localhost");
        txtServerAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerAddressActionPerformed(evt);
            }
        });

        lblPortNumber.setText("Port Number:");

        txtPortNumber.setText("1234");

        label.setText("Enter Username:");

        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });

        txtMainArea.setColumns(20);
        txtMainArea.setRows(5);
        jScrollPane1.setViewportView(txtMainArea);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.setEnabled(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnUserList.setText("Update User List");
        btnUserList.setEnabled(false);
        btnUserList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserListActionPerformed(evt);
            }
        });

        cmbUserList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        cmbUserList.setEnabled(false);

        lblSendTo.setText("Send to:");

        btnSendFile.setText("Send File");
        btnSendFile.setEnabled(false);
        btnSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendFileActionPerformed(evt);
            }
        });

        lblSendFileTo.setText("Send File To:");

        cmbSendFileTo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblServerAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPortNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPortNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label)
                            .addComponent(lblSendTo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textField)
                            .addComponent(cmbUserList, 0, 184, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSendFileTo)
                            .addGap(18, 18, 18)
                            .addComponent(cmbSendFileTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSendFile))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(btnLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnLogout)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnUserList))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUserList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSendTo))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServerAddress)
                    .addComponent(txtServerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPortNumber)
                    .addComponent(txtPortNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnLogout)
                    .addComponent(btnUserList))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSendFileTo)
                    .addComponent(btnSendFile)
                    .addComponent(cmbSendFileTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtServerAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServerAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServerAddressActionPerformed

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String username = textField.getText().trim();

        if (username.length() == 0) {
            return;
        }

        String server = txtServerAddress.getText().trim();
        if (server.length() == 0) {
            return;
        }

        String portNumber = txtPortNumber.getText().trim();
        if (portNumber.length() == 0) {
            return;
        }
        int port = 0;
        try {
            port = Integer.parseInt(portNumber);
        } catch (Exception en) {
            return;
        }

        client = new Client(server, port, username, this);
        client.runClient();
        textField.setText("");
        label.setText("Enter message:");
        this.setTitle("Client " + username);
        connected = true;
        btnLogin.setEnabled(false);
        btnLogout.setEnabled(true);
        btnUserList.setEnabled(true);
        txtServerAddress.setEditable(false);
        txtPortNumber.setEditable(false);
        cmbUserList.setEnabled(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, "", "", ""));
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnUserListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserListActionPerformed
        cmbSendFileTo.setEnabled(true);
        btnSendFile.setEnabled(true);
        cmbUserList.removeAllItems();
        cmbSendFileTo.removeAllItems();
        cmbUserList.addItem("All");
        client.sendMessage(new ChatMessage(ChatMessage.USER_LIST, "", "", ""));
    }//GEN-LAST:event_btnUserListActionPerformed

    private void textFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldKeyReleased
        if (connected && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, textField.getText(), cmbUserList.getSelectedItem().toString(), ""));
            textField.setText("");
        }
    }//GEN-LAST:event_textFieldKeyReleased

    private void btnSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendFileActionPerformed
        chooser = new JFileChooser("E:\\Marian\\Projects");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int choice = chooser.showOpenDialog(this);
        if (choice == JFileChooser.CANCEL_OPTION) {
            append("No file selected!\n");
            return;
        }
        if (choice == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            if (file.getTotalSpace() > Long.MAX_VALUE) {
                append("File too big!\n");
                return;
            }
            client.sendMessage(new ChatMessage(ChatMessage.FILE, "", cmbSendFileTo.getSelectedItem().toString(), chooser.getName(file)));
            try {
                client.sendFile(file, userList.get(cmbSendFileTo.getSelectedItem()));
            } catch (IOException ex) {
                Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSendFileActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI("localhost", 1234).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSendFile;
    private javax.swing.JButton btnUserList;
    private javax.swing.JComboBox cmbSendFileTo;
    private javax.swing.JComboBox cmbUserList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lblPortNumber;
    private javax.swing.JLabel lblSendFileTo;
    private javax.swing.JLabel lblSendTo;
    private javax.swing.JLabel lblServerAddress;
    private javax.swing.JTextField textField;
    private javax.swing.JTextArea txtMainArea;
    private javax.swing.JTextField txtPortNumber;
    private javax.swing.JTextField txtServerAddress;
    // End of variables declaration//GEN-END:variables
}
