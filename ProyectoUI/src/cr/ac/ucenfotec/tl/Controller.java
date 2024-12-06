package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entitites.Almacen.Almacen;
import cr.ac.ucenfotec.bl.entitites.Cocinero.cocinero;
import cr.ac.ucenfotec.bl.entitites.Estante.Estante;
import cr.ac.ucenfotec.bl.entitites.Ingrediente.Ingrediente;
import cr.ac.ucenfotec.bl.entitites.Pinche.pinche;
import cr.ac.ucenfotec.bl.entitites.Plato.Plato;
import cr.ac.ucenfotec.bl.entitites.Superadministrador;
import cr.ac.ucenfotec.bl.logic.*;
import cr.ac.ucenfotec.ui.UI;

import java.time.LocalDate;


public class Controller {
    private UI interfaz;
    private CocineroGestor cocineroGest;
    private PincheGestor pincheGest;
    private AlmacenGestor almacenGest;
    private IngredienteGestor ingredienteGest;
    private PlatoGestor platoGest;


    public Controller() {
        interfaz = new UI();
        cocineroGest = new CocineroGestor();
        pincheGest = new PincheGestor();
        almacenGest = new AlmacenGestor();
        ingredienteGest = new IngredienteGestor();
        platoGest = new PlatoGestor();
    }

    public void start() {
        LocalDate fechaNacimiento = LocalDate.of(2002, 9, 9);
        Superadministrador superAdmin = new Superadministrador("isa@gmail.com", "Isabella123!?", "Isabella", "Nassar", "1", 2, "87878787", "45566");
        if (iniciarSesionSuperAdmin(superAdmin)) {
            menu();
        } else {
            cocinero cocinero = iniciarSesion();
            if (cocinero != null) {
                cocineroGest.mostrarDatosCocinero(cocinero).forEach(System.out::println);
                menuCocinero();
            } else {
                System.out.println(".........");
            }
        }
    }

    public boolean iniciarSesionSuperAdmin(Superadministrador superAdmin) {
        try {
            System.out.println("***Iniciar Sesión como Superadministrador***");
            System.out.print("Ingrese su correo electrónico: ");
            String correoElectronico = interfaz.leerTexto();
            System.out.print("Ingrese su contraseña: ");
            String contrasenia = interfaz.leerTexto();

            if (superAdmin.getCorreoElectronico().equals(correoElectronico) && superAdmin.getContrasenia().equals(contrasenia)) {
                System.out.println("Inicio de sesión exitoso como superadministrador.");
                menu();
            } else {
                System.out.println("Lo sentimos: Credenciales de superadministrador incorrectas.");
            }

        } catch (
                Exception e) {

            e.printStackTrace();
        }
        return false;
    }


    public cocinero iniciarSesion() {
        System.out.println("*** Iniciar Sesión como Empleado ***");
        System.out.print("Ingrese su DNI: ");
        String dni = interfaz.leerTexto();

        if (cocineroGest.buscarCredencialPorDni(dni)) {
            cocinero cocinero = cocineroGest.cocineroPorDni(dni);
            System.out.print("Ingrese su correo electrónico: ");
            String correoElectronico = interfaz.leerTexto();
            System.out.print("Ingrese su contraseña: ");
            String contrasenia = interfaz.leerTexto();
            if (cocinero != null && cocineroGest.buscarCredenciales(correoElectronico, contrasenia)) {
                cocineroGest.mostrarDatosCocinero(cocinero).forEach(System.out::println);
                menuCocinero();
            } else {
                System.out.println("Ingreso de datos incorrecto.");
            }
        } else if (pincheGest.buscarCredencialPorDni(dni)) {
            pinche pinche = pincheGest.pinchePorDni(dni);
            System.out.print("Ingrese su correo electrónico: ");
            String correoElectronico = interfaz.leerTexto();
            System.out.print("Ingrese su contraseña: ");
            String contrasenia = interfaz.leerTexto();
            if (pinche != null && pincheGest.buscarCredenciales(correoElectronico, contrasenia)) {
                pincheGest.mostrarDatosPinche(pinche).forEach(System.out::println);
                System.out.println("Digite el id de su cocinero!!!");
                String dniCocinero = interfaz.leerTexto();
                platoGest.listadoPlato(Integer.parseInt(dniCocinero)).forEach(System.out::println);

                vincularPlato();
            } else {
                System.out.println("Ingreso de datos incorrecto.");
            }
        } else {
            System.out.println("El DNI ingresado no está en el sistema.");
        }
        return null;
    }


