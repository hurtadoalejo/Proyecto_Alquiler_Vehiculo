package co.edu.uniquindio.poo;

public class Auto extends Vehiculo{
    private int numPuertas;

    /**
     * Metodo constructor de la clase Auto
     * @param numMatricula Numero de la matricula del auto a crear 
     * @param marca Marca del auto a crear
     * @param modelo Modelo del auto a crear
     * @param anioFabricacion Año de fabricacion del auto a crear
     * @param numPuertas Numero de puertas del auto a crear
     */
    public Auto(int numMatricula, String marca, int modelo, int anioFabricacion, int numPuertas) {
        super(numMatricula, marca, modelo, anioFabricacion);
        this.numPuertas = numPuertas;
    }
    
    /**
     * Metodo para obtener el numero de puertas del auto
     * @return Numero de puertas del auto
     */
    public int getNumPuertas() {
        return numPuertas;
    }

    /**
     * Metodo para modificar el numero de puertas del auto
     * @param numPuertas Nuevo numero de puertas del auto
     */
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    /**
     * Metodo para calcular el alquiler del auto
     */
    @Override
    public void calcularAlquiler(int Alquiler) {
        
    }
}