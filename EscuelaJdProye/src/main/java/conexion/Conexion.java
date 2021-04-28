package conexion;

import java.sql.*;

/**
 *Esta clase permite hacer la conexion a la base de datos proyectojd
 * @author jd_6
 */
public class Conexion {

    Connection con;

   
    public Conexion() {
        
        
        /**
         * Permite hacer la conexion a la base de datos del proyecto, ingresndo las credenciales de mysql
         * @param url obtiene la url de la base de datos de nuestro proyecto
         * @param user contiene el usuario de nuestra conexion sql
         * @param password contiene la contraseña de nuestra conexion sql
         * 
         */
        String url = "jdbc:mysql://localhost:3306/proyectojd";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion establecida con exito " +
                    "" + url);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }

}

