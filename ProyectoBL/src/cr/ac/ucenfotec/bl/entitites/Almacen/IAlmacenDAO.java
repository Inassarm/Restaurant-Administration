package cr.ac.ucenfotec.bl.entitites.Almacen;


import cr.ac.ucenfotec.bl.entitites.Estante.Estante;

import java.util.ArrayList;

public interface IAlmacenDAO {
    String registrarAlmacen(Almacen almacen);


    ArrayList<Almacen> listarAlmacenes();


    String registrarEstante(Almacen Almacen, Estante Estante);

    String eliminarAlmacen(int numAlmacen);


    String modificarDatosAlmacen(int numAlmacen, String nuevoNombreAlmacen, String nuevaDescripcion);


    void modificarAlmacen(Almacen almacen);

    void modificarEstante(Estante estante);

    String eliminarEstante(int codigoEstante);
}
