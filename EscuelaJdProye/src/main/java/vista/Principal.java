package vista;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author jd_6
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {

        initComponents();
        cerrar();
        this.setLocationRelativeTo(null);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnAlumnos = new javax.swing.JButton();
        BtnGestorAlumnos = new javax.swing.JButton();
        BtnGestorCursos = new javax.swing.JButton();
        BtnGestorNotas = new javax.swing.JButton();
        BtnEliminarTareas = new javax.swing.JButton();
        BtnRegistroCurso = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        BtnAlumnos.setBackground(new java.awt.Color(0, 204, 204));
        BtnAlumnos.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnAlumnos.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\iconfinder-499-student.png")); // NOI18N
        BtnAlumnos.setText("Alumnos");
        BtnAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlumnosActionPerformed(evt);
            }
        });

        BtnGestorAlumnos.setBackground(new java.awt.Color(0, 204, 204));
        BtnGestorAlumnos.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnGestorAlumnos.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\1490820812-14_82398.png")); // NOI18N
        BtnGestorAlumnos.setText("Gestor de alumnos");
        BtnGestorAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGestorAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGestorAlumnosActionPerformed(evt);
            }
        });

        BtnGestorCursos.setBackground(new java.awt.Color(0, 204, 204));
        BtnGestorCursos.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnGestorCursos.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\research_books_22128.png")); // NOI18N
        BtnGestorCursos.setText("Gestor de cursos");
        BtnGestorCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGestorCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGestorCursosActionPerformed(evt);
            }
        });

        BtnGestorNotas.setBackground(new java.awt.Color(0, 204, 204));
        BtnGestorNotas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnGestorNotas.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\list_notes_930.png")); // NOI18N
        BtnGestorNotas.setText("Gestor de notas");
        BtnGestorNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGestorNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGestorNotasActionPerformed(evt);
            }
        });

        BtnEliminarTareas.setBackground(new java.awt.Color(0, 204, 204));
        BtnEliminarTareas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnEliminarTareas.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\iconfinder-trash-4341321_120557.png")); // NOI18N
        BtnEliminarTareas.setText("Borar datos de tabla");
        BtnEliminarTareas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarTareasActionPerformed(evt);
            }
        });

        BtnRegistroCurso.setBackground(new java.awt.Color(0, 204, 204));
        BtnRegistroCurso.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnRegistroCurso.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\Courses_35785.png")); // NOI18N
        BtnRegistroCurso.setText("Cursos");
        BtnRegistroCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRegistroCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistroCursoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Principal");
        jLabel1.setFocusCycleRoot(true);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnRegistroCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnGestorAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnGestorCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(BtnGestorNotas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEliminarTareas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAlumnos)
                    .addComponent(BtnGestorAlumnos))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGestorCursos)
                    .addComponent(BtnRegistroCurso))
                .addGap(43, 43, 43)
                .addComponent(BtnGestorNotas)
                .addGap(18, 18, 18)
                .addComponent(BtnEliminarTareas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGestorCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGestorCursosActionPerformed

        GestionCursos gestionCursos = new GestionCursos();
        gestionCursos.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_BtnGestorCursosActionPerformed

    private void BtnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlumnosActionPerformed

        RegistroAlumnos registroAlumnos = new RegistroAlumnos();
        registroAlumnos.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnAlumnosActionPerformed

    private void BtnGestorAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGestorAlumnosActionPerformed
        GestionAlumnos gestionAlumnos = new GestionAlumnos();
        gestionAlumnos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnGestorAlumnosActionPerformed

    private void BtnRegistroCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistroCursoActionPerformed
        RegistroCursos registroCursos = new RegistroCursos();
        registroCursos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnRegistroCursoActionPerformed

    private void BtnGestorNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGestorNotasActionPerformed
        GestionNotas gestionNotas = new GestionNotas();
        gestionNotas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnGestorNotasActionPerformed

    private void BtnEliminarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarTareasActionPerformed
        EliminarTareas eliminarTareas = new EliminarTareas();
        eliminarTareas.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnEliminarTareasActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlumnos;
    private javax.swing.JButton BtnEliminarTareas;
    private javax.swing.JButton BtnGestorAlumnos;
    private javax.swing.JButton BtnGestorCursos;
    private javax.swing.JButton BtnGestorNotas;
    private javax.swing.JButton BtnRegistroCurso;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
