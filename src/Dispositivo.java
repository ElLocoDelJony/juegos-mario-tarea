public class Dispositivo {
    private String marca;
    private String modelo;
    private double precio;

    public Dispositivo(String marca, String modelo, double precio){
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

    public void tipo(){
        System.out.println("Tipo de dispostivo");
    }

    @Override
    public String toString() {
        return "";
    }
}

class Laptop extends Dispositivo{
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


class Telefono extends Dispositivo{
    private String esCargaRapida;
    public Telefono(String marca, String modelo, double precio,String esCargaRapida){
        super(marca, modelo, precio);
        this.esCargaRapida = esCargaRapida;
    }

    @Override
    public void tipo(){
        System.out.println("TELEFONOS REGISTRADOS");
        System.out.println("\nModelo del dispositivo: "+getModelo()+
                "\nMarca del dispositivo: "+getMarca()+
                "\nEs carga Rapida?: "+esCargaRapida);
    }


}

class DatoInvalidosException extends Exception{
    public DatoInvalidosException(String mensaje){
        super(mensaje);
    }
}

