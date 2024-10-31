package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Alquiler;
import co.edu.uniquindio.poo.model.Cliente;

public class AlquilerController {
    Empresa empresa;

    public AlquilerController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearAlquiler(Alquiler alquiler){
        return empresa.agregarAlquiler(alquiler);
    }

    public Collection<Alquiler> obtenerListaAlquileres() {
        return empresa.getListaAlquileres();
    }

    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getListaClientes();
    }

    public Collection<Vehiculo> obtenerListaVehiculos() {
        return empresa.getListaVehiculos();
    }

    public boolean verificarCliente(String cedula) {
        return empresa.verificarCliente(cedula);
    }

    public boolean verificarVehiculo(int numMatricula) {
        return empresa.verificarVehiculo(numMatricula);
    }

    public boolean eliminarAlquiler(int codigo){
        return empresa.eliminarAlquiler(codigo);
    }

    public boolean actualizarAlquiler(int codigo, Alquiler alquiler){
        return empresa.actualizarAlquiler(codigo, alquiler);
    }
}