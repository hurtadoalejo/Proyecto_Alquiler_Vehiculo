package co.edu.uniquindio.poo;

public class Camioneta extends Vehiculo{
    private double capacidadCarga;

    /**
     * Metodo constructor de la clase Camioneta
     * @param numMatricula Numero de la matricula de la camioneta a crear 
     * @param marca Marca de la camioneta a crear
     * @param modelo Modelo de la camioneta a crear
     * @param anioFabricacion Año de fabricacion de la camionetao a crear
     * @param capacidadCarga Capacidad de carga de la camioneta a crear
     */
    public Camioneta(int numMatricula, String marca, int modelo, int anioFabricacion, double capacidadCarga) {
        super(numMatricula, marca, modelo, anioFabricacion);
        this.capacidadCarga = capacidadCarga;
    }

    /**
     * Metodo para obtener la capacidad de carga de la camioneta
     * @return Capacidad de carga de la camioneta
     */
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    /**
     * Metodo para modificar la capacidad de carga de la camioneta
     * @param capacidadCarga Nueva capacidad de carga de la camioneta
     */
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    
    /**
     * Metodo para calcular el alquiler de la moto
     */
    @Override
    public double calcularAlquiler(double tarifaBase, int diasAlquiler) {
        double total = tarifaBase * diasAlquiler;
        return total; 
    }
}