/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import files.*;
import basics.*;
import tests.*;
import db.*;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;





/**
 *
 * @author it21735/it21754/it217130
 */
public class Scenario2 extends javax.swing.JFrame {  
    //through this class the project is looking in the database to find if any objects match the given query. 
    //If any objects match the given query, then they will be shown in the texta area 
    //If there is not any objects, that match the given query, then the user will be asked if he wants to search in the api.

    Database db = new Database();
    Scenario1 sc = new Scenario1();
    APIWrapper api = new APIWrapper();
    Scenario1 sc1 = new Scenario1();

    DefaultListModel dataModel;
    DefaultListModel Arraydata;

    ArrayList <Artist> Artistdatafromdb;
    ArrayList<Release> Releasedatafromdb;

    String userinput = null;
    Component myFrame = null;
    int number_of_elements = 0;

    //Artist's fields
    String string;
    String name = null;
    String type = null;
    String gender = null;
    String country = null;

    //Release's field
    String title = null;
    String status = null;  //official or unofficial 
    String releaseDate = null;
    String format = null;
    //+country 

    /**
     * Creates new form Scenario2
     */
    public Scenario2() {
        this.dataModel = new DefaultListModel();
        this.Arraydata = new DefaultListModel();
        initComponents();
        this.setDefaultCloseOperation(Scenario2.DISPOSE_ON_CLOSE);  //DISPOSE  HIDE JFrame  WindowConstants
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ClearButton = new javax.swing.JButton();
        SearchText = new javax.swing.JTextField();
        ArtistNameCheckBox = new javax.swing.JCheckBox();
        GroupNameCheckBox = new javax.swing.JCheckBox();
        CountryCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DoesTheDBreturnObjectsTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        ReleaseCheckBox = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListWhereObjectsFromDBShowUp = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        NumberOfObjectsThatTheDBReturns = new javax.swing.JTextArea();
        HowManyObjectsDidTheDBReturnjLabel = new javax.swing.JLabel();
        GoBackToTheMenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1619, 700));

        ClearButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ClearButton.setForeground(new java.awt.Color(0, 0, 153));
        ClearButton.setText("Clear Options and Results");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        ArtistNameCheckBox.setForeground(new java.awt.Color(0, 0, 51));
        ArtistNameCheckBox.setText("Solo Artist Name");
        ArtistNameCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtistNameCheckBoxActionPerformed(evt);
            }
        });

        GroupNameCheckBox.setForeground(new java.awt.Color(0, 0, 51));
        GroupNameCheckBox.setText("Group name");
        GroupNameCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupNameCheckBoxActionPerformed(evt);
            }
        });

        CountryCheckBox.setForeground(new java.awt.Color(0, 0, 51));
        CountryCheckBox.setText("Country");
        CountryCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountryCheckBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Short Description");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Choose what you wanna search for");

        SubmitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SubmitButton.setForeground(new java.awt.Color(0, 0, 153));
        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Did the database return something?");

        DoesTheDBreturnObjectsTextArea.setColumns(20);
        DoesTheDBreturnObjectsTextArea.setRows(5);
        jScrollPane1.setViewportView(DoesTheDBreturnObjectsTextArea);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("These are the objects/information that were found in the database");

        ReleaseCheckBox.setForeground(new java.awt.Color(0, 0, 51));
        ReleaseCheckBox.setText("Release");
        ReleaseCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReleaseCheckBoxActionPerformed(evt);
            }
        });

        jListWhereObjectsFromDBShowUp.setModel(Arraydata);
        jScrollPane4.setViewportView(jListWhereObjectsFromDBShowUp);

        NumberOfObjectsThatTheDBReturns.setColumns(20);
        NumberOfObjectsThatTheDBReturns.setRows(5);
        jScrollPane2.setViewportView(NumberOfObjectsThatTheDBReturns);

        HowManyObjectsDidTheDBReturnjLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HowManyObjectsDidTheDBReturnjLabel.setForeground(new java.awt.Color(0, 0, 102));
        HowManyObjectsDidTheDBReturnjLabel.setText("How many objects did the database return ?");

        GoBackToTheMenuButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        GoBackToTheMenuButton.setForeground(new java.awt.Color(0, 0, 153));
        GoBackToTheMenuButton.setText("Go Back to the Menu!");
        GoBackToTheMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackToTheMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SearchText)
                        .addGap(247, 247, 247))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ArtistNameCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(GroupNameCheckBox)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CountryCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(ReleaseCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane4))
                        .addContainerGap(806, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(HowManyObjectsDidTheDBReturnjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(1166, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ClearButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubmitButton)
                    .addComponent(GoBackToTheMenuButton))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchText, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(SubmitButton))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ArtistNameCheckBox)
                    .addComponent(GroupNameCheckBox)
                    .addComponent(CountryCheckBox)
                    .addComponent(ReleaseCheckBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(HowManyObjectsDidTheDBReturnjLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GoBackToTheMenuButton)
                    .addComponent(ClearButton))
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        SearchText.setText("");

        //Deselecting the checkbox, that has been selected 
        ArtistNameCheckBox.setSelected(false);
        CountryCheckBox.setSelected(false);
        GroupNameCheckBox.setSelected(false);
        ReleaseCheckBox.setSelected(false);

        DoesTheDBreturnObjectsTextArea.setText("");
        NumberOfObjectsThatTheDBReturns.setText("");

        try {
            Artistdatafromdb.clear();
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("null pointer exception");
        }

        try {
            Releasedatafromdb.clear();
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("null pointer exception");
        }
        
        if (Arraydata.isEmpty()) {     //if the arraydata is empty
            Arraydata.addElement(" No elements were found");
            jListWhereObjectsFromDBShowUp.setModel(Arraydata);
            jListWhereObjectsFromDBShowUp.setVisible(true);

            Arraydata = (DefaultListModel) jListWhereObjectsFromDBShowUp.getModel();
            Arraydata.removeAllElements();
        } else {
            Arraydata = (DefaultListModel) jListWhereObjectsFromDBShowUp.getModel();
            Arraydata.removeAllElements();
        }
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        //The actionPerformed() method is invoked automatically whenever you click on the registered component.
        userinput = SearchText.getText();      //in the variable userinput is being saved what the user has typed every time  

        if (userinput == null)
            JOptionPane.showMessageDialog(myFrame, "Sorry!\n\nNo matches were found!");   //showing pop frame to the user
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void ArtistNameCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistNameCheckBoxActionPerformed
      SearchArtistIntoDatabase( db.executeQuerySearchBasedOnArtistName(userinput) ); 
    }//GEN-LAST:event_ArtistNameCheckBoxActionPerformed

    private void GroupNameCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupNameCheckBoxActionPerformed
      SearchArtistIntoDatabase( db.executeQuerySearchBasedOnGroupName(userinput) );   
    }//GEN-LAST:event_GroupNameCheckBoxActionPerformed

    private void CountryCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountryCheckBoxActionPerformed
        try {   
            SearchArtistIntoDatabase(  db.executeQuerySearchBasedOnCountry(userinput) );
        } catch (SQLException ex) {
            Logger.getLogger(Scenario2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CountryCheckBoxActionPerformed

    private void ReleaseCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReleaseCheckBoxActionPerformed
        //showing pop frame to the user
        JOptionPane.showMessageDialog(myFrame, "Your search has been submitted!\n\nWe are waiting for the results!");

        Releasedatafromdb = db.executeQuerySearchBasedOnReleaseTitle(userinput);   //givensearchword
        if (Releasedatafromdb.isEmpty()) {   //if the arraylist is empty, it means that the api did not return any objects aka results 
            DoesTheDBreturnObjectsTextArea.setText("Sorry!\nNo matches were found!");
            DoesTheDBreturnObjectsTextArea.setVisible(true);

            this.dispose();  //DISPOSE  JFrame 
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Scenario1().setVisible(true);
                }
            });

        } else { //if the the arraylist is not empty, which means that objects were saved into the arraylist

            DoesTheDBreturnObjectsTextArea.setText("YES!\nResults were found!");
            DoesTheDBreturnObjectsTextArea.setVisible(true);

            saveReleaseIntoArraydata(db.executeQuerySearchBasedOnReleaseTitle(userinput));

            jListWhereObjectsFromDBShowUp.setModel(Arraydata); //adding the arraylist to the jlist, in order the objects -saved into the arraylist- to be displayed          
            jListWhereObjectsFromDBShowUp.setVisible(true);

            number_of_elements = 0;
            number_of_elements = Arraydata.size();

            NumberOfObjectsThatTheDBReturns.setText(Integer.toString(Arraydata.size())); //show the number of the objects
        }
    }//GEN-LAST:event_ReleaseCheckBoxActionPerformed

    private void GoBackToTheMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackToTheMenuButtonActionPerformed
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_GoBackToTheMenuButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Scenario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scenario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scenario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scenario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scenario2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ArtistNameCheckBox;
    private javax.swing.JButton ClearButton;
    private javax.swing.JCheckBox CountryCheckBox;
    private javax.swing.JTextArea DoesTheDBreturnObjectsTextArea;
    private javax.swing.JButton GoBackToTheMenuButton;
    private javax.swing.JCheckBox GroupNameCheckBox;
    private javax.swing.JLabel HowManyObjectsDidTheDBReturnjLabel;
    private javax.swing.JTextArea NumberOfObjectsThatTheDBReturns;
    private javax.swing.JCheckBox ReleaseCheckBox;
    private javax.swing.JTextField SearchText;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListWhereObjectsFromDBShowUp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

    protected void SearchArtistIntoDatabase(ArrayList<Artist> datafromdb) { //the method search every time into the databse based on the search query that the user gives and the artist objects , that are being returned every time, will show up 
        Artistdatafromdb = datafromdb;
        //showing pop frame to the user
        JOptionPane.showMessageDialog(myFrame, "Your search has been submitted!\n\nWe are waiting for the results!");

        // Artistdatafromdb = db.executeQuerySearch....(userinput);   //userinput = the searchword that the user gives every time
        if (Artistdatafromdb.isEmpty()) {   //if the arraylist is empty, it means that the api did not return any objects aka results 
            DoesTheDBreturnObjectsTextArea.setText("Sorry!\nNo matches were found!");
            DoesTheDBreturnObjectsTextArea.setVisible(true);

            this.dispose();  //DISPOSE  JFrame 
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Scenario1().setVisible(true);
                }
            });

        } else { //if the the arraylist is not empty, which means that objects were saved into the arraylist

            DoesTheDBreturnObjectsTextArea.setText("YES!\nResults were found!");
            DoesTheDBreturnObjectsTextArea.setVisible(true);

            saveArtistIntoArraydata(Artistdatafromdb); //Artistdatafromdb=db.executeQuerySearch ...;  method called from the database package 

            jListWhereObjectsFromDBShowUp.setModel(Arraydata); //adding the arraylist to the jlist, in order the objects -saved into the arraylist- to be displayed          
            jListWhereObjectsFromDBShowUp.setVisible(true);

            number_of_elements = 0;
            number_of_elements = Arraydata.size();

            NumberOfObjectsThatTheDBReturns.setText(Integer.toString(Arraydata.size())); //show the number of the objects
        }
    }

    protected void saveArtistIntoArraydata(ArrayList<Artist> datafromdb) {
        for (int i = 0; i < datafromdb.size(); i++) {
            name = (String) datafromdb.get(i).getName();
            type = (String) datafromdb.get(i).getType();
            gender = (String) datafromdb.get(i).getGender();
            country = (String) datafromdb.get(i).getCountry();

            Arraydata.addElement(name);
            Arraydata.addElement(type);
            Arraydata.addElement(gender);
            Arraydata.addElement(country);
            Arraydata.addElement("\n");
        }
    }

    protected void saveReleaseIntoArraydata(ArrayList<Release> datafromdb) {
        for (int i = 0; i < datafromdb.size(); i++) {
            title = (String) datafromdb.get(i).getTitle();
            status = (String) datafromdb.get(i).getStatus();
            releaseDate = (String) datafromdb.get(i).getReleaseDate();
            format = (String) datafromdb.get(i).getFormat();
            country = (String) datafromdb.get(i).getCountry();

            Arraydata.addElement(title);
            Arraydata.addElement(status);
            Arraydata.addElement(releaseDate);
            Arraydata.addElement(format);
            Arraydata.addElement(country);
            Arraydata.addElement("\n");
        }
    }

}
