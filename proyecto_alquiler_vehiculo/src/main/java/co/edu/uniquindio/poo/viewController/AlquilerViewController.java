package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.AlquilerController;
import co.edu.uniquindio.poo.model.Alquiler;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AlquilerViewController {

    AlquilerController alquilerController;
    ObservableList<Alquiler> listaAlquileres = FXCollections.observableArrayList();
    Alquiler selectedAlquiler;

    @FXML
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_cliente;

    @FXML
    private TextField txt_codigo;

    @FXML
    private TableColumn<Alquiler, Double> cl_total;

    @FXML
    private TableColumn<Alquiler, Integer> cl_codigo;

    @FXML
    private TableColumn<Vehiculo, Integer> cl_matricula;

    @FXML
    private Button bt_7;

    @FXML
    private Label lb_dias;

    @FXML
    private TableColumn<Alquiler, Double> cl_precioDia;

    @FXML
    private Button bt_5;

    @FXML
    private Button bt_6;

    @FXML
    private Button bt_3;

    @FXML
    private Button bt_4;

    @FXML
    private Button bt_1;

    @FXML
    private TableColumn<Cliente, String> cl_cedula;

    @FXML
    private Button bt_2;

    @FXML
    private Label lb_clienteCedula;

    @FXML
    private Label lb_vehiculoMatricula;

    @FXML
    private Pane pane_1;

    @FXML
    private TableColumn<Alquiler, Integer> cl_dias;

    @FXML
    private TextField txt_dias;

    @FXML
    private TableView<Alquiler> tbl_alquileres;

    @FXML
    private TextField txt_vehiculo;

    @FXML
    private TextField txt_precioDia;

    @FXML
    private Label lb_precioDia;

    @FXML
    private Label lb_codigo;

    private void mostrarInformacionAlquiler(Alquiler alquiler) {
        if (alquiler != null) {
            txt_codigo.setText(String.valueOf(alquiler.getCodigo()));
            txt_dias.setText(String.valueOf(alquiler.getDiasAlquiler()));
            txt_precioDia.setText(String.valueOf(alquiler.getTarifaBase()));
            txt_vehiculo.setText(String.valueOf(alquiler.getVehiculo().getNumMatricula()));
            txt_cliente.setText(alquiler.getCliente().getCedula());
        }
    }

    private boolean esEntero(String texto){
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esDouble(String texto){
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void listenerSelection() {
        tbl_alquileres.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedAlquiler = newSelection;
            mostrarInformacionAlquiler(selectedAlquiler);
        });
    }

    private void limpiarSeleccion() {
        tbl_alquileres.getSelectionModel().clearSelection();
        limpiarCamposAlquiler();
    }

    private void limpiarCamposAlquiler() {
        txt_codigo.clear();
        txt_dias.clear();
        txt_vehiculo.clear();
        txt_cliente.clear();
        txt_precioDia.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        alquilerController = new AlquilerController(App.empresa);
        assert txt_cliente != null : "fx:id=\"txt_cliente\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert txt_codigo != null : "fx:id=\"txt_codigo\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert cl_total != null : "fx:id=\"cl_total\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert cl_codigo != null : "fx:id=\"cl_codigo\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert cl_matricula != null : "fx:id=\"cl_matricula\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert bt_7 != null : "fx:id=\"bt_7\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert lb_dias != null : "fx:id=\"lb_dias\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert cl_precioDia != null : "fx:id=\"cl_precioDia\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert bt_5 != null : "fx:id=\"bt_5\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert bt_6 != null : "fx:id=\"bt_6\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert bt_3 != null : "fx:id=\"bt_3\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert bt_4 != null : "fx:id=\"bt_4\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert bt_1 != null : "fx:id=\"bt_1\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert cl_cedula != null : "fx:id=\"cl_cedula\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert bt_2 != null : "fx:id=\"bt_2\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert lb_clienteCedula != null : "fx:id=\"lb_clienteCedula\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert lb_vehiculoMatricula != null : "fx:id=\"lb_vehiculoMatricula\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert pane_1 != null : "fx:id=\"pane_1\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert cl_dias != null : "fx:id=\"cl_dias\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert txt_dias != null : "fx:id=\"txt_dias\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert tbl_alquileres != null : "fx:id=\"tbl_alquileres\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert txt_vehiculo != null : "fx:id=\"txt_vehiculo\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert txt_precioDia != null : "fx:id=\"txt_precioDia\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert lb_precioDia != null : "fx:id=\"lb_precioDia\" was not injected: check your FXML file 'alquiler.fxml'.";
        assert lb_codigo != null : "fx:id=\"lb_codigo\" was not injected: check your FXML file 'alquiler.fxml'.";

    }
}
