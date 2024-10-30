package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Alquiler;

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

    public boolean eliminarAlquiler(int codigo){
        return empresa.eliminarAlquiler(codigo);
    }

    public boolean actualizarAlquiler(int codigo, Alquiler alquiler){
        return empresa.actualizarAlquiler(codigo, alquiler);
    }
}