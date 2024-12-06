package cr.ac.ucenfotec.bl.entitites.Estante;

import cr.ac.ucenfotec.bl.entitites.Cocinero.cocinero;

import java.util.ArrayList;

public interface IEstanteDAO {
    String registrarEstante(Estante estante);


    ArrayList<Estante> listarEstante();
}
