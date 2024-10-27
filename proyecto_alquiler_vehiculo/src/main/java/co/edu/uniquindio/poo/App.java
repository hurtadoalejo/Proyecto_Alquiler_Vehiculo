package co.edu.uniquindio.poo;

public class App {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Sucursal");
        Auto auto = new Auto(123, "Mazda", 2020, 1980, 3);
        Moto moto = new Moto(111, "BMW", 2000, 1980, Tipo_transmision.MANUAL);
        Camioneta camioneta = new Camioneta(100, "sz", 2014, 1980, 30);
        Cliente cliente = new Cliente("Alejandro", "1092850037", "3161970000", "alejo@gmail.com");
        Alquiler alquiler = new Alquiler(1, cliente, camioneta, 15, 1000);
        empresa.agregarCliente(cliente);
        empresa.agregarVehiculo(moto);
        empresa.agregarVehiculo(auto);
        empresa.agregarVehiculo(camioneta);
        empresa.agregarAlquiler(alquiler);
        System.out.println(alquiler.getCostoAlquiler());
    }
}