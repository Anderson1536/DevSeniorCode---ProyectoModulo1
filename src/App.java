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
    static double[] maxSpeed ={20000.0,15000.0,30000.0}; 
    static int[] passengers = {4, 7, 2};
    static double[] fuel = {250.0, 450.0,300.0}; //autonomia miles de kilogramos por día
    static double oxygen = 9.0; //kilogramos dia por persona

    static String[] event = {"Fallo en el sistema!", "Asteroides en el camino!", "Perdida de oxigeno!"};

    //Variables para realizar operaciones entre metodos
    static double speed;
    static double route;

    static double days;
    static int optionNave;
    static int passenger;

    static int progress;

    static double calculateFuel;
    static double calculateOxygen;

    public static void main(String[] args) throws Exception {
        
        int option;

        do {
            showMenu(); //Mostra menú principal

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    selectPlanet();
                    break;
                case 2:
                    selectNave();
                    break;
                case 3:
                    travelSimulation();
                    break;
                case 4:
                    System.out.println("Saliendo...");
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

        showArray(planets); //Mostrar contenido del array planets

        int optionUser = enterOption(); //Ingresar una opción

        switch (optionUser) {
            case 1:
                System.out.println("El destino seleccionado es: " + planets[0]);

                route = planetDistance(optionUser); //Mostrar la distancia del planeta seleccionado
                System.out.println("Distancia de la tierra: " + route + " millones de kilometros");
                planetDescription(optionUser);   
                break;
            case 2:
                System.out.println("El destino seleccionado es: "+ planets[1]);

                route = planetDistance(optionUser);
                System.out.println("Distancia de la tierra: " + route + " millones de kilometros");
                planetDescription(optionUser); //Mostrar la descripción del planeta seleccionado  
                break;
            case 3:
                System.out.println("El destino seleccionado es: "+ planets[2]);

                route = planetDistance(optionUser);
                System.out.println("Distancia de la tierra: " + route + " millones de kilometros");
                planetDescription(optionUser);
                break;
            case 4:
                System.out.println("El destino seleccionado es: "+ planets[3]);

                route = planetDistance(optionUser);
                System.out.println("Distancia de la tierra: " + route + " millones de kilometros");
                planetDescription(optionUser);
                break;
            case 5:
                System.out.println("El destino seleccionado es: "+ planets[4]);

                route = planetDistance(optionUser);
                System.out.println("Distancia de la tierra: " + route + " millones de kilometros");
                planetDescription(optionUser);
                break;
            default:
            System.out.println("Opción invalida");
                break;
        }
    }

    public static void selectNave(){

        showArray(naves); //Mostrar contenido del array naves
        optionNave = enterOption(); //Ingresar una opción

        switch (optionNave){
            case 1:
                System.out.println("Nave seleccionada: " + naves[0]);

                speed = naveSpeed(optionNave); //Mostrar la velocidad de la nave seleccionada
                System.out.println("La velocidad es: " + speed + " k/h");

                passengerCapacity(optionNave); //Mostrar la capacidad de pasajeros de la nave seleccionada
                break;
            case 2:
                System.out.println("Nave seleccionada: "+ naves[1]);
                speed = naveSpeed(optionNave);
                System.out.println("La velocidad es: " + speed + " k/h");
                passengerCapacity(optionNave);
                break;
            case 3:
                System.out.println("Nave seleccionada: "+ naves[2]);
                speed = naveSpeed(optionNave);
                System.out.println("La velocidad es: " + speed + " k/h");
                passengerCapacity(optionNave);
                break;
            default:
            System.out.println("Opción invalida");
                break;
        }

        System.out.println();

        calculateTime(speed, route); //Calcular los días estimados del viaje a partir de la distancia y la velocidad
        amountpassengers(); //Solicitar la cantidad de pasajeros que viajarán
        manageResources();
        System.out.println("----------------------------------");
    }

    public static void amountpassengers(){
        
        //Solicitar la cantidad de pasajeros que viajarán y verificar si el valor el negativo o positivo
        boolean amount = true;
        while (amount) {
            System.out.println("Ingrese la cantidad de pasajeros que viajaran: ");
            passenger = scanner.nextInt();
            if(passenger < 1){
                System.out.println("Cantidad incorrecta, intentelo de nuevo.");
            }else{
                amount = false;
            }
        }
    }

    public static void calculateTime(double velocidad, double distancia){ //Caldular el tiempo del viaje en días
        double time = distancia * 1000000 / velocidad;
        days = time / 24;
        System.out.println("La duración estimada del viaje es de " + days + " días.");
    }

    public static void travelSimulation(){

        var rand = random.nextInt(80); //Numero aleatorio que se compara con el progreso para soltar el evento
        progress = 0;

        System.out.println("Iniciando viaje en: "); //Cuenta regresiva
            for(int i = 3; i > 0; i--){
                System.out.println(i);
            }
        System.out.println("Despegando...");
        System.out.println();

        for(progress = 0; progress <= 100; progress++){
            
            if(progress == rand){
                events(); //Mostrar evento aleatorio
            }
            
            //Progreso del viaje
            if(progress == 0){
                System.out.println("Inicio del viaje...");
            }else if(progress == 50){
                System.out.println("Vamos a la mitad del camino...");
            }else if(progress < 100 && progress != 50){
                System.out.println("Llevas un " + progress + "% del viaje");
            }else if(rand == progress){
                events();
            }else if(progress == 100){
                System.out.println("Llegada al destino, el viaje se completó correctamente!");
            }
        }
    }

    public static void manageResources(){
        // Calcular combustible
        switch (optionNave) {
            case 1:
                calculateFuel = days * fuel[0];
                System.out.println("El combustible necesario para el viaje es: " + calculateFuel + " kilogramos");
                break;
            case 2:
                calculateFuel = days * fuel[1];
                System.out.println("El combustible necesario para el viaje es: " + calculateFuel + " kilogramos");
                break;
            case 3:
                calculateFuel = days * fuel[2];
                System.out.println("El combustible necesario para el viaje es: " + calculateFuel + " kilogramos");
                break;
            default:
                break;
        }

        //Calcular Oxigeno

        calculateOxygen = passenger * oxygen * days;
        System.out.println("El oxigeno necesario para el viaje es: " + calculateOxygen + " kilogramos");

        //Ajustar recursos de la nave
        adjustResources();
    }

    public static void events(){
        
        //Mostrar evento aleatorio
        int randomEvent = random.nextInt(1,3);
        switch (randomEvent) {
            case 1:
                System.out.println(event[0]);
                break;
            case 2:
                System.out.println(event[1]);
                break;
            case 3:
                System.out.println(event[2]);
                break;    
            default:
                break;
        }

        //Decisiones sobre el evento generado
        System.out.println("¿Que deseas hacer?");
        System.out.println("1. continuar");
        System.out.println("2. desviar");
        System.out.println("3. Reparar");
        var decision = scanner.nextInt();

            switch (decision) {
                case 1:
                    System.out.println("Continuando...");
                    break;
                case 2:
                    System.out.println("Calculando nueva ruta...");
                    System.out.println("Ruta deifinida, continuando viaje...");
                    break;
                case 3:
                    System.out.println("Reparando la nave...");
                    System.out.println("Falla ajustada con exito! \nContinuando...");
                    break;
                default:
                    break;
            }
    }


    //Metodos auxiliares

    public static int enterOption(){ //Ingresar una opción
        System.out.println("Por favor seleccione una opción: ");
        int optionUser = scanner.nextInt();
        System.out.println("----------------------------------");
        return optionUser;
    }

    public static double planetDistance(int opcion){ //Mostrar la distancia del planeta seleccionado
        double range = 0;
        switch (opcion) {
            case 1:
                range = distance[0];
                break;
            case 2:
                range = distance[1];
                break;
            case 3:
                range = distance[2];
                break;
            case 4:
                range = distance[3];
                break;
            case 5:
                range = distance[4];
                break;
            default:
                break;
        }

        return range;
    }

    public static void showArray(String[]aux){ //Mostrar contenido de un array
        int option = 1;
        System.out.println("Listado: ");

        for(int i = 0; i < aux.length; i++){
            System.out.println(option++ + ". " + aux[i]);
        }
    }

    public static double naveSpeed(int option){ //Mostrar la velocidad de la nave seleccionada

        double velocity = 0;
        switch (option) {
            case 1:
                velocity = maxSpeed[0];
                break;
            case 2:
                velocity = maxSpeed[1];
                break;
            case 3:
                velocity = maxSpeed[2];
                break;
            default:
                break;
        }

        return velocity;
    }

    public static void planetDescription(int option){ //Mostrar la descripción del planeta seleccionado
        switch (option) {
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

    public static void passengerCapacity(int option){ //Mostrar la capacidad de pasajeros de la nave seleccionada
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

    public static void adjustResources (){

        //Ajustar recursos de la nave
        var exit = true;
        
        System.out.println("¿Deseas ajustar los recursos?");
        System.out.println("1. Si \n2. No ");
        var option = scanner.nextInt();

        
        if(option == 1){
            while (exit) {
                System.out.println("¿Que deseas hacer?");
                System.out.println("1. Aumentar combustible");
                System.out.println("2. Aumentar oxigeno");
                System.out.println("3. Salir");
                var opt = scanner.nextInt();
                    if(opt == 1){
                        System.out.println("Ingresa cuanto quieres agregar de combustible: ");
                        var fuel = scanner.nextInt();
                        var finalFuel = fuel + calculateFuel;
                        System.out.println("El combustible final con el ajuste es: " + finalFuel);
                    }else if(opt == 2){
                        System.out.println("Ingresa cuanto quieres agregar de oxigeno: ");
                        var oxygen = scanner.nextInt();
                        var finalOxygen = oxygen + calculateOxygen;
                        System.out.println("El oxigeno final con el ajuste es: " + finalOxygen);
                    }else if (opt == 3){
                        System.out.println("Continuando...");
                        exit = false;
                    }
                } 
            } else{
                System.out.println("Ok continuado...");
            }
    }

}
