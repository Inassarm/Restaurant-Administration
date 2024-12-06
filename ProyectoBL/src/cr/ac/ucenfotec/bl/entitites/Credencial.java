package cr.ac.ucenfotec.bl.entitites;

import java.util.Objects;

public class Credencial {

    private String correoElectronico;
    private String contrasenia;

    public Credencial() {
    }

    public Credencial(String correoElectronico, String contrasenia) {
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


    public String toString() {
        return " Credenciales: " +
                "Correo Electronico='" + correoElectronico + '\'' +
                ", Contraseña='" + contrasenia+" ";
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credencial that = (Credencial) o;
        return Objects.equals(correoElectronico, that.correoElectronico) && Objects.equals(contrasenia, that.contrasenia);
    }

}
