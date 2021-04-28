package vista;


import conexion.Conexion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jd_6
 */
public class InfoNotas extends javax.swing.JFrame {
    
    int idAlumno = 0;
    int idNota = 0;
    
    String nombreAlumno = "";

    public InfoNotas() {
        initComponents();
        
        cerrar();
        
        this.setLocationRelativeTo(null);
        
        txtNombreAlu.setEditable(false);
        
        idNota = InfoAlumnos.idNota;
        
        idAlumno = GestionAlumnos.idAlumno;
        
        try {
            
            PreparedStatement ps = cn.prepareStatement("SELECT nombre FROM alumnos WHERE id_alumno= '"+ idAlumno +"'");
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                nombreAlumno = rs.getString("nombre");
            }
         
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al consultar nombre alumno");
        }
        
        try {
            
            PreparedStatement ps = cn.prepareStatement("SELECT tarea,calificacion FROM notas WHERE id_nota= '"+idNota +"'");
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                txtTareaAlu.setText(rs.getString("tarea"));
                txtNotaALu.setText(rs.getString("calificacion"));
                
                
                        ;
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la información de notas");
        }
        
        txtNombreAlu.setText(nombreAlumno);
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID nota");
        modelo.addColumn("Tarea");
        modelo.addColumn("Nota");
        
        tablaInfoNotas.setModel(modelo);
        
        String sql = "SELECT id_nota,tarea,calificacion FROM notas WHERE id_alumno_nota= '"+idAlumno +"' ";
        
        String datos[] = new String[3];
        
        Statement st;
        
        try {
            
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                datos[0] = rs.getString("id_nota");
                datos[1] = rs.getString("tarea");
                datos[2] = rs.getString("calificacion");
                
                modelo.addRow(datos);
                
            }
            
            tablaInfoNotas.setModel(modelo);
        
        
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de notas");
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreAlu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTareaAlu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNotaALu = new javax.swing.JTextField();
        btaActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInfoNotas = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        jMenuItem1.setText("Borrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Información de notas");

        jLabel2.setText("Alumno:");

        jLabel3.setText("Tarea: ");

        txtTareaAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTareaAluActionPerformed(evt);
            }
        });

        jLabel4.setText("Nota:");

        btaActualizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\arrow_refresh_15732.png")); // NOI18N
        btaActualizar.setText("Actualizar");
        btaActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btaActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaActualizarActionPerformed(evt);
            }
        });

        tablaInfoNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaInfoNotas.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tablaInfoNotas);

        btnVolver.setIcon(new javax.swing.ImageIcon("C:\\Users\\jd_6\\Documents\\NetBeansProjects\\ProyectoEscuelaJD\\src\\main\\resources\\Imagenes\\arrow_left_icon_183068 (1).png")); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(txtNombreAlu)
                        .addComponent(txtTareaAlu)
                        .addComponent(jLabel4)
                        .addComponent(txtNotaALu, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addComponent(btaActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(298, 298, 298))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTareaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNotaALu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btaActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTareaAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTareaAluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTareaAluActionPerformed

    private void btaActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaActualizarActionPerformed
        try {
            
            if(txtTareaAlu.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null, "Campo tarea no puede estar vacio");
            }
            else if(txtNotaALu.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null, "Campo nota no puede estar vacio");
            }else{
                PreparedStatement ps = cn.prepareStatement("UPDATE notas SET tarea='"+txtTareaAlu.getText()+"', calificacion= '"+txtNotaALu.getText() +"' WHERE id_nota= '"+idNota +"'");
                int respuesta = ps.executeUpdate();
                
                if(respuesta>0){
                    
                    JOptionPane.showMessageDialog(null, "Datos actualizados ");
                }
            }       
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error al actualizar datos de notas ");
        }
    }//GEN-LAST:event_btaActualizarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            
            PreparedStatement ps = cn.prepareStatement("DELETE FROM notas WHERE id_nota='"+idNota+"'");
            int respuesta = ps.executeUpdate();
            
            if(respuesta>0){
                JOptionPane.showMessageDialog(null, "Datos borrados");
            
        }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado fila ");
                
            }
        } catch (SQLException e) {
            
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        InfoAlumnos infoAlumnos = new InfoAlumnos();
        
        infoAlumnos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(InfoNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btaActualizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaInfoNotas;
    private javax.swing.JTextField txtNombreAlu;
    private javax.swing.JTextField txtNotaALu;
    private javax.swing.JTextField txtTareaAlu;
    // End of variables declaration//GEN-END:variables

    Conexion con = new Conexion();
    Connection cn = con.getConnection();
}
