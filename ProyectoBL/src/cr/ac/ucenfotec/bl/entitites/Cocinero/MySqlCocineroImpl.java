package cr.ac.ucenfotec.bl.entitites.Cocinero;

import cr.ac.ucenfotec.bl.entitites.Pinche.pinche;
import cr.ac.ucenfotec.bl.entitites.Plato.Plato;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlCocineroImpl implements ICocineroDAO {

    private String query;

    public String registrarCocinero(cocinero cocinero) {
        query = "INSERT INTO COCINERO VALUES('" + cocinero.getCorreoElectronico() + "','" + cocinero.getContrasenia() + "', '" + cocinero.getNombre() + "','" + cocinero.getApellidos() + "','" + cocinero.getDni() + "', " + cocinero.getSegSocial() + ", '" + cocinero.getNumFijo() + "','" + cocinero.getNumMovil() + "'," + cocinero.getAniosServicio() + ")";
        Conector.getConnector().ejecutarSQL(query);

        return "El cocinero con DNI " + cocinero.getDni() + ", se ha registrado correctamente!";
    }


    public ArrayList<cocinero> listarCocinero() {
        ArrayList<cocinero> listaCocinero = new ArrayList<>();
        try {
            String sql = "SELECT CORREOELECTRONICO, CONTRASENIA, NOMBRE, APELLIDOS, IDCOCINERO, SEGSOCIAL, NUMFIJO, NUMMOVIL, ANIOSSERVICIO FROM COCINERO";
            ResultSet rsCocinero = Conector.getConnector().ejecutarQuery(sql);

            while (rsCocinero.next()) {
                cocinero cocineroEncontrado = new cocinero(
                        rsCocinero.getString("CORREOELECTRONICO"),
                        rsCocinero.getString("CONTRASENIA"),
                        rsCocinero.getString("NOMBRE"),
                        rsCocinero.getString("APELLIDOS"),
                        rsCocinero.getString("IDCOCINERO"),
                        rsCocinero.getInt("SEGSOCIAL"),
                        rsCocinero.getString("NUMFIJO"),
                        rsCocinero.getString("NUMMOVIL"),
                        rsCocinero.getInt("ANIOSSERVICIO")

                );

                sql = "SELECT P.CORREOELECTRONICO, P.CONTRASENIA, P.NOMBRE, P.APELLIDOS, P.DNI, P.SEGSOCIAL, P.NUMFIJO, P.NUMMOVIL, P.FECHANACIMIENTO" +
                        " FROM COCINERO_PINCHE CP INNER JOIN PINCHE P ON CP.FK_IDPINCHE = P.DNI" +
                        " WHERE CP.FK_IDCOCINERO = " + cocineroEncontrado.getDni();


                ResultSet rsPinche = Conector.getConnector().ejecutarQuery(sql);
                while (rsPinche.next()) {
                    pinche pincheEncontrado = new pinche(
                            rsPinche.getString("CORREOELECTRONICO"),
                            rsPinche.getString("CONTRASENIA"),
                            rsPinche.getString("NOMBRE"),
                            rsPinche.getString("APELLIDOS"),
                            rsPinche.getString("DNI"),
                            rsPinche.getInt("SEGSOCIAL"),
                            rsPinche.getString("NUMFIJO"),
                            rsPinche.getString("NUMMOVIL"),
                            rsPinche.getDate("FECHANACIMIENTO").toLocalDate()

                    );
                    cocineroEncontrado.vincularPinche(pincheEncontrado);
                }

                sql = "SELECT P.IDPLATO, P.PLATO, P.PRECIO, P.CLASIFICACION" +
                        " FROM COCINERO_PLATO CP INNER JOIN PLATO P ON CP.FK_DNIPLATO = P.IDPLATO" +
                        " WHERE CP.FK_DNICOCINERO = " + cocineroEncontrado.getDni();
                ResultSet rsPlato = Conector.getConnector().ejecutarQuery(sql);
                while (rsPlato.next()) {
                    Plato platoEncontrado = new Plato(
                            rsPlato.getString("IDPLATO"),
                            rsPlato.getString("PLATO"),
                            rsPlato.getDouble("PRECIO"),
                            rsPlato.getString("CLASIFICACION")
                    );
                    cocineroEncontrado.vincularPlato(platoEncontrado);
                }

                listaCocinero.add(cocineroEncontrado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaCocinero;
    }

    public String vincularPinche(pinche pinche, cocinero cocinero) {
        String mensaje;
        try {
            String sql = "INSERT INTO COCINERO_PINCHE (FK_IDPINCHE, FK_IDCOCINERO) VALUES ('" + pinche.getDni() + "', '" + cocinero.getDni() + "')";

            Conector.getConnector().ejecutarSQL(sql);

            mensaje = "El pinche " + pinche.getNombre() + " fue vinculado correctamente al cocinero " + cocinero.getDni();
        } catch (Exception e) {

            e.printStackTrace();
            mensaje = "Error al vincular el pinche con el cocinero: " + e.getMessage();
        }

        return mensaje;
    }


    public String vincularPlato(Plato plato, cocinero cocinero) {
        String mensaje;
        try {
            String sql = "INSERT INTO COCINERO_PLATO (FK_DNIPLATO, FK_DNICOCINERO) VALUES ('" + plato.getIdPlato() + "', '" + cocinero.getDni() + "')";

            Conector.getConnector().ejecutarSQL(sql);

            mensaje = "El plato " + plato.getPlato() + " fue vinculado correctamente al cocinero " + cocinero.getDni();
        } catch (Exception e) {

            e.printStackTrace();
            mensaje = "Error al vincular el plato con el cocinero: " + e.getMessage();
        }

        return mensaje;
    }

}











//public ArrayList<Casa> enlistarCasa() {
//        ArrayList<Casa> listaCasas = new ArrayList<>();
//
//
//        try {
//            // Consulta para obtener todas las casas
//            String sql = "SELECT IDCASA, DIRECCION, DETALLES, VECINOENCARGADO FROM CASA";
//            ResultSet rsCasa = Conector.getConnector().ejecutarQuery(sql);
//
//            while (rsCasa.next()) {
//                // Crear una nueva instancia de Casa para cada fila de resultados
//                Casa casaEncontrada = new Casa(
//                        rsCasa.getString("IDCASA"),
//                        rsCasa.getString("DIRECCION"),
//                        rsCasa.getString("DETALLES"),
//                        rsCasa.getString("VECINOENCARGADO")
//                );
//
//                // Consulta para obtener los vecinos de esta casa
//                sql = "SELECT V.IDVECINO, V.NOMBREVECINO, V.APELLIDOVECINO, V.FECHANACIMIENTO, V.GENERO, V.TELEFONO, V.CORREOELECTRONICO, V.CONTRASENIA, V.CREDENCIAL" +
//                        " FROM CASA_VECINO CV INNER JOIN VECINO V ON CV.FK_IDVECINO = V.IDVECINO" +
//                        " WHERE CV.FK_IDCASA = " + casaEncontrada.getIdCasa();
//                ResultSet rsVecino = Conector.getConnector().ejecutarQuery(sql);
//
//                while (rsVecino.next()) {
//                    Vecino vecinoEncontrado = new Vecino(
//                            rsVecino.getString("IDVECINO"),
//                            rsVecino.getString("NOMBREVECINO"),
//                            rsVecino.getString("APELLIDOVECINO"),
//                            rsVecino.getDate("FECHANACIMIENTO").toLocalDate(),
//                            rsVecino.getString("GENERO").charAt(0),
//                            rsVecino.getString("TELEFONO"),
//                            rsVecino.getString("CORREOELECTRONICO"),
//                            rsVecino.getString("CONTRASENIA"),
//                            rsVecino.getString("CREDENCIAL")
//                    );
//
//                    casaEncontrada.vincularVecino(vecinoEncontrado);
//                }