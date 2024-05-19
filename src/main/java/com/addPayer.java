/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com;

import classe.Payer;
import classe.Personne;
import classe.bd;
import classe.payerBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Mickele
 */
public class addPayer extends javax.swing.JFrame {

    /**
     * Creates new form addPayer
     */
    private javax.swing.JComboBox<String> ImPayer;
    private com.toedter.calendar.JDateChooser datePayer;
    public addPayer() {
        initComponents();
        datePayer = new com.toedter.calendar.JDateChooser();
        ImPayer = new javax.swing.JComboBox<String>();
        IM_payer.add(ImPayer);
        dateDePayement.add(datePayer);
        chargerIM();
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
        jLabel6 = new javax.swing.JLabel();
        IM_payer = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        dateDePayement = new com.toedter.calendar.JDateChooser();
        AjouterPayement = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("IM :");

        IM_payer.setMaximumRowCount(10);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Date :");

        AjouterPayement.setText("Ajouter");
        AjouterPayement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterPayementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AjouterPayement, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IM_payer, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateDePayement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(IM_payer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(dateDePayement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(AjouterPayement)
                .addGap(0, 41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjouterPayementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterPayementActionPerformed
    String button = AjouterPayement.getText();
    if(button.equals("Ajouter")) {
        String im = (String) IM_payer.getSelectedItem();
        Date date = dateDePayement.getDate();
        
        // Récupération du diplôme de la personne sélectionnée
        String diplome = null;
        Connection connection = null;
        try {
            // Récupération du diplôme
            connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
            String sql = "SELECT Diplome FROM PERSONNE WHERE IM = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, im);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                diplome = resultSet.getString("Diplome");
            } else {
                // Gérer le cas où aucun diplôme n'est trouvé
                JOptionPane.showMessageDialog(null, "Aucun diplôme trouvé pour cet IM.");
                return;
            }
            // Récupération du numéro de tarif en fonction du diplôme de la personne
            String numTarif = null;
            sql = "SELECT Num_tarif FROM TARIF WHERE Diplome = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, diplome);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                numTarif = resultSet.getString("Num_tarif");
            } else {
                // Gérer le cas où aucun numéro de tarif n'est trouvé
                JOptionPane.showMessageDialog(null, "Aucun numéro de tarif trouvé pour ce diplôme.");
                return;
            }

            // Insertion du paiement dans la base de données
            Payer nouveauPaiement = new Payer(im, numTarif, date);
            boolean insertionReussie = payerBD.ajouterPayement(nouveauPaiement, connection);

            // Vérification si l'ajout a réussi
            if (insertionReussie) {
                // Affichage d'un message de succès
                JOptionPane.showMessageDialog(null, "Le paiement a été ajouté avec succès !");
                dispose();
            } else {
                // Affichage d'un message d'erreur
                JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du paiement !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception SQL
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération du diplôme ou du numéro de tarif.");
        } finally {
            // Fermeture de la connexion
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur lors de la récupération du diplôme ou du numéro de tarif.");
                }
            }
        }
    }
    else if(button.equals("Modifier")){
        String im = (String) IM_payer.getSelectedItem();
        Date date = dateDePayement.getDate();

        // Récupération du diplôme de la personne sélectionnée
        String diplome = null;
        Connection connection = null;
        try {
            // Récupération du diplôme
            connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
            String sql = "SELECT Diplome FROM PERSONNE WHERE IM = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, im);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                diplome = resultSet.getString("Diplome");
            } else {
                // Gérer le cas où aucun diplôme n'est trouvé
                JOptionPane.showMessageDialog(null, "Aucun diplôme trouvé pour cet IM.");
                return;
            }

            // Récupération du numéro de tarif en fonction du diplôme de la personne
            String numTarif = null;
            sql = "SELECT Num_tarif FROM TARIF WHERE Diplome = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, diplome);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                numTarif = resultSet.getString("Num_tarif");
            } else {
                // Gérer le cas où aucun numéro de tarif n'est trouvé
                JOptionPane.showMessageDialog(null, "Aucun numéro de tarif trouvé pour ce diplôme.");
                return;
            }

            // Insertion du paiement dans la base de données
            Payer nouveauPaiement = new Payer(im, numTarif, date);
            boolean insertionReussie = payerBD.modifierPayement(nouveauPaiement, connection);

            // Vérification si l'ajout a réussi
            if (insertionReussie) {
                // Affichage d'un message de succès
                JOptionPane.showMessageDialog(null, "Le paiement a été modifier avec succès !");
                dispose();
            } else {
                // Affichage d'un message d'erreur
                JOptionPane.showMessageDialog(null, "Erreur lors de la modification du paiement !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception SQL
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération du diplôme ou du numéro de tarif.");
        } finally {
            // Fermeture de la connexion
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur lors de la récupération du diplôme ou du numéro de tarif.");
                }
            }
        }
    }
    

    }//GEN-LAST:event_AjouterPayementActionPerformed
    public void remplirChampsPayer(String IM, String numTarif, Date date) {
        IM_payer.setSelectedItem(IM);
        dateDePayement.setDate(date);
        AjouterPayement.setText("Modifier");   
    }
    
    public void chargerIM() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
        // Connexion à la base de données
        connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");

        // Requête pour récupérer tous les diplômes de la table "tarif"
        String query = "SELECT DISTINCT IM FROM personne";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        IM_payer.removeAllItems();

        while (resultSet.next()) {
            String IM = resultSet.getString("IM");
            IM_payer.addItem(IM);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Fermer les ressources
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
    
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
            java.util.logging.Logger.getLogger(addPayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addPayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addPayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addPayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addPayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjouterPayement;
    private javax.swing.JComboBox<String> IM_payer;
    private com.toedter.calendar.JDateChooser dateDePayement;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}