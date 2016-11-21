package py.gov.asuncion.demopf.modelo.negocio;
// Generated 18/11/2016 11:08:05 by Hibernate Tools 4.3.1

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

    private int id;
    private Rol rol;
    private String usuario;
    private String contrasenia;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private short edad;
    private String correo;
    private String direccion;

    public Usuario() {
    }

    public Usuario(int id, Rol rol, String usuario, String contrasenia, String nombre, String apellidoPaterno, short edad, String correo, String direccion) {
        this.id = id;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Usuario(int id, Rol rol, String usuario, String contrasenia, String nombre, String apellidoPaterno, String apellidoMaterno, short edad, String correo, String direccion) {
        this.id = id;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
