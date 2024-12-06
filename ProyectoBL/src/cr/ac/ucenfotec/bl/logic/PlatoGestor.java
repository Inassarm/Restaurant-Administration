package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entitites.Ingrediente.Ingrediente;
import cr.ac.ucenfotec.bl.entitites.Plato.IPlatoDAO;
import cr.ac.ucenfotec.bl.entitites.Plato.MySqlPlatoImpl;
import cr.ac.ucenfotec.bl.entitites.Plato.Plato;

import java.util.ArrayList;

public class PlatoGestor {
    private IPlatoDAO datos;

    private ArrayList<Plato> listaPlatos;

    public PlatoGestor() {
        datos = new MySqlPlatoImpl();

        listaPlatos = datos.enlistarPlato();

    }

    public String registrarPlato(String idPlato, String plato, Double precio, String clasificacion) {
        Plato Plato = new Plato(idPlato, plato, precio, clasificacion);
        return datos.registrarPlato(Plato);
    }

    public ArrayList<Plato> enlistarPlato(){
        return datos.enlistarPlato();
    }

    public ArrayList<Plato> listadoPlato(int ID){
        return datos.listadoPlato(ID);
    }

    public String vincularIngrediente(String idPlato, Ingrediente ingrediente) {
        Plato plato = buscarPlato(idPlato);
        System.out.println("Plato encontrado: " + plato);
        if (plato != null) {
            plato.vincularIngrediente(ingrediente);
            datos.vincularIngrediente(ingrediente, plato);
            return "SE HA VINCULADO CON ÉXITO: El ingrediente " + ingrediente.getNombreIngrediente() + " fue vinculado correctamente al plato # " + plato.getIdPlato();
        } else {
            return "El plato con el ID " + idPlato + " no se encuentra registrada en el sistema.";
        }
    }


    public Plato buscarPlato(String idPlato) {
        for (Plato busquedaPlato : listaPlatos) {
            if (busquedaPlato.getIdPlato().equals(idPlato)) {
                return busquedaPlato;
            }
        }
        return null;
    }
}
