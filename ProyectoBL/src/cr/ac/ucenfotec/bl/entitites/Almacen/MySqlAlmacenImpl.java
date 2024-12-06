package cr.ac.ucenfotec.bl.entitites.Almacen;

import com.sun.jdi.connect.spi.Connection;
import cr.ac.ucenfotec.bl.entitites.Estante.Estante;
import cr.ac.ucenfotec.dl.AccesoBD;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlAlmacenImpl implements IAlmacenDAO {

    private String query;
    private String sql;

    public String registrarAlmacen(Almacen almacen) {
        query = "INSERT INTO ALMACEN VALUES(" + almacen.getNumAlmacen() + ",'" + almacen.getNombreAlmacen() + "', '" + almacen.getDescripcion() + "')";
        Conector.getConnector().ejecutarSQL(query);

        return "El Almacén con el número " + almacen.getNumAlmacen() + ", se ha registrado correctamente!";
    }

    public ArrayList<Almacen> listarAlmacenes() {
        ArrayList<Almacen> listaAlmacenes = new ArrayList<>();

        try {
            String sql = "SELECT NUMALMACEN, NOMBREALMACEN, DESCRIPCION FROM ALMACEN";
            ResultSet rsAlmacen = Conector.getConnector().ejecutarQuery(sql);

            while (rsAlmacen.next()) {
                // Crear nueva instancia de Almacen
                Almacen almacenEncontrado = new Almacen(
                        rsAlmacen.getInt("NUMALMACEN"),
                        rsAlmacen.getString("NOMBREALMACEN"),
                        rsAlmacen.getString("DESCRIPCION")
                );
                //Para obtener los estantes de ese almacen
                sql = "SELECT CODIGOESTANTE, ALTO, ANCHO, PROFUNDIDAD FROM ESTANTE WHERE NUMALMACEN = " + almacenEncontrado.getNumAlmacen();

                ResultSet rsEstante = Conector.getConnector().ejecutarQuery(sql);
                while (rsEstante.next()) {
                    almacenEncontrado.asignarEstante(
                            rsEstante.getInt("CODIGOESTANTE"),
                            rsEstante.getDouble("ALTO"),
                            rsEstante.getDouble("ANCHO"),
                            rsEstante.getDouble("PROFUNDIDAD"));
                }

                listaAlmacenes.add(almacenEncontrado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaAlmacenes;

    }

    public String registrarEstante(Almacen Almacen, Estante Estante) {
        String sql = "INSERT INTO ESTANTE (CODIGOESTANTE, ALTO, ANCHO, PROFUNDIDAD, NUMALMACEN) VALUES(" + Estante.getCodigoEstante() + "," + Estante.getAlto() + "," + Estante.getAncho() + "," + Estante.getProfundidad() + "," + Almacen.getNumAlmacen() + ")";

        Conector.getConnector().ejecutarSQL(sql);

        return "Se crea de manera correcta el estante " + Estante.getCodigoEstante() + ", para el almacen " + Almacen.getNumAlmacen();

    }

    public String modificarDatosAlmacen(int numAlmacen, String nuevoNombreAlmacen, String nuevaDescripcion) {
        AccesoBD conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = Conector.getConnector();
            pstmt = conn.prepareStatement("UPDATE ALMACEN SET NOMBREALMACEN = ?, DESCRIPCION = ? WHERE NUMALMACEN = ?");

            pstmt.setString(1, nuevoNombreAlmacen);
            pstmt.setString(2, nuevaDescripcion);
            pstmt.setInt(3, numAlmacen);

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                return "Se ha modificado el almacén exitosamente.";
            } else {
                return "No se encontró ningún almacén con el número proporcionado.";
            }
        } catch (SQLException e) {
            return "Error al modificar el almacén: " + e.getMessage();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

}
    public void modificarAlmacen(Almacen almacen) {
        try {
            String SQL = "UPDATE ALMACEN SET NOMBREALMACEN=?, DESCRIPCION=? WHERE NUMALMACEN=?";
            AccesoBD conn = Conector.getConnector();
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setString(1, almacen.getNombreAlmacen());
            stmt.setString(2, almacen.getDescripcion());
            stmt.setInt(3, almacen.getNumAlmacen());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void modificarEstante(Estante estante) {
        try {
            String SQL = "UPDATE ESTANTE SET ALTO=?, ANCHO=?, PROFUNDIDAD=? WHERE CODIGOESTANTE=?";
            AccesoBD conn = Conector.getConnector();
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setDouble(1, estante.getAlto());
            stmt.setDouble(2, estante.getAncho());
            stmt.setDouble(3, estante.getProfundidad());
            stmt.setInt(4, estante.getCodigoEstante());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String eliminarAlmacen(int numAlmacen) {
        try {
            String query = "DELETE FROM ALMACEN WHERE NUMALMACEN=" + numAlmacen;

            Conector.getConnector().ejecutarSQL(query);

            return "Se ha eliminado el almacen con id " + numAlmacen + " exitosamente.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el almacen: " + e.getMessage();
        }
    }


    public String eliminarEstante(int codigoEstante) {
        try {
            String query = "DELETE FROM ESTANTE WHERE CODIGOESTANTE=" + codigoEstante;

            Conector.getConnector().ejecutarSQL(query);

            return "Se ha eliminado el estante con id " + codigoEstante + " exitosamente.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el estante: " + e.getMessage();
        }
    }


    //public static String modificarAlmacen(int placa, String nuevaMarca) {
    //        try {
    //            // Establecer la conexión a la base de datos
    //            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ventaautos?user=root&password=Bella14pi!?");
    //
    //            // Crear la consulta SQL para actualizar la marca del auto
    //            String query = "UPDATE AUTO SET MARCA = ? WHERE PLACA = ?";
    //            PreparedStatement pstmt = conn.prepareStatement(query);
    //            pstmt.setString(1, nuevaMarca);
    //            pstmt.setInt(2, placa);
    //
    //            // Ejecutar la consulta de actualización
    //            int filasAfectadas = pstmt.executeUpdate();
    //
    //            // Verificar si se realizaron cambios en la base de datos
    //            if (filasAfectadas > 0) {
    //                return "Se ha modificado la marca del auto exitosamente.";
    //            } else {
    //                return "No se encontró ningún auto con la placa proporcionada.";
    //            }
    //        } catch (SQLException e) {
    //            return "Error al modificar la marca del auto: " + e.getMessage();
    //        }
    //    }

}

