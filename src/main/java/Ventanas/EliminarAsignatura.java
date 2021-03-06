/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Clases.Instituto;

/**
 *
 * @author Nobu
 */
public class EliminarAsignatura extends javax.swing.JFrame {
    Instituto inst;
    
    /**
     * Creates new form EliminarAsignatura
     */
    public EliminarAsignatura() {
        initComponents();
    }
    
    public EliminarAsignatura(Instituto inst) {
        initComponents();
        this.inst = inst;
        
        campoCarrera.removeAllItems();
        campoCarrera.addItem(" ");
        String[] listaCarreras = inst.mostrarCarreras();
        for (int i = 0; i < listaCarreras.length; i++) {
            String[] carreraSeparada = listaCarreras[i].split("-");
            campoCarrera.addItem(carreraSeparada[0]); 
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoCarrera = new javax.swing.JComboBox<>();
        botonBuscar = new javax.swing.JButton();
        campoCodigo = new javax.swing.JComboBox<>();
        botonEliminar = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Elegir una carrera");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Elegir codigo de asignatura");

        campoCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        campoCodigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEliminar)
                    .addComponent(botonBuscar))
                .addGap(147, 147, 147))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAtras)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoCarrera, 0, 250, Short.MAX_VALUE)
                        .addComponent(campoCodigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(campoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscar)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(botonAtras)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        String nombreCarrera = campoCarrera.getSelectedItem().toString();
        String[] codigoCurso = campoCodigo.getSelectedItem().toString().split("-");
        Aviso avisoEmergente = new Aviso();
        
        if(inst.eliminarAsignatura(nombreCarrera, codigoCurso[0])){
            avisoEmergente.cambiarAviso("Se ha eliminado con exito la asignatura " + codigoCurso[1]);
        }else{
            avisoEmergente.cambiarAviso("No se ha podido eliminar la asignatura" + codigoCurso[1]);
        }
        
        avisoEmergente.setVisible(true);
        campoCarrera.setSelectedIndex(0);
        campoCodigo.removeAllItems();
    }//GEN-LAST:event_botonEliminarActionPerformed
    
    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        // TODO add your handling code here:
        MenuEliminar menuE = new MenuEliminar(inst);
        this.dispose();
        menuE.setVisible(true);
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String nombreCarrera = campoCarrera.getSelectedItem().toString();
        
        campoCodigo.removeAllItems();
        campoCodigo.addItem("");
        String[] listaAsignaturas = inst.mostrarAsignaturasCarrera(nombreCarrera);
        for (int i = 0; i < listaAsignaturas.length; i++) {
            String[] asignaturaSeparada = listaAsignaturas[i].split("-");
            campoCodigo.addItem(asignaturaSeparada[1] + "-" + asignaturaSeparada[0]); 
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JComboBox<String> campoCarrera;
    private javax.swing.JComboBox<String> campoCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
