package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entitites.Cocinero.ICocineroDAO;
import cr.ac.ucenfotec.bl.entitites.Cocinero.MySqlCocineroImpl;
import cr.ac.ucenfotec.bl.entitites.Cocinero.cocinero;
import cr.ac.ucenfotec.bl.entitites.Pinche.pinche;
import cr.ac.ucenfotec.bl.entitites.Plato.Plato;

import java.time.LocalDate;
import java.util.ArrayList;

public class CocineroGestor {

    private ICocineroDAO datos;
    private ArrayList<cocinero> listaCocinero;

    public CocineroGestor() {
        datos = new MySqlCocineroImpl();
        listaCocinero = datos.listarCocinero();
    }

    public ArrayList<cocinero> listarCocinero() {
        return datos.listarCocinero();
    }

    public String registrarCocinero(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int segSocial, String numFijo, String numMovil, int aniosServicio) {
        cocinero nuevoChef = new cocinero(correoElectronico, contrasenia, nombre, apellidos, dni, segSocial, numFijo, numMovil, aniosServicio);
        return datos.registrarCocinero(nuevoChef);
    }

    public String vincularPinche(String dni, pinche pinche) {
        cocinero cocineroTemp = buscarCocinero(dni);
        System.out.println("Cocinero encontrado: " + cocineroTemp);
        if (cocineroTemp != null) {
            cocineroTemp.vincularPinche(pinche);
            datos.vincularPinche(pinche, cocineroTemp);
            return "SE HA VINCULADO CON ÉXITO: El pinche " + pinche.getNombre() + " fue vinculado correctamente al cocinero  " + cocineroTemp.getDni();
        } else {
            return "No se encuentra registrado en el sistema! :( ";
        }
    }

    public String vincularPlato(String dni, Plato plato) {
        cocinero cocineroTemp = buscarCocinero(dni);
        System.out.println("Cocinero encontrado: " + cocineroTemp);
        if (cocineroTemp != null) {
            cocineroTemp.vincularPlato(plato);

            datos.vincularPlato(plato, cocineroTemp);
            return "SE HA VINCULADO CON ÉXITO: El plato " + plato.getPlato() + " fue vinculado correctamente al cocinero  " + cocineroTemp.getDni();
        } else {
            return "No se encuentra registrado en el sistema! :( ";
        }
    }

    public cocinero buscarCocinero(String dni) {
        for (cocinero busquedaCocinero : listaCocinero) {
            if (busquedaCocinero.getDni().equals(dni)) {
                return busquedaCocinero;
            }
        }
        return null;
    }
    public boolean buscarCredencialPorDni(String dni) {
        for (cocinero cocinero : listaCocinero) {
            if (cocinero.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }
    public boolean buscarCredenciales(String correoElectronico , String contrasenia) {
        for (cocinero cocinero : listaCocinero) {
            if (cocinero.getCorreoElectronico().equals(correoElectronico) && cocinero.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }


    public cocinero cocineroPorDni(String dni) {
        for (cocinero cocinero : listaCocinero) {
            if (cocinero.getDni().equals(dni)) {
                return cocinero;
            }
        }
        return null;
    }

    public ArrayList<String> mostrarDatosCocinero(cocinero cocinero) {
        ArrayList<String> infoCocinero = new ArrayList<>();
        if (cocinero != null) {
            System.out.println("***Informacion del empleado***");
            System.out.println(".....................................");
            infoCocinero.add("Correo electrónico: " + cocinero.getCorreoElectronico());
            infoCocinero.add("Contraseña: " + cocinero.getContrasenia());
            infoCocinero.add("Nombre: " + cocinero.getNombre());
            infoCocinero.add("Apellidos: " + cocinero.getApellidos());
            infoCocinero.add("DNI: " + cocinero.getDni());
            infoCocinero.add("Seguro Social: " + cocinero.getSegSocial());
            infoCocinero.add("Número fijo tel: " + cocinero.getNumFijo());
            infoCocinero.add("Número Móvil cel: " + cocinero.getNumMovil());
            infoCocinero.add("Años de servicio: " + cocinero.getAniosServicio());
            infoCocinero.add("Pinches asociados: " + cocinero.getListaDePinches());

            System.out.println(".....................................");

        } else {
            infoCocinero.add("No hay información registrada!.");
        }
        return infoCocinero;
    }
}

