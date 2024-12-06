package cr.ac.ucenfotec.bl.entitites.Pinche;

import cr.ac.ucenfotec.bl.entitites.Empleado;

import java.time.LocalDate;
import java.util.Objects;

public class pinche extends Empleado {
    private LocalDate fechaNacimiento;


    public pinche(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int segSocial, String numFijo, String numMovil, LocalDate fechaNacimiento) {
        super(correoElectronico, contrasenia, nombre, apellidos, dni, segSocial, numFijo, numMovil);
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String toString() {
        return super.toString()+ " Pinche:" +
                "Fecha de Nacimiento=" + fechaNacimiento + " ";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pinche pinche = (cr.ac.ucenfotec.bl.entitites.Pinche.pinche) o;
        return Objects.equals(fechaNacimiento, pinche.fechaNacimiento);
    }

}