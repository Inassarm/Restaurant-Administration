package cr.ac.ucenfotec.bl.entitites.Plato;

import cr.ac.ucenfotec.bl.entitites.Ingrediente.Ingrediente;

import java.util.ArrayList;

public interface IPlatoDAO {
    String registrarPlato(Plato plato);

    ArrayList<Plato> enlistarPlato();

    String vincularIngrediente(Ingrediente ingrediente, Plato plato);

    ArrayList<Plato> listadoPlato(int ID);
}
