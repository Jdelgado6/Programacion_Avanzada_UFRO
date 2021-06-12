package vista;

import conexion.Conexion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author jd_6
 */
public class RegistroNotas extends javax.swing.JFrame {

    int idAlumno = 0;
    String nombreAlu = "";
    String nombreCurso = "";

    public RegistroNotas() {
        initComponents();
        ejecutarConsultaRegistroNotas();
        this.setLocationRelativeTo(null);
        cerrar();
        cargarComboCurso(cmbCurso);
        txtAlu.setEditable(false);
        cmbCurso.setEditable(false);
        txtAlu.setText(nombreAlu);
        cmbCurso.setSelectedItem(cmbCurso);

    }

    public void ejecutarConsultaRegistroNotas() {
        
        idAlumno = GestionAlumnos.idAlumno;

        try {
            PreparedStatement ps = cn.prepareStatement("SELECT nombre FROM alumnos WHERE id_alumno='" + idAlumno + "'");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nombreAlu = rs.getString("nombre");

            }

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al consultar nombre del alumno");
        }

        try {
            PreparedStatement ps = cn.prepareStatement("SELECT id_curso_asignado FROM alumnos WHERE id_alumno='" + idAlumno + "'");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nombreCurso = rs.getString("id_curso_asignado");

            }

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al consultar curso en alumno");
        }

    }

    public void cargarComboCurso(JComboBox comboDelCurso) {

        try {

            String sql = "SELECT nombreCurso FROM cursos";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                comboDelCurso.addItem(rs.getString("nombreCurso"));

            }

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar datos en combobox");
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAlu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTarea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        BtnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registro de notas");

        jLabel2.setText("Alumno:");

        jLabel3.setText("Tarea:");

        txtTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTareaActionPerformed(evt);
            }
        });

        jLabel4.setText("Nota:");

        jLabel5.setText("Curso:");

        cmbCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione curso" }));

        btnRegistrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\records_notes_journal_edited_9479.png")); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        BtnVolver.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\arrow_left_icon_183068 (1).png")); // NOI18N
        BtnVolver.setText("Volver");
        BtnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNota)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnVolver))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(cmbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTarea)
                    .addComponent(txtAlu)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(BtnVolver))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTareaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String curso = cmbCurso.getSelectedItem().toString();

        try {

            if (txtTarea.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Campo tarea no puede estar vacio");

            } else if (txtNota.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Campo nota no puede estar vacio");

            } else {

                PreparedStatement ps = cn.prepareStatement(" INSERT INTO notas(id_alumno_nota,id_curso_nota,tarea,calificacion) VALUES (?,?,?,?)");

                ps.setInt(1, idAlumno);
                ps.setString(2, curso);
                ps.setString(3, txtTarea.getText());
                ps.setString(4, txtNota.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Datos guardados");
            }

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al guardar datos de notas");

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed

        InfoAlumnos infoAlumnos = new InfoAlumnos();
        infoAlumnos.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVolver;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtAlu;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtTarea;
    // End of variables declaration//GEN-END:variables

    Conexion con = new Conexion();
    Connection cn = con.getConnection();
}
