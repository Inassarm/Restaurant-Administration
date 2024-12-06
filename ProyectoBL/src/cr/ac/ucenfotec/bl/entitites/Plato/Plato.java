package cr.ac.ucenfotec.bl.entitites.Plato;

import cr.ac.ucenfotec.bl.entitites.Estante.Estante;
import cr.ac.ucenfotec.bl.entitites.Ingrediente.Ingrediente;
import java.util.ArrayList;
import java.util.Objects;

public class Plato {
    private String idPlato;
    private String plato;
    private double precio;
    private String clasificacion;
    private ArrayList<Ingrediente> listaIngredientes;

    public Plato() {
        listaIngredientes = new ArrayList<>();
    }

    public Plato(String idPlato, String plato, double precio, String clasificacion) {
        this.idPlato = idPlato;
        this.plato = plato;
        this.precio = precio;
        this.clasificacion = clasificacion;
        this.listaIngredientes = new ArrayList<>();
    }

    public ArrayList<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public String getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(String idPlato) {
        this.idPlato = idPlato;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void vincularIngrediente(Ingrediente ingrediente) {
        listaIngredientes.add(ingrediente);
    }

    public String toString() {
        return "Plato= " +
                "ID del Plato='" + idPlato + '\'' +
                ", Plato='" + plato + '\'' +
                ", Precio=" + precio +
                ", Clasificacion='" + clasificacion + '\'' +
                ", Lista de Ingredientes=" + listaIngredientes;
    }


}
