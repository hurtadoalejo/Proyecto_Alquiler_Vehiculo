package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;

public class ClienteController {
    Empresa empresa;

    /**
     * Metodo constructor de la clase ClienteController
     * @param empresa Empresa del cliente controller a crear
     */
    public ClienteController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Metodo para crear un Cliente
     * @param cliente Cliente que se busca crear
     * @return Booleano sobre si se pudo o no crear el cliente
     */
    public boolean crearCliente(Cliente cliente) {
        return empresa.agregarCliente(cliente);
    }

    /**
     * Metodo para obtener la coleccion de clientes de la empresa
     * @return Coleccion de clientes de la empresa
     */
    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getListaClientes();
    }

    /**
     * Metodo para eliminar un cliente
     * @param cedula Cedula de un cliente a eliminar
     * @return Booleano sobre si se pudo o no eliminar el cliente
     */
    public boolean eliminarCliente(String cedula) {
       return empresa.eliminarCliente(cedula);
    }

    /**
     * Metodo para actualizar un cliente
     * @param cedula Cedula del cliente que se busca actualizar
     * @param actualizado Cliente con los datos nuevos que se buscan actualizar
     * @return Booleano sobre si se pudo o no actualizar el cliente
     */
    public boolean actualizarCliente(String cedula, Cliente actualizado) {
       return empresa.actualizarCliente(cedula, actualizado);
    }
}