    public void menu() {
        int seleccion;
        do {
            interfaz.menu();
            seleccion = interfaz.leerNumero();
            organizarPersonal(seleccion);
        } while (seleccion != 0);
    }

    public void organizarPersonal(int seleccion) {
        switch (seleccion) {
            case 1:
                registrarCocinero();
                break;
            case 2:
                registrarPinche();
                break;
            case 3:
                listarCocinero();
                break;
            case 4:
                listarPinche();
                break;
            case 5:
                vincularPinche();
                break;
            case 6:
                registrarAlmacen();
                break;
            case 7:
                listarAlmacenes();
                break;
            case 8:
                registrarEstante();
                break;
            case 9:
                registrarIngrediente();
                break;
            case 10:
                listarIngrediente();
                break;
            case 11:
                enlistarPlato();
                break;
            case 12:
                vincularIngrediente();
                break;
            case 13:
                eliminarAlmacen();
                break;
            case 14:
                eliminarEstante();
                break;
            case 15:
                modificarDatosAlmacen();
                break;
            case 16:
                modificarEstante();
                break;
            default:
                System.out.println("Gracias por trabajar en Restaurante Bien Feliz :) ");
        }
    }

    public void menuCocinero() {
        int seleccionDos;
        do {
            interfaz.menuCocinero();
            seleccionDos = interfaz.leerNumero();
            menuCocinero(seleccionDos);
        } while (seleccionDos != 0);
    }

    public void menuCocinero(int seleccionDos) {
        switch (seleccionDos) {
            case 1:
                registrarPlato();
                break;
            case 2:
                vincularIngrediente();
                break;
            case 3:
                enlistarPlato();
                break;
            default:
                System.out.println("Gracias por trabajar en Restaurante Bien Feliz :) ");
        }
    }

    public boolean validarContrasenia(String contrasenia) {
        // Verificar si la contraseña tiene al menos 8 caracteres
        if (contrasenia.length() < 8) {
            return false;
        }

        // Verificar si la contraseña contiene al menos un número
        boolean contieneNumero = false;
        for (char caracter : contrasenia.toCharArray()) {
            if (Character.isDigit(caracter)) {
                contieneNumero = true;
                break;
            }
        }
        if (!contieneNumero) {
            return false;
        }

        // una letra mayúscula y una minúscula
        boolean contieneMayuscula = false;
        boolean contieneMinuscula = false;
        for (char caracter : contrasenia.toCharArray()) {
            if (Character.isUpperCase(caracter)) {
                contieneMayuscula = true;
            } else if (Character.isLowerCase(caracter)) {
                contieneMinuscula = true;
            }
        }
        if (!contieneMayuscula || !contieneMinuscula) {
            return false;
        }

        // Al menos un símbolo
        String simbolos = "!@#$%^&*()-_=+[{]}|;:,<.>/?";
        boolean contieneSimbolo = false;
        for (char caracter : contrasenia.toCharArray()) {
            if (simbolos.contains(String.valueOf(caracter))) {
                contieneSimbolo = true;
                break;
            }
        }
        if (!contieneSimbolo) {
            return false;
        }

        return true;
    }

