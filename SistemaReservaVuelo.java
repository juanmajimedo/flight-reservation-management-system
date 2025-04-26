// Este ejercicio constará de la elaboración de la clase principal "SistemaReservaVuelo" y de las clases "Vuelo" y "Reserva"

import java.util.Scanner;

// En primer lugar, crearemos la clase "Vuelo":

class Vuelo {

    // Definimos las variables de la clase "Vuelo":

    private String numeroVuelo, origen, destino;
    private int asientosDisponibles;

    // Redactaremos un constructor con todas las variables que han de ser devueltas por la función:

    Vuelo(String numeroVuelo, String origen, String destino, int asientosDisponibles) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.asientosDisponibles = asientosDisponibles;
    }

    /*
    En primer lugar, estableceremos una función booleana para la reserva de asiento, permitiendo adquirir un asiento en caso de que haya zonas disponibles 
    (asientosDisponibles > 0) y haciendo efectiva su retirada dentro del grupo de localidades disponibles (this.asientosDisponibles = this.asientosDisponibles - 1).
    Al tratarse de un booleano, el éxito retornará un "true", mientras que el fracaso se traducirá en "false":
    */

    public boolean reservarAsiento() {
        if (this.asientosDisponibles > 0) {
            this.asientosDisponibles = this.asientosDisponibles - 1;
            return true;
        }
        return false;
    }
    
    // En segundo lugar, haremos lo mismo a través de una función con la que poder mostrar la información del vuelo en cuestión: 

    public void mostrarInformacionVuelo() {
        System.out.println("- - - - - - - - - - - - - -");
        System.out.println("Número de vuelo: " + this.numeroVuelo);
        System.out.println("Origen: " + this.origen);
        System.out.println("Destino: " + this.destino);
        System.out.println("Asientos Disponibles: " + this.asientosDisponibles);
        System.out.println("- - - - - - - - - - - - - -");
    }

}


// En segundo lugar, crearemos la clase "Reserva":

class Reserva {

    // Definimos las variables de la clase "Reserva":

    private String nombrePasajero, numeroPasaporte;
    private Vuelo vuelo;

    // Creamos nuestro constructor para la función:

    Reserva(String nombrePasajero, String numeroPasaporte, Vuelo vuelo) {
        this.nombrePasajero = nombrePasajero;
        this.numeroPasaporte = numeroPasaporte;
        this.vuelo = vuelo;
    }

    // Al igual que en la clase "Vuelo", haremos una función que refleje la información de la reserva, siendo acompañada esta vez junto con la del vuelo:

    public void mostrarInformacionReserva() {
        System.out.println("Nombre de usuario: " + this.nombrePasajero);
        System.out.println("Número de pasaporte: " + this.numeroPasaporte);
        vuelo.mostrarInformacionVuelo();
    }

}


// Una vez elaboradas las clases "Vuelo" y "Reserva", pasaremos a la clase principal "sistemaReservaVuelo"

public class SistemaReservaVuelo {
    public static void main(String[] args) {

        // Para representar las dos opciones posibles en un supuesto de compra, se han incluido tanto un vuelo con asientos disponibles (vuelo 1), como uno que carezca de ellos (vuelo 2):

        Vuelo vuelo1 = new Vuelo("DCU5683", "Tatooine", "Gotham City", 39);
        Vuelo vuelo2 = new Vuelo("BTD5683", "Ciudad Anillada", "Cauce Boscoso", 0);

        // Configuraremos un nuevo teclado para más adelante en la función, además de configurar las variables integer "eleccion" y String "nombre" y "pasaporte":

        int eleccion;
        String nombre, pasaporte;
        Scanner teclado = new Scanner(System.in);

        // Al iniciar el programa, se mostrarán en pantalla los detalles de los vuelos disponibles en este momento ("vuelo1" y "vuelo2"):

        System.out.println("Vuelo 1: ");
        vuelo1.mostrarInformacionVuelo();

        System.out.println("Vuelo 2: ");
        vuelo2.mostrarInformacionVuelo();

        // Daremos la opción al usuario de realizar una reserva seleccionando uno de los vuelos disponibles:

        System.out.println("¿Qué vuelo deseas? (Elija entre Vuelo 1 y Vuelo 2)");
        eleccion = teclado.nextInt();
        
        // A su vez, para permitir que éste siga introduciendo datos será necesaria la inclusión de "teclado.nextLine();":

        teclado.nextLine();

        /* 
        Establecemos un switch que permita abrir una dicotomía en la que poder acceder bien al "vuelo1" habiendo marcado el numero 1 en la terminal,
        o bien al "vuelo2" habiendo seleccionado el 2 como "eleccion".
        */ 

        switch (eleccion) {

            /*
            Ambos cases dentro del switch poseen la misma estructura: 
            · En primer lugar, Un bucle-if en el que, si seleccionan un vuelo que siga manteniendo asientos disponibles, podrán insertar su nombre y su pasaporte, 
            datos que posteriormente se mostrarán en pantalla una vez concluida la transacción.
            · En segundo lugar, un else que desplegará un texto indicando la imposibilidad de culminar la compra frente a la falta de plazas en la oferta.
            · Finalmente, se impondrá un default que surja en caso de que la opción marcada en terminal no fuese ninguna de las disponibles en ese momento.
            */ 
            
            /*
            Así pues, en caso de tomar el vuelo con localidades disponibles ("case 1"), al introducir nuestro nombre y pasaporte podremos hacer nuestra reserva 
            efectiva, mostrando además la información relacionada con la reserva (número de vuelo, origen, destino y asientos disponibles):
            */

            case 1:
                if(vuelo1.reservarAsiento()) {
                    System.out.println("Introduzca su nombre: ");
                    nombre = teclado.nextLine();
                    System.out.println("Introduzca su pasaporte: ");
                    pasaporte = teclado.nextLine();
                    Reserva reserva1 = new Reserva(nombre, pasaporte, vuelo1);
                    reserva1.mostrarInformacionReserva();
                } 

                else { 
                    System.out.println("No hay asientos disponibles");
                } 

                break;

            
            // Si por el contrario, el usuario tomara el vuelo sin localidades disponibles ("case 2"), recibiremos como negativa que "No hay asientos disponibles":

            case 2:
                if(vuelo2.reservarAsiento()) {
                    System.out.println("Introduzca su nombre: ");
                    nombre = teclado.nextLine();
                    System.out.println("Introduzca su pasaporte: ");
                    pasaporte = teclado.nextLine();
                    Reserva reserva2 = new Reserva(nombre, pasaporte, vuelo2);
                    reserva2.mostrarInformacionReserva();
                } 
                else {
                    System.out.println("No hay asientos disponibles");
                } 
                break;
            
            // Si quisiéramos introducir otro número, la terminal devolvería el mensaje "No es ninguna de las opciones disponibles"

            default:
            System.out.println("No es ninguna de las opciones disponibles");
                break;
        }

        // Para concluir el periplo dentro del código, cerraremos "teclado", concluyendo la elaboración del "Sistema de Reserva de Vuelos"

        teclado.close();

        // Muchas gracias por su tiempo y atención |^_^|
    }
}