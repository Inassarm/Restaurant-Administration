package cr.ac.ucenfotec.bl.entitites.Pinche;

import cr.ac.ucenfotec.bl.entitites.Cocinero.cocinero;

import java.util.ArrayList;

public interface IPincheDAO {

    String registrarPinche(pinche pinche);



    ArrayList<pinche> listarPinche();
}