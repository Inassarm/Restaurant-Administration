package cr.ac.ucenfotec.bl.entitites.Ingrediente;

import cr.ac.ucenfotec.bl.entitites.Plato.Plato;

import java.util.Objects;

public class Ingrediente {
    private String idIngrediente;
    private String nombreIngrediente;
    private double cantidad;



    public Ingrediente() {
    }

    public Ingrediente(String idIngrediente, String nombreIngrediente, double cantidad) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.cantidad = cantidad;

    }

    public String getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "nombreIngrediente='" + nombreIngrediente + '\'' +
                ", cantidad=" + cantidad;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingrediente that = (Ingrediente) o;
        return Double.compare(cantidad, that.cantidad) == 0 && Objects.equals(nombreIngrediente, that.nombreIngrediente);
    }

}
