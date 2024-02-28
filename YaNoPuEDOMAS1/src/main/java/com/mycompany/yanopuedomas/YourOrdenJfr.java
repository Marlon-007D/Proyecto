
package com.mycompany.yanopuedomas;

import com.mycompany.yanopuedomas.MongoSearch;
import com.mycompany.yanopuedomas.MongoDelete;
import com.mycompany.yanopuedomas.ModifyMongo;
import com.mycompany.yanopuedomas.MongoConnection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

public class YourOrdenJfr extends javax.swing.JFrame {
    MongoSearch search = new MongoSearch ();
     MongoConnection mongoC = new MongoConnection ();
     MongoDelete deleteM = new MongoDelete ();
     ModifyMongo modify = new ModifyMongo();
     DefaultTableModel modeloTabla;
     
    public YourOrdenJfr() {
        initComponents();
        
        mongoC.connect();
        modeloTabla = (DefaultTableModel) jTOrden.getModel();
        updateTable();

        // Agrega un ListSelectionListener a la tabla para detectar la selección de una fila
        jTOrden.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = jTOrden.getSelectedRow();
            if (selectedRow != -1) { // Si hay una fila seleccionada
                soupBase = jTOrden.getValueAt(selectedRow, 0).toString(); // Obtén la sopa base seleccionada
            }
        });

        // Agrega un ActionListener al botón "Eliminar" para manejar la eliminación
        deleteB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (soupBase != null) { // Si se ha seleccionado una sopa base
                    deleteM.Eliminar(soupBase); // Elimina la sopa base de la base de datos
                    updateTable(); // Actualiza la tabla después de eliminar
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar.");
                }
            }
        });
        

        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        deleteB = new javax.swing.JButton();
        modifyB = new javax.swing.JButton();
        searchB = new javax.swing.JButton();
        showB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTOrden = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteB.setText("Eliminar");
        deleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBActionPerformed(evt);
            }
        });
        getContentPane().add(deleteB, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 130, 30));

        modifyB.setText("Modificar");
        modifyB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBActionPerformed(evt);
            }
        });
        getContentPane().add(modifyB, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 130, -1));

        searchB.setText("Buscar");
        searchB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBActionPerformed(evt);
            }
        });
        getContentPane().add(searchB, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 130, 30));

        showB.setText("Mostrar");
        showB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBActionPerformed(evt);
            }
        });
        getContentPane().add(showB, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 130, 30));

        jTOrden.setBackground(new java.awt.Color(255, 204, 255));
        jTOrden.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sopa base", "Proteína", "Combo Toppins", "Bebidas"
            }
        ));
        jScrollPane1.setViewportView(jTOrden);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 450, 160));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CarritoCompras.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String soupBase;
    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este elemento?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
        deleteM.Eliminar(soupBase);
        updateTable();
        }
    }//GEN-LAST:event_deleteBActionPerformed

    private void searchBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBActionPerformed
       String nombreBusqueda = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar:");

    if (nombreBusqueda != null && !nombreBusqueda.isEmpty()) {
        FindIterable<Document> resultados = search.searchSoupBase(nombreBusqueda);
        updateTable(resultados);
    } else {
        JOptionPane.showMessageDialog(null, "Nombre no encontrado");
    }
    }//GEN-LAST:event_searchBActionPerformed

    private void showBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBActionPerformed
        updateTable ();
    }//GEN-LAST:event_showBActionPerformed

    private void modifyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBActionPerformed
       modify.modificarDocumento(soupBase);
       updateTable();
    }//GEN-LAST:event_modifyBActionPerformed
    
       
    
    public void updateTable(FindIterable<Document> resultados) {
    modeloTabla.setRowCount(0); 

    for (Document document : resultados) {
        String sopaBase = document.getString("Sopa base");
        String proteina = document.getString("Proteína");
        String beber = document.getString("Bebidas");
        String comboToppins = document.getString("Toppins");
        modeloTabla.addRow(new Object[]{sopaBase, proteina,beber, comboToppins});
    }
}
    
    public void updateTable (){
        MongoConnection mongoConnection = MongoConnection.getInstance();
        mongoConnection.connect();

        MongoCollection<Document> collection = mongoConnection.getCollection();
         modeloTabla.setRowCount(0);
         
        
        for (Document document : mongoC.collection.find()) {
            String sopaBase = document.getString("Sopa base");
        String proteina = document.getString("Proteína");
        String beber = document.getString("Bebidas");
        String comboToppins = document.getString("Toppins");
        modeloTabla.addRow(new Object[]{sopaBase, proteina,beber, comboToppins});
        }
    
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YourOrdenJfr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new YourOrdenJfr().setVisible(true);
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTOrden;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton modifyB;
    private javax.swing.JButton searchB;
    private javax.swing.JButton showB;
    // End of variables declaration//GEN-END:variables
}
