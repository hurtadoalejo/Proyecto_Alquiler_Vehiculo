package co.edu.uniquindio.poo.model;
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
     * Metodo para agregar un cliente a la lista de clientes de la empresa y devolver booleano sobre si se pudo agregar o no
     * @param cliente Cliente que se quiere agregar
     * @return Booleano sobre si se pudo agregar o no
     */
    public boolean agregarCliente(Cliente cliente){
        boolean accion = false;
        if (!verificarCliente(cliente.getCedula())) {
            accion = true;
            listaClientes.add(cliente);
        }
        return accion;
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
     * Metodo para actualizar los datos de un cliente si corresponde a una cedula entregada
     * @param cedula Cedula a verificar
     * @param actualizado Cliente con los datos nuevos
     * @return Booleano sobre si se pudo actualizar o no
     */
    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean accion = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setTelefono(actualizado.getTelefono());
                cliente.setCorreo(actualizado.getCorreo());
                accion = true;
                break;
            }
        }
        return accion;
    }
    /**
     * Metodo para eliminar un cliente de la lista de clientes de la empresa si tiene la misma cedula que la administrada y devolver un booleano si se pudo eliminar o no
     * @param cedula Cedula del cliente a eliminar
     * @return Booleano sobre si se pudo eliminar o no
     */
    public boolean eliminarCliente(String cedula){
        boolean accion = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                accion = true;
                listaClientes.remove(cliente);
                break;
            }
        }
        return accion;
    }

    /**
     * Metodo para agregar un vehiculo a la lista de vehiculos de la empresa y devolver booleano sobre si se pudo agregar o no
     * @param vehiculo Vehiculo que se quiere agregar
     * @return Booleano sobre si se pudo agregar o no
     */
    public boolean agregarVehiculo(Vehiculo vehiculo){
        boolean accion = false;
        if (!verificarVehiculo(vehiculo.getNumMatricula())) {
            accion = true;
            listaVehiculos.add(vehiculo);
        }
        return accion;
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
            }
        }
        return repetido;
    }
    /**
     * Metodo para actualizar los datos de un vehiculo si corresponde a un numero de matricula entregado
     * @param numMatricula Numero de matricula a verificar
     * @param actualizado Vehiculo con los datos nuevos
     * @return Booleano sobre si se pudo actualizar o no
     */
    public boolean actualizarVehiculo(int numMatricula, Vehiculo actualizado) {
        boolean accion = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getNumMatricula() == numMatricula) {
                vehiculo.setModelo(actualizado.getModelo());
                vehiculo.setMarca(actualizado.getMarca());
                vehiculo.setNumMatricula(actualizado.getNumMatricula());
                vehiculo.setAnioFabricacion(actualizado.getAnioFabricacion());
                if (vehiculo instanceof Camioneta && actualizado instanceof Camioneta) {
                    ((Camioneta) vehiculo).setCapacidadCarga(((Camioneta) actualizado).getCapacidadCarga());                   
                }
                else if (vehiculo instanceof Moto && actualizado instanceof Moto) {
                    ((Moto) vehiculo).setTipoTransmision(((Moto) actualizado).getTipoTransmision());;
                }
                else if (vehiculo instanceof Auto && actualizado instanceof Auto) {
                    ((Auto) vehiculo).setNumPuertas(((Auto) actualizado).getNumPuertas());
                }
                accion = true;
                break;
            }
        }
        return accion;
    }
    public boolean vehiculoEsUnico(int numMatricula, Vehiculo actualizado){
        boolean codigoUnico = true;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getNumMatricula() == actualizado.getNumMatricula() && vehiculo.getNumMatricula() != numMatricula) {
                codigoUnico = false;
            }
        }
        return codigoUnico;
    }
    /**
     * Metodo para eliminar un vehiculo de la lista de vehiculos de la empresa si tiene el mismo numero de matricula que la administrada 
     * @param numMatricula Numero de matricula del vehiculo a eliminar
     * @return Booleano sobre si se pudo eliminar el vehiculo o no
     */
    public boolean eliminarVehiculo(int numMatricula){
        boolean accion = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getNumMatricula() == numMatricula) {
                accion = true;
                listaVehiculos.remove(vehiculo);
                break;
            }
        }
        return accion;
    }

    /**
     * Metodo para agregar un alquiler a la lista de alquileres de la empresa y devolver booleano sobre si se pudo agregar o no
     * @param alquiler Alquiler que se busca agregar a la lista de alquileres de la empresa
     * @return Booleano sobre si se pudo agregar o no
     */
    public boolean agregarAlquiler(Alquiler alquiler){
        boolean accion = false;
        if (!verificarAlquiler(alquiler.getCodigo())) {
            if (verificarVehiculo(alquiler.getVehiculo().getNumMatricula()) && alquiler.getVehiculo().getEstadoVehiculo().equals(Estado_disponibilidad.DISPONIBLE)) {
                if (verificarCliente(alquiler.getCliente().getCedula()) && alquiler.getCliente().getEstadoCliente().equals(Estado_disponibilidad.DISPONIBLE)) {
                    alquiler.getCliente().setEstadoCliente(Estado_disponibilidad.NO_DISPONIBLE);
                    alquiler.getVehiculo().setEstadoVehiculo(Estado_disponibilidad.NO_DISPONIBLE);
                    accion = true;
                    listaAlquileres.add(alquiler);
                }
            }
        }
        return accion;
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
     * Metodo para actualizar los datos de un alquiler si corresponde a un codigo de alquiler entregado
     * @param codigo Codigo de alquiler a verificar
     * @param actualizado Alquiler con los datos nuevos
     * @return Booleano sobre si se pudo actualizar o no
     */
    public boolean actualizarAlquiler(int codigo, Alquiler actualizado){
        boolean accion = false;
        if (actualizado == null) {
            return accion;
        }
        for (Alquiler alquiler : listaAlquileres) {
            alquiler.getCliente().setEstadoCliente(Estado_disponibilidad.DISPONIBLE);
            alquiler.getVehiculo().setEstadoVehiculo(Estado_disponibilidad.DISPONIBLE);
            if (alquiler.getCodigo() == codigo && actualizado.getCliente().getEstadoCliente().equals(Estado_disponibilidad.DISPONIBLE) && actualizado.getVehiculo().getEstadoVehiculo().equals(Estado_disponibilidad.DISPONIBLE) && verificarCliente(alquiler.getCliente().getCedula()) && verificarVehiculo(alquiler.getVehiculo().getNumMatricula())) {
                alquiler.setCodigo(actualizado.getCodigo());
                alquiler.setCostoAlquiler(actualizado.getCostoAlquiler());
                alquiler.setDiasAlquiler(actualizado.getDiasAlquiler());
                alquiler.setTarifaBase(actualizado.getTarifaBase());
                alquiler.setCliente(actualizado.getCliente());
                alquiler.setVehiculo(actualizado.getVehiculo());
                alquiler.setCostoAlquiler(alquiler.calcularTotal());
                accion = true;
            }
            alquiler.getCliente().setEstadoCliente(Estado_disponibilidad.NO_DISPONIBLE);
            alquiler.getVehiculo().setEstadoVehiculo(Estado_disponibilidad.NO_DISPONIBLE);
            break;
        }
        
        return accion;
    }
    /**
     * Metodo para eliminar un alquiler de la lista de alquileres de la empresa si tiene el mismo codigo que el administrado
     * @param codigo
     * @return Booleano sobre si se pudo eliminar el alquiler o no
     */
    public boolean eliminarAlquiler(int codigo){
        boolean accion = false;
        for (Alquiler alquiler : listaAlquileres) {
            if (alquiler.getCodigo() == codigo) {
                accion = true;
                alquiler.getCliente().setEstadoCliente(Estado_disponibilidad.DISPONIBLE);
                alquiler.getVehiculo().setEstadoVehiculo(Estado_disponibilidad.DISPONIBLE);
                listaAlquileres.remove(alquiler);
                break;
            }
        }
        return accion;
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