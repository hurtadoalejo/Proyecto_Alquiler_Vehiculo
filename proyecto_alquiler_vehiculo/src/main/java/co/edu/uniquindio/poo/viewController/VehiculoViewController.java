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
import co.edu.uniquindio.poo.controller.VehiculoController;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Tipo_transmision;
import co.edu.uniquindio.poo.model.Tipo_vehiculo;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    private ComboBox<Tipo_vehiculo> cb_tipoVehiculo;

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
        limpiarSeleccion();
    }

    @FXML
    void onEliminarVehiculo() {
        eliminarVehiculo();
    }

    @FXML
    void onActualizarVehiculo() {
        actualizarVehiculo();
    }

    @FXML
    void onAgregarVehiculo() {
        agregarVehiculo();
    }

    private void initView() {
        initDataBinding();
        obtenerVehiculos();
        tbl_vehiculos.getItems().clear();
        tbl_vehiculos.setItems(listaVehiculos);
        listenerSelection();
    }

    private void initDataBinding() {
        cl_numMatricula.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumMatricula()).asObject());
        cl_marca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        cl_modelo.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getModelo()).asObject());
        cl_anioFabricacion.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAnioFabricacion()).asObject());
        initDataBindingPersonalized();
    }

    private void initDataBindingPersonalized() {
        Tipo_vehiculo tipo = cb_tipoVehiculo.getSelectionModel().getSelectedItem();
        if (tipo == null) {
            return;
        }
    
        // Reinicia el CellValueFactory y la visibilidad de las columnas
        cl_numPuertas.setCellValueFactory(null);
        cl_capacidadCarga.setCellValueFactory(null);
    
        // Determina la visibilidad y los datos de cada columna según el tipo de vehículo
        if (tipo.equals(Tipo_vehiculo.AUTO)) {
            cl_numPuertas.setVisible(true);
            cl_capacidadCarga.setVisible(false);
            cl_numPuertas.setCellValueFactory(cellData -> new SimpleIntegerProperty(((Auto) cellData.getValue()).getNumPuertas()).asObject());
        } else if (tipo.equals(Tipo_vehiculo.CAMIONETA)) {
            cl_numPuertas.setVisible(false);
            cl_capacidadCarga.setVisible(true);
            cl_capacidadCarga.setCellValueFactory(cellData -> new SimpleDoubleProperty(((Camioneta) cellData.getValue()).getCapacidadCarga()).asObject());
        } else {
            // Para Moto u otros tipos, ambas columnas no son visibles
            cl_numPuertas.setVisible(false);
            cl_capacidadCarga.setVisible(false);
        }
    }
        /*else if (tipo.equals(Tipo_vehiculo.MOTO)) {
            cb_tipoTransmision.setCellValueFactory(cellData -> {
                Tipo_transmision tipoTransmision = cellData.getValue().getTipoTransmision();
                return new SimpleStringProperty(tipoTransmision != null ? tipoTransmision.name() : "");
            });
        }*/

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
            mostrarInformacionPersonalizadaVehiculo(vehiculo);
        }
    }

    private void mostrarInformacionPersonalizadaVehiculo(Vehiculo vehiculo){
        if (vehiculo instanceof Camioneta) {
            Camioneta camioneta = (Camioneta) vehiculo;
            txt_capacidadCarga.setText(String.valueOf(camioneta.getCapacidadCarga()));
            cb_tipoVehiculo.getSelectionModel().select(Tipo_vehiculo.CAMIONETA);
            cb_tipoVehiculo.setDisable(true);
        } 
        else if (vehiculo instanceof Auto) {
            Auto auto = (Auto) vehiculo;
            txt_numPuertas.setText(String.valueOf(auto.getNumPuertas()));
            cb_tipoVehiculo.getSelectionModel().select(Tipo_vehiculo.AUTO);
            cb_tipoVehiculo.setDisable(true);
        } 
        else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            cb_tipoTransmision.getSelectionModel().select(moto.getTipoTransmision());
            cb_tipoVehiculo.getSelectionModel().select(Tipo_vehiculo.MOTO);
            cb_tipoVehiculo.setDisable(true);
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

    private boolean verificarCasillasCorrectas(){
        Tipo_vehiculo tipo = (Tipo_vehiculo) cb_tipoVehiculo.getSelectionModel().getSelectedItem();
        boolean decision = false;
        if (esEntero(txt_numMatricula.getText()) && esEntero(txt_modelo.getText()) && esEntero(txt_anioFabricacion.getText())) {
            if (tipo.equals(Tipo_vehiculo.AUTO) && esEntero(txt_numPuertas.getText())) {
                decision = true;
            }
            else if (tipo.equals(Tipo_vehiculo.CAMIONETA) && esDouble(txt_capacidadCarga.getText())) {
                decision = true;
            }
            else if (tipo.equals(Tipo_vehiculo.MOTO) && !cb_tipoTransmision.getSelectionModel().isEmpty()) {
                decision = true;
            }
        }
        return decision;
    }

    private void agregarVehiculo() {
        if (verificarCasillasCorrectas()) {
            Vehiculo vehiculo = buildVehiculo();
            if (verificarVehiculoCasillas(vehiculo) && vehiculo != null) {
                if (vehiculoController.crearVehiculo(vehiculo)) {
                    listaVehiculos.add(vehiculo);
                    limpiarCamposVehiculo();
                }
            }   
        }
    }

    private boolean verificarVehiculoCasillas(Vehiculo vehiculo){
        Tipo_vehiculo tipo = (Tipo_vehiculo) cb_tipoVehiculo.getSelectionModel().getSelectedItem();
        boolean decision = false;

        if (!txt_numMatricula.getText().isEmpty() && !txt_marca.getText().isEmpty() && !txt_modelo.getText().isEmpty() && !txt_anioFabricacion.getText().isEmpty() && !cb_tipoVehiculo.getSelectionModel().isEmpty()) {
            if (tipo.equals(Tipo_vehiculo.AUTO) && !txt_numPuertas.getText().isEmpty()) {
                decision = true;
            }
            else if (tipo.equals(Tipo_vehiculo.CAMIONETA) && !txt_capacidadCarga.getText().isEmpty()) {
                decision = true;
            }
            else if (tipo.equals(Tipo_vehiculo.MOTO) && !cb_tipoTransmision.getSelectionModel().isEmpty()) {
                decision = true;
            }
        }

        return decision;
    }

    private Vehiculo buildVehiculo() {
        Tipo_vehiculo tipo = (Tipo_vehiculo) cb_tipoVehiculo.getSelectionModel().getSelectedItem();
        if (tipo == null) {
            return null;
        }
        switch (tipo) {
            case AUTO:
               return new Auto(Integer.parseInt(txt_numMatricula.getText()), txt_marca.getText(), Integer.parseInt(txt_modelo.getText()), Integer.parseInt(txt_anioFabricacion.getText()), Integer.parseInt(txt_numPuertas.getText()));
            case CAMIONETA:
                return new Camioneta(Integer.parseInt(txt_numMatricula.getText()), txt_marca.getText(), Integer.parseInt(txt_modelo.getText()), Integer.parseInt(txt_anioFabricacion.getText()), Double.parseDouble(txt_capacidadCarga.getText()));
            case MOTO:
                Tipo_transmision tipoTransmisionSeleccionada = (Tipo_transmision) cb_tipoTransmision.getSelectionModel().getSelectedItem();
                return new Moto(Integer.parseInt(txt_numMatricula.getText()), txt_marca.getText(), Integer.parseInt(txt_modelo.getText()), Integer.parseInt(txt_anioFabricacion.getText()), tipoTransmisionSeleccionada);
            default:
                return null;
        }
    }

    private void eliminarVehiculo() {
        if (!txt_numMatricula.getText().isEmpty() && esEntero(txt_numMatricula.getText())) {
            if (vehiculoController.eliminarVehiculo(Integer.parseInt(txt_numMatricula.getText()))) {
                eliminarVehiculoPorMatricula();
                limpiarCamposVehiculo();
                limpiarSeleccion();
            }
        }   
    }

    private void eliminarVehiculoPorMatricula(){
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getNumMatricula() == Integer.parseInt(txt_numMatricula.getText())) {
                listaVehiculos.remove(vehiculo);
                break;
            }
        }
    }

    private void actualizarVehiculo() {

        if (selectedVehiculo != null && vehiculoController.actualizarVehiculo(selectedVehiculo.getNumMatricula(), buildVehiculo())) {
            int index = listaVehiculos.indexOf(selectedVehiculo);
            if (index >= 0) {
                listaVehiculos.set(index, buildVehiculo());
            }

            tbl_vehiculos.refresh();
            limpiarSeleccion();
            limpiarCamposVehiculo();
        }
    }

    private void limpiarSeleccion() {
        tbl_vehiculos.getSelectionModel().clearSelection();
        limpiarCamposVehiculo();
    }

    private void limpiarCamposVehiculo() {
        cb_tipoVehiculo.getSelectionModel().clearSelection();
        txt_numMatricula.clear();
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

    private void manejarSeleccionTipo() {
        Tipo_vehiculo tipo =  (Tipo_vehiculo) cb_tipoVehiculo.getSelectionModel().getSelectedItem();

        if (tipo == null) {
            txt_numMatricula.setDisable(true);
            txt_marca.setDisable(true);
            txt_modelo.setDisable(true);
            txt_anioFabricacion.setDisable(true);
            txt_capacidadCarga.setDisable(true);
            txt_numPuertas.setDisable(true);
            cb_tipoTransmision.setDisable(true);
            cb_tipoVehiculo.setDisable(false);
            return;
        }

        switch (tipo) {
            case AUTO:
                txt_numMatricula.setDisable(false);
                txt_marca.setDisable(false);
                txt_modelo.setDisable(false);
                txt_anioFabricacion.setDisable(false);
                txt_capacidadCarga.setDisable(true);
                txt_numPuertas.setDisable(false);
                cb_tipoTransmision.setDisable(true);
                txt_capacidadCarga.clear();
                cb_tipoTransmision.getSelectionModel().clearSelection();
                break;
            case CAMIONETA:
                txt_numMatricula.setDisable(false);
                txt_marca.setDisable(false);
                txt_modelo.setDisable(false);
                txt_anioFabricacion.setDisable(false);
                txt_capacidadCarga.setDisable(false);
                txt_numPuertas.setDisable(true);
                cb_tipoTransmision.setDisable(true);
                txt_numPuertas.clear();
                cb_tipoTransmision.getSelectionModel().clearSelection();
                break;
            case MOTO:
                txt_numMatricula.setDisable(false);
                txt_marca.setDisable(false);
                txt_modelo.setDisable(false);
                txt_anioFabricacion.setDisable(false);
                txt_capacidadCarga.setDisable(true);
                txt_numPuertas.setDisable(true);
                cb_tipoTransmision.setDisable(false);
                txt_capacidadCarga.clear();
                txt_numPuertas.clear();
                break;
            default:
                break;
        }
    }
    
    @FXML
    void initialize() {
        cb_tipoTransmision.getItems().addAll(Tipo_transmision.values());
        cb_tipoVehiculo.getItems().addAll(Tipo_vehiculo.values());
        cb_tipoVehiculo.setOnAction(event -> manejarSeleccionTipo());
        vehiculoController = new VehiculoController(App.empresa);
        initView();
        manejarSeleccionTipo();

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