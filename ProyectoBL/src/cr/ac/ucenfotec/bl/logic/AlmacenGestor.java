package cr.ac.ucenfotec.bl.logic;
import cr.ac.ucenfotec.bl.entitites.Almacen.Almacen;
import cr.ac.ucenfotec.bl.entitites.Almacen.IAlmacenDAO;
import cr.ac.ucenfotec.bl.entitites.Almacen.MySqlAlmacenImpl;
import cr.ac.ucenfotec.bl.entitites.Estante.Estante;

import java.util.ArrayList;

public class AlmacenGestor {
    private IAlmacenDAO datos;
    private ArrayList<Almacen> listaAlmacenes;


    public AlmacenGestor() {
        datos = new MySqlAlmacenImpl();
        listaAlmacenes = datos.listarAlmacenes();
    }

    public String registrarAlmacen(int numAlmacen, String nombreAlmacen, String descripcion) {
        Almacen almacenNuevo = new Almacen(numAlmacen, nombreAlmacen, descripcion);
        String resultado = datos.registrarAlmacen(almacenNuevo);
        if (resultado.equals("Almacén registrado correctamente")) {
            listaAlmacenes.add(almacenNuevo); // Agregar el nuevo almacén a la lista
        }
        return resultado;
    }
    public ArrayList<Almacen> listarAlmacenes(){
        return datos.listarAlmacenes();
    }
    public Almacen buscarAlmacen(int numAlmacen) {
        for (Almacen busquedaAlmacen : listaAlmacenes) {
            if (busquedaAlmacen.getNumAlmacen() == numAlmacen) {

                return busquedaAlmacen;
            }
        }
        return null;
    }

    public String registrarEstante(int codigoEstante, double alto, double ancho, double profundidad, int numAlmacen){
        ArrayList<Almacen> listaAlmacenes = datos.listarAlmacenes();
        Almacen almacenElegido = new Almacen();
        almacenElegido = buscarAlmacen(numAlmacen); //Esto fue
        int pos = listaAlmacenes.indexOf(almacenElegido);

        if(pos >=0){
            almacenElegido = listaAlmacenes.get(pos);
            Estante nuevoEstante = new Estante(codigoEstante, alto, ancho, profundidad);
            System.out.println(nuevoEstante);
            return datos.registrarEstante(almacenElegido,nuevoEstante);

        }

        return "El almacen "+numAlmacen + ", no está dentro del sistema :( ";
    }

    public String eliminarAlmacen(int numAlmacen) {
        try {
            Almacen almacenEliminado = new Almacen(numAlmacen, "", "");

            // Llamar al método correspondiente en la interfaz IAlmacenDAO
            return datos.eliminarAlmacen(numAlmacen);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el almacén: " + e.getMessage();
        }
    }
    public String eliminarEstante(int codigoEstante) {
        try {
            Estante estanteEliminado = new Estante(codigoEstante, 0.0, 0.0, 0.0);

            return datos.eliminarEstante(codigoEstante);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el estante: " + e.getMessage();
        }
    }

    public void modificarAlmacen(Almacen almacen) {
            datos.modificarAlmacen(almacen);
        }

    public void modificarEstante(Estante estante) {
        datos.modificarEstante(estante);
    }
}




