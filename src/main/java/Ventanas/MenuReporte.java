/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Clases.FormaNormal;
import Clases.FormaSoloCursos;
import Clases.Instituto;

/**
 *
 * @author Nobu
 */
public class MenuReporte extends javax.swing.JFrame {
    Instituto inst;
    /**
     * Creates new form MenuReporte
     * @param inst
     */
    public MenuReporte(Instituto inst) {
        initComponents();
        this.inst = inst;
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
        botonNormal = new javax.swing.JButton();
        botonEspecial = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Menu Reporte");

        botonNormal.setText("Reporte Normal");
        botonNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNormalActionPerformed(evt);
            }
        });

        botonEspecial.setText("Reporte \"Solo Cursos\"");
        botonEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEspecialActionPerformed(evt);
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
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonEspecial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(botonAtras)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonNormal)
                .addGap(18, 18, 18)
                .addComponent(botonEspecial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(botonAtras)
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNormalActionPerformed
        Aviso mensajeEmergente = new Aviso();
        inst.setFormatoSalida(new FormaNormal());
        inst.crearReporte();
        mensajeEmergente.cambiarAviso("Se ha generado el reporte de forma normal");
        mensajeEmergente.setVisible(true);
    }//GEN-LAST:event_botonNormalActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        MenuPrincipal menuP = new MenuPrincipal(inst);
        menuP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEspecialActionPerformed
        Aviso mensajeEmergente = new Aviso();
        inst.setFormatoSalida(new FormaSoloCursos());
        inst.crearReporte();
        mensajeEmergente.cambiarAviso("Se ha generado el reporte de forma especial");
        mensajeEmergente.setVisible(true);
    }//GEN-LAST:event_botonEspecialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonEspecial;
    private javax.swing.JButton botonNormal;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}