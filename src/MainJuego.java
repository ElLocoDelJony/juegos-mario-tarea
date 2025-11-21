import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Juego> juegos = new ArrayList<>();
        int opcion = -1;

        do {
            System.out.println("\n--MENU DE JUEGOS--");
            System.out.println("DIGITE UNA OPCION:");
            System.out.println("1. Registrar Juego de Mario Bros");
            System.out.println("2. Registrar Carrera de Vehiculo");
            System.out.println("3. Consultar Juegos");
            System.out.println("4. Buscar juegos por nombre");
            System.out.println("5. Filtrar por tipo de juego");
            System.out.println("6. SALIR");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        try {
                            System.out.print("Digite el nombre del juego: ");
                            String nombre = sc.nextLine();
                            if (nombre.isEmpty()) {
                                throw new DatosInvalidosException("El nombre no puede estar vacío");
                            }

                            System.out.print("Digite el año de salida del juego: ");
                            String añoSalida = sc.nextLine();
                            if (añoSalida.isEmpty()) {
                                throw new DatosInvalidosException("El año de salida no puede estar vacío");
                            }

                            System.out.print("Es exclusivo de Nintendo? (true/false): ");
                            String esExclusivo = sc.nextLine().toLowerCase();
                            if (!esExclusivo.equals("true") && !esExclusivo.equals("false")) {
                                throw new DatosInvalidosException("Debe ingresar 'true' o 'false'");
                            }

                            juegos.add(new MarioBros(nombre, añoSalida, esExclusivo));
                            System.out.println("Juego agregado correctamente");
                        } catch (DatosInvalidosException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Digite el nombre del juego Carrera: ");
                            String nombre = sc.nextLine();
                            if (nombre.isEmpty()) {
                                throw new DatosInvalidosException("El nombre no puede estar vacío");
                            }

                            System.out.print("Digite el año de salida: ");
                            String añoSalida = sc.nextLine();
                            if (añoSalida.isEmpty()) {
                                throw new DatosInvalidosException("El año de salida no puede estar vacío");
                            }

                            System.out.print("Ingrese el número de jugadores: ");
                            int numeroJ = sc.nextInt();
                            sc.nextLine();
                            if (numeroJ <= 0) {
                                throw new DatosInvalidosException("El número de jugadores debe ser positivo");
                            }

                            juegos.add(new CarreraVehiculos(nombre, añoSalida, numeroJ));
                            System.out.println("Juego agregado correctamente");
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Debe ingresar un número válido");
                            sc.nextLine(); // limpiar buffer
                        } catch (DatosInvalidosException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.println("\n--- Juegos registrados ---");
                        if (juegos.isEmpty()) {
                            System.out.println("La lista de juegos está vacía");
                        } else {
                            for (Juego j : juegos) {
                                System.out.println(j);   // usa toString()
                                j.tipoJuego();           // polimorfismo
                            }
                        }
                        break;

                    case 4:
                        try {
                            System.out.println("Digite el nombre del juego a buscar: ");
                            String buscar = sc.nextLine();
                            boolean encontrado = false;

                            if(buscar.isEmpty()){
                                throw new DatosInvalidosException("No puede estar vacio el campo");
                            }
                            if(juegos.isEmpty()){
                                System.out.println("Lista vacia");
                            }
                            for(Juego j: juegos){
                                if(j.getNombre().equalsIgnoreCase(buscar)){
                                   encontrado = true;
                                   break;
                                }
                            }

                            if(encontrado){
                                System.out.println("El juego "+ buscar+" esta en la lista" );
                            }else {
                                System.out.println("El juego "+buscar +" no esta en la lista");
                            }

                        }catch (DatosInvalidosException e ){
                            System.out.println("Error: "+e.getMessage());
                        }break;

                    case 5:
                        try{
                            System.out.println("¿Qué tipo de juego desea consultar?");
                            System.out.println("1. Mario Bros");
                            System.out.println("2. Carrera de Vehículos");
                            int tipo = sc.nextInt();
                            sc.nextLine();

                            if(tipo!=1 && tipo!=2){
                                System.out.println("Opcion no valida");
                            }


                            if (juegos.isEmpty()) {
                                System.out.println("No hay juegos registrados");
                            } else {
                                for (Juego j : juegos) {
                                    if (tipo == 1 && j instanceof MarioBros) {
                                        System.out.println(j);
                                        j.tipoJuego();
                                    } else if (tipo == 2 && j instanceof CarreraVehiculos) {
                                        System.out.println(j);
                                        j.tipoJuego();
                                    }
                                }
                            }

                        }catch (InputMismatchException e){
                            System.out.println("Error: Debe ser un numero entero");
                        }break;



                    case 6:
                        System.out.println("SALIENDO DEL SISTEMA...");
                        break;

                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero para la opción");
                sc.nextLine(); // limpiar buffer
            }

        } while (opcion != 6);

    }
}
