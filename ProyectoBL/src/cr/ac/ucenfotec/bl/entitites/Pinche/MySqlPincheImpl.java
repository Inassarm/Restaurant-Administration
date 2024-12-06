package cr.ac.ucenfotec.bl.entitites.Pinche;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlPincheImpl implements IPincheDAO{
    private String query;
    public String registrarPinche(pinche pinche) {
        query="INSERT INTO PINCHE VALUES('"+pinche.getCorreoElectronico()+"','"+pinche.getContrasenia()+"', '"+pinche.getNombre()+"','"+pinche.getApellidos()+"','"+pinche.getDni()+ "', "+pinche.getSegSocial()+", '"+pinche.getNumFijo()+"','"+pinche.getNumMovil()+"','"+pinche.getFechaNacimiento()+"')";
        Conector.getConnector().ejecutarSQL(query);

        return "El pinche con DNI " + pinche.getDni() + ", se ha registrado correctamente!";
    }

    @Override
    public ArrayList<pinche> listarPinche() {
        ArrayList<pinche> listaPinche = new ArrayList<>();
        try {
            String sql = "SELECT P.CORREOELECTRONICO, P.CONTRASENIA, P.NOMBRE, P.APELLIDOS, P.DNI, P.SEGSOCIAL, P.NUMFIJO, P.NUMMOVIL, P.FECHANACIMIENTO " +
                    "FROM PINCHE P " +
                    "LEFT JOIN COCINERO_PINCHE CP " +
                    "ON P.DNI = CP.FK_IDPINCHE " +
                    "LEFT JOIN COCINERO C " +
                    "ON CP.FK_IDCOCINERO = C.IDCOCINERO";

            ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
            while (rs.next()) {
                pinche pincheEncontrado = new pinche(
                        rs.getString("CORREOELECTRONICO"),
                        rs.getString("CONTRASENIA"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDOS"),
                        rs.getString("DNI"),
                        rs.getInt("SEGSOCIAL"),
                        rs.getString("NUMFIJO"),
                        rs.getString("NUMMOVIL"),
                        rs.getDate("FECHANACIMIENTO").toLocalDate()
                );

                listaPinche.add(pincheEncontrado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPinche;
    }


}

