package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo{
    private Tipo_transmision tipoTransmision;

    /**
     * Metodo constructor de la clase Moto
     * @param numMatricula Numero de la matricula de la moto a crear 
     * @param marca Marca de la moto a crear
     * @param modelo Modelo de la moto a crear
     * @param anioFabricacion Año de fabricacion de la moto a crear
     * @param tipoTransmision Tipo de transmision de la moto a crear
     */
    public Moto(int numMatricula, String marca, int modelo, int anioFabricacion, Tipo_transmision tipoTransmision) {
        super(numMatricula, marca, modelo, anioFabricacion);
        this.tipoTransmision = tipoTransmision;
    }
    
    /**
     * Metodo para obtener el tipo de transmision de la moto
     * @return Tipo de transmision de la moto
     */
    public Tipo_transmision getTipoTransmision() {
        return tipoTransmision;
    }

    /**
     * Metodo para modificar el tipo de transmision de la moto
     * @param tipoTransmision Nuevo tipo de transmision de la moto
     */
    public void setTipoTransmision(Tipo_transmision tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }

    /**
     * Metodo para calcular el alquiler de la moto
     */
    @Override
    public double calcularAlquiler(double tarifaBase, int diasAlquiler) {
        double total = tarifaBase * diasAlquiler;
        if (tipoTransmision == Tipo_transmision.AUTOMATICA) {
            total *= 1.2;
        }
        return total; 
    }

}