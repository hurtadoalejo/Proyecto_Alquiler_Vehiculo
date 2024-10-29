package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ClienteController;
import co.edu.uniquindio.poo.controller.VehiculoController;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Tipo_transmision;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class VehiculoViewController {

    VehiculoController vehiculoController;
    ObservableList<Vehiculo> listaVehiculos = FXCollections.observableArrayList();
    Vehiculo selectedVehiculo;

    @FXML
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_marca;

    @FXML
    private TableColumn<Moto, Tipo_transmision> cl_tipoTransmision;

    @FXML
    private Label lbl_1;

    @FXML
    private Label lbl_2;

    @FXML
    private Label lbl_3;

    @FXML
    private TextField txt_modelo;

    @FXML
    private Label lbl_21;

    @FXML
    private Label lbl_4;

    @FXML
    private Label lbl_5;

    @FXML
    private TableColumn<Vehiculo, Integer> cl_numMatricula;

    @FXML
    private TableColumn<Vehiculo, Integer> cl_modelo;

    @FXML
    private Label lbl_6;

    @FXML
    private Label lbl_7;

    @FXML
    private Label lbl_8;

    @FXML
    private TableColumn<Vehiculo, String> cl_marca;

    @FXML
    private TableColumn<Vehiculo, Integer> cl_anioFabricacion;

    @FXML
    private TextField txt_anioFabricacion;

    @FXML
    private Button bt_7;

    @FXML
    private TextField txt_numPuertas;

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
    private Button bt_2;

    @FXML
    private TableColumn<Auto, Integer> cl_numPuertas;

    @FXML
    private TableColumn<Camioneta, Double> cl_capacidadCarga;

    @FXML
    private TextField txt_numMatricula;

    @FXML
    private ComboBox<Tipo_transmision> cb_tipoTransmision;

    @FXML
    private TableView<Vehiculo> tbl_vehiculos;

    @FXML
    private Pane pane_1;

    @FXML
    private ComboBox<?> cb_tipoVehiculo;

    @FXML
    private TextField txt_capacidadCarga;

    @FXML
    void onOpenMenu() {
        app.openMenu();
    }

    @FXML
    void onOpenCliente() {
        app.openCliente();
    }

    @FXML
    void onLimpiar() {
        
    }

    @FXML
    void onEliminarVehiculo() {

    }

    @FXML
    void onActualizarVehiculo() {

    }

    @FXML
    void onAgregarVehiculo() {

    }

    private void initView() {
        initDataBinding();
        obtenerVehiculos();
        tbl_vehiculos.getItems().clear();
        tbl_vehiculos.setItems(listaVehiculos);
        listenerSelection();
    }

    private void obtenerVehiculos() {
        listaVehiculos.addAll(vehiculoController.obtenerListaVehiculos());
    }

    private void listenerSelection() {
        tbl_vehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVehiculo = newSelection;
            mostrarInformacionVehiculo(selectedVehiculo);
        });
    }

    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            txt_numMatricula.setText(String.valueOf(vehiculo.getNumMatricula()));
            txt_marca.setText(vehiculo.getMarca());
            txt_modelo.setText(String.valueOf(vehiculo.getModelo()));
            txt_anioFabricacion.setText(String.valueOf(vehiculo.getAnioFabricacion()));

        }
    }

    private void buildVehiculoDiferente(Vehiculo vehiculo) {
        if (vehiculo instanceof Camioneta) {
            ((Camioneta) vehiculo).setCapacidadCarga(Integer.parseInt(txt_capacidadCarga.getText()));
        } 
        else if (vehiculo instanceof Auto) {
            ((Auto) vehiculo).setNumPuertas(Integer.parseInt(txt_numPuertas.getText()));;
        } 
        else if (vehiculo instanceof Moto) {
            ((Moto) vehiculo).setTipoTransmision(cb_tipoTransmision.getSelectionModel().getSelectedItem());
        }
    }

    private void MostrarInformacionPersonalizadaVehiculo(Vehiculo vehiculo){
        if () {
            
        }
    }

    private Vehiculo buildVehiculo() {
        int numMatricula, modelo, anioFabricacion;
        try {
            numMatricula = Integer.parseInt(txt_numMatricula.getText());
        } catch (NumberFormatException e) {
            return null;
        }
        try {
            modelo = Integer.parseInt(txt_modelo.getText());
        } catch (NumberFormatException e) {
            return null;
        }
        try {
            anioFabricacion = Integer.parseInt(txt_anioFabricacion.getText());
        } catch (NumberFormatException e) {
            return null;
        }
        Vehiculo vehiculo = new Vehiculo(numMatricula, txt_marca.getText(), modelo, anioFabricacion);
        buildVehiculoDiferente(vehiculo);
        return vehiculo;
    }

    private void limpiarSeleccion() {
        tbl_vehiculos.getSelectionModel().clearSelection();
        limpiarCamposVehiculo();
    }

    private void limpiarCamposVehiculo() {
        cb_tipoVehiculo.getSelectionModel().clearSelection();
        txt_marca.clear();
        txt_modelo.clear();
        txt_anioFabricacion.clear();
        txt_numPuertas.clear();
        txt_capacidadCarga.clear();
        cb_tipoTransmision.getSelectionModel().clearSelection();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        cb_tipoTransmision.getItems().addAll(Tipo_transmision.values());
        vehiculoController = new VehiculoController(App.empresa);
        initView();

        assert txt_marca != null : "fx:id=\"txt_marca\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cl_tipoTransmision != null : "fx:id=\"cl_tipoTransmision\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert lbl_1 != null : "fx:id=\"lbl_1\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert lbl_2 != null : "fx:id=\"lbl_2\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert lbl_3 != null : "fx:id=\"lbl_3\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert txt_modelo != null : "fx:id=\"txt_modelo\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert lbl_21 != null : "fx:id=\"lbl_21\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert lbl_4 != null : "fx:id=\"lbl_4\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert lbl_5 != null : "fx:id=\"lbl_5\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cl_numMatricula != null : "fx:id=\"cl_numMatricula\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cl_modelo != null : "fx:id=\"cl_modelo\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert lbl_6 != null : "fx:id=\"lbl_6\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert lbl_7 != null : "fx:id=\"lbl_7\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert lbl_8 != null : "fx:id=\"lbl_8\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cl_marca != null : "fx:id=\"cl_marca\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cl_anioFabricacion != null : "fx:id=\"cl_anioFabricacion\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert txt_anioFabricacion != null : "fx:id=\"txt_anioFabricacion\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert bt_7 != null : "fx:id=\"bt_7\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert txt_numPuertas != null : "fx:id=\"txt_numPuertas\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert bt_5 != null : "fx:id=\"bt_5\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert bt_6 != null : "fx:id=\"bt_6\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert bt_3 != null : "fx:id=\"bt_3\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert bt_4 != null : "fx:id=\"bt_4\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert bt_1 != null : "fx:id=\"bt_1\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert bt_2 != null : "fx:id=\"bt_2\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cl_numPuertas != null : "fx:id=\"cl_numPuertas\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cl_capacidadCarga != null : "fx:id=\"cl_capacidadCarga\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert txt_numMatricula != null : "fx:id=\"txt_numMatricula\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cb_tipoTransmision != null : "fx:id=\"cb_tipoTransmision\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert tbl_vehiculos != null : "fx:id=\"tbl_vehiculos\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert pane_1 != null : "fx:id=\"pane_1\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cb_tipoVehiculo != null : "fx:id=\"cb_tipoVehiculo\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert txt_capacidadCarga != null : "fx:id=\"txt_capacidadCarga\" was not injected: check your FXML file 'vehiculo.fxml'.";

    }
}
