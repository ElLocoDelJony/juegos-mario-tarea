import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDispositivo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Dispositivo> dispositivo = new ArrayList<>();
        int opcion = -1;

        do {
            System.out.println("\n--MENU DE DISPOSITIVOS--");
            System.out.println("SELECCIONE UNA OPCION");
            System.out.println("1. Registrar dispositivo Laptop");
            System.out.println("2. Registrar dispositivo Telefono");
            System.out.println("3. Ver lista de dispositivos registrados");
            System.out.println("4. Filtrar por tipo: (Laptop/Telefono)");
            System.out.println("5. Salir");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        try {
                            System.out.print("Marca del dispositivo: ");
                            String marca = sc.nextLine();
                            if (marca.isEmpty()) throw new DatosInvalidosException("La marca no puede estar vacía");

                            System.out.print("Modelo del dispositivo: ");
                            String modelo = sc.nextLine();
                            if (modelo.isEmpty()) throw new DatosInvalidosException("El modelo no puede estar vacío");

                            System.out.print("Digite el precio: ");
                            double precio = sc.nextDouble();
                            sc.nextLine();
                            if (precio < 1) throw new DatosInvalidosException("El precio debe ser mayor a 0");

                            System.out.print("Sistema Operativo: ");
                            String so = sc.nextLine();
                            if (so.isEmpty()) throw new DatosInvalidosException("El sistema operativo no puede estar vacío");

                            dispositivo.add(new Laptop(marca, modelo, precio, so));
                            System.out.println("Laptop agregada correctamente");
                        } catch (DatosInvalidosException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Debe ingresar un número válido para el precio");
                            sc.nextLine();
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Marca del dispositivo: ");
                            String marca = sc.nextLine();
                            if (marca.isEmpty()) throw new DatosInvalidosException("La marca no puede estar vacía");

                            System.out.print("Modelo del dispositivo: ");
                            String modelo = sc.nextLine();
                            if (modelo.isEmpty()) throw new DatosInvalidosException("El modelo no puede estar vacío");

                            System.out.print("Digite el precio: ");
                            double precio = sc.nextDouble();
                            sc.nextLine();
                            if (precio < 1) throw new DatosInvalidosException("El precio debe ser mayor a 0");

                            System.out.print("Es carga rápida? (true/false): ");
                            String es = sc.nextLine().toLowerCase();
                            if (!es.equals("true") && !es.equals("false")) {
                                throw new DatosInvalidosException("Debe ingresar 'true' o 'false'");
                            }

                            dispositivo.add(new Telefono(marca, modelo, precio, es));
                            System.out.println("Teléfono agregado correctamente");
                        } catch (DatosInvalidosException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Debe ingresar un número válido para el precio");
                            sc.nextLine();
                        }
                        break;

                    case 3:
                        System.out.println("\n--- Dispositivos registrados ---");
                        if (dispositivo.isEmpty()) {
                            System.out.println("La lista está vacía");
                        } else {
                            for (Dispositivo d : dispositivo) {
                                System.out.println(d);   // usa toString()
                                d.tipo();               // polimorfismo
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Seleccione una opción: \n1. Teléfono \n2. Laptop");
                        int op = sc.nextInt();
                        sc.nextLine();
                        if (op != 1 && op != 2) {
                            System.out.println("Opción no válida");
                        } else {
                            for (Dispositivo d : dispositivo) {
                                if (op == 1 && d instanceof Telefono) {
                                    System.out.println(d);
                                    d.tipo();
                                } else if (op == 2 && d instanceof Laptop) {
                                    System.out.println(d);
                                    d.tipo();
                                }
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero para la opción");
                sc.nextLine();
            }

        } while (opcion != 5);

        sc.close();
    }
}
