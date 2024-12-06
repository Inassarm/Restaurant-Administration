package cr.ac.ucenfotec.bl.entitites.Cocinero;
import cr.ac.ucenfotec.bl.entitites.Plato.Plato;
import cr.ac.ucenfotec.bl.entitites.Empleado;
import cr.ac.ucenfotec.bl.entitites.Pinche.pinche;

import java.util.ArrayList;
import java.util.Objects;

public class cocinero extends Empleado {
    private int aniosServicio;
    private ArrayList<pinche> listaDePinches;
    private ArrayList <Plato> listaDePlatos;


    public cocinero(String correoElectronico, String contrasenia, String nombre, String apellidos, String dni, int segSocial, String numFijo, String numMovil, int aniosServicio) {
        super(correoElectronico, contrasenia, nombre, apellidos, dni, segSocial, numFijo, numMovil);
        this.aniosServicio = aniosServicio;
        this.listaDePinches = new ArrayList<>();
        this.listaDePlatos = new ArrayList<>();
    }

    public int getAniosServicio() {
        return aniosServicio;
    }

    public void setAniosServicio(int aniosServicio) {
        this.aniosServicio = aniosServicio;
    }

    public ArrayList<pinche> getListaDePinches() {
        return listaDePinches;
    }

    public void setListaDePinches(ArrayList<pinche> listaDePinches) {
        this.listaDePinches = listaDePinches;
    }

    public ArrayList<Plato> getListaDePlatos() {
        return listaDePlatos;
    }

    public void setListaDePlatos(ArrayList<Plato> listaDePlatos) {
        this.listaDePlatos = listaDePlatos;
    }

    public void vincularPinche(pinche pinche){
        listaDePinches.add(pinche);

    }

    public void vincularPlato(Plato plato){
        listaDePlatos.add(plato);

    }

    public String toString() {
        return super.toString()+" Cocinero: " +
                "Años de servicio=" + aniosServicio +
                " lista de Pinches=" + listaDePinches +
                " lista de platos= " + listaDePlatos;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        cocinero cocinero = (cocinero) o;
        return aniosServicio == cocinero.aniosServicio && Objects.equals(listaDePinches, cocinero.listaDePinches) && Objects.equals(listaDePlatos, cocinero.listaDePlatos);
    }

}

