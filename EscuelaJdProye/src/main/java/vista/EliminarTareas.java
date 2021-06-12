package vista;

import conexion.Conexion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author jd_6
 */
public class EliminarTareas extends javax.swing.JFrame {

    /**
     * Eliminar tareas elimina todos los registros de notas y tareas de un alumno
     */
    
    public EliminarTareas() {
        initComponents();
        this.setLocationRelativeTo(null);
        cerrar();
    }
    
    /**
     * Cerrar se encarga de dar aviso al usuario que cerrará la aplicación con un mensaje.
     */
    
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
        btnEliminarTodo = new javax.swing.JButton();
        BtnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Eliminar todas las tareas");

        btnEliminarTodo.setText("Eliminar todas las tareas");
        btnEliminarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTodoActionPerformed(evt);
            }
        });

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
                .addGap(244, 244, 244)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(237, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVolver)
                .addGap(326, 326, 326))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(btnEliminarTodo)
                .addGap(34, 34, 34)
                .addComponent(BtnVolver)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void btnEliminarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTodoActionPerformed
        try {
            
            int valor = JOptionPane.showConfirmDialog(this,"¿Desea borrar de forma permanente las tareas de los alumnos ?", "Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            
            if(valor == JOptionPane.YES_OPTION){
                
                PreparedStatement ps = cn.prepareStatement("TRUNCATE TABLE notas ");
                
                ps.execute();
                ps.close();
                
                JOptionPane.showMessageDialog(null, "Ha eliminado todas las tareas de forma correcta ", "", JOptionPane.INFORMATION_MESSAGE);
                                
            }
           
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al eliminar todas las tareas");
        }
                
    }//GEN-LAST:event_btnEliminarTodoActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarTareas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVolver;
    private javax.swing.JButton btnEliminarTodo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    Conexion con = new Conexion();
    Connection cn = con.getConnection();
}
