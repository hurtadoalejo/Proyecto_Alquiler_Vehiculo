package co.edu.uniquindio.poo;

public class App {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Sucursal");
        Auto auto = new Auto(123, "Mazda", 2024, 1980, 3);
        Cliente cliente = new Cliente("Alejandro", "1092850037", "3161970000", "alejo@gmail.com");
        Alquiler alquiler = new Alquiler(1, cliente, auto);
        empresa.agregarAlquiler(alquiler);
        empresa.agregarCliente(cliente);
        empresa.agregarVehiculo(auto);
        System.out.println(empresa.getListaClientes());
        System.out.println(empresa.getListaVehiculos());
        System.out.println(empresa.getListaAlquileres());
    }
}