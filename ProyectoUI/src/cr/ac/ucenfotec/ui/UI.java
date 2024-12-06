package cr.ac.ucenfotec.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UI {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void menu() {
        System.out.println("1. Registrar cocinero");
        System.out.println("2. Registrar Pinche");
        System.out.println("3. Ver lista cocineros");
        System.out.println("4. Ver lista Pinches");
        System.out.println("5. Vincular Pinche con Cocinero");
        System.out.println("6. Registrar Almacen");
        System.out.println("7. lista de almacenes disponibles");
        System.out.println("8. Registrar Estantes ");
        System.out.println("9. Registrar ingrediente");
        System.out.println("10. Listar ingredientes disponibles");
        System.out.println("11. Listar platos disponibles");
        System.out.println("12. vincular ingrediente a plato");
        System.out.println("13. Eliminar almacen ");
        System.out.println("14. Eliminar estante ");
        System.out.println("15. Modificar un almacen ");
        System.out.println("16. Modificar un estante ");

        System.out.println("0: SALIR ");
    }

    public void menuCocinero() {
        System.out.println("1. Registrar plato");
        System.out.println("2. Vincular ingrediente a plato");
        System.out.println("3. Listas platos.");
        System.out.println("0: SALIR ");
    }

    public int leerNumero() {
        int numero = 0;
        boolean existeError = true;
        do {
            try {
                numero = Integer.parseInt(in.readLine());
                if (numero < 0) {
                    throw new Exception("Por favor ingrese un nÃºmero mayor o igual a cero.");
                }
                existeError = false;
            } catch (NumberFormatException nfe) {
                existeError = true;
                System.out.println("El dato ingresado no es un nÃºmero, intentelo nuevamente!");
            } catch (Exception e) {
                existeError = true;
                System.out.println(e.getMessage());
            }
        } while (existeError);
        return numero;
    }

    public String leerTexto() {
        String texto = "";
        boolean existeError = true;
        do {
            try {
                texto = in.readLine();
                existeError = false;
            } catch (Exception e) {
                existeError = true;
                System.out.println("El dato ingresado presenta errores, intentelo nuevamente!");
            }
        } while (existeError);
        return texto;
    }

    public boolean leerBoleano() throws Exception {
        return in.readLine().equals("S");
    }

    public double leerDecimales() {
        double decimal = 0.0;
        boolean existeError = true;
        do {
            try {
                decimal = Double.parseDouble(in.readLine());
                existeError = false;
            } catch (Exception e) {
                existeError = true;
                System.out.println("El dato ingresado presenta errores, intentelo nuevamente!");
            }
        } while (existeError);
        return decimal;
    }

    public LocalDate leerFecha() {
        String fecha = "";
        LocalDate fechaNueva = null;
        boolean existeError;
        do {
            try {
                fecha = in.readLine().toLowerCase();
                fechaNueva = LocalDate.parse(fecha, formatter);
                existeError = false;
            } catch (Exception e) {
                existeError = true;
                System.out.println("El formato de la fecha es incorrecto, debe ser de tipo dd/MM/yyyy.");
            }
        } while (existeError);
        return fechaNueva;
    }

    public void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}