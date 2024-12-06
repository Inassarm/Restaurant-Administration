package cr.ac.ucenfotec.dl;

public class Conector {

    private static AccesoBD coneccionBD = null;

    public static AccesoBD getConnector(){

        String URL ="jdbc:mysql://localhost/proyecto";
        String user ="root";
        String password = "Bella14pi!?";

        if(coneccionBD == null){
            coneccionBD = new AccesoBD(URL,user,password);
        }
        return coneccionBD;
    }
}