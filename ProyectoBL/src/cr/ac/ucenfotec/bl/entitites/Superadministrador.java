package cr.ac.ucenfotec.bl.entitites;

public class Superadministrador extends Empleado {

    public Superadministrador(String correoElectronico, String contrasenia) {
        super(correoElectronico, contrasenia);
    }

    public Superadministrador(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int segSocial, String numFijo, String numMovil) {
        super(correoElectronico, contrasenia, nombre, apellidos, dni, segSocial, numFijo, numMovil);
    }

    @Override
    public String toString() {
        return super.toString() + "Superadministrador";
    }

}
