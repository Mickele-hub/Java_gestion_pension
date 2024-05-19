/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com;

import classe.Personne;
import classe.Tarif;
import classe.bd;
import classe.tarifBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Mickele
 */
public class addTarifs extends javax.swing.JFrame {

    /**
     * Creates new form addTarifs
     */
    private javax.swing.JTextField numtarif;
    private javax.swing.JTextField diplomeTarif;
    private javax.swing.JTextField categoritarif;
    private javax.swing.JSpinner mont;

    public addTarifs() {
        initComponents();
        numtarif = new javax.swing.JTextField();
        diplomeTarif = new javax.swing.JTextField();
        categoritarif = new javax.swing.JTextField();
        mont = new javax.swing.JSpinner();
        num_tarif.add(numtarif);
        diplome_tarif.add(diplomeTarif);
        categorie.add(categoritarif);
        montant_tarif.add(mont);
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
        jLabel1 = new javax.swing.JLabel();
        num_tarif = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        diplome_tarif = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        categorie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        montant_tarif = new javax.swing.JSpinner();
        AjouterTarif = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(717, 298));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Numero :");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Diplome :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Catégorie:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Montant :");

        AjouterTarif.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AjouterTarif.setText("Ajouter");
        AjouterTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterTarifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categorie, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diplome_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(montant_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(AjouterTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(num_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(diplome_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(categorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(montant_tarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(AjouterTarif)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjouterTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterTarifActionPerformed
        String button = AjouterTarif.getText();
        if (button.equals("Ajouter")) {
            String numTarif = num_tarif.getText();
            String diplome = diplome_tarif.getText();
            String categor = categorie.getText();

            // Récupération de la valeur actuelle du JSpinner
            int montant = (int) montant_tarif.getValue();

            // Création d'un objet Tarif avec les données saisies
            Tarif nouveauTarif = new Tarif(numTarif, diplome, categor, montant);

            // Obtention de la connexion à la base de données
            Connection connection = tarifBD.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");

            // Exécution de la requête d'ajout
            boolean insertionReussie = tarifBD.ajouterTarif(nouveauTarif, connection);

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Vérification si l'ajout a réussi
            if (insertionReussie) {
                // Affichage d'un message de succès
                JOptionPane.showMessageDialog(null, "Le tarif a été ajouté avec succès !");
                dispose();
            } else {
                // Affichage d'un message d'erreur
                JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du tarif !");
            }
        } else if (button.equals("Modifier")) {
            String numTarif = num_tarif.getText();
            String diplome = diplome_tarif.getText();
            String categor = categorie.getText();

            // Récupération de la valeur actuelle du JSpinner
            int montant = (int) montant_tarif.getValue();
            Tarif nouveauTarif = new Tarif(numTarif, diplome, categor, montant);
            Connection connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
            boolean modificationReussie = tarifBD.modifierTarif(nouveauTarif, connection);
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Vérification si la modification a réussi
            if (modificationReussie) {
                // Affichage d'un message de succès
                JOptionPane.showMessageDialog(null, "Le tarif a été modifiée avec succès !");
                dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Aucun tarif !");
        
        }
    }//GEN-LAST:event_AjouterTarifActionPerformed

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
            java.util.logging.Logger.getLogger(addTarifs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addTarifs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addTarifs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addTarifs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addTarifs().setVisible(true);
            }
        });
    }
public void remplirChampsTarif(String numTarif, String diplome, String catego, int montant) {
        num_tarif.setText(numTarif);
        diplome_tarif.setText(diplome);
        categorie.setText(catego);
        montant_tarif.setValue(montant);
        AjouterTarif.setText("Modifier");
        num_tarif.setEditable(false);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjouterTarif;
    private javax.swing.JTextField categorie;
    private javax.swing.JTextField diplome_tarif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner montant_tarif;
    private javax.swing.JTextField num_tarif;
    // End of variables declaration//GEN-END:variables
}
