package co.unicauca.restaurant.client.presentation;


import javax.swing.JTable;

/**
 *
 * @author libardo Para que las celdas del jTable no sean editables, se usó este
 * tutorial: http://www.elprogramador.com.mx/celdas-no-editables-en-jtable/
 */
public class GUIListaComponente extends javax.swing.JInternalFrame {

    private String accion;

    /**
     * Creates new form GUITiposVehiculo
     */
    public GUIListaComponente() {
        initComponents();
        inicializarTabla();
        btnGrabar.setEnabled(false);
        btnEliminar.setEnabled(false);
        this.setSize(1200, 680);
    }

    private void inicializarTabla() {
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Nombre", "Tarifa", "Fecha Inicio", "Fecha Fin", "Estado"
                }
        ));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        pnlSur = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Componentes");
        getContentPane().setLayout(null);

        pnlCentro.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlCentro.setLayout(new java.awt.BorderLayout());

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "SEL", "NOMBRE", "DESCRIPCIÒN", "PRECIO", "TIPO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        pnlCentro.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlCentro);
        pnlCentro.setBounds(6, 103, 890, 260);

        pnlSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlSur.add(btnNuevo);

        btnGrabar.setText("Agregar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        pnlSur.add(btnGrabar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlSur.add(btnEliminar);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlSur.add(btnCerrar);

        getContentPane().add(pnlSur);
        pnlSur.setBounds(0, 405, 894, 35);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FOOD DELIVERY");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(350, 10, 194, 32);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tblDatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMousePressed
    }//GEN-LAST:event_tblDatosMousePressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}