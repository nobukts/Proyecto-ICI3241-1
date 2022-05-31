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
public class MenuBuscar extends javax.swing.JFrame {
    Instituto inst;
    
    /**
     * Creates new form MenuBuscar
     */
    public MenuBuscar() {
        initComponents();
    }
    
    public MenuBuscar(Instituto inst) {
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
        botonBuscarAlumno = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        botonBuscarAsignatura = new javax.swing.JButton();
        botonBuscarMenorCreditos = new javax.swing.JButton();
        botonBuscarRango = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Menu Buscar");

        botonBuscarAlumno.setText("Buscar Alumno");
        botonBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarAlumnoActionPerformed(evt);
            }
        });

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        botonBuscarAsignatura.setText("Buscar Asignatura");
        botonBuscarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarAsignaturaActionPerformed(evt);
            }
        });

        botonBuscarMenorCreditos.setText("Buscar a los alumnos con la menor cantidad de creditos");
        botonBuscarMenorCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarMenorCreditosActionPerformed(evt);
            }
        });

        botonBuscarRango.setText("Buscar alumnos por rango de creditos");
        botonBuscarRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarRangoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonBuscarAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonBuscarMenorCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonBuscarAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonBuscarRango, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(botonAtras)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(botonBuscarAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscarAsignatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscarMenorCreditos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscarRango)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addComponent(botonAtras)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        MenuPrincipal menuP = new MenuPrincipal(inst);
        this.dispose();
        menuP.setVisible(true);
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarAlumnoActionPerformed
        BuscarAlumno bA = new BuscarAlumno(inst);
        this.dispose();
        bA.setVisible(true);
    }//GEN-LAST:event_botonBuscarAlumnoActionPerformed

    private void botonBuscarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarAsignaturaActionPerformed
        BuscarAsignatura bAs = new BuscarAsignatura(inst);
        this.dispose();
        bAs.setVisible(true);
    }//GEN-LAST:event_botonBuscarAsignaturaActionPerformed

    private void botonBuscarMenorCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarMenorCreditosActionPerformed
        BuscarMenorCreditos bMC = new BuscarMenorCreditos(inst);
        this.dispose();
        bMC.setVisible(true);
    }//GEN-LAST:event_botonBuscarMenorCreditosActionPerformed

    private void botonBuscarRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarRangoActionPerformed
        BuscarRangoCreditos bRC = new BuscarRangoCreditos(inst);
        this.dispose();
        bRC.setVisible(true);
    }//GEN-LAST:event_botonBuscarRangoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonBuscarAlumno;
    private javax.swing.JButton botonBuscarAsignatura;
    private javax.swing.JButton botonBuscarMenorCreditos;
    private javax.swing.JButton botonBuscarRango;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
