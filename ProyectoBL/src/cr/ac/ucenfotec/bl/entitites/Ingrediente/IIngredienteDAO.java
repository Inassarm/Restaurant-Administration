package cr.ac.ucenfotec.bl.entitites.Ingrediente;

import java.util.ArrayList;

public interface IIngredienteDAO {

    String registrarIngrediente (Ingrediente ingrediente);
    ArrayList<Ingrediente> listarIngrediente();
}
