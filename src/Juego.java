
abstract public class Juego {
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


    @Override
    public String toString() {
        return "";
    }


}

class MarioBros extends Juego{
    private String esExclusivo;
    public MarioBros(String nombre, String añoSalida, String esExclusivo){

        super(nombre,añoSalida);
        this.esExclusivo = esExclusivo;
    }

    @Override
    public void tipoJuego(){
        System.out.println("Mario Bros");
        System.out.println(
                "\nNombre del Juego "+getNombre() +"\nAño de salida "+ getAñoSalida()+
                        "\nEs exclusivo de nintendo? "+esExclusivo);
    }

}

class CarreraVehiculos extends Juego{
    private int numeroJugadores;
    public CarreraVehiculos(String nombre, String añoSalida, int numeroJugadores){
        super(nombre,añoSalida);
        this.numeroJugadores = numeroJugadores;
    }

    @Override
    public void tipoJuego(){
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