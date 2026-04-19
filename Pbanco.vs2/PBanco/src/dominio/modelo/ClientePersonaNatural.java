package dominio.modelo;

public class ClientePersonaNatural {

    private String nombreCompleto;
    private String identificacion;
    private String correo;
    private String telefono;
    private String fechaNacimiento;
    private String direccion;

    public ClientePersonaNatural() {}

    public ClientePersonaNatural(String nombreCompleto, String identificacion, String correo, String telefono, String fechaNacimiento, String direccion) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public String getIdentificacion() { return identificacion; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getDireccion() { return direccion; }
}