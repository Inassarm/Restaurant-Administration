package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entitites.Cocinero.cocinero;
import cr.ac.ucenfotec.bl.entitites.Pinche.IPincheDAO;
import cr.ac.ucenfotec.bl.entitites.Pinche.MySqlPincheImpl;
import cr.ac.ucenfotec.bl.entitites.Pinche.pinche;

import java.time.LocalDate;
import java.util.ArrayList;

public class PincheGestor{
    private IPincheDAO datos;
    private ArrayList<pinche> listaPinches;


    public PincheGestor() {
        datos = new MySqlPincheImpl();
        listaPinches = datos.listarPinche();
    }

    public ArrayList<pinche> listarPinche(){
        return datos.listarPinche();
    }

    public String registrarPinche(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int segSocial, String numFijo, String numMovil, LocalDate fechaNacimiento) {
        pinche nuevoPinche = new pinche(correoElectronico, contrasenia, nombre, apellidos, dni, segSocial, numFijo, numMovil, fechaNacimiento);
        return datos.registrarPinche(nuevoPinche);

    }

    public pinche buscarPinche(String dni) {
        for (pinche busquedaPinche : listaPinches) {
            if (busquedaPinche.getDni().equals(dni)) {
                return busquedaPinche;
            }
        }
        return null;
    }

    public boolean buscarCredencialPorDni(String dni) {
        for (pinche pinche : listaPinches) {
            if (pinche.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }
    public boolean buscarCredenciales(String correoElectronico , String contrasenia) {
        for (pinche pinche : listaPinches) {
            if (pinche.getCorreoElectronico().equals(correoElectronico) && pinche.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }


    public pinche pinchePorDni(String dni) {
        for (pinche pinche : listaPinches) {
            if (pinche.getDni().equals(dni)) {
                return pinche;
            }
        }
        return null;
    }

    public ArrayList<String> mostrarDatosPinche(pinche pinche) {
        ArrayList<String> infoPinche = new ArrayList<>();
        if (pinche != null) {
            System.out.println("***Informacion del empleado***");
            System.out.println(".....................................");
            infoPinche.add("Correo electrónico: " + pinche.getCorreoElectronico());
            infoPinche.add("Contraseña: " + pinche.getContrasenia());
            infoPinche.add("Nombre: " + pinche.getNombre());
            infoPinche.add("Apellidos: " + pinche.getApellidos());
            infoPinche.add("DNI: " + pinche.getDni());
            infoPinche.add("Seguro Social: " + pinche.getSegSocial());
            infoPinche.add("Número fijo tel: " + pinche.getNumFijo());
            infoPinche.add("Número Móvil cel: " + pinche.getNumMovil());
            infoPinche.add("Fecha Nacimiento: " + pinche.getFechaNacimiento());

            System.out.println(".....................................");

        } else {
            infoPinche.add("No hay información registrada!.");
        }
        return infoPinche;
    }

}

