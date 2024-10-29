package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.viewController.ClienteViewController;
import co.edu.uniquindio.poo.viewController.MenuViewController;
import co.edu.uniquindio.poo.viewController.PrimaryViewController;
import co.edu.uniquindio.poo.viewController.VehiculoViewController;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    @SuppressWarnings("exports")
    public static Empresa empresa = new Empresa("Empresita");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Clientes");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            primaryViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }  
    
    public void openMenu() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menu.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            MenuViewController menuViewController = loader.getController();
            menuViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    } 

    public void openCliente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("cliente.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            ClienteViewController clienteViewController = loader.getController();
            clienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    } 

    public void openVehiculo() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("vehiculo.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            VehiculoViewController vehiculoViewController = loader.getController();
            vehiculoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    } 

    public static void main(String[] args) {
        launch();
    }

}