    public void registrarCocinero() {
        String correoElectronico = interfaz.leerTexto();
        String contrasenia;
        do {
            System.out.println("Digite el correo electrónico:");
            correoElectronico = interfaz.leerTexto();

            System.out.println("Digite una contraseña (Mínimo 8 caracteres, números, letras mayúsculas y minúsculas, y al menos un símbolo):");
            contrasenia = interfaz.leerTexto();

            if (!validarContrasenia(contrasenia)) {
                System.out.println("La contraseña no cumple con los requisitos !!!. Vuelva a intentar.");
            }
        } while (!validarContrasenia(contrasenia));

        System.out.println("Digite el nombre del cocinero ");
        String nombreCocinero = interfaz.leerTexto();
        System.out.println("Digite los apellidos del cocinero ");
        String apellidosCocinero = interfaz.leerTexto();
        System.out.println("Digite el documento de identidad (DNI) del cocinero ");
        String dni = interfaz.leerTexto();
        System.out.println("Digite el número de Seguridad Social del cocinero ");
        int segSocialCocinero = interfaz.leerNumero();
        System.out.println("Digite su número de teléfono fijo del cocinero ");
        String numFijoCocinero = interfaz.leerTexto();
        System.out.println("Digite su número de teléfono móvil del cocinero ");
        String numMovilCocinero = interfaz.leerTexto();
        System.out.println("Digite el número de años de servicio del cocinero ");
        int aniosServicio = interfaz.leerNumero();

        String registroCocinero = cocineroGest.registrarCocinero(correoElectronico, contrasenia, nombreCocinero, apellidosCocinero, dni, segSocialCocinero, numFijoCocinero, numMovilCocinero, aniosServicio);
        interfaz.imprimirMensaje(registroCocinero);
    }

    public void registrarPinche() {
        String correoElectronico = interfaz.leerTexto();
        String contrasenia;
        do {
            System.out.println("Digite el correo electrónico:");
            correoElectronico = interfaz.leerTexto();

            System.out.println("Digite una contraseña (Mínimo 8 caracteres, números, letras mayúsculas y minúsculas, y al menos un símbolo):");
            contrasenia = interfaz.leerTexto();

            if (!validarContrasenia(contrasenia)) {
                System.out.println("La contraseña no cumple con los requisitos !!!. Vuelva a intentar.");
            }
        } while (!validarContrasenia(contrasenia));


        System.out.println("Digite el nombre del pinche ");
        String nombre = interfaz.leerTexto();
        System.out.println("Digite los apellidos del pinche ");
        String apellidos = interfaz.leerTexto();
        System.out.println("Digite el documento de identidad (DNI) del pinche ");
        String dni = interfaz.leerTexto();
        System.out.println("Digite el número de Seguridad Social del pinche ");
        int segSocial = interfaz.leerNumero();
        System.out.println("Digite su número de teléfono fijo del pinche ");
        String numFijoPinche = interfaz.leerTexto();
        System.out.println("Digite su número de teléfono móvil del pinche ");
        String numMovilPinche = interfaz.leerTexto();
        System.out.println("Digite la fecha de nacimiento (DD/MM/AA) del pinche ");
        LocalDate fechaNacimiento = interfaz.leerFecha();

        String registroPinche = pincheGest.registrarPinche(correoElectronico, contrasenia, nombre, apellidos, dni, segSocial, numFijoPinche, numMovilPinche, fechaNacimiento);
        interfaz.imprimirMensaje(registroPinche);
    }

    public void registrarAlmacen() {
        System.out.println("Digite el número de almacén ");
        int numAlmacen = interfaz.leerNumero();
        System.out.println("Digite el nombre del almacén ");
        String nombreAlmacen = interfaz.leerTexto();
        System.out.println("Digite la descripción del almacén ");
        String descripcion = interfaz.leerTexto();

        String registrarAlmacen = almacenGest.registrarAlmacen(numAlmacen, nombreAlmacen, descripcion);
        interfaz.imprimirMensaje(registrarAlmacen);
    }

