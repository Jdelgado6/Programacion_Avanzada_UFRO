package vista;

import conexion.Conexion;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import static vista.GestionAlumnos.idAlumno;

/**
 *
 * @author jd_6
 */
public class InfoAlumnos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();

    int idAlumno = 0;

    public static int idNota = 0;

    public InfoAlumnos() {
        initComponents();
        
        cerrar();

        this.setLocationRelativeTo(null);

        TxtNombreAlu.setEditable(false);
        TxtApellidoAlu.setEditable(false);
        txtMatriculaAlu.setEditable(false);
        lblAprobado.setEditable(false);
        txtNota.setEditable(false);

        idAlumno = GestionAlumnos.idAlumno;

        try {

            Connection cn = con.getConnection();

            PreparedStatement ps = cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno='" + idAlumno + "'");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                setTitle("Información del alumno: " + rs.getString("nombre"));
                
                lblInfoAlu.setText("Información del alumno: " + rs.getString("nombre"));

                TxtNombreAlu.setText(rs.getString("nombre"));
                TxtApellidoAlu.setText(rs.getString("apellido"));
                txtMatriculaAlu.setText(rs.getString("matricula"));

            }
            
            //cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar alumnos... contacte al administador");
        }

        try {
            
            PreparedStatement pst = cn.prepareStatement("SELECT id_nota,tarea,calificacion FROM notas WHERE id_alumno_nota= '" + idAlumno + "'");

            ResultSet rs = pst.executeQuery();

            tablaNotas = new JTable(modelo);

            jScrollPane1.setViewportView(tablaNotas);

            modelo.addColumn("ID nota");
            modelo.addColumn("Tarea");
            modelo.addColumn("Nota");

            while (rs.next()) {

                Object[] fila = new Object[3];

                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);

                }

                modelo.addRow(fila);

                double filax = 0;
                double total = 0;
                double promedio = 0;

                for (int i = 0; i < tablaNotas.getRowCount(); i++) {

                    filax = Double.parseDouble(tablaNotas.getValueAt(i, 2).toString());
                    total += filax;
                    promedio = total / tablaNotas.getRowCount();

                    txtNota.setText("" + promedio);

                }

                double notax = Double.parseDouble(txtNota.getText());

                if (notax >= 4.0) {
                    lblAprobado.setText(String.valueOf("Aprobado"));
                    txtNota.setBackground(Color.green);

                } else {
                    lblAprobado.setText(String.valueOf("Reprobado"));
                    txtNota.setBackground(Color.red);
                }

            }

        } catch (Exception e) {
            System.err.println("Error en el llenado de la tabla notas");
        }

        tablaNotas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int filaPoint = tablaNotas.rowAtPoint(e.getPoint());
                int columnaPoint = 0;

                if (filaPoint > -1) {
                    idNota = (int) modelo.getValueAt(filaPoint, columnaPoint);
                    InfoNotas infoNotas = new InfoNotas();
                    infoNotas.setVisible(true);
                    dispose();

                }

            }
        });
    }

    public void cerrar() {

        try {

            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

            addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e) {

                    confirmarSalida();
                }
            });

        } catch (Exception e) {
        }
    }

    public void confirmarSalida() {

        int valor = JOptionPane.showConfirmDialog(this, "¿Desea cerrar la aplicación ?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (valor == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Hasta pronto", "", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfoAlu = new javax.swing.JLabel();
        LblNombreAlu = new javax.swing.JLabel();
        TxtNombreAlu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtApellidoAlu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMatriculaAlu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNotas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblAprobado = new javax.swing.JTextField();
        BtnVolver = new javax.swing.JButton();
        BtnRegistrarNota = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInfoAlu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInfoAlu.setText("Información de alumno");

        LblNombreAlu.setText("Nombre");

        TxtNombreAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreAluActionPerformed(evt);
            }
        });

        jLabel2.setText("Apellido");

        jLabel3.setText("Matricula");

        txtMatriculaAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaAluActionPerformed(evt);
            }
        });

        tablaNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaNotas);

        jLabel4.setText("Estatus:");

        BtnVolver.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\arrow_left_icon_183068 (1).png")); // NOI18N
        BtnVolver.setText("Volver");
        BtnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        BtnRegistrarNota.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\records_notes_journal_edited_9479.png")); // NOI18N
        BtnRegistrarNota.setText("Registrar nota");
        BtnRegistrarNota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRegistrarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarNotaActionPerformed(evt);
            }
        });

        jLabel5.setText("Nota:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtNombreAlu)
                    .addComponent(LblNombreAlu, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(TxtApellidoAlu)
                    .addComponent(jLabel3)
                    .addComponent(txtMatriculaAlu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnVolver)
                        .addGap(18, 18, 18)
                        .addComponent(BtnRegistrarNota)
                        .addGap(162, 162, 162)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNota))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(lblInfoAlu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfoAlu)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNombreAlu)
                    .addComponent(jLabel4)
                    .addComponent(lblAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TxtNombreAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(TxtApellidoAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtMatriculaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnVolver)
                        .addComponent(BtnRegistrarNota))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNombreAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreAluActionPerformed

    private void txtMatriculaAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaAluActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        GestionAlumnos gestionAlumnos = new GestionAlumnos();
        gestionAlumnos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void BtnRegistrarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarNotaActionPerformed
        RegistroNotas registroNotas = new RegistroNotas();
        registroNotas.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_BtnRegistrarNotaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InfoAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrarNota;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JLabel LblNombreAlu;
    private javax.swing.JTextField TxtApellidoAlu;
    private javax.swing.JTextField TxtNombreAlu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblAprobado;
    private javax.swing.JLabel lblInfoAlu;
    private javax.swing.JTable tablaNotas;
    private javax.swing.JTextField txtMatriculaAlu;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables

    Conexion con = new Conexion();
    Connection cn = con.getConnection();
}
