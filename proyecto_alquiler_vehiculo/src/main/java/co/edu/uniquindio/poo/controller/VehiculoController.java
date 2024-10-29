package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Empresa;

public class VehiculoController {
    Empresa empresa;

    public VehiculoController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearVehiculo(Vehiculo vehiculo) {
        return empresa.agregarVehiculo(vehiculo);
    }

    public Collection<Vehiculo> obtenerListaVehiculos() {
        return empresa.getListaVehiculos();
    }

    public boolean eliminarVehiculo(int numMatricula) {
       return empresa.eliminarVehiculo(numMatricula);
    }

    public boolean actualizarVehiculo(int numMatricula, Vehiculo actualizado) {
       return empresa.actualizarVehiculo(numMatricula, actualizado);
    }
}