    public void registrarEstante() {


        interfaz.imprimirMensaje("Digite el número de almacén al que desea vincular el estante:");
        int numAlmacen = interfaz.leerNumero();

        Almacen almacen = almacenGest.buscarAlmacen(numAlmacen);
        if (almacen == null) {
            interfaz.imprimirMensaje("¡El almacén con el número " + numAlmacen + " no se encontró!");

        } else {


            interfaz.imprimirMensaje("Digite el código del estante:");
            int codigoEstante = interfaz.leerNumero();
            interfaz.imprimirMensaje("Digite el alto del estante:");
            double alto = interfaz.leerDecimales();
            interfaz.imprimirMensaje("Digite el ancho del estante:");
            double ancho = interfaz.leerDecimales();
            interfaz.imprimirMensaje("Digite la profundidad del estante:");
            double profundidad = interfaz.leerDecimales();
            interfaz.imprimirMensaje("Digite el número de almacén al que desea vincular el estante:");
            numAlmacen = interfaz.leerNumero();


            String registroEstante = almacenGest.registrarEstante(codigoEstante, alto, ancho, profundidad, numAlmacen);
            interfaz.imprimirMensaje(registroEstante);
        }
    }

    public void modificarDatosAlmacen() {
        interfaz.imprimirMensaje("**** Modificar Datos de Almacen ****");
        interfaz.imprimirMensaje("Digite el código del almacen que desea modificar:");
        int numAlmacen = interfaz.leerNumero();
        interfaz.imprimirMensaje("Digite el nuevo nombre:");
        String nombreAlmacen = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite los nuevos detalles de la descripción:");
        String descripcion = interfaz.leerTexto();

        Almacen almacenModificado = new Almacen(numAlmacen, nombreAlmacen, descripcion);


        almacenGest.modificarAlmacen(almacenModificado);
        interfaz.imprimirMensaje("Se ha modificado con mucho éxito!!!");
    }

    public void modificarEstante() {
        interfaz.imprimirMensaje("**** Modificar Datos de Estante ****");
        interfaz.imprimirMensaje("Digite el código del estante que desea modificar:");
        int codigoEstante = interfaz.leerNumero();
        interfaz.imprimirMensaje("Digite la nueva medida de alto:");
        double alto = interfaz.leerDecimales();
        interfaz.imprimirMensaje("Digite la nueva medida de ancho:");
        double ancho = interfaz.leerDecimales();
        interfaz.imprimirMensaje("Digite la nueva medida de profundidad:");
        double profundidad = interfaz.leerDecimales();

        Estante estanteModificado = new Estante(codigoEstante, alto, ancho, profundidad);


        almacenGest.modificarEstante(estanteModificado);
        interfaz.imprimirMensaje("Se ha modificado con mucho éxito!!!");
    }


    public void listarAlmacenes() {
        interfaz.imprimirMensaje("***Información de los almacenes registrados***");
        for (Almacen almacenTemp : almacenGest.listarAlmacenes()) {
            interfaz.imprimirMensaje(almacenTemp.toString());

        }
    }

    public void enlistarPlato() {
        interfaz.imprimirMensaje("***Información de los platos registrados***");
        for (Plato platoTemp : platoGest.enlistarPlato()) {
            System.out.println(platoTemp.toString());

        }
    }

    public void listarIngrediente() {
        interfaz.imprimirMensaje("***Información de los ingredientes registrados***");
        for (Ingrediente ingredienteTemp : ingredienteGest.listarIngrediente()) {
            System.out.println(ingredienteTemp.toString());

        }
    }

    public void registrarPlato() {
        System.out.println("Digite el id del plato");
        String idPlato = interfaz.leerTexto();
        System.out.println("Digite el nombre del plato");
        String plato = interfaz.leerTexto();
        System.out.println("Digite el precio del plato ");
        double precio = interfaz.leerDecimales();
        System.out.println("Digite la clasificación ");
        String clasificacion = interfaz.leerTexto();

        String registroPlato = platoGest.registrarPlato(idPlato, plato, precio, clasificacion);
        System.out.println(registroPlato);
    }

