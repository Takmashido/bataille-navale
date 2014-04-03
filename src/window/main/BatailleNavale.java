/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package window.main;

import bataille_navale.Jeu;
import bataille_navale.Profil;
import bataille_navale.TailleGrille;
import controller.AfficherPartiesController;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import stockage.DAOFactory;

/**
 * BatailleNavale
 * @author Tristan
 */
public class BatailleNavale extends javax.swing.JFrame {
    
    
    /////////////////////////////// VARIABLES /////////////////////////////////
    
    
    protected Jeu _jeu;
    public static int w = 800;
    public static int h = 600;
    private final ArrayList<TailleGrille> TailleGrilles = (ArrayList<TailleGrille>) DAOFactory.getInstance().getDAO_Grille().getGrilles();
    
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////
    
    
    /**
     * Creates new form BatailleNavale
     */
    public BatailleNavale() {
        initComponents();
        
        this._jeu = new Jeu();
        this.initialisation();
        this.setLocationRelativeTo(null);
           
    } // BatailleNavale()
    
    
    /////////////////////////////// FONCTIONS /////////////////////////////////
    
    
    /**
     * Permet d'intialiser le jeu a partir des fichier de configuration
     * et de sauvegarde
     */
    public void initialisation() {
        
        if(DAOFactory.getInstance().getDAO_Sauvegarde().getAllProfils() == null 
                || DAOFactory.getInstance().getDAO_Sauvegarde().getAllProfils().isEmpty()) {
            System.out.println(DAOFactory.getInstance().getDAO_Sauvegarde().getAllProfils().size());
            
            //this.jLabel5.setVisible(true);
            // sale
            this.listeProfils.removeAll();
            javax.swing.GroupLayout listeProfilsLayout1 = new javax.swing.GroupLayout(listeProfils);;
            listeProfils.setLayout(listeProfilsLayout1);
            listeProfilsLayout1.setHorizontalGroup(
                    listeProfilsLayout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            );
            listeProfilsLayout1.setVerticalGroup(
                    listeProfilsLayout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listeProfilsLayout1.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(122, Short.MAX_VALUE))
            );
            
        } else {
            
            // Masque le label qui signal qu'aucun profil n'est disponible
            //this.jLabel5.setVisible(false);
            // Affichage des profils disponibles
            int nbProfils = DAOFactory.getInstance().getDAO_Sauvegarde().getAllProfils().size();
            FlowLayout fl = new FlowLayout();
            this.listeProfils.removeAll();
            this.listeProfils.setPreferredSize(new Dimension(w,h/2));
            this.listeProfils.setLayout(fl);
            
            Iterator iterator = DAOFactory.getInstance().getDAO_Sauvegarde()
                        .getAllProfils().keySet().iterator();
            while(iterator.hasNext()) {
                
                JPanel profilPanel = new JPanel();
                profilPanel.setPreferredSize(new Dimension(w/(nbProfils+1),h/2-5));
                
                // Profil
                final Profil p = (Profil)DAOFactory.getInstance().getDAO_Sauvegarde().getAllProfils().get(iterator.next());
                JButton profil = new JButton(p.getNom());
                profil.setPreferredSize(new Dimension(w/(nbProfils+1),h/2-50));
                profil.addActionListener(new AfficherPartiesController(p,this,this.popupParties,this.jPanel1,this.nomProfil));
                profilPanel.add(profil);
                
                // Bouton permettant de supprimer le profil
                JButton supr = new JButton("SUPR");
                supr.setPreferredSize(new Dimension(w/(nbProfils+1),30));
                supr.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DAOFactory.getInstance().getDAO_Sauvegarde().removeProfil(p);
                        initialisation();
                    }
                });
                profilPanel.add(supr);
                
                this.listeProfils.add(profilPanel);
                
            }
            this.listeProfils.updateUI();
            
        }
        
    } // initialisation()

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupNouveauProfil = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        saisieNomProfil = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        erreurNomProfil = new javax.swing.JLabel();
        popupParties = new javax.swing.JDialog();
        nomProfil = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        popupParametres = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxTailleGrilles = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxEpoques = new javax.swing.JComboBox();
        jComboBoxDifficultees = new javax.swing.JComboBox();
        jRadioButtonManuel = new javax.swing.JRadioButton();
        jRadioButtonAleatoire = new javax.swing.JRadioButton();
        jButtonJouer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        listeProfils = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        popupNouveauProfil.setMinimumSize(new java.awt.Dimension(400, 220));
        popupNouveauProfil.setResizable(false);
        popupNouveauProfil.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                popupNouveauProfilWindowClosing(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nom du nouveau profil");

        saisieNomProfil.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        saisieNomProfil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        saisieNomProfil.setToolTipText("");
        saisieNomProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saisieNomProfilActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton2.setText("Ajouter le profil");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        erreurNomProfil.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        erreurNomProfil.setForeground(new java.awt.Color(255, 102, 102));
        erreurNomProfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        erreurNomProfil.setText("Désolé, ce nom de profil est déjà utilisé.");

        javax.swing.GroupLayout popupNouveauProfilLayout = new javax.swing.GroupLayout(popupNouveauProfil.getContentPane());
        popupNouveauProfil.getContentPane().setLayout(popupNouveauProfilLayout);
        popupNouveauProfilLayout.setHorizontalGroup(
            popupNouveauProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupNouveauProfilLayout.createSequentialGroup()
                .addGroup(popupNouveauProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(popupNouveauProfilLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(saisieNomProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(popupNouveauProfilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(popupNouveauProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(erreurNomProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popupNouveauProfilLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(125, 125, 125))
        );
        popupNouveauProfilLayout.setVerticalGroup(
            popupNouveauProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupNouveauProfilLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(saisieNomProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(erreurNomProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        popupParties.setSize(new java.awt.Dimension(500, 350));
        popupParties.setResizable(false);
        popupParties.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                popupPartiesWindowClosing(evt);
            }
        });

        nomProfil.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        nomProfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomProfil.setText("NOM");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mes parties en cours");

        jButton3.setText("Nouvelle partie");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout popupPartiesLayout = new javax.swing.GroupLayout(popupParties.getContentPane());
        popupParties.getContentPane().setLayout(popupPartiesLayout);
        popupPartiesLayout.setHorizontalGroup(
            popupPartiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupPartiesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(popupPartiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popupPartiesLayout.createSequentialGroup()
                .addGap(0, 179, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        popupPartiesLayout.setVerticalGroup(
            popupPartiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupPartiesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(nomProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        popupParametres.setSize(new java.awt.Dimension(500, 350));
        popupParametres.setResizable(false);
        popupParametres.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                popupParametresWindowClosing(evt);
            }
        });

        jLabel4.setText("Paramètres de la nouvelle partie");

        for(TailleGrille tg : this.TailleGrilles){
            this.jComboBoxTailleGrilles.addItem(tg.getX()+"x"+tg.getY());
        }
        jComboBoxTailleGrilles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTailleGrillesActionPerformed(evt);
            }
        });

        jLabel6.setText("Nombre de cases :");

        jLabel8.setText("Epoque :");

        jLabel9.setText("Difficultées :");

        jLabel10.setText("Placement des Cases :");

        jComboBoxEpoques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEpoquesActionPerformed(evt);
            }
        });

        jComboBoxDifficultees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDifficulteesActionPerformed(evt);
            }
        });

        jRadioButtonManuel.setText("Manuel");
        jRadioButtonManuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonManuelActionPerformed(evt);
            }
        });

        jRadioButtonAleatoire.setText("Aleatoire");

        jButtonJouer.setText("Jouer");
        jButtonJouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJouerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout popupParametresLayout = new javax.swing.GroupLayout(popupParametres.getContentPane());
        popupParametres.getContentPane().setLayout(popupParametresLayout);
        popupParametresLayout.setHorizontalGroup(
            popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupParametresLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonJouer, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(popupParametresLayout.createSequentialGroup()
                        .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(popupParametresLayout.createSequentialGroup()
                                .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(19, 19, 19))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(popupParametresLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxDifficultees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxEpoques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTailleGrilles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(popupParametresLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonAleatoire)
                                    .addComponent(jRadioButtonManuel))))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        popupParametresLayout.setVerticalGroup(
            popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupParametresLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxTailleGrilles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEpoques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDifficultees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(popupParametresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(popupParametresLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel10))
                    .addGroup(popupParametresLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jRadioButtonManuel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonAleatoire)))
                .addGap(18, 18, 18)
                .addComponent(jButtonJouer)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Battleship");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Devenez le maître des océans !");

        jButton1.setText("Ajouter un profil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 50)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Aucun profil disponible");

        javax.swing.GroupLayout listeProfilsLayout = new javax.swing.GroupLayout(listeProfils);
        listeProfils.setLayout(listeProfilsLayout);
        listeProfilsLayout.setHorizontalGroup(
            listeProfilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        listeProfilsLayout.setVerticalGroup(
            listeProfilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listeProfilsLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(listeProfils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(listeProfils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Permet d'afficher la fenetre permettant de creer un nouveau profil
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.popupNouveauProfil.setLocationRelativeTo(null);
        this.erreurNomProfil.setVisible(false);
        this.setEnabled(false);
        this.popupNouveauProfil.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    /********************* JDIALOG - NOUVEAU PROFIL **************************/
    
    
    /**
     * Zone de saisie du nouveau profil
     * @param evt 
     */
    private void saisieNomProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saisieNomProfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saisieNomProfilActionPerformed

    
    /**
     * Permet d'ajouter le nouveau profil
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (DAOFactory.getInstance().getDAO_Sauvegarde().isExistingProfil(this.saisieNomProfil.getText())) {

            // Affichage du message d'erreur
            this.erreurNomProfil.setText("Désolé, ce nom de profil est déjà utilisé.");
            this.erreurNomProfil.setVisible(true);

        } else if (this.saisieNomProfil.getText().equals("") || this.saisieNomProfil.getText() == null) {
            this.erreurNomProfil.setText("Le nom de profil ne doit pas être vide.");
            this.erreurNomProfil.setVisible(true);
        } else {
          
            // Creation et sauvegrade du profil
            Profil newProfil = new Profil(this.saisieNomProfil.getText());
            DAOFactory.getInstance().getDAO_Sauvegarde().saveProfil(newProfil);
            this.initialisation();
            this.popupNouveauProfil.setVisible(false);
            this.saisieNomProfil.setText(null);
            this.setEnabled(true);
            this.setVisible(true);
      }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    /************************ JDIALOG - PARTIES ******************************/
    
    
    /**
     * Permet de selectionner ou de creer une nouvelle partie pour un profil
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.popupParametres.setLocationRelativeTo(null);
        this.setEnabled(false);
        this.popupParties.setVisible(false);
        this.popupParametres.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    
    /**
     * Permet de reautoriser les actions sur la fenetre principale
     * @param evt 
     */
    private void popupPartiesWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_popupPartiesWindowClosing
        
        this.setEnabled(true);
        
    }//GEN-LAST:event_popupPartiesWindowClosing

    
    /**
     * Reautorise le clique sur la fenetre prinicpale
     * @param evt 
     */
    private void popupNouveauProfilWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_popupNouveauProfilWindowClosing
       
        this.setEnabled(true);
        
    }//GEN-LAST:event_popupNouveauProfilWindowClosing

    private void jComboBoxTailleGrillesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTailleGrillesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTailleGrillesActionPerformed

    private void jComboBoxEpoquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEpoquesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEpoquesActionPerformed

    private void jComboBoxDifficulteesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDifficulteesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDifficulteesActionPerformed

    private void jButtonJouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJouerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonJouerActionPerformed

    private void jRadioButtonManuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonManuelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonManuelActionPerformed

    private void popupParametresWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_popupParametresWindowClosing
        // TODO add your handling code here:
        this.setEnabled(true);
    }//GEN-LAST:event_popupParametresWindowClosing

    
    /******************************* MAIN ************************************/ 
    
    
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
            java.util.logging.Logger.getLogger(BatailleNavale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatailleNavale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatailleNavale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatailleNavale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatailleNavale().setVisible(true);
            }
        });
        
    } // main(String args[])
    
    
    //////////////////////// VARIABLES GRAPHIQUES /////////////////////////////
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel erreurNomProfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonJouer;
    private javax.swing.JComboBox jComboBoxDifficultees;
    private javax.swing.JComboBox jComboBoxEpoques;
    private javax.swing.JComboBox jComboBoxTailleGrilles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonAleatoire;
    private javax.swing.JRadioButton jRadioButtonManuel;
    private javax.swing.JPanel listeProfils;
    private javax.swing.JLabel nomProfil;
    private javax.swing.JDialog popupNouveauProfil;
    private javax.swing.JDialog popupParametres;
    private javax.swing.JDialog popupParties;
    private javax.swing.JTextField saisieNomProfil;
    // End of variables declaration//GEN-END:variables


} // class BatailleNavale
