package co.edu.uniquindio.poo;
import java.util.LinkedList;
import java.util.List;

public class Empresa {
    private String nombre;
    private double gananciasTotales;
    private List<Cliente> listaClientes;
    private List<Vehiculo> listaVehiculos;
    private List<Alquiler> listaAlquileres;
    
    /**
     * Metodo constructor de la clase Empresa
     * @param nombre Nombre de la empresa a crear
     */
    public Empresa(String nombre) {
        this.nombre = nombre;
        gananciasTotales = 0;
        listaClientes = new LinkedList<>();
        listaVehiculos = new LinkedList<>();
        listaAlquileres = new LinkedList<>();
    }

    /**
     * Metodo para obtener el nombre de la empresa
     * @return Nombre de la empresa
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para obtener las ganancias totales de la empresa
     * @return Ganancias totales de la empresa
     */
    public double getGananciasTotales() {
        return gananciasTotales;
    }
    /**
     * Metodo para obtener la lista de clientes de la empresa
     * @return Lista de clientes de la empresa
     */
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    /**
     * Metodo para obtener la lista de vehiculos de la empresa
     * @return Lista de vehiculos de la empresa
     */
    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
    /**
     * Metodo para obtener la lista de alquileres de la empresa
     * @return Lista de alquileres de la empresa
     */
    public List<Alquiler> getListaAlquileres() {
        return listaAlquileres;
    }

    /**
     * Metodo para modificar el nombre de la empresa
     * @param nombre Nuevo nombre de la empresa
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para modificar las ganancias totales de la empresa
     * @param gananciasTotales Nuevas ganancias totales de la empresa
     */
    public void setGananciasTotales(double gananciasTotales) {
        this.gananciasTotales = gananciasTotales;
    }
    /**
     * Metodo para modificar la lista de clientes de la empresa
     * @param listaClientes Nueva lista de clientes de la empresa
     */
    public void setListaClientes(LinkedList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    /**
     * Metodo para modificar la lista de vehiculos de la empresa
     * @param listaVehiculos Nueva lista de vehiculos de la empresa
     */
    public void setListaVehiculos(LinkedList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
    /**
     * Metodo para modificar la lista de alquileres de la empresa
     * @param listaAlquileres Nueva lista de alquileres de la empresa
     */
    public void setListaAlquileres(LinkedList<Alquiler> listaAlquileres) {
        this.listaAlquileres = listaAlquileres;
    }

    /**
     * Metodo para agregar un cliente a la lista de clientes de la empresa
     * @param cliente Cliente que se quiere agregar
     */
    public void agregarCliente(Cliente cliente){
        if (!verificarCliente(cliente.getCedula())) {
            listaClientes.add(cliente);
        }
    }
    /**
     * Metodo para verificar si hay un cliente en la lista de clientes de la empresa con la misma cedula que la administrada
     * @param cedula Cedula a verificar
     * @return Booleano sobre si existe un cliente con esa condicion o no
     */
    public boolean verificarCliente(String cedula){
        boolean repetido = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                repetido = true;
                break;
            }
        }
        return repetido;
    }
    /**
     * Metodo para eliminar un cliente de la lista de clientes de la empresa si tiene la misma cedula que la administrada 
     * @param cedula Cedula del cliente a eliminar
     */
    public void eliminarCliente(String cedula){
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                listaClientes.remove(cliente);
                break;
            }
        }
    }

    /**
     * Metodo para agregar un vehiculo a la lista de vehiculos de la empresa
     * @param vehiculo Vehiculo que se quiere agregar
     */
    public void agregarVehiculo(Vehiculo vehiculo){
        if (!verificarVehiculo(vehiculo.getNumMatricula())) {
            listaVehiculos.add(vehiculo);
        }
    }
    /**
     * Metodo para verificar si hay un vehiculo en la lista de vehiculos de la empresa con el mismo numero de matricula que la administrada
     * @param numMatricula Numero de matricula a verificar
     * @return Booleano sobre si existe un vehiculo con esa condicion o no
     */
    public boolean verificarVehiculo(int numMatricula){
        boolean repetido = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getNumMatricula() == numMatricula) {
                repetido = true;
                break;
            }
        }
        return repetido;
    }
    /**
     * Metodo para eliminar un vehiculo de la lista de vehiculos de la empresa si tiene el mismo numero de matricula que la administrada 
     * @param numMatricula Numero de matricula del vehiculo a eliminar
     */
    public void eliminarVehiculo(int numMatricula){
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getNumMatricula() == numMatricula) {
                listaVehiculos.remove(vehiculo);
                break;
            }
        }
    }

    /**
     * Metodo para agregar un alquiler a la lista de alquileres de la empresa
     * @param alquiler Alquiler que se busca agregar a la lista de alquileres de la empresa
     */
    public void agregarAlquiler(Alquiler alquiler){
        if (!verificarAlquiler(alquiler.getCodigo())) {
            if (!verificarVehiculo(alquiler.getVehiculo().getNumMatricula())) {
                if (!verificarCliente(alquiler.getCliente().getCedula())) {
                    listaAlquileres.add(alquiler);
                }
            }
        }
    }
    /**
     * Metodo para verificar si hay un alquiler en la lista de alquileres de la empresa con el mismo codigo que el administrado
     * @param codigo Codigo a verificar
     * @return Booleano sobre si existe un alquiler con esa condicion o no
     */
    public boolean verificarAlquiler(int codigo){
        boolean repetido = false;
        for (Alquiler alquiler : listaAlquileres) {
            if (alquiler.getCodigo() == codigo) {
                repetido = true;
                break; 
            }
        }
        return repetido;
    }
    /**
     * Metodo para eliminar un alquiler de la lista de alquileres de la empresa si tiene el mismo codigo que el administrado
     * @param codigo
     */
    public void eliminarAlquiler(int codigo){
        for (Alquiler alquiler : listaAlquileres) {
            if (alquiler.getCodigo() == codigo) {
                listaAlquileres.remove(alquiler);
                break;
            }
        }
    }


    /**
     * Metodo para calcular las ganancias totales de la empresa
     * @return Ganancias totales de la empresa
     */
    public double calcularGanaciasTotales(){
        double ganaciasTotales = 0;
        for (Alquiler alquiler : listaAlquileres) {
            ganaciasTotales += alquiler.calcularTotal();
        }
        return ganaciasTotales;
    }
}