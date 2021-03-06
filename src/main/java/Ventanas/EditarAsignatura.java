/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import javax.swing.JOptionPane;

import Clases.Instituto;
import Exceptions.CodigoMalEscritoException;

/**
 *
 * @author Nobu
 */
public class EditarAsignatura extends javax.swing.JFrame {
    Instituto inst;
    /**
     * Creates new form EditarAsignatura
     */
    public EditarAsignatura() {
        initComponents();
    }

    public EditarAsignatura(Instituto inst) {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoInfo = new javax.swing.JTextField();
        botonEditar = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Ingresar el codigo de asignatura");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ingresar el nuevo nombre de la asignatura");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ingresar la Escuela o Carrera que imparte la asignatura");

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(campoNombre)
                            .addComponent(campoInfo))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonEditar)
                                .addGap(119, 119, 119))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonAtras)
                                .addGap(277, 277, 277))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonEditar)
                .addGap(18, 18, 18)
                .addComponent(botonAtras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        MenuEditar menuE = new MenuEditar(inst);
        menuE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private String getCodigoCurso() throws CodigoMalEscritoException{
        String codigoCurso = campoCodigo.getText();
        if(codigoCurso.length() == 6){

        }else{
            throw new CodigoMalEscritoException();
        }
        return codigoCurso;
    }
    
    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        try {
            String codigoAsignatura = getCodigoCurso();
            String nombreNuevo = campoNombre.getText();
            String infoNueva = campoInfo.getText();
            Aviso avisoEmergente = new Aviso();
            
            if(inst.editarAsignatura(codigoAsignatura, nombreNuevo, infoNueva)){
                avisoEmergente.cambiarAviso("Se ha actualizado la informacion de la asignatura");
            }else{
                avisoEmergente.cambiarAviso("No se ha podido actualizar la informacion de la asignatura");
            }
            
            avisoEmergente.setVisible(true);
            campoCodigo.setText("");
            campoNombre.setText("");
            campoInfo.setText("");
        } catch (CodigoMalEscritoException e) {
            JOptionPane.showMessageDialog(null, "Escribi?? mal el codigo");
        }
        
    }//GEN-LAST:event_botonEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonEditar;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoInfo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
