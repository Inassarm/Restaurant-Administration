package cr.ac.ucenfotec.bl.entitites;

public class Empleado extends Credencial {
    private String nombre;
    private String apellidos;
    private String dni;
    private int SegSocial;
    private String numFijo;
    private String numMovil;

    public Empleado(String correoElectronico, String contrasenia) {
        super(correoElectronico, contrasenia);
    }

    public Empleado(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int segSocial, String numFijo, String numMovil) {
        super(correoElectronico, contrasenia);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        SegSocial = segSocial;
        this.numFijo = numFijo;
        this.numMovil = numMovil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getSegSocial() {
        return SegSocial;
    }

    public void setSegSocial(int segSocial) {
        SegSocial = segSocial;
    }

    public String getNumFijo() {
        return numFijo;
    }

    public void setNumFijo(String numFijo) {
        this.numFijo = numFijo;
    }

    public String getNumMovil() {
        return numMovil;
    }

    public void setNumMovil(String numMovil) {
        this.numMovil = numMovil;
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado: " +
                "Nombre='" + nombre + '\'' +
                ", Apellidos='" + apellidos + '\'' +
                ", DNI='" + dni + '\'' +
                ", Número de Seguridad Social=" + SegSocial +
                ", Número Fijo='" + numFijo + '\'' +
                ", Número Movil='" + numMovil+" ";
    }
}
