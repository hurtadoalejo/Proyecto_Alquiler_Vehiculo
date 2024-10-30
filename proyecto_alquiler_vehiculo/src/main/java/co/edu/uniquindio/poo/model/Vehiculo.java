package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    private int numMatricula;
    private String marca;
    private int modelo;
    private int anioFabricacion;
    private Estado_disponibilidad estadoVehiculo;

    /**
     * Metodo constructor de la clase Vehiculo
     * @param numMatricula Numero de la matricula del vehiculo a crear 
     * @param marca Marca del vehiculo a crear
     * @param modelo Modelo del vehiculo a crear
     * @param anioFabricacion Año de fabricacion del vehiculo a crear
     */
    public Vehiculo(int numMatricula, String marca, int modelo, int anioFabricacion) {
        this.numMatricula = numMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.estadoVehiculo = Estado_disponibilidad.DISPONIBLE;
    }

    /**
     * Metodo para obtener el numero de matricula del vehiculo
     * @return Numero de matricula del vehiculo
     */
    public int getNumMatricula() {
        return numMatricula;
    }
    /**
     * Metodo para obtener la marca del vehiculo
     * @return Marca del vehiculo
     */
    public String getMarca() {
        return marca;
    }
    /**
     * Metodo para obtener el modelo del vehiculo
     * @return Modelo del vehiculo
     */
    public int getModelo() {
        return modelo;
    }
    /**
     * Metodo para obtener el año de fabricacion del vehiculo
     * @return Año de fabricacion del vehiculo
     */
    public int getAnioFabricacion() {
        return anioFabricacion;
    }
    /**
     * Metodo para obtener el estado del vehiculo
     * @return Estado del vehiculo
     */
    public Estado_disponibilidad getEstadoVehiculo() {
        return estadoVehiculo;
    }

    /**
     * Metodo para modificar el numero de matricula del vehiculo
     * @param numMatricula Nuevo numero de matricula del vehiculo
     */
    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }
    /**
     * Metodo para modificar la marca del vehiculo
     * @param marca Nueva marca del vehiculo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
     * Metodo para modificar el modelo del vehiculo
     * @param modelo Nuevo modelo del vehiculo
     */
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    /**
     * Metodo para modificar el año de fabricacion del vehiculo
     * @param anioFabricacion Nuevo año de fabricacion del vehiculo
     */
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    /**
     * Metodo para modificar el estado del vehiculo
     * @param estadoVehiculo Nuevo estado del vehiculo
     */
    public void setEstadoVehiculo(Estado_disponibilidad estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public abstract double calcularAlquiler(double tarifaBase, int diasAlquiler);
}