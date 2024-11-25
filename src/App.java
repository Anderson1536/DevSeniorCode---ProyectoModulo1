import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static String[] planets = {"Mercurio","Venus","Marte","Jupiter","Saturno"};
    static double[] distance = {77.0, 61.0, 54.6, 965.0, 1345.0};
    static String[] description ={  "Es el planeta más pequeño del sistema solar y el más cercano al Sol",
                                    "Planeta caluroso, rocoso y terrestre. Gira en dirección contraria a la Tierra",
                                    "Planeta frío, desértico y rocoso. Se caracteriza por su color rojizo",
                                    "Es el planeta más grande y masivo del sistema solar. Es parecido a una estrella",
                                    "Es un planeta gaseoso del sistema solar que se caracteriza por sus anillos, su color y su rápido giro"};
    
    static String[] naves = {"Exploradora", "Carga pesada", "Gran velocidad"};
    static double[] speedMax ={20000.0,15000.0,30000.0};
    static int[] passengers = {4, 7, 2};
    static double[] fuel = {250000.0, 450000.0,300000.0}; //autonomia kilogramos por día
    static double oxygen = 9.0; //kilogramos dia por persona

    static String[] event = {"Fallo en el sistema! reparando..", "Asteroides en el camino! cambiando rumbo...", "Perdida de oxigeno! ajustando niveles..."};

    //Variables para calcular el tiempo de viaje
    static double velocidad;
    static double distancia;

    static double days;
    static int optionNave;
    static int pasajeros;

    public static void main(String[] args) throws Exception {
        
        int option;

        do {
            showMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    selectPlanet();
                    break;
                case 2:
                    selectNave();
                    break;
                case 3:
                    simulacionViaje();
                    break;
                default:
                    System.err.println("Opción invalida, por favor intente de nuevo");
                    break;
            }

        } while (option != 4);
    }

    public static void showMenu(){
        System.out.println("\n________ Menú Principal ________");
        System.out.println("1. Seleccionar un planeta de destino");
        System.out.println("2. Seleccionar una nave espacial");
        System.out.println("3. Iniciar la simulación del viaje");
        System.out.println("4. Salir del programa");
        System.out.println("Por favor, elige una opción: ");

    }

    public static void selectPlanet(){

        showArray(planets);
        int optionUser = ingresarOpcion();

        switch (optionUser) {
            case 1:
                System.out.println("El destino seleccionado es: " + planets[0]);
                distancia = distanciaPlaneta(optionUser);
                System.out.println("Distancia de la tierra: " + distancia + " millones de kilometros");
                descripcionPlaneta(optionUser);            
                break;
            case 2:
                System.out.println("El destino seleccionado es: "+ planets[1]);
                distancia = distanciaPlaneta(optionUser);
                System.out.println("Distancia de la tierra: " + distancia + " millones de kilometros");
                descripcionPlaneta(optionUser);
                break;
            case 3:
                System.out.println("El destino seleccionado es: "+ planets[2]);
                distancia = distanciaPlaneta(optionUser);
                System.out.println("Distancia de la tierra: " + distancia + " millones de kilometros");
                descripcionPlaneta(optionUser);
                break;
            case 4:
            System.out.println("El destino seleccionado es: "+ planets[3]);
                distancia = distanciaPlaneta(optionUser);
                System.out.println("Distancia de la tierra: " + distancia + " millones de kilometros");
                descripcionPlaneta(optionUser);
                break;
            case 5:
                System.out.println("El destino seleccionado es: "+ planets[4]);
                distancia = distanciaPlaneta(optionUser);
                System.out.println("Distancia de la tierra: " + distancia + " millones de kilometros");
                descripcionPlaneta(optionUser);
                break;
            default:
            System.out.println("Opción invalida");
                break;
        }
    }

    public static void selectNave(){

        showArray(naves);
        optionNave = ingresarOpcion();

        switch (optionNave){
            case 1:
                System.out.println("Nave seleccionada: " + naves[0]);
                velocidad = velocidadNave(optionNave);
                System.out.println("La velocidad es: " + velocidad + " k/h");
                capacidadPasajeros(optionNave);
                break;
            case 2:
                System.out.println("Nave seleccionada: "+ naves[1]);
                velocidad = velocidadNave(optionNave);
                System.out.println("La velocidad es: " + velocidad + " k/h");
                capacidadPasajeros(optionNave);
                break;
            case 3:
                System.out.println("Nave seleccionada: "+ naves[2]);
                velocidad = velocidadNave(optionNave);
                System.out.println("La velocidad es: " + velocidad + " k/h");
                capacidadPasajeros(optionNave);
                break;
            default:
            System.out.println("Opción invalida");
                break;
        }

        System.out.println();
        calculateTime(velocidad, distancia);
        cantidadPasajeros();
        manageResources();
        System.out.println("----------------------------------");
    }

    public static void cantidadPasajeros(){
        
        boolean cantidad = true;
        while (cantidad) {
            System.out.println("Ingrese la cantidad de pasajeros que viajaran: ");
            pasajeros = scanner.nextInt();
            if(pasajeros < 1){
                System.out.println("Cantidad incorrecta, intentelo de nuevo.");
            }else{
                cantidad = false;
            }
        }
    }

    public static void calculateTime(double velocidad, double distancia){
        double time = distancia * 1000000 / velocidad;
        days = time / 24;
        System.out.println("La duración estimada del viaje es de " + days + " días.");
    }

    public static void simulacionViaje(){

        int progreso = 0;
        System.out.println("Iniciando viaje en: ");
            for(int i = 3; i > 0; i--){
                System.out.println(i);
            }
        System.out.println("Despegando...");
        System.out.println();

        for(progreso = 0; progreso <= 100; progreso++){
            
            if(progreso == 0){
                System.out.println("Inicio del viaje...");
            }else if(progreso == 50){
                System.out.println("Vamos a la mitad del camino...");
            }else if(progreso < 100 && progreso != 50){
                System.out.println("Llevas un " + progreso + "% del viaje");
            }else if(progreso == 100){
                System.out.println("Llegada al destino, el viaje se completó correctamente!");
            }
        }
    }

    public static void manageResources(){
        //combustible

        double calcularCombustible;
        switch (optionNave) {
            case 1:
                calcularCombustible = days * fuel[0];
                System.out.println("El combustible necesario para el viaje es: " + calcularCombustible + " kilogramos");
                break;
            case 2:
                calcularCombustible = days * fuel[1];
                System.out.println("El combustible necesario para el viaje es: " + calcularCombustible + " kilogramos");
                break;
            case 3:
                calcularCombustible = days * fuel[2];
                System.out.println("El combustible necesario para el viaje es: " + calcularCombustible + " kilogramos");
                break;
            default:
                break;
        }

        //Oxigeno

        double calcularOxigeno = pasajeros * oxygen * days;
        System.out.println("El oxigeno necesario para el viaje es: " + calcularOxigeno + " kilogramos");
    }

    public static void events(){
        int aleatorio = random.nextInt(1, 100);
        String eventoAleatorio;
    }

    public static void naveState(){

    }


    //Metodos auxiliares

    public static int ingresarOpcion(){
        System.out.println("Por favor seleccione una opción: ");
        int optionUser = scanner.nextInt();
        System.out.println("----------------------------------");
        return optionUser;
    }

    public static double distanciaPlaneta(int opcion){
        double distancia = 0;
        switch (opcion) {
            case 1:
                //System.out.println("Distancia de la tierra: " + distance[0] + " millones de kilometros");
                distancia = distance[0];
                break;
            case 2:
                distancia = distance[1];
                break;
            case 3:
                distancia = distance[2];
                break;
            case 4:
                distancia = distance[3];
                break;
            case 5:
                distancia = distance[4];
                break;
            default:
                break;
        }

        return distancia;
    }

    public static void showArray(String[]aux){
        int option = 1;
        System.out.println("Listado: ");

        for(int i = 0; i < aux.length; i++){
            System.out.println(option++ + ". " + aux[i]);
        }
    }

    public static double velocidadNave(int option){

        double velocidad = 0;
        switch (option) {
            case 1:
                velocidad = speedMax[0];
                break;
            case 2:
                velocidad = speedMax[1];
                break;
            case 3:
                velocidad = speedMax[2];
                break;
            default:
                break;
        }

        return velocidad;
    }

    public static void descripcionPlaneta(int opcion){
        switch (opcion) {
            case 1:
                System.out.println(description[0]);
                System.out.println("----------------------------------");
                break;
            case 2:
                System.out.println(description[1]);
                System.out.println("----------------------------------");
                break;
            case 3:
                System.out.println(description[2]);
                System.out.println("----------------------------------");
                break;
            case 4:
                System.out.println(description[3]);
                System.out.println("----------------------------------");
                break;
            case 5:
                System.out.println(description[4]);
                System.out.println("----------------------------------");
                break;
            default:
                break;
        }
    }

    public static void capacidadPasajeros(int option){
        switch (option) {
            case 1:
                System.out.println("Capacidad maxima de pasajeros: " + passengers[0]);
                System.out.println("----------------------------------");
                break;
            case 2:
                System.out.println("Capacidad maxima de pasajeros: " + passengers[1]);
                System.out.println("----------------------------------");
                break;
            case 3:
                System.out.println("Capacidad maxima de pasajeros: " + passengers[2]);
                System.out.println("----------------------------------");
                break;
            default:
                break;
        }        
    }
}
