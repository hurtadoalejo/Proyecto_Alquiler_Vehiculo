package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.AlquilerController;
import co.edu.uniquindio.poo.model.Alquiler;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Vehiculo;
import java.util.Collection;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
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

    @FXML
    void onOpenMenu() {
        app.openMenu();
    }

    @FXML
    void onOpenVehiculo() {
        app.openVehiculo();
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
    void onAgregarAlquiler() {
        agregarAlquiler();
    }

    @FXML
    void onActualizarAlquiler() {
        actualizarAlquiler();
    }

    @FXML
    void onEliminarAlquiler() {
        eliminarAlquiler();
    }

    private void initView() {
        initDataBinding();
        obtenerAlquileres();
        tbl_alquileres.getItems().clear();
        tbl_alquileres.setItems(listaAlquileres);
        listenerSelection();
    }

    private void initDataBinding() {
        cl_codigo.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCodigo()).asObject());
        cl_dias.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getDiasAlquiler()).asObject());
        cl_precioDia.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTarifaBase()).asObject());
        cl_matricula.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumMatricula()).asObject());
        cl_cedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        cl_total.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getCostoAlquiler()).asObject());
    }

    private void obtenerAlquileres() {
        listaAlquileres.addAll(alquilerController.obtenerListaAlquileres());
    }

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

    private boolean verificarCasillasCorrectas(){
        boolean decision = false;
        if (esEntero(txt_codigo.getText()) && esEntero(txt_dias.getText()) && esDouble(txt_precioDia.getText()) && esEntero(txt_vehiculo.getText())) {
            decision = true;
        }
        return decision;
    }

    private boolean verificarAlquilerCasillas(){
        boolean decision = false;
        if (!txt_codigo.getText().isEmpty() && !txt_dias.getText().isEmpty() && !txt_precioDia.getText().isEmpty() && !txt_vehiculo.getText().isEmpty() && !txt_cliente.getText().isEmpty()) {
            decision = true;
        }
        return decision;
    }

    private void agregarAlquiler() {
        if (verificarCasillasCorrectas()) {
            Alquiler alquiler = buildAlquiler();
            if (verificarAlquilerCasillas() && alquiler != null) {
                if (alquilerController.crearAlquiler(alquiler)) {
                    listaAlquileres.add(alquiler);
                    limpiarCamposAlquiler();
                }
            }   
        }
    }
    private Alquiler buildAlquiler() {
        int matricula = Integer.parseInt(txt_vehiculo.getText());
        String cedula = txt_cliente.getText();
        Alquiler alquiler = new Alquiler(Integer.parseInt(txt_codigo.getText()), buscarClientePorCedula(cedula), buscarVehiculoPorMatricula(matricula), Integer.parseInt(txt_dias.getText()), Double.parseDouble(txt_precioDia.getText()));
        return alquiler;
    }
    private void actualizarAlquiler() {
        if (selectedAlquiler != null && alquilerController.actualizarAlquiler(selectedAlquiler.getCodigo(), buildAlquiler())) {
            int index = listaAlquileres.indexOf(selectedAlquiler);
            if (index >= 0) {
                listaAlquileres.set(index, buildAlquiler());
            }

            tbl_alquileres.refresh();
            limpiarSeleccion();
            limpiarCamposAlquiler();
        }
    }
    private void eliminarAlquiler() {
        if (!txt_codigo.getText().isEmpty() && esEntero(txt_codigo.getText())) {
            if (alquilerController.eliminarAlquiler(Integer.parseInt(txt_codigo.getText()))) {
                eliminarAlquilerPorCodigo();
                limpiarCamposAlquiler();
                limpiarSeleccion();
            }
        }   
    }
    private void eliminarAlquilerPorCodigo(){
        for (Alquiler alquiler : listaAlquileres) {
            if (alquiler.getCodigo() == Integer.parseInt(txt_codigo.getText())) {
                listaAlquileres.remove(alquiler);
                break;
            }
        }
    }
    @SuppressWarnings("exports")
    public Cliente buscarClientePorCedula(String cedula){
        Collection<Cliente> listaClientes = alquilerController.obtenerListaClientes();
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }
    @SuppressWarnings("exports")
    public Vehiculo buscarVehiculoPorMatricula(int matricula){
        Collection<Vehiculo> listaVehiculos = alquilerController.obtenerListaVehiculos();
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getNumMatricula() == matricula) {
                return vehiculo;
            }
        }
        return null;
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
        initView();
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
