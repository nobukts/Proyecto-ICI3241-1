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
public class MenuEditar extends javax.swing.JFrame {
    Instituto inst;
    
    /**
     * Creates new form MenuEditar
     */
    public MenuEditar() {
        initComponents();
    }

    public MenuEditar(Instituto inst) {
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
        botonEditarCarrera = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        botonEditarAlumno = new javax.swing.JButton();
        botonEditarEstadoRamo = new javax.swing.JButton();
        botonEditarAsignatura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Menu Editar");

        botonEditarCarrera.setText("Editar Carrera");
        botonEditarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarCarreraActionPerformed(evt);
            }
        });

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        botonEditarAlumno.setText("Editar Alumno");
        botonEditarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarAlumnoActionPerformed(evt);
            }
        });

        botonEditarEstadoRamo.setText("Editar estado del ramo");
        botonEditarEstadoRamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarEstadoRamoActionPerformed(evt);
            }
        });

        botonEditarAsignatura.setText("Editar Asignatura");
        botonEditarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarAsignaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEditarAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEditarCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonEditarEstadoRamo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(botonEditarAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonAtras)
                        .addGap(159, 159, 159))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEditarCarrera)
                .addGap(18, 18, 18)
                .addComponent(botonEditarAlumno)
                .addGap(18, 18, 18)
                .addComponent(botonEditarAsignatura)
                .addGap(18, 18, 18)
                .addComponent(botonEditarEstadoRamo)
                .addGap(40, 40, 40)
                .addComponent(botonAtras)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEditarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarCarreraActionPerformed
        EditarCarrera eC = new EditarCarrera(inst);
        this.dispose();
        eC.setVisible(true);
    }//GEN-LAST:event_botonEditarCarreraActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        MenuPrincipal menuP = new MenuPrincipal(inst);
        this.dispose();
        menuP.setVisible(true);
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonEditarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarAlumnoActionPerformed
        EditarAlumno eA = new EditarAlumno(inst);
        this.dispose();
        eA.setVisible(true);
    }//GEN-LAST:event_botonEditarAlumnoActionPerformed

    private void botonEditarEstadoRamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarEstadoRamoActionPerformed
        EditarEstadoRamo eER = new EditarEstadoRamo(inst);
        this.dispose();
        eER.setVisible(true);
    }//GEN-LAST:event_botonEditarEstadoRamoActionPerformed

    private void botonEditarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarAsignaturaActionPerformed
        EditarAsignatura eAs = new EditarAsignatura(inst);
        this.dispose();
        eAs.setVisible(true);
    }//GEN-LAST:event_botonEditarAsignaturaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonEditarAlumno;
    private javax.swing.JButton botonEditarAsignatura;
    private javax.swing.JButton botonEditarCarrera;
    private javax.swing.JButton botonEditarEstadoRamo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
