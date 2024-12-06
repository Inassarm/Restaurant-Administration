package cr.ac.ucenfotec.bl.entitites.Cocinero;

import cr.ac.ucenfotec.bl.entitites.Pinche.pinche;
import cr.ac.ucenfotec.bl.entitites.Plato.Plato;

import java.util.ArrayList;
public interface ICocineroDAO {

    String registrarCocinero(cocinero cocinero);

    String vincularPinche(pinche pinche, cocinero cocinero); // Added a closing parenthesis here

    ArrayList<cocinero> listarCocinero();

    String vincularPlato(Plato plato, cocinero cocineroTemp);
}