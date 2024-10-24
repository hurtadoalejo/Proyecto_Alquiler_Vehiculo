package co.edu.uniquindio.poo;

public class Alquiler {
    private int codigo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double costoAlquiler;
    private int diasAlquiler;
    private double tarifaBase;

    /**
     * Metodo constructor de la clase Alquiler
     * @param codigo Codigo del alquiler a crear
     * @param cliente Cliente del alquiler a crear
     * @param vehiculo Vehiculo del alquiler a crear
     */
    public Alquiler(int codigo, Cliente cliente, Vehiculo vehiculo) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.costoAlquiler = 0;
    }

    /**
     * Metodo para obtener el codigo del alquiler
     * @return Codigo del alquiler
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * Metodo para obtener el cliente del alquiler
     * @return Cliente del alquiler
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Metodo para obtener el vehiculo del alquiler
     * @return Vehiculo del alquiler
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    /**
     * Metodo para obtener el costo del alquiler
     * @return Costo del alquiler
     */
    public double getCostoAlquiler() {
        return costoAlquiler;
    }
    /**
     * Metodo para obtener los dias del alquiler
     * @return Dias del alquiler
     */
    public int getDiasAlquiler() {
        return diasAlquiler;
    }
    /**
     * Metodo para obtener la tarifa base del alquiler
     * @return Tarifa base del alquiler
     */
    public double getTarifaBase() {
        return tarifaBase;
    }

    /**
     * Metodo para modificar el codigo del alquiler
     * @param codigo Nuevo codigo del alquiler
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    /**
     * Metodo para modificar el cliente del alquiler
     * @param cliente Nuevo cliente del alquiler
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * Metodo para modificar el vehiculo del alquiler
     * @param vehiculo Nuevo vehiculo del alquiler
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    /**
     * Metodo para modificar el costo del alquiler
     * @param costoAlquiler
     */
    public void setCostoAlquiler(double costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
    }
    /**
     * Metodo para modificar los dias del alquiler
     * @param diasAlquiler Nuevos dias del alquiler
     */
    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }
    /**
     * Metodo para modificar la tarifa base del alquiler
     * @param tarifaBase Nueva tarifa base del alquiler
     */
    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double calcularTotal(){
        double costoTotal = vehiculo.calcularAlquiler(tarifaBase, diasAlquiler);
        return costoTotal;
    }
}