    public void registrarIngrediente() {
        System.out.println("Digite el id del ingrediente");
        String idIngrediente = interfaz.leerTexto();
        System.out.println("Digite el nombre del ingrediente ");
        String nombreIngrediente = interfaz.leerTexto();
        System.out.println("Digite la cantidad existente ");
        double cantidad = interfaz.leerNumero();

        String registroIngrediente = ingredienteGest.registrarIngrediente(idIngrediente, nombreIngrediente, cantidad);
        System.out.println(registroIngrediente);
    }

    public void vincularPinche() {
        interfaz.imprimirMensaje("***Vincular un pinche a un cocinero!!!***");
        interfaz.imprimirMensaje("Digite el número de ID del cocinero que desea vincular: ");
        String idCocinero = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el número de ID del pinche que desea vincular: ");
        String idPinche = interfaz.leerTexto();

        pinche pinche = pincheGest.buscarPinche(idPinche);

        if (pinche != null) {
            String mensaje = cocineroGest.vincularPinche(idCocinero, pinche);
            interfaz.imprimirMensaje(mensaje);
        } else {
            interfaz.imprimirMensaje("El pinche con el dni " + idPinche + ", no está en el sistema!");
        }
    }


    public void vincularPlato() {
        interfaz.imprimirMensaje("***Vincular un plato a un cocinero!!!***");
        interfaz.imprimirMensaje("Digite el número de ID del cocinero que desea vincular: ");
        String idCocinero = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el número de ID del plato que desea vincular: ");
        String idPlato = interfaz.leerTexto();

        Plato plato = platoGest.buscarPlato(idPlato);

        if (plato != null) {
            String mensaje = cocineroGest.vincularPlato(idCocinero, plato);
            interfaz.imprimirMensaje(mensaje);
        } else {
            interfaz.imprimirMensaje("El plato con el dni " + idPlato + ", no está en el sistema!");
        }
    }


    public void vincularIngrediente() {
        interfaz.imprimirMensaje("***Vincular un ingrediente a un plato!!!***");
        interfaz.imprimirMensaje("Digite el número de ID del plato que desea vincular: ");
        String idPlato = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el número de ID del ingrediente que desea vincular: ");
        String idIngrediente = interfaz.leerTexto();

        Plato plato = platoGest.buscarPlato(idPlato);
        Ingrediente ingrediente = ingredienteGest.buscarIngrediente(idIngrediente);

        if (plato != null && ingrediente != null) {
            String mensaje = platoGest.vincularIngrediente(idPlato, ingrediente);
            interfaz.imprimirMensaje(mensaje);


            int cantidadUtilizada = 1;
            ingrediente.setCantidad(ingrediente.getCantidad() - cantidadUtilizada);
            interfaz.imprimirMensaje("Se ha restado 1 unidad del ingrediente " + ingrediente.getNombreIngrediente() + ".");
        } else {
            interfaz.imprimirMensaje("El plato o el ingrediente no están en el sistema!");
        }
    }


    public void listarCocinero() {
        System.out.println("***Listado de cocineros***");
        for (cocinero datoTemp : cocineroGest.listarCocinero()) {
            System.out.println(datoTemp);
        }

    }

    public void listarPinche() {
        System.out.println("***Listado de pinches***");
        for (pinche pincheTemp : pincheGest.listarPinche()) {
            System.out.println(pincheTemp);
        }
    }

    public void eliminarAlmacen() {
        System.out.println("***Eliminar un almacen***");
        System.out.print("Por favor digite el número del almacén: ");
        int numAlmacen = interfaz.leerNumero();
        String mensajeBorrar = almacenGest.eliminarAlmacen(numAlmacen);
        System.out.println(mensajeBorrar);

    }

