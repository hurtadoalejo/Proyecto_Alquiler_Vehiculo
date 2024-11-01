package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PrimaryViewController {

    @FXML
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_1;

    @FXML
    private Label lbl_2;

    @FXML
    private Label lbl_3;

    @FXML
    private Button bt_1;
    
    @FXML
    private Pane primary;

    /**
     * Metodo para establecer la aplicacion principal para este controlador
     * @param app Aplicacion principal a establecer
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Metodo para inicializar la interfaz del menu
     */
    @FXML
    void onOpenMenu() {
        app.openMenu();
    }

    /**
     * Metodo para inicializar este controlador despues de que su archivo FXML haya sido cargado
     */
    @FXML
    void initialize() {
        assert lbl_1 != null : "fx:id=\"lbl_1\" was not injected: check your FXML file 'primary.fxml'.";
        assert lbl_2 != null : "fx:id=\"lbl_2\" was not injected: check your FXML file 'primary.fxml'.";
        assert lbl_3 != null : "fx:id=\"lbl_3\" was not injected: check your FXML file 'primary.fxml'.";
        assert bt_1 != null : "fx:id=\"bt_1\" was not injected: check your FXML file 'primary.fxml'.";
        assert primary != null : "fx:id=\"primary\" was not injected: check your FXML file 'primary.fxml'.";
    }
}