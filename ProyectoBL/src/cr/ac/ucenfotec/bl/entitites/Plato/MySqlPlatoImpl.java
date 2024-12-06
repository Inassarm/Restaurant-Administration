package cr.ac.ucenfotec.bl.entitites.Plato;

import cr.ac.ucenfotec.bl.entitites.Ingrediente.Ingrediente;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlPlatoImpl implements IPlatoDAO {
    private String query;

    public String registrarPlato(Plato plato) {
        query = "INSERT INTO PLATO VALUES('" + plato.getIdPlato() + "', '" + plato.getPlato() + "'," + plato.getPrecio() + ",'" + plato.getClasificacion() + "')";
        Conector.getConnector().ejecutarSQL(query);

        return "El plato con el ID  " + plato.getIdPlato() + " se ha registrado correctamente";

    }

    public ArrayList<Plato> enlistarPlato() {
        ArrayList<Plato> listaPlatos = new ArrayList<>();
        try {
            String sql = "SELECT IDPLATO, PLATO, PRECIO, CLASIFICACION FROM PLATO";
            ResultSet rsPlato = Conector.getConnector().ejecutarQuery(sql);

            while (rsPlato.next()) {
                Plato platoEncontrado = new Plato(
                        rsPlato.getString("IDPLATO"),
                        rsPlato.getString("PLATO"),
                        rsPlato.getDouble("PRECIO"),
                        rsPlato.getString("CLASIFICACION")

                );
                sql = "SELECT I.IDINGREDIENTE, I.NOMBREINGREDIENTE, I.CANTIDAD" +
                        " FROM PLATO_INGREDIENTE PI INNER JOIN INGREDIENTE I ON PI.FK_IDINGREDIENTE = I.IDINGREDIENTE" +
                        " WHERE PI.FK_IDPLATO = " + platoEncontrado.getIdPlato();



                ResultSet rsIngrediente = Conector.getConnector().ejecutarQuery(sql);
                while (rsIngrediente.next()) {
                    Ingrediente ingredienteEncontrado = new Ingrediente(
                            rsIngrediente.getString("IDINGREDIENTE"),
                            rsIngrediente.getString("NOMBREINGREDIENTE"),
                            rsIngrediente.getDouble("CANTIDAD")

                    );

                    platoEncontrado.vincularIngrediente(ingredienteEncontrado);
                }

                listaPlatos.add(platoEncontrado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPlatos;
    }

    public String vincularIngrediente(Ingrediente ingrediente, Plato plato) {
        String mensaje;
        try {
            // Verificar si el plato e ingrediente son válidos
            if (plato == null || ingrediente == null) {
                return "Error: El plato o el ingrediente no son válidos.";
            }

            // Construir la consulta SQL para insertar el vínculo en la tabla intermedia
            String sqlInsertar = "INSERT INTO PLATO_INGREDIENTE (FK_IDPLATO, FK_IDINGREDIENTE) VALUES (?, ?)";
            PreparedStatement pstmtInsertar = Conector.getConnector().prepareStatement(sqlInsertar);
            pstmtInsertar.setString(1, plato.getIdPlato());
            pstmtInsertar.setString(2, ingrediente.getIdIngrediente());
            pstmtInsertar.executeUpdate();
            pstmtInsertar.close();

            // Actualizar la cantidad disponible del ingrediente
            double cantidadUtilizada = 1;
            double nuevaCantidad = ingrediente.getCantidad() - cantidadUtilizada;
            if (nuevaCantidad < 0) {
                return "Error: No hay suficiente cantidad del ingrediente disponible.";
            }

            String sqlActualizar = "UPDATE INGREDIENTE SET CANTIDAD = ? WHERE IDINGREDIENTE = ?";
            PreparedStatement pstmtActualizar = Conector.getConnector().prepareStatement(sqlActualizar);
            pstmtActualizar.setDouble(1, nuevaCantidad);
            pstmtActualizar.setString(2, ingrediente.getIdIngrediente());
            pstmtActualizar.executeUpdate();
            pstmtActualizar.close();

            mensaje = "El ingrediente " + ingrediente.getNombreIngrediente() + " fue vinculado correctamente al plato con el código " + plato.getIdPlato();
        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al vincular el plato con el ingrediente: " + e.getMessage();
        }

        return mensaje;
    }




    public ArrayList<Plato> listadoPlato(int ID) {
        ArrayList<Plato> listaPlatos = new ArrayList<>();
        try {
            String sql = "SELECT P.IDPLATO, P.PLATO, P.PRECIO, P.CLASIFICACION " +
                    "FROM COCINERO_PLATO CP INNER JOIN PLATO P ON CP.FK_DNIPLATO = P.IDPLATO " +
                    "WHERE CP.FK_DNICOCINERO = ?";
            PreparedStatement statement = Conector.getConnector().prepareStatement(sql);
            statement.setInt(1, ID);

            ResultSet rsPlato = statement.executeQuery();

            while (rsPlato.next()) {
                Plato platoEncontrado = new Plato(
                        rsPlato.getString("IDPLATO"),
                        rsPlato.getString("PLATO"),
                        rsPlato.getDouble("PRECIO"),
                        rsPlato.getString("CLASIFICACION")
                );
                listaPlatos.add(platoEncontrado);
            }
            rsPlato.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPlatos;
    }



}



