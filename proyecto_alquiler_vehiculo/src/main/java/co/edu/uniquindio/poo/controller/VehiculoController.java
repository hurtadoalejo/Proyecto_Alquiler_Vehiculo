package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Empresa;

public class VehiculoController {
    Empresa empresa;

    /**
     * Metodo constructor de la clase VehiculoController
     * @param empresa Empresa del vehiculo controller a crear
     */
    public VehiculoController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Metodo para crear un vehiculo
     * @param vehiculo Vehiculo que se busca crear
     * @return Booleano sobre si se pudo o no crear el vehiculo
     */
    public boolean crearVehiculo(Vehiculo vehiculo) {
        return empresa.agregarVehiculo(vehiculo);
    }

    /**
     * Metodo para obtener la coleccion de vehiculos de la empresa
     * @return Coleccion de vehiculos de la empresa
     */
    public Collection<Vehiculo> obtenerListaVehiculos() {
        return empresa.getListaVehiculos();
    }

    /**
     * Metodo para eliminar un vehiculo
     * @param numMatricula Numero de matricula de un vehiculo a eliminar
     * @return Booleano sobre si se pudo o no eliminar el vehiculo
     */
    public boolean eliminarVehiculo(int numMatricula) {
       return empresa.eliminarVehiculo(numMatricula);
    }

    /**
     * Metodo para actualizar un vehiculo
     * @param numMatricula Matricula del vehiculo que se busca actualizar
     * @param actualizado Vehiculo con los datos nuevos que se buscan actualizar
     * @return Booleano sobre si se pudo o no actualizar el vehiculo
     */
    public boolean actualizarVehiculo(int numMatricula, Vehiculo actualizado) {
       return empresa.actualizarVehiculo(numMatricula, actualizado);
    }
}
