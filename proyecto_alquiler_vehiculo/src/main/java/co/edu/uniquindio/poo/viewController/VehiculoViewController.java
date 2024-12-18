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
    private TextField txt_numMatricula;

    @FXML
    private ComboBox<Tipo_transmision> cb_tipoTransmision;

    @FXML
    private TableColumn<Vehiculo, String> cl_estadoVehiculo;

    @FXML
    private TableView<Vehiculo> tbl_vehiculos;

    @FXML
    private Pane pane_1;

    @FXML
    private ComboBox<Tipo_vehiculo> cb_tipoVehiculo;

    @FXML
    private TextField txt_capacidadCarga;

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
     * Metodo para inicializar la interfaz del cliente
     */
    @FXML
    void onOpenCliente() {
        app.openCliente();
    }

    /**
     * Metodo para inicializar la interfaz del alquiler
     */
    @FXML
    void onOpenAlquiler() {
        app.openAlquiler();
    }

    /**
     * Metodo para manejar el evento de limpiar la seleccion actual
     */
    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    /**
     * Metodo para manejar el evento de eliminar un vehiculo
     */
    @FXML
    void onEliminarVehiculo() {
        eliminarVehiculo();
    }

    /**
     * Metodo para manejar el evento de actualizar un vehiculo
     */
    @FXML
    void onActualizarVehiculo() {
        actualizarVehiculo();
    }

    /**
     * Metodo para manejar el evento de agregar un vehiculo
     */
    @FXML
    void onAgregarVehiculo() {
        agregarVehiculo();
    }

    /**
     * Metodo que inicializa la vista del controlador
     */
    private void initView() {
        initDataBinding();
        obtenerVehiculos();
        tbl_vehiculos.getItems().clear();
        tbl_vehiculos.setItems(listaVehiculos);
        listenerSelection();
    }

    /**
     * Metodo para configurar los tipos de datos de cada columna de la tabla vehiculo del controlador
     */
    private void initDataBinding() {
        cl_numMatricula.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumMatricula()).asObject());
        cl_marca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        cl_modelo.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getModelo()).asObject());
        cl_anioFabricacion.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAnioFabricacion()).asObject());
        cl_estadoVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstadoVehiculo().name()));
    }

    /**
     * Metodo para obtener la lista de vehiculos de la empresa y asignarla a la lista de vehiculos del controlador
     */
    private void obtenerVehiculos() {
        listaVehiculos.addAll(vehiculoController.obtenerListaVehiculos());
    }

    /**
     * Metodo para configurar la seleccion de un elemento en la tabla de vehiculos
     */
    private void listenerSelection() {
        tbl_vehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVehiculo = newSelection;
            mostrarInformacionVehiculo(selectedVehiculo);
        });
    }

    /**
     * Metodo para mostrar la informacion de un vehiculo en los campos correspondientes de la tabla de vehiculos
     * @param vehiculo Vehiculo con la informacion que se busca mostrar
     */
    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            txt_numMatricula.setText(String.valueOf(vehiculo.getNumMatricula()));
            txt_marca.setText(vehiculo.getMarca());
            txt_modelo.setText(String.valueOf(vehiculo.getModelo()));
            txt_anioFabricacion.setText(String.valueOf(vehiculo.getAnioFabricacion()));
            mostrarInformacionPersonalizadaVehiculo(vehiculo);
            txt_numMatricula.setDisable(true);
        }
    }

    private void mostrarInformacionPersonalizadaVehiculo(Vehiculo vehiculo){
        cb_tipoVehiculo.setDisable(true);
        if (vehiculo instanceof Camioneta) {
            Camioneta camioneta = (Camioneta) vehiculo;
            txt_capacidadCarga.setText(String.valueOf(camioneta.getCapacidadCarga()));
            cb_tipoVehiculo.getSelectionModel().select(Tipo_vehiculo.CAMIONETA);     
        } 
        else if (vehiculo instanceof Auto) {
            Auto auto = (Auto) vehiculo;
            txt_numPuertas.setText(String.valueOf(auto.getNumPuertas()));
            cb_tipoVehiculo.getSelectionModel().select(Tipo_vehiculo.AUTO);
        } 
        else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            cb_tipoTransmision.getSelectionModel().select(moto.getTipoTransmision());
            cb_tipoVehiculo.getSelectionModel().select(Tipo_vehiculo.MOTO);
        }
    }

    /**
     * Metodo para saber si un String es un dato de tipo int
     * @param texto String a verificar
     * @return Booleano sobre si el String es int o no
     */
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

    /**
     * Metodo para saber si un String es un dato de tipo double
     * @param texto String a verificar
     * @return Booleano sobre si el String es double o no
     */
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

    /**
     * Metodo para verificar si las casillas de texto relacionadas con la informacion del vehiculo tienen datos validos
     * @return Booleano sobre si los campos relacionados al vehiculo tienen datos validos
     */
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

    /**
     * Metodo para verificar si las casillas de texto relacionadas con la informacion del vehiculo estan llenas
     * @return Booleano sobre si todos los campos estan llenos o no
     */
    private boolean verificarVehiculoCasillas(){
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

    /**
     * Metodo para agregar un vehiculo a la lista de vehiculos si los campos estan llenos y con los tipos de datos validos
     */
    private void agregarVehiculo() {
        if (verificarCasillasCorrectas()) {
            Vehiculo vehiculo = buildVehiculo();
            if (verificarVehiculoCasillas() && vehiculo != null) {
                if (vehiculoController.crearVehiculo(vehiculo)) {
                    listaVehiculos.add(vehiculo);
                    limpiarCamposVehiculo();
                }
            }   
        }
    }

    /**
     * Metodo para crear un vehiculos con los datos ingresados en los campos de texto
     * @return Vehiculo creado
     */
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

    /**
     * Metodo para actualizar la informacion del vehiculo seleccionado si los campos estan llenos correctamente
     */
    private void actualizarVehiculo() {
        if (verificarCasillasCorrectas() && verificarVehiculoCasillas()) {
            if (selectedVehiculo != null && vehiculoController.actualizarVehiculo(selectedVehiculo.getNumMatricula(), buildVehiculo())) {
                tbl_vehiculos.refresh();
                limpiarSeleccion();
                limpiarCamposVehiculo();
            }
        }
    }

    /**
     * Metodo para eliminar un vehiculo de la lista de vehiculos segun el numero de matricula proporcionado en el campo de este
     */
    private void eliminarVehiculo() {
        if (!txt_numMatricula.getText().isEmpty() && esEntero(txt_numMatricula.getText())) {
            if (vehiculoController.eliminarVehiculo(Integer.parseInt(txt_numMatricula.getText()))) {
                listaVehiculos.remove(selectedVehiculo);
                limpiarCamposVehiculo();
                limpiarSeleccion();
            }
        }   
    }

    /**
     * Metodo para limpiar la seleccion de un elementos en la tabla de alquileres
     */
    private void limpiarSeleccion() {
        tbl_vehiculos.getSelectionModel().clearSelection();
        txt_numMatricula.setDisable(false);;
        limpiarCamposVehiculo();
    }

    /**
     * Metodo para limpiar los campos de texto relacionados con la informacion del vehiculo
     */
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

    /**
     * Metodo para ocultar o mostrar diferentes casillas relacionadas con los datos de un vehiculo dependiendo de la seleccion que tenga el ComboBox cb_tipoVehiculo
     */
    private void manejarSeleccionTipo() {
        Tipo_vehiculo tipo =  (Tipo_vehiculo) cb_tipoVehiculo.getSelectionModel().getSelectedItem();

        if (tipo == null) {
            txt_numMatricula.setVisible(false);
            lbl_8.setVisible(false);
            txt_marca.setVisible(false);
            lbl_2.setVisible(false);
            txt_modelo.setVisible(false);
            lbl_3.setVisible(false);
            txt_anioFabricacion.setVisible(false);
            lbl_4.setVisible(false);
            txt_capacidadCarga.setVisible(false);
            lbl_5.setVisible(false);
            txt_numPuertas.setVisible(false);
            lbl_6.setVisible(false);
            cb_tipoTransmision.setVisible(false);
            lbl_7.setVisible(false);
            cb_tipoVehiculo.setDisable(false);
            return;
        }

        switch (tipo) {
            case AUTO:
                txt_numMatricula.setVisible(true);
                lbl_2.setVisible(true);
                txt_marca.setVisible(true);
                lbl_3.setVisible(true);
                txt_modelo.setVisible(true);
                lbl_4.setVisible(true);
                txt_anioFabricacion.setVisible(true);
                lbl_5.setVisible(true);
                txt_numPuertas.setVisible(true);
                lbl_6.setVisible(true);
                txt_capacidadCarga.setVisible(false);
                lbl_7.setVisible(false);
                cb_tipoTransmision.setVisible(false);
                lbl_8.setVisible(false);
                txt_capacidadCarga.clear();
                cb_tipoTransmision.getSelectionModel().clearSelection();
                break;
            case CAMIONETA:
                txt_numMatricula.setVisible(true);
                lbl_2.setVisible(true);
                txt_marca.setVisible(true);
                lbl_3.setVisible(true);
                txt_modelo.setVisible(true);
                lbl_4.setVisible(true);
                txt_anioFabricacion.setVisible(true);
                lbl_5.setVisible(true);
                txt_numPuertas.setVisible(false);
                lbl_6.setVisible(false);
                txt_capacidadCarga.setVisible(true);
                lbl_7.setVisible(true);
                cb_tipoTransmision.setVisible(false);
                lbl_8.setVisible(false);
                txt_numPuertas.clear();
                cb_tipoTransmision.getSelectionModel().clearSelection();
                break;
            case MOTO:
                txt_numMatricula.setVisible(true);
                lbl_2.setVisible(true);
                txt_marca.setVisible(true);
                lbl_3.setVisible(true);
                txt_modelo.setVisible(true);
                lbl_4.setVisible(true);
                txt_anioFabricacion.setVisible(true);
                lbl_5.setVisible(true);
                txt_numPuertas.setVisible(false);
                lbl_6.setVisible(false);
                txt_capacidadCarga.setVisible(false);
                lbl_7.setVisible(false);
                cb_tipoTransmision.setVisible(true);
                lbl_8.setVisible(true);
                txt_capacidadCarga.clear();
                txt_numPuertas.clear();
                break;
            default:
                break;
        }
    }
    
    /**
     * Metodo para inicializar el controlador despues de que su archivo FXML haya sido cargado, configura el vehiculoController e inicializa los ComboBox usados
     */
    @FXML
    void initialize() {
        cb_tipoTransmision.getItems().addAll(Tipo_transmision.values());
        cb_tipoVehiculo.getItems().addAll(Tipo_vehiculo.values());
        cb_tipoVehiculo.setOnAction(event -> manejarSeleccionTipo());
        vehiculoController = new VehiculoController(App.empresa);
        initView();
        manejarSeleccionTipo();

        assert txt_marca != null : "fx:id=\"txt_marca\" was not injected: check your FXML file 'vehiculo.fxml'.";
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
        assert txt_numMatricula != null : "fx:id=\"txt_numMatricula\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cb_tipoTransmision != null : "fx:id=\"cb_tipoTransmision\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert tbl_vehiculos != null : "fx:id=\"tbl_vehiculos\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert pane_1 != null : "fx:id=\"pane_1\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert cb_tipoVehiculo != null : "fx:id=\"cb_tipoVehiculo\" was not injected: check your FXML file 'vehiculo.fxml'.";
        assert txt_capacidadCarga != null : "fx:id=\"txt_capacidadCarga\" was not injected: check your FXML file 'vehiculo.fxml'.";

    }
}