
package com.mycompany.yanopuedomas;

import javax.swing.JOptionPane;
import org.bson.Document;

public class Inter1 extends javax.swing.JFrame {
Ingredients ingre=new Ingredients();
    public Inter1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Yasai = new javax.swing.JCheckBox();
        Chiki = new javax.swing.JCheckBox();
        Gyuniku = new javax.swing.JCheckBox();
        Buta = new javax.swing.JCheckBox();
        Tariniku = new javax.swing.JCheckBox();
        Amazuppai = new javax.swing.JCheckBox();
        Butaniku = new javax.swing.JCheckBox();
        Konbo3 = new javax.swing.JCheckBox();
        Konbo2 = new javax.swing.JCheckBox();
        Konbo1 = new javax.swing.JCheckBox();
        Ramura = new javax.swing.JCheckBox();
        Bubble = new javax.swing.JCheckBox();
        Sake = new javax.swing.JCheckBox();
        Matcha = new javax.swing.JCheckBox();
        Insert = new javax.swing.JButton();
        fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Yasai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YasaiActionPerformed(evt);
            }
        });
        getContentPane().add(Yasai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, 210));

        Chiki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChikiActionPerformed(evt);
            }
        });
        getContentPane().add(Chiki, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 130, 210));

        Gyuniku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GyunikuActionPerformed(evt);
            }
        });
        getContentPane().add(Gyuniku, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 130, 210));
        getContentPane().add(Buta, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 90, 100));
        getContentPane().add(Tariniku, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 100, 100));
        getContentPane().add(Amazuppai, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 100, 100));
        getContentPane().add(Butaniku, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 110, 100));
        getContentPane().add(Konbo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 140, 220));
        getContentPane().add(Konbo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 140, 220));

        Konbo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Konbo1ActionPerformed(evt);
            }
        });
        getContentPane().add(Konbo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 130, 220));
        getContentPane().add(Ramura, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 90, 90));
        getContentPane().add(Bubble, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 90, 90));
        getContentPane().add(Sake, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 90, 90));
        getContentPane().add(Matcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 80, 90));

        Insert.setText("Arregar");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });
        getContentPane().add(Insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, 90, 30));

        fond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.png"))); // NOI18N
        getContentPane().add(fond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YasaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YasaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YasaiActionPerformed

    private void ChikiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChikiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChikiActionPerformed

    private void GyunikuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GyunikuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GyunikuActionPerformed

    private void Konbo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Konbo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Konbo1ActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed

        Validation Vali= new Validation();

    String soupData = Vali.TomarDatosSoup(Yasai, Chiki, Gyuniku);
    String drinksData = Vali.TomarDatosBebidas(Matcha, Sake, Bubble, Ramura);
    String proteinsData = Vali.TomarDatosProteina(Buta, Tariniku, Amazuppai, Butaniku);
    String toppingsData = Vali.TomarDatosToppins(Konbo1, Konbo2, Konbo3);

     // Patron Creacional: Factory Method
        // Este se encarga de crear objetos de la superclase, los datos de de la subclase se modificaran 
        Ingredients ingredients = new Ingredients ();
        ingredients.setSoupBase(soupData);
        ingredients.setProteins(proteinsData);
        ingredients.setToppins(toppingsData);
        ingredients.setDrinks(drinksData);
        
     MongoDocumentBuilder builder = new MongoDocumentBuilder();
        builder.soupBase(soupData)
               .proteins(proteinsData)
               .toppings(toppingsData)
               .drinks(drinksData);

        // Insertar el documento en la base de datos 
        MongoInsert mongoInsert = new MongoInsert();
        mongoInsert.insert(builder);
        Payment pay = new Payment();
        pay.setVisible(true);
        pay.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_InsertActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inter1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox Amazuppai;
    public javax.swing.JCheckBox Bubble;
    public javax.swing.JCheckBox Buta;
    public javax.swing.JCheckBox Butaniku;
    public javax.swing.JCheckBox Chiki;
    public javax.swing.JCheckBox Gyuniku;
    public javax.swing.JButton Insert;
    public javax.swing.JCheckBox Konbo1;
    public javax.swing.JCheckBox Konbo2;
    public javax.swing.JCheckBox Konbo3;
    public javax.swing.JCheckBox Matcha;
    public javax.swing.JCheckBox Ramura;
    public javax.swing.JCheckBox Sake;
    public javax.swing.JCheckBox Tariniku;
    public javax.swing.JCheckBox Yasai;
    private javax.swing.JLabel fond;
    // End of variables declaration//GEN-END:variables
}
