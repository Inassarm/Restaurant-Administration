package cr.ac.ucenfotec.bl.entitites;

import cr.ac.ucenfotec.bl.entitites.Almacen.Almacen;
import cr.ac.ucenfotec.bl.entitites.Cocinero.cocinero;
import cr.ac.ucenfotec.bl.entitites.Pinche.pinche;

import java.time.LocalDate;
import java.util.ArrayList;

public class CL {
//private ArrayList<cocinero> listadoCocineros;
//    private ArrayList<pinche> listadoPinches;
//    private ArrayList<Otro> listadoOtros;
//    private ArrayList<Almacen> listadoAlmacenes;
//    private ArrayList<Estante> listadoEstantes;
//    private ArrayList<Ingrediente> listadoIngredientes;
//    private ArrayList<Empleado> listadoEmpleados;
//    private ArrayList<Credencial> listadoCredenciales;
//
//
//    public CL() {
//        listadoOtros = new ArrayList<>();
//        listadoCocineros = new ArrayList<>();
//        listadoPinches = new ArrayList<>();
//        listadoAlmacenes = new ArrayList<>();
//        listadoEstantes = new ArrayList<>();
//        listadoIngredientes = new ArrayList<>();
//        listadoCredenciales = new ArrayList<>();
//        listadoEmpleados = new ArrayList<>();
//
//    }
//
//
//    public String registrarCocinero(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int segSocial, String numFijo, String numMovil, int aniosServicio) {
//        cocinero cocinero = new cocinero(correoElectronico, contrasenia, nombre, apellidos, dni, segSocial, numFijo, numMovil, aniosServicio);
//        listadoCocineros.add(cocinero);
//        listadoEmpleados.add(cocinero);
//
//        return "Se ha registrado el cocinero " + cocinero.getNombre() + " con éxito!!!";
//    }
//
//    public String registrarPinche(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int segSocial, String numFijo, String numMovil, LocalDate fechaNacimiento) {
//        pinche pinche = new pinche(correoElectronico, contrasenia, nombre, apellidos, dni, segSocial, numFijo, numMovil, fechaNacimiento);
//        listadoPinches.add(pinche);
//        listadoEmpleados.add(pinche);
//
//        return "Se ha registrado el pinche " + pinche.getNombre() + " con éxito!!!";
//    }
//
//    public String registrarOtro(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int seguridadSocial, String numeroFijo, String numeroMovil, String otroRol) {
//        Otro otro = new Otro(correoElectronico, contrasenia, nombre, apellidos, dni, seguridadSocial, numeroFijo, numeroMovil, otroRol);
//        listadoOtros.add(otro);
//        listadoEmpleados.add(otro);
//
//        return "Se ha registrado el otro empleado " + otro.getNombre() + " con éxito!!!";
//    }
//
//    public String registrarAlmacen(String nombreAlmacen, int numAlmacen, String descripcion) {
//        Almacen almacen = new Almacen(nombreAlmacen, numAlmacen, descripcion);
//        listadoAlmacenes.add(almacen);
//
//        return "Se ha registrado el almacén " + almacen.getNombreAlmacen() + " con éxito!!!";
//
//    }
//
//    public String registrarEstante(int codigoEstante, double alto, double ancho, double profundidad) {
//        Estante estante = new Estante(codigoEstante, alto, ancho, profundidad);
//        listadoEstantes.add(estante);
//
//        return "Se ha registrado el estante " + estante.getCodigoEstante() + " con éxito!!!";
//    }
//
//    public String registrarIngrediente(String nombreIngrediente, double cantidad) {
//        Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidad);
//        listadoIngredientes.add(ingrediente);
//
//        return "Se ha registrado el ingrediente " + ingrediente.getNombreIngrediente() + " con éxito!!!";
//    }
//
//    public cocinero buscarCocinero(String dniCocinero) {
//        for (cocinero cocineroBuscado : listadoCocineros) {
//            if (cocineroBuscado.getDni().equals(dniCocinero)) {
//                return cocineroBuscado;
//            }
//
//        }
//        return null;
//    }
//
//    public pinche buscarPinche(String dniPinche) {
//        for (pinche pincheBuscado : listadoPinches) {
//            if (pincheBuscado.getDni().equals(dniPinche)) {
//                return pincheBuscado;
//            }
//
//        }
//        return null;
//    }
//
//    public String vincularPincheCocinero(String dniCocinero, String dniPinche) {
//        cocinero cocineroElegido = buscarCocinero(dniCocinero);
//        if (cocineroElegido != null) {
//            pinche pincheElegido = buscarPinche(dniPinche);
//            if (pincheElegido != null) {
//                cocineroElegido.vincularPinche(pincheElegido);
//                return "El pinche " + pincheElegido.getNombre() + " ha sido vinculado correctamente al cocinero " + cocineroElegido.getNombre();
//            }
//            return "El pinche no se encuentra registrado en el sistema";
//        }
//        return "El cocinero no se encuentra en el sistema";
//    }
//
//
//    public ArrayList<String> listarCocineros() {
//        ArrayList<String> datosCocineros = new ArrayList<>();
//        for (cocinero cocineroTemp : listadoCocineros) {
//            datosCocineros.add(cocineroTemp.toString());
//        }
//        return datosCocineros;
//    }
//
//    public ArrayList<String> listarPinches() {
//        ArrayList<String> datosPinches = new ArrayList<>();
//        for (pinche pincheTemp : listadoPinches) {
//            datosPinches.add(pincheTemp.toString());
//        }
//        return datosPinches;
//    }
//
//    public ArrayList<String> listarOtros() {
//        ArrayList<String> datosOtros = new ArrayList<>();
//        for (Otro otroTemp : listadoOtros) {
//            datosOtros.add(otroTemp.toString());
//        }
//        return datosOtros;
//    }
//
//    public boolean buscarCredencialPorDni(String dni) {
//        for (Empleado empleado : listadoEmpleados) {
//            if (empleado.getDni().equals(dni)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean buscarCredenciales(String correoElectronico , String contrasenia) {
//        for (Empleado empleado : listadoEmpleados) {
//            if (empleado.getCorreoElectronico().equals(correoElectronico) && empleado.getContrasenia().equals(contrasenia)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public Empleado empleadoPorDni(String dni) {
//        for (Empleado empleado : listadoEmpleados) {
//            if (empleado.getDni().equals(dni)) {
//                return empleado;
//            }
//        }
//        return null;
//    }
//
//    public ArrayList<String> mostrarDatosEmpleado(Empleado empleado) {
//        ArrayList<String> infoEmpleado = new ArrayList<>();
//        if (empleado != null) {
//            System.out.println("***Información del empleado***");
//            System.out.println(".....................................");
//            infoEmpleado.add("Nombre: " + empleado.getNombre());
//            infoEmpleado.add("Apellido: " + empleado.getApellidos());
//            infoEmpleado.add("DNI: " + empleado.getDni());
//            infoEmpleado.add("Número de Seguridad Social: " + empleado.getSegSocial());
//            infoEmpleado.add("Número de teléfono fijo: " + empleado.getNumFijo());
//            infoEmpleado.add("Número de teléfono Móvil: " + empleado.getNumMovil());
//            System.out.println(".....................................");
//
//        } else {
//            infoEmpleado.add("No hay información.");
//        }
//        return infoEmpleado;
//    }
//}
}



