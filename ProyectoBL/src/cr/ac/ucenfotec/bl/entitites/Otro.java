package cr.ac.ucenfotec.bl.entitites;

import java.util.Objects;

public class Otro extends Empleado{
    private String otroRol;


    public Otro(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int segSocial, String numFijo, String numMovil, String otroRol) {
        super(correoElectronico, contrasenia, nombre, apellidos, dni, segSocial, numFijo, numMovil);
        this.otroRol = otroRol;

    }

    public String getOtroRol() {
        return otroRol;
    }

    public void setOtroRol(String otroRol) {
        this.otroRol = otroRol;
    }

    public String toString() {
        return super.toString()+" Otro empleado" +
                "Rol asignado='" + otroRol+ " ";
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Otro otro = (Otro) o;
        return Objects.equals(otroRol, otro.otroRol);
    }

}
