
abstract public class Juego { // Clase padre
    private String nombre;
    private String añoSalida;

    public Juego(String nombre,String añoSalida){
        this.nombre = nombre;
        this.añoSalida = añoSalida;
    }

    // Getters
    public String getNombre(){
        return nombre;
    }

    public String getAñoSalida(){
        return añoSalida;
    }


    public abstract void tipoJuego();


    @Override  // Metodo sobreecrito para imprimir objetos de manera legible
    public String toString() {
        return "";
    }


}

class MarioBros extends Juego{  // clase hija
    private String esExclusivo;
    public MarioBros(String nombre, String añoSalida, String esExclusivo){

        super(nombre,añoSalida);
        this.esExclusivo = esExclusivo;
    }

    @Override  // Sobreescribir metodo abstract
    public void tipoJuego(){
        System.out.println("Mario Bros");
        System.out.println(
                "\nNombre del Juego "+getNombre() +"\nAño de salida "+ getAñoSalida()+
                        "\nEs exclusivo de nintendo? "+esExclusivo);
    }

}

class CarreraVehiculos extends Juego{ // clase hija
    private int numeroJugadores;
    public CarreraVehiculos(String nombre, String añoSalida, int numeroJugadores){
        super(nombre,añoSalida);
        this.numeroJugadores = numeroJugadores;
    }

    @Override
    public void tipoJuego(){  // metodo sobrescrito
        System.out.println("\"Carrera Vehiculos\" ");
        System.out.println("\nNombre Juego "+getNombre()+
                "\nNumero de Jugadores: "+ numeroJugadores+ "\nAño de salida: "+getAñoSalida());
    }
}

// Excepcion personalizada

class DatosInvalidosException extends Exception{
    public DatosInvalidosException(String mensaje){
        super(mensaje);
    }
}

2. Ejericicio Dispositivo

public class Dispositivo {  // Clase padre
    private String marca;
    private String modelo;
    private double precio;

    public Dispositivo(String marca, String modelo, double precio){   // CONSTRUCTOR
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }


    // GETTERS Y SETTERS

    public void setMarca(String m){marca = m;}

    public String getMarca(){return marca;}

    public void setModelo(String md){modelo = md;}

    public String getModelo(){return modelo;}

    public void setPrecio(double p){precio = p;}

    public double getPrecio(){return precio;}

    // Metodo clase padre

    public void tipo(){  // metodo que se va a heredar
        System.out.println("Tipo de dispostivo");
    }

    @Override  // para que sea legible la impresion de los objetos
    public String toString() {
        return "";
    }
}

class Laptop extends Dispositivo{   // Clase hija
    private String sistemaOperativo;
    public Laptop(String marca, String modelo, double precio, String sistemaOperativo){
        super(marca, modelo, precio);
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public void tipo(){
        System.out.println("LAPTOPS REGISTRADAS");
        System.out.println("\nModelo del dispositivo: "+getModelo()+
                "\nMarca del dispositivo: "+getMarca()+
                "\nSistema operativo: "+sistemaOperativo);
    }



}


class Telefono extends Dispositivo{  // Clase hija
    private String esCargaRapida;
    public Telefono(String marca, String modelo, double precio,String esCargaRapida){
        super(marca, modelo, precio);
        this.esCargaRapida = esCargaRapida;
    }

    @Override  // Sobrescribir metodo padre
    public void tipo(){
        System.out.println("TELEFONOS REGISTRADOS");
        System.out.println("\nModelo del dispositivo: "+getModelo()+
                "\nMarca del dispositivo: "+getMarca()+
                "\nEs carga Rapida?: "+esCargaRapida);
    }


}

class DatoInvalidosException extends Exception{   // Excepcion personalizada
    public DatoInvalidosException(String mensaje){
        super(mensaje);
    }
}






