package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entitites.Ingrediente.IIngredienteDAO;
import cr.ac.ucenfotec.bl.entitites.Ingrediente.Ingrediente;
import cr.ac.ucenfotec.bl.entitites.Ingrediente.MySqlIngredienteImpl;
import cr.ac.ucenfotec.bl.entitites.Pinche.pinche;

import java.time.LocalDate;
import java.util.ArrayList;

public class IngredienteGestor {
    private IIngredienteDAO datos;
    private ArrayList<Ingrediente> listaIngrediente;


    public IngredienteGestor() {
        datos = new MySqlIngredienteImpl();
        listaIngrediente = datos.listarIngrediente();
    }

    public String registrarIngrediente(String idIngrediente, String nombreIngrediente, double cantidad) {
        Ingrediente ingredienteNuevo = new Ingrediente(idIngrediente, nombreIngrediente, cantidad);
        return datos.registrarIngrediente(ingredienteNuevo);

    }

    public ArrayList<Ingrediente> listarIngrediente(){
        return datos.listarIngrediente();
    }

    public Ingrediente buscarIngrediente(String idIngrediente) {
        for (Ingrediente busquedaIngrediente : listaIngrediente) {
            if (busquedaIngrediente.getIdIngrediente().equals(idIngrediente)) {
                return busquedaIngrediente;
            }
        }
        return null;
    }
}
