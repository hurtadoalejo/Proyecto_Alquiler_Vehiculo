package co.edu.uniquindio.poo.model;

public class Cliente {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private Estado_disponibilidad estadoCliente;

    /**
     * Metodo constructor de la clase Cliente
     * @param nombre Nombre del cliente a crear
     * @param cedula Cedula del cliente a crear
     * @param telefono Telefono del cliente a crear
     * @param correo Correo del cliente a crear
     */
    public Cliente(String nombre, String cedula, String telefono, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.estadoCliente = Estado_disponibilidad.DISPONIBLE;
    }

    /**
     * Metodo para obtener el nombre del cliente
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para obtener la cedula del cliente
     * @return Cedula del cliente
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * Metodo para obtener el telefono del cliente
     * @return Telefono del cliente
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Metodo para obtener el correo del cliente
     * @return Correo del cliente
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Metodo para obtener el estado del cliente
     * @return Estado del cliente
     */
    public Estado_disponibilidad getEstadoCliente() {
        return estadoCliente;
    }

    /**
     * Metodo para modificar el nombre del cliente
     * @param nombre Nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para modificar la cedula del cliente
     * @param cedula Nueva cedula del cliente
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * Metodo para modificar el telefono del cliente
     * @param telefono Nuevo telefono del cliente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Metodo para modificar el correo del cliente
     * @param correo Nuevo correo del cliente
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Metodo para modificar el estado del cliente
     * @param estadoCliente Nuevo estado del cliente
     */
    public void setEstadoCliente(Estado_disponibilidad estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
    
}