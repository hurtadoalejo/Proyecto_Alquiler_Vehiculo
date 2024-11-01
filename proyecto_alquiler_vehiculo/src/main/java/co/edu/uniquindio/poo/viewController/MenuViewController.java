package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MenuViewController {

    @FXML
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane_1;

    @FXML
    private Button bt_3;

    @FXML
    private Label lbl_1;

    @FXML
    private Label lbl_2;

    @FXML
    private Button bt_1;

    @FXML
    private Button bt_2;

    /**
     * Metodo para establecer la aplicacion principal para este controlador
     * @param app Aplicacion principal a establecer
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Metodo para cerrar el programa
     */
    @FXML
        void cerrarPrograma() {
        Platform.exit();
    }

    /**
     * Metodo para inicializar la interfaz del cliente
     */
    @FXML
    void onOpenCliente() {
        app.openCliente();
    }

    /**
     * Metodo para inicializar la interfaz del vehiculo
     */
    @FXML
    void onOpenVehiculo() {
        app.openVehiculo();
    }

    /**
     * Metodo para inicializar la interfaz del alquiler
     */
    @FXML
    void onOpenAlquiler() {
        app.openAlquiler();
    }

    /**
     * Metodo para inicializar el controlador despues de que su archivo FXML haya sido cargado
     */
    @FXML
    void initialize() {
        assert pane_1 != null : "fx:id=\"pane_1\" was not injected: check your FXML file 'menu.fxml'.";
        assert bt_3 != null : "fx:id=\"bt_3\" was not injected: check your FXML file 'menu.fxml'.";
        assert lbl_1 != null : "fx:id=\"lbl_1\" was not injected: check your FXML file 'menu.fxml'.";
        assert lbl_2 != null : "fx:id=\"lbl_2\" was not injected: check your FXML file 'menu.fxml'.";
        assert bt_1 != null : "fx:id=\"bt_1\" was not injected: check your FXML file 'menu.fxml'.";
        assert bt_2 != null : "fx:id=\"bt_2\" was not injected: check your FXML file 'menu.fxml'.";

    }
}