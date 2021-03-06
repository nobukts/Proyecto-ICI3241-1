/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import javax.swing.JOptionPane;

import Clases.Instituto;
import Clases.Obligatorio;
import Exceptions.CodigoMalEscritoException;

/**
 *
 * @author Nobu
 */
public class AñadirMalla extends javax.swing.JFrame {
    Instituto inst;
    /**
     * Creates new form AñadirMalla
     */
    
    public AñadirMalla(){
        initComponents();
    }
    
    public AñadirMalla(Instituto inst) {
        initComponents();
        this.inst = inst;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoCodigo = new javax.swing.JTextField();
        primerSemestreCheck = new javax.swing.JCheckBox();
        botonAñadir = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        campoCreditos = new javax.swing.JSpinner();
        campoCarrera = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Ingrese nombre de la asignatura");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ingrese el codigo del curso");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ingrese cantidad de creditos");

        primerSemestreCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        primerSemestreCheck.setText("¿Se cursa en el primer semestre?");

        botonAñadir.setText("Añadir");
        botonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirActionPerformed(evt);
            }
        });

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ingrese el nombre de la carrera");

        campoCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        campoCarrera.setSelectedIndex(-1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(botonAtras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(primerSemestreCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addComponent(botonAñadir)
                        .addGap(135, 135, 135))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel3)))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNombre)
                            .addComponent(campoCodigo)
                            .addComponent(campoCreditos)
                            .addComponent(campoCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCarrera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(primerSemestreCheck)
                    .addComponent(botonAñadir))
                .addGap(18, 18, 18)
                .addComponent(botonAtras)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String getCodigoCurso() throws CodigoMalEscritoException{
        String codigoCurso = campoCodigo.getText();
        if(codigoCurso.length() == 6){

        }else{
            throw new CodigoMalEscritoException();
        }
        return codigoCurso;
    }

    private void botonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirActionPerformed
        // TODO add your handling code here:
        try {
            String nombreCarrera = campoCarrera.getSelectedItem().toString();
            String nombreCurso = campoNombre.getText();
            String codigoCurso = getCodigoCurso();

            int cantCreditos = (Integer) campoCreditos.getValue();
            boolean esDePrimero = primerSemestreCheck.isSelected();
            Aviso avisoEmergente = new Aviso();
            
            if(inst.agregarMalla(new Obligatorio(nombreCurso, codigoCurso, cantCreditos, esDePrimero, nombreCarrera), nombreCarrera)){
                avisoEmergente.cambiarAviso("Se ingreso a la malla el ramo " + nombreCurso);
            }else{
                avisoEmergente.cambiarAviso("No se pudo ingresar a la malla el ramo " + nombreCurso);
            }
            
            avisoEmergente.setVisible(true);
            campoNombre.setText("");
            campoCodigo.setText("");
            campoCreditos.setValue(0);
            primerSemestreCheck.setSelected(false);
            
        } catch (CodigoMalEscritoException e) {
            JOptionPane.showMessageDialog(null, "Escribió mal el codigo");
        }
        
    }//GEN-LAST:event_botonAñadirActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        // TODO add your handling code here:
        MenuAñadir menuA = new MenuAñadir(inst);
        this.dispose();
        menuA.setVisible(true);
    }//GEN-LAST:event_botonAtrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonAñadir;
    private javax.swing.JComboBox<String> campoCarrera;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JSpinner campoCreditos;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JCheckBox primerSemestreCheck;
    // End of variables declaration//GEN-END:variables
}