    public void eliminarEstante() {
        System.out.println("***Eliminar un estante***");
        System.out.print("Por favor digite el código del estante: ");
        int codigoEstante = interfaz.leerNumero();
        String mensajeBorrarEstante = almacenGest.eliminarEstante(codigoEstante);
        System.out.println(mensajeBorrarEstante);

    }

}
//
//    public void listarOtros() {
//        System.out.println("***Listado de otros empleados***");
//        for (String otrosTemp : gestor.listarOtros()) {
//            System.out.println(otrosTemp);
//        }
//    }
//
//    public void vincularPincheCocinero() {
//        System.out.println("***Asociar pinche con cocinero***");
//        System.out.println("Indique el DNI del cocinero al que le desea vincular Pinches ");
//        String dniCocinero = interfaz.leerTexto();
//        System.out.println("Indique el DNI del pinche que desea vincular ");
//        String dniPinche = interfaz.leerTexto();
//
//        String pincheAsociado = cocineroGest.vincularPincheCocinero(dniCocinero, dniPinche);
//        System.out.println(pincheAsociado.toString());
//    }
//}
//public void vincularVecinoCasa () {
//            interfaz.imprimirMensaje("***Vincular un vecino a una casa!!!***");
//            interfaz.imprimirMensaje("Digite el número de ID de la casa que desea vincular: ");
//            String idCasa = interfaz.leerTexto();
//            interfaz.imprimirMensaje("Digite el número de ID del vecino que desea vincular: ");
//            String idVecino = interfaz.leerTexto();
//
//            Vecino vecino = gestorVecino.buscarVecino(idVecino);
//
//            if (vecino != null) {
//                String mensaje = gestorCasa.vincularVecinoCasa(idCasa, vecino);
//                interfaz.imprimirMensaje(mensaje);
//            } else {
//                interfaz.imprimirMensaje("El vecino con el id " + idVecino + ", no está en el sistema!");
//            }
//        }
//
//    }

//public void start() {
//        LocalDate fechaNacimiento = LocalDate.of(2002, 9, 9);
//        Superadministrador superAdmin = new Superadministrador("Isa", "Nassar", "1", fechaNacimiento, 'f', "45566", "isa@gmail.com", "123","2");
//        if (iniciarSesionSuperAdmin(superAdmin)) {
//            muestraMenu();
//        } else {
//
//                System.out.println("Error: Credenciales incorrectas o vecino no encontrado.");
//            }
//        }
//    }

//public void iniciarSesionVecino() {
//        System.out.println("*** Iniciar Sesión como Vecino ***");
//        System.out.print("Ingrese su DNI: ");
//        String dni = interfaz.leerTexto();
//
//        if (gestorVecino.buscarCredencialPorDni(dni)) {
//            Vecino vecino = gestorVecino.VecinoPorDni(dni);
//            System.out.print("Ingrese su correo electrónico: ");
//            String correoElectronico = interfaz.leerTexto();
//            System.out.print("Ingrese su contraseña: ");
//            String contrasenia = interfaz.leerTexto();
//            if (vecino != null && gestorVecino.buscarCredenciales(correoElectronico, contrasenia)) {
//                gestorVecino.mostrarDatosVecino(vecino).forEach(System.out::println);
//            } else {
//                System.out.println("Ingreso de datos incorrecto.");
//            }
//        } else {
//            System.out.println("El DNI ingresado no está en el sistema.");
//        }
//    }

//    public boolean iniciarSesionSuperAdmin(Superadministrador superAdmin) {
//        try {
//            System.out.println("***Iniciar Sesión como Superadministrador***");
//            System.out.print("Ingrese su correo electrónico: ");
//            String correoElectronico = interfaz.leerTexto();
//            System.out.print("Ingrese su contraseña: ");
//            String contrasenia = interfaz.leerTexto();
//
//            if (superAdmin.getCorreoElectronico().equals(correoElectronico) && superAdmin.getContrasenia().equals(contrasenia)) {
//                System.out.println("Inicio de sesión exitoso como superadministrador.");
//                muestraMenu();
//            } else {
//                System.out.println("Lo sentimos: Credenciales de superadministrador incorrectas.");
//            }
//
//        } catch(
//                Exception e)
//
//        {
//
//            e.printStackTrace();
//        }
//        return false;
//    }