package Ventanas;

import Clases.Instituto;

public class MenuPrincipal extends javax.swing.JFrame {
    private Instituto inst;
    
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }
    
    public MenuPrincipal(Instituto inst){
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

        botonAñadir = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonMostrar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonReporte = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        importarCSV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAñadir.setText("Añadir");
        botonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonMostrar.setText("Mostrar");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonReporte.setText("Reporte");
        botonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteActionPerformed(evt);
            }
        });

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        Titulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Titulo.setText("Menu Principal");

        importarCSV.setText("Importar CSV");
        importarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAñadir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(importarCSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonMostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(Titulo)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Titulo)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAñadir)
                    .addComponent(botonMostrar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminar)
                    .addComponent(botonBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditar)
                    .addComponent(botonReporte)
                    .addComponent(importarCSV))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirActionPerformed
        MenuAñadir menuA = new MenuAñadir(inst);
        menuA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonAñadirActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if(!inst.noContieneCarrera()){
            MenuBuscar menuB = new MenuBuscar(inst);
            menuB.setVisible(true);
            this.dispose();
        }else{
            Aviso avisoEmergente = new Aviso();
            avisoEmergente.cambiarAviso("No hay datos para buscar");
            avisoEmergente.setVisible(true);
        }
        
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
        if(!inst.noContieneCarrera()){
            MenuMostrar menuM = new MenuMostrar(inst);
            menuM.setVisible(true);
            this.dispose();
        }else{
            Aviso avisoEmergente = new Aviso();
            avisoEmergente.cambiarAviso("No hay carreras para mostrar");
            avisoEmergente.setVisible(true);
        }
    }//GEN-LAST:event_botonMostrarActionPerformed

    private void botonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteActionPerformed
        Aviso avisoEmergente = new Aviso();
        if(!inst.noContieneCarrera()){
            inst.crearReporte();
            avisoEmergente.cambiarAviso("Se genero el reporte de las carreras");
        }else{
            avisoEmergente.cambiarAviso("No se puede generar el reporte, porque no hay informacion");
        }
        avisoEmergente.setVisible(true);
    }//GEN-LAST:event_botonReporteActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if(!inst.noContieneCarrera()){
            MenuEliminar menuE = new MenuEliminar(inst);
            this.dispose();
            menuE.setVisible(true);
        }else{
            Aviso avisoEmergente = new Aviso();
            avisoEmergente.cambiarAviso("No hay datos para eliminar");
            avisoEmergente.setVisible(true);
        }

    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        if(!inst.noContieneCarrera()){
            MenuEditar menuE = new MenuEditar(inst);
            this.dispose();
            menuE.setVisible(true);
        }else{
            Aviso avisoEmergente = new Aviso();
            avisoEmergente.cambiarAviso("No hay datos que modificar");
        }
        
    }//GEN-LAST:event_botonEditarActionPerformed

    private void importarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarCSVActionPerformed
        MenuCSV mCSV = new MenuCSV(inst);
        this.dispose();
        mCSV.setVisible(true);
        
    }//GEN-LAST:event_importarCSVActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton botonAñadir;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JButton botonReporte;
    private javax.swing.JButton importarCSV;
    // End of variables declaration//GEN-END:variables
}
