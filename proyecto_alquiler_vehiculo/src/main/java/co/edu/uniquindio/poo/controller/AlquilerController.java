package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Alquiler;
import co.edu.uniquindio.poo.model.Cliente;

public class AlquilerController {
    Empresa empresa;

    /**
     * Metodo constructor de la clase AlquilerController
     * @param empresa Empresa del alquiler controller a crear
     */
    public AlquilerController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Metodo para crear un alquiler
     * @param alquiler Alquiler que se busca crear
     * @return Booleano sobre si se pudo o no crear el alquiler
     */
    public boolean crearAlquiler(Alquiler alquiler){
        return empresa.agregarAlquiler(alquiler);
    }

    /**
     * Metodo para obtener la coleccion de alquileres de la empresa
     * @return Coleccion de alquileres de la empresa
     */
    public Collection<Alquiler> obtenerListaAlquileres() {
        return empresa.getListaAlquileres();
    }

    /**
     * Metodo para eliminar un alquiler
     * @param codigo Codigo de un alquiler a eliminar
     * @return Booleano sobre si se pudo o no eliminar el alquiler
     */
    public boolean eliminarAlquiler(int codigo){
        return empresa.eliminarAlquiler(codigo);
    }

    /**
     * Metodo para actualizar un alquiler
     * @param codigo Codigo del alquiler que se busca actualizar
     * @param alquiler Alquiler con los datos nuevos que se buscan actualizar
     * @return Booleano sobre si se pudo o no actualizar el alquiler
     */
    public boolean actualizarAlquiler(int codigo, Alquiler alquiler){
        return empresa.actualizarAlquiler(codigo, alquiler);
    }
    
    /**
     * Metodo para obtener la coleccion de clientes de la empresa
     * @return Coleccion de clientes de la empresa
     */
    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getListaClientes();
    }

    /**
     * Metodo para obtener la coleccion de vehiculos de la empresa
     * @return Coleccion de vehiculos de la empresa
     */
    public Collection<Vehiculo> obtenerListaVehiculos() {
        return empresa.getListaVehiculos();
    }

    /**
     * Metodo para verificar si hay un cliente en la lista de clientes de la empresa con la misma cedula que la administrada
     * @param cedula Cedula a verificar
     * @return Booleano sobre si existe un cliente con esa condicion o no
     */
    public boolean verificarCliente(String cedula) {
        return empresa.verificarCliente(cedula);
    }

    /**
     * Metodo para verificar si hay un vehiculo en la lista de vehiculos de la empresa con el mismo numero de matricula que la administrada
     * @param numMatricula Numero de matricula a verificar
     * @return Booleano sobre si existe un vehiculo con esa condicion o no
     */
    public boolean verificarVehiculo(int numMatricula) {
        return empresa.verificarVehiculo(numMatricula);
    }
}