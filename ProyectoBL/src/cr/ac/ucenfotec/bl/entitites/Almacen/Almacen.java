package cr.ac.ucenfotec.bl.entitites.Almacen;

import cr.ac.ucenfotec.bl.entitites.Estante.Estante;


import java.util.ArrayList;
import java.util.Objects;

public class Almacen {
    private int numAlmacen;
    private String nombreAlmacen;
    private String descripcion;
    private ArrayList<Estante> listaDeEstantes;

    public Almacen() {
        listaDeEstantes = new ArrayList<>();
    }

    public Almacen(int numAlmacen, String nombreAlmacen, String descripcion) {
        this.numAlmacen = numAlmacen;
        this.nombreAlmacen = nombreAlmacen;
        this.descripcion = descripcion;
        this.listaDeEstantes = new ArrayList<>();
    }

    public int getNumAlmacen() {
        return numAlmacen;
    }

    public void setNumAlmacen(int numAlmacen) {
        this.numAlmacen = numAlmacen;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Estante> getListaDeEstantes() {
        return listaDeEstantes;
    }

    public void setListaDeEstantes(ArrayList<Estante> listaDeEstantes) {
        this.listaDeEstantes = listaDeEstantes;
    }

    public void asignarEstante(int codigoEstante, double alto, double ancho, double profundidad) {
        Estante nuevoEstante= new Estante(codigoEstante, alto, ancho, profundidad);
        listaDeEstantes.add(nuevoEstante);
    }

    public String toString() {
        String info =
                "Número de almacen: " + numAlmacen + "," + " Nombre del almacen: " + nombreAlmacen + "," + " Descripción del almacen: "+ descripcion + "\n";
        info += "*** Estantes ***\n";
        for (Estante estante: listaDeEstantes) {
            info += estante.toString() + "\n";
            for (Estante Estante : listaDeEstantes) {
                info += "Número de almacen: " + numAlmacen + "\n";
                ;
            }
        }
        return info;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Almacen almacen = (Almacen) o;
        return numAlmacen == almacen.numAlmacen && Objects.equals(nombreAlmacen, almacen.nombreAlmacen) && Objects.equals(descripcion, almacen.descripcion);
    }

}
