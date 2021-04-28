package modelo;

/**
 *La clase usuario genera los parametros de un usuario con sus getter y setter para los llamados desde otra clase.
 * @author jd_6
 */
public class Usuarios {
    
    /**
     * @param id crea un entero con el parametro id de usuario
     * @param usuario crea un String con el valor de nombre de usuario
     * @param contrasenia genera la contraseña ingresada por el usuario para el registro
     * @param tipo_nivel identifica el tipo de usuario si es administrador, alumno o profesor
     */
    private int id;
    private String usuario;
    private String contrasenia;
    private String tipo_nivel;

    public String getTipo_nivel() {
        return tipo_nivel;
    }

    public void setTipo_nivel(String tipo_nivel) {
        this.tipo_nivel = tipo_nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
}
