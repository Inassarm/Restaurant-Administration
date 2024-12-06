package cr.ac.ucenfotec.bl.entitites.Ingrediente;

import cr.ac.ucenfotec.bl.entitites.Pinche.pinche;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlIngredienteImpl  implements IIngredienteDAO {

    private String query;

    public String registrarIngrediente(Ingrediente Ingrediente) {
        query = "INSERT INTO INGREDIENTE VALUES(" + Ingrediente.getIdIngrediente() + ", '" + Ingrediente.getNombreIngrediente() + "'," + Ingrediente.getCantidad() + ")";
        Conector.getConnector().ejecutarSQL(query);

        return "El ingrediente con el  " + Ingrediente.getIdIngrediente() + " se ha registrado correctamente";

    }

    public ArrayList<Ingrediente> listarIngrediente() {
        ArrayList<Ingrediente> listaIngrediente = new ArrayList<>();
        try {
            String sql = "SELECT I.IDINGREDIENTE, I.NOMBREINGREDIENTE, I.CANTIDAD "
                    + "FROM INGREDIENTE I";
            ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
            while (rs.next()) {
                Ingrediente ingredienteEncontrado = new Ingrediente(rs.getString("IDINGREDIENTE"),
                        rs.getString("NOMBREINGREDIENTE"),
                        rs.getDouble("CANTIDAD"));
                listaIngrediente.add(ingredienteEncontrado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaIngrediente;
    }
}
