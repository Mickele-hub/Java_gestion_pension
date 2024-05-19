package com;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import classe.bd;
import static classe.bd.getConnection;
import classe.payerBD;
import classe.tarifBD;
import java.awt.CardLayout;
import java.awt.Component;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicButtonUI;
import com.addPersons;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



public class hello extends javax.swing.JFrame {
        private DefaultTableModel tableModel;
        private DefaultTableModel tarifModel;
        private DefaultTableModel payerModel;
        CardLayout cardlayout;
        private addPersons addPersonsWindow;
        private addTarifs addTarifWindow;
        private addPayer addPayerWindow;
        private detailsPayer detail;
        private histo histogram;
        public hello() {
            initComponents();
            tableModel = (DefaultTableModel) personne.getModel();
            tarifModel = (DefaultTableModel) tarif.getModel();
            payerModel = (DefaultTableModel) payer.getModel(); 
            addPersonsWindow = new addPersons();
            addTarifWindow = new addTarifs();
            addPayerWindow = new addPayer();
            detail = new detailsPayer();
            histogram = new histo();
            Connection connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
            afficherDonneesPersonne();
            afficherDonneesTarif();
            afficherDonneesPayer();
            Component [] components = this.getContentPane().getComponents();
            for(Component component : components){
                if(component instanceof JButton){
                    ((JButton) component).setUI(new BasicButtonUI());
                    ((JButton) component).setFocusPainted(false);
                }
            }
            cardlayout = (CardLayout)(panelCard.getLayout());
            like.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                likeActionPerformed(evt);
            }
        });
        }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        panelCard = new javax.swing.JPanel();
        panelPayer = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        payer = new javax.swing.JTable();
        payementAjout = new javax.swing.JButton();
        deletePayer = new javax.swing.JButton();
        modifierPayement = new javax.swing.JButton();
        detail_payer = new javax.swing.JButton();
        histoire = new javax.swing.JButton();
        date1 = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        dateSearch = new javax.swing.JButton();
        actualisé = new javax.swing.JButton();
        panelHisto = new javax.swing.JPanel();
        panelTarif = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tarif = new javax.swing.JTable();
        addTarif = new javax.swing.JButton();
        deleteTarif = new javax.swing.JButton();
        modifierTarif = new javax.swing.JButton();
        panelAcceuil = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personne = new javax.swing.JTable();
        addPerson = new javax.swing.JButton();
        supprimerPersons = new javax.swing.JButton();
        modifierPersons = new javax.swing.JButton();
        recherche = new javax.swing.JTextField();
        like = new javax.swing.JButton();
        statusVivant = new javax.swing.JButton();
        mort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setName("Nav"); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ACCUEILLE");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("PAYEMENT");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("TARIF");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        jButton1.getAccessibleContext().setAccessibleName("");
        jButton1.getAccessibleContext().setAccessibleDescription("");
        jButton2.getAccessibleContext().setAccessibleName("");
        jButton2.getAccessibleContext().setAccessibleDescription("");

        jSplitPane1.setLeftComponent(jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("Nav");
        jPanel1.getAccessibleContext().setAccessibleDescription("Nav");

        panelCard.setLayout(new java.awt.CardLayout());

        panelPayer.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestion des pensions des retraités");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        payer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "IM", "Numero tarif", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(payer);
        if (payer.getColumnModel().getColumnCount() > 0) {
            payer.getColumnModel().getColumn(0).setResizable(false);
            payer.getColumnModel().getColumn(1).setResizable(false);
            payer.getColumnModel().getColumn(2).setResizable(false);
        }

        payementAjout.setText("Ajouter");
        payementAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payementAjoutActionPerformed(evt);
            }
        });

        deletePayer.setText("Supprimer");
        deletePayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePayerActionPerformed(evt);
            }
        });

        modifierPayement.setText("Modifier");
        modifierPayement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierPayementActionPerformed(evt);
            }
        });

        detail_payer.setText("Details");
        detail_payer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detail_payerActionPerformed(evt);
            }
        });

        histoire.setText("Histogramme");
        histoire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histoireActionPerformed(evt);
            }
        });

        dateSearch.setText("Rechercher");
        dateSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateSearchActionPerformed(evt);
            }
        });

        actualisé.setText("Actualisé");
        actualisé.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualiséActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPayerLayout = new javax.swing.GroupLayout(panelPayer);
        panelPayer.setLayout(panelPayerLayout);
        panelPayerLayout.setHorizontalGroup(
            panelPayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(panelPayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPayerLayout.createSequentialGroup()
                        .addComponent(histoire, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detail_payer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(modifierPayement, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(deletePayer, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(payementAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(panelPayerLayout.createSequentialGroup()
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(dateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(actualisé, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelPayerLayout.setVerticalGroup(
            panelPayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPayerLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelPayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateSearch)
                        .addComponent(actualisé)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(panelPayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payementAjout)
                    .addComponent(deletePayer)
                    .addComponent(modifierPayement)
                    .addComponent(detail_payer)
                    .addComponent(histoire))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelCard.add(panelPayer, "panelPayer");

        panelHisto.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout panelHistoLayout = new javax.swing.GroupLayout(panelHisto);
        panelHisto.setLayout(panelHistoLayout);
        panelHistoLayout.setHorizontalGroup(
            panelHistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        panelHistoLayout.setVerticalGroup(
            panelHistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        panelCard.add(panelHisto, "panelHisto");

        panelTarif.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gestion des pensions des retraités");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 587, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        tarif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero tarif", "Diplome", "Catégorie", "Montant"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tarif);

        addTarif.setText("Ajouter");
        addTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTarifActionPerformed(evt);
            }
        });

        deleteTarif.setText("Supprimer");
        deleteTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTarifActionPerformed(evt);
            }
        });

        modifierTarif.setText("Modifier");
        modifierTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierTarifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTarifLayout = new javax.swing.GroupLayout(panelTarif);
        panelTarif.setLayout(panelTarifLayout);
        panelTarifLayout.setHorizontalGroup(
            panelTarifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTarifLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTarifLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modifierTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(deleteTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(addTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        panelTarifLayout.setVerticalGroup(
            panelTarifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTarifLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(panelTarifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTarif)
                    .addComponent(deleteTarif)
                    .addComponent(modifierTarif))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        panelCard.add(panelTarif, "panelTarif");

        panelAcceuil.setBackground(java.awt.Color.white);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gestion des pensions des retraités");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        personne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IM", "Nom", "Prenom", "Date", "Diplome", "Contact", "Statut", "Situation", "Nom conjoint", "Prenom conjoint"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(personne);
        if (personne.getColumnModel().getColumnCount() > 0) {
            personne.getColumnModel().getColumn(2).setHeaderValue("Prenom");
            personne.getColumnModel().getColumn(3).setHeaderValue("Date");
            personne.getColumnModel().getColumn(4).setHeaderValue("Diplome");
            personne.getColumnModel().getColumn(5).setHeaderValue("Contact");
            personne.getColumnModel().getColumn(6).setHeaderValue("Statut");
            personne.getColumnModel().getColumn(7).setHeaderValue("Situation");
            personne.getColumnModel().getColumn(8).setHeaderValue("Nom conjoint");
            personne.getColumnModel().getColumn(9).setHeaderValue("Prenom conjoint");
        }

        addPerson.setLabel("Ajouter");
        addPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonActionPerformed(evt);
            }
        });

        supprimerPersons.setText("Supprimer");
        supprimerPersons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerPersonsActionPerformed(evt);
            }
        });

        modifierPersons.setText("Modifier");
        modifierPersons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierPersonsActionPerformed(evt);
            }
        });

        like.setText("Rechercer");
        like.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeActionPerformed(evt);
            }
        });

        statusVivant.setText("Vivant");
        statusVivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusVivantActionPerformed(evt);
            }
        });

        mort.setText("Décedé");
        mort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAcceuilLayout = new javax.swing.GroupLayout(panelAcceuil);
        panelAcceuil.setLayout(panelAcceuilLayout);
        panelAcceuilLayout.setHorizontalGroup(
            panelAcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelAcceuilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAcceuilLayout.createSequentialGroup()
                        .addComponent(statusVivant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modifierPersons, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(supprimerPersons, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(addPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAcceuilLayout.createSequentialGroup()
                        .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(like)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAcceuilLayout.setVerticalGroup(
            panelAcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAcceuilLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(like))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(panelAcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPerson)
                    .addComponent(supprimerPersons)
                    .addComponent(modifierPersons)
                    .addComponent(mort)
                    .addComponent(statusVivant))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        addPerson.getAccessibleContext().setAccessibleName("addPerson");

        panelCard.add(panelAcceuil, "panelAcceuil");

        jSplitPane1.setRightComponent(panelCard);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cardlayout.show(panelCard,"panelAcceuil");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cardlayout.show(panelCard,"panelPayer");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonActionPerformed
        addPersons frame = new addPersons();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            // Appel de la fonction afficherDonnesPersonne lorsque la fenêtre est fermée
            afficherDonneesPersonne();
        }
        });
    }//GEN-LAST:event_addPersonActionPerformed

    private void supprimerPersonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerPersonsActionPerformed
           int selectedRow = personne.getSelectedRow();
            if (selectedRow != -1) { // Vérifier si une ligne est sélectionnée
                String IM = (String) tableModel.getValueAt(selectedRow, 0); // Récupérer l'IM de la personne sélectionnée

                // Boîte de dialogue pour confirmer la suppression
                int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cette personne ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) { // Si l'utilisateur confirme la suppression
                    Connection connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");

                    // Appeler la fonction de suppression
                    boolean suppressionReussie = bd.supprimerPersonne(IM, connection);

                    if (suppressionReussie) {
                        // Rafraîchir les données affichées dans le JTable
                        afficherDonneesPersonne();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une personne à supprimer.", "Aucune personne sélectionnée", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_supprimerPersonsActionPerformed

    private void modifierPersonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierPersonsActionPerformed
        int selectedRow = personne.getSelectedRow();
        if (selectedRow != -1) { // Vérifiez si une ligne est sélectionnée
            // Récupérer les données de la personne sélectionnée
            String IM = (String) tableModel.getValueAt(selectedRow, 0);
            String nom = (String) tableModel.getValueAt(selectedRow, 1);
            String prenom = (String) tableModel.getValueAt(selectedRow, 2);
            String dateString = (String) tableModel.getValueAt(selectedRow, 3);
            Date date = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Le format de votre date
                date = dateFormat.parse(dateString);
            } catch (ParseException ex) {
                ex.printStackTrace(); // Ou toute autre gestion appropriée des erreurs de conversion
            }
            String diplome = (String) tableModel.getValueAt(selectedRow, 4);
            String contact = (String) tableModel.getValueAt(selectedRow, 5);
            Boolean statut = null;
            String statutStr = (String) tableModel.getValueAt(selectedRow, 6);
                if (statutStr.equalsIgnoreCase("Vivant")) {
                    statut = true;
                } else if (statutStr.equalsIgnoreCase("Décédé")) {
                    statut = false;
                }

            String situation = (String) tableModel.getValueAt(selectedRow, 7);
            String nomConjoint = (String) tableModel.getValueAt(selectedRow, 8);
            String prenomConjoint = (String) tableModel.getValueAt(selectedRow, 9); 
            
            addPersonsWindow.remplirChamps(IM, nom, prenom,date,diplome,contact,statut,situation,nomConjoint,prenomConjoint);
            addPersonsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addPersonsWindow.setLocationRelativeTo(null);
            addPersonsWindow.setVisible(true);
        
        // Ajouter un WindowListener pour rafraîchir les données après la fermeture de la fenêtre
            addPersonsWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Rafraîchir les données affichées dans le JTable
                afficherDonneesPersonne();
            }
        });
    } else {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner une personne à modifier.", "Aucune personne sélectionnée", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_modifierPersonsActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cardlayout.show(panelCard,"panelTarif");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void addTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTarifActionPerformed
        addTarifs frame = new addTarifs();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            // Appel de la fonction afficherDonnesPersonne lorsque la fenêtre est fermée
            afficherDonneesTarif();
        }
        });
    }//GEN-LAST:event_addTarifActionPerformed

    private void deleteTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTarifActionPerformed
        int selectedRow = tarif.getSelectedRow();
            if (selectedRow != -1) { // Vérifier si une ligne est sélectionnée
                String IM = (String) tarifModel.getValueAt(selectedRow, 0); // Récupérer l'IM de la personne sélectionnée

                // Boîte de dialogue pour confirmer la suppression
                int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer ce tarif ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) { // Si l'utilisateur confirme la suppression
                    Connection connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");

                    // Appeler la fonction de suppression
                    boolean suppressionReussie = tarifBD.supprimerTarif(IM, connection);

                    if (suppressionReussie) {
                        // Rafraîchir les données affichées dans le JTable
                        afficherDonneesTarif();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un tarif à supprimer.", "Aucune personne sélectionnée", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_deleteTarifActionPerformed

    private void modifierTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierTarifActionPerformed
        int selectedRow = tarif.getSelectedRow();
        if (selectedRow != -1) { // Vérifiez si une ligne est sélectionnée
            // Récupérer les données de la personne sélectionnée
            String num_tarif = (String) tarifModel.getValueAt(selectedRow, 0);
            String diplome = (String) tarifModel.getValueAt(selectedRow, 1);
            String catego = (String) tarifModel.getValueAt(selectedRow, 2);
            int montant = (int) tarifModel.getValueAt(selectedRow, 3);
            
            addTarifWindow.remplirChampsTarif(num_tarif, diplome, catego,montant);
            addTarifWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addTarifWindow.setLocationRelativeTo(null);
            addTarifWindow.setVisible(true);
        
        // Ajouter un WindowListener pour rafraîchir les données après la fermeture de la fenêtre
            addTarifWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Rafraîchir les données affichées dans le JTable
                afficherDonneesTarif();
            }
        });
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un tarif à modifier.", "Aucun tarif sélectionnée", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_modifierTarifActionPerformed

    private void payementAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payementAjoutActionPerformed
        addPayer frame = new addPayer();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            // Appel de la fonction afficherDonnesPersonne lorsque la fenêtre est fermée
            afficherDonneesPayer();
        }
        });
    }//GEN-LAST:event_payementAjoutActionPerformed

    private void deletePayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePayerActionPerformed
    int selectedRow = payer.getSelectedRow();
    if (selectedRow != -1) { // Vérifier si une ligne est sélectionnée
        // Récupérer les données de la ligne sélectionnée
        String IM = (String) payerModel.getValueAt(selectedRow, 0); // Récupérer l'IM de la personne sélectionnée
        String numTarif = (String) payerModel.getValueAt(selectedRow, 1); // Récupérer le numéro de tarif
        String dateString = (String) payerModel.getValueAt(selectedRow, 2); // Récupérer la date de paiement
        Date datePaiement = null;
        try {
            // Convertir la date de paiement en objet java.util.Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            datePaiement = dateFormat.parse(dateString);
        } catch (ParseException ex) {
            ex.printStackTrace();
            // Gérer toute erreur de conversion de la date
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération de la date de paiement.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Boîte de dialogue pour confirmer la suppression
        int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer ce paiement ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) { // Si l'utilisateur confirme la suppression
            Connection connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");

            // Appeler la fonction de suppression
            boolean suppressionReussie = payerBD.supprimerPayer(datePaiement, connection);

            if (suppressionReussie) {
                // Rafraîchir les données affichées dans le JTable
                afficherDonneesPayer();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner un paiement à supprimer.", "Aucun paiement sélectionné", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_deletePayerActionPerformed

    private void modifierPayementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierPayementActionPerformed
        afficherDonneesTarif();
        int selectedRow = payer.getSelectedRow();
        if (selectedRow != -1) { // Vérifiez si une ligne est sélectionnée
            // Récupérer les données de la personne sélectionnée
            String Im = (String) payerModel.getValueAt(selectedRow, 1);
            String numTarif = (String) payerModel.getValueAt(selectedRow, 2);
            String dateString = (String) payerModel.getValueAt(selectedRow, 3);
            Date date = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Le format de votre date
                date = dateFormat.parse(dateString);
            } catch (ParseException ex) {
                ex.printStackTrace(); // Ou toute autre gestion appropriée des erreurs de conversion
            }
            
            addPayerWindow.remplirChampsPayer(Im, numTarif, date);
            addPayerWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addPayerWindow.setLocationRelativeTo(null);
            addPayerWindow.setVisible(true);
        
        // Ajouter un WindowListener pour rafraîchir les données après la fermeture de la fenêtre
            addPayerWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Rafraîchir les données affichées dans le JTable
                afficherDonneesPayer();
            }
        });
        } else {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner un payement à modifier.", "Aucun payement sélectionnée", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_modifierPayementActionPerformed

    private void detail_payerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detail_payerActionPerformed
    int selectedRow = payer.getSelectedRow();
    if (selectedRow != -1) { // Vérifier si une ligne est sélectionnée
        // Récupérer les données de la ligne sélectionnée
        String IM = (String) payerModel.getValueAt(selectedRow, 0); // Récupérer l'IM de la personne sélectionnée
        String numTarif = (String) payerModel.getValueAt(selectedRow, 1); // Récupérer le numéro de tarif
        String dateString = (String) payerModel.getValueAt(selectedRow, 2); // Récupérer la date de paiement
        Date datePaiement = null;
        try {
            // Convertir la date de paiement en objet java.util.Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            datePaiement = dateFormat.parse(dateString);
        } catch (ParseException ex) {
            ex.printStackTrace();
            // Gérer toute erreur de conversion de la date
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération de la date de paiement.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
            Connection connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
            // Afficher la fenêtre détails du paiement
                
                // Afficher les détails dans la fenêtre de détail
            detail.afficherDetailsPaiement(IM, numTarif, datePaiement);
            detail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            detail.setLocationRelativeTo(null);
            detail.setVisible(true);
           
        
    } else {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner un payement à afficher.", "Aucun paiement sélectionné", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_detail_payerActionPerformed

    private void histoireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_histoireActionPerformed
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
    // Connexion à la base de données
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        // Connexion à la base de données
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");

        // Requête SQL pour récupérer les données
        String query = "SELECT EXTRACT(YEAR FROM date_paiement) AS annee, SUM(montant) AS total " +
                       "FROM PAYER " +
                       "JOIN TARIF ON PAYER.num_tarif = TARIF.num_tarif " +
                       "GROUP BY annee";

        // Préparation de la requête
        preparedStatement = connection.prepareStatement(query);

        // Exécution de la requête
        resultSet = preparedStatement.executeQuery();

        // Ajout des données au dataset
        while (resultSet.next()) {
            String annee = resultSet.getString("annee");
            int montantTotal = resultSet.getInt("total");
            dataset.addValue(montantTotal, "Montant total", annee);
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        // Gestion des exceptions SQL
    } finally {
        // Fermeture des ressources
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestion des exceptions lors de la fermeture des ressources
        }
    }

    histogram.afficherHistogramme(dataset);
    histogram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    histogram.setLocationRelativeTo(null);
    histogram.setVisible(true);
    }//GEN-LAST:event_histoireActionPerformed

    private void likeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeActionPerformed
    String searchText = recherche.getText();

    // Connexion à la base de données
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
        String sql = "SELECT * FROM PERSONNE WHERE IM LIKE ? OR Nom LIKE ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + searchText + "%");
        preparedStatement.setString(2, "%" + searchText + "%");
        resultSet = preparedStatement.executeQuery();

        // Effacer le contenu actuel de la table
        tableModel.setRowCount(0);

        // Parcourir les résultats de la requête et ajouter chaque ligne à la table
        while (resultSet.next()) {
            String IM = resultSet.getString("IM");
            String nom = resultSet.getString("Nom");
            String prenom = resultSet.getString("Prenoms");
            java.sql.Date dateSQL = resultSet.getDate("Datenais");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            String formattedDate = dateFormat.format(dateSQL);
            String diplome = resultSet.getString("Diplome");
            String contact = resultSet.getString("Contact");
            boolean statut = resultSet.getBoolean("Statut");
            String statutAffiche = statut ? "Vivant" : "Décédé";
            String situation = resultSet.getString("Situation");
            String nomConjoint = resultSet.getString("NomConjoint");
            String prenomConjoint = resultSet.getString("PrenomConjoint");

            Object[] rowData = {IM, nom, prenom, formattedDate, diplome, contact, statutAffiche, situation, nomConjoint, prenomConjoint};
            tableModel.addRow(rowData);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de la récupération des données !");
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_likeActionPerformed

    private void statusVivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusVivantActionPerformed
        vivant frame = new vivant();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_statusVivantActionPerformed

    private void mortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mortActionPerformed
        mort frame = new mort();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_mortActionPerformed

    private void dateSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateSearchActionPerformed
    Date dateDebut = date1.getDate();
    Date dateFin = date2.getDate();
    
    if (dateDebut != null && dateFin != null) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
        
        try {
            connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
            String sql = "SELECT * FROM PAYER WHERE date_paiement BETWEEN ? AND ?";
            statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(dateDebut.getTime()));
            statement.setDate(2, new java.sql.Date(dateFin.getTime()));
            
            resultSet = statement.executeQuery();
            payerModel.setRowCount(0);
            
            while (resultSet.next()) {
                String IM = resultSet.getString("IM");
                String num_tarif = resultSet.getString("Num_tarif");
                java.sql.Date dateSQL = resultSet.getDate("date_paiement");
                String formattedDate = dateFormat.format(dateSQL);
                Object[] rowData = {IM, num_tarif, formattedDate};
                payerModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la récupération des données !");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner les deux dates.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_dateSearchActionPerformed

    private void actualiséActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualiséActionPerformed
        afficherDonneesPayer();
    }//GEN-LAST:event_actualiséActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hello().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualisé;
    private javax.swing.JButton addPerson;
    private javax.swing.JButton addTarif;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JButton dateSearch;
    private javax.swing.JButton deletePayer;
    private javax.swing.JButton deleteTarif;
    private javax.swing.JButton detail_payer;
    private javax.swing.JButton histoire;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton like;
    private javax.swing.JButton modifierPayement;
    private javax.swing.JButton modifierPersons;
    private javax.swing.JButton modifierTarif;
    private javax.swing.JButton mort;
    private javax.swing.JPanel panelAcceuil;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelHisto;
    private javax.swing.JPanel panelPayer;
    private javax.swing.JPanel panelTarif;
    private javax.swing.JButton payementAjout;
    private javax.swing.JTable payer;
    private javax.swing.JTable personne;
    private javax.swing.JTextField recherche;
    private javax.swing.JButton statusVivant;
    private javax.swing.JButton supprimerPersons;
    private javax.swing.JTable tarif;
    // End of variables declaration//GEN-END:variables

   public void afficherDonneesPersonne() {
        Connection connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
        String sql = "SELECT * FROM PERSONNE";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Exécution de la requête
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Effacer le contenu actuel de la table
                    tableModel.setRowCount(0);
                    // Parcourir les résultats de la requête et ajouter chaque ligne à la table
                    while (resultSet.next()) {
                        String IM = resultSet.getString("IM");
                        String nom = resultSet.getString("Nom");
                        String prenom = resultSet.getString("Prenoms");
                        java.sql.Date dateSQL = resultSet.getDate("Datenais");
                        String formattedDate = dateFormat.format(dateSQL);
                        String diplome = resultSet.getString("Diplome");
                        String contact = resultSet.getString("Contact");
                        boolean statut = resultSet.getBoolean("Statut");
                        String statutAffiche = statut ? "Vivant" : "Décédé";
                        String situation = resultSet.getString("Situation");
                        String nomConjoint = resultSet.getString("NomConjoint");
                        String prenomConjoint = resultSet.getString("PrenomConjoint");

                        Object[] rowData = {IM, nom, prenom, formattedDate, diplome, contact, statutAffiche, situation, nomConjoint, prenomConjoint};
                        tableModel.addRow(rowData);
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("Erreur lors de la récuperation de données !");
                }
    }catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de l'affichage!");
    }
 }
   public void afficherDonneesTarif() {
        Connection connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
        String sql = "SELECT * FROM TARIF";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Exécution de la requête
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Effacer le contenu actuel de la table
                    tarifModel.setRowCount(0);
                    // Parcourir les résultats de la requête et ajouter chaque ligne à la table
                    while (resultSet.next()) {
                        String num_tarif = resultSet.getString("Num_tarif");
                        String diplome = resultSet.getString("Diplome");
                        String categorie = resultSet.getString("Categorie");
                        int montant = resultSet.getInt("Montant");

                        Object[] rowData = {num_tarif, diplome, categorie, montant};
                        tarifModel.addRow(rowData);
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("Erreur lors de la récuperation de données !");
                }
    }catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de l'affichage!");
    }
 }
    public void afficherDonneesPayer() {
        Connection connection = bd.getConnection("jdbc:postgresql://localhost:5432/Java", "postgres", "madarauchiwa");
        String sql = "SELECT * FROM PAYER";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Exécution de la requête
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Effacer le contenu actuel de la table
                    payerModel.setRowCount(0);
                    // Parcourir les résultats de la requête et ajouter chaque ligne à la table
                    while (resultSet.next()) {
                        String IM = resultSet.getString("IM");
                        String num_tarif = resultSet.getString("Num_tarif");
                        java.sql.Date dateSQL = resultSet.getDate("date_paiement");
                        String formattedDate = dateFormat.format(dateSQL);
                        Object[] rowData = {IM, num_tarif, formattedDate};
                        payerModel.addRow(rowData);
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("Erreur lors de la récuperation de données !");
                }
    }catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de l'affichage!");
    }
 }
}