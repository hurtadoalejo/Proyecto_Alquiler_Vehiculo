package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ClienteController;
import co.edu.uniquindio.poo.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ClienteViewController {

    ClienteController clienteController;
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    Cliente selectedCliente;

    @FXML
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Cliente, String> cl_estadoCliente;

    @FXML
    private TextField txt_telefono;

    @FXML
    private Button bt_7;

    @FXML
    private Button bt_5;

    @FXML
    private Button bt_6;

    @FXML
    private Button bt_3;

    @FXML
    private Label lbl_1;

    @FXML
    private Label lbl_2;

    @FXML
    private Button bt_4;

    @FXML
    private TableColumn<Cliente, String> cl_cedula;

    @FXML
    private Button bt_1;

    @FXML
    private Label lbl_3;

    @FXML
    private TableView<Cliente> tbl_clientes;

    @FXML
    private TableColumn<Cliente, String> cl_correo;

    @FXML
    private Button bt_2;

    @FXML
    private Label lbl_4;

    @FXML
    private Label lbl_5;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TableColumn<Cliente, String> cl_telefono;

    @FXML
    private TextField txt_correo;

    @FXML
    private Pane pane_1;

    @FXML
    private TableColumn<Cliente, String> cl_nombre;

    @FXML
    private TextField txt_cedula;

    @FXML
    void onOpenMenu() {
        app.openMenu();
    }

    @FXML
    void onOpenVehiculo() {
        app.openVehiculo();
    }

    @FXML
    void onOpenAlquiler() {
        app.openAlquiler();
    }

    @FXML
    void onAgregarCliente() {
        agregarCliente();
    }

    @FXML
    void onActualizarCliente() {
        actualizarCliente();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminarCliente() {
        eliminarCliente();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tbl_clientes.getItems().clear();
        tbl_clientes.setItems(listaClientes);
        listenerSelection();
    }

    private void initDataBinding() {
        cl_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        cl_cedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        cl_telefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        cl_correo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        cl_estadoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstadoCliente().name()));
    }

    private void obtenerClientes() {
        listaClientes.addAll(clienteController.obtenerListaClientes());
    }

    private void listenerSelection() {
        tbl_clientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txt_nombre.setText(cliente.getNombre());
            txt_cedula.setText(cliente.getCedula());
            txt_telefono.setText(cliente.getTelefono());
            txt_correo.setText(cliente.getCorreo());
            txt_cedula.setDisable(true);
        }
    }

    private void agregarCliente() {
        if (verificarCasillasLlenas()) {
            Cliente cliente = buildCliente();
            if (clienteController.crearCliente(cliente)) {
                listaClientes.add(cliente);
                limpiarCamposCliente();
            }
        } 
    }

    private boolean verificarCasillasLlenas() {
        boolean decision = false;
        if (!txt_nombre.getText().isEmpty() && !txt_cedula.getText().isEmpty() && !txt_telefono.getText().isEmpty() && !txt_correo.getText().isEmpty()){
            decision = true;
        }
        return decision;
    }

    private Cliente buildCliente() {
        Cliente cliente = new Cliente(txt_nombre.getText(), txt_cedula.getText(), txt_telefono.getText(), txt_correo.getText());
        return cliente;
    }

    private void eliminarCliente() {
        if (clienteController.eliminarCliente(txt_cedula.getText())) {
            eliminarClientePorCedula();
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }

    private void eliminarClientePorCedula(){
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(txt_cedula.getText())) {
                listaClientes.remove(cliente);
                break;
            }
        }
    }

    private void actualizarCliente() {
        if (verificarCasillasLlenas()) {
            if (selectedCliente != null && clienteController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {
                int index = listaClientes.indexOf(selectedCliente);
                if (index >= 0) {
                    listaClientes.set(index, buildCliente());
                }
                
                tbl_clientes.refresh();
                limpiarSeleccion();
                limpiarCamposCliente();
            }
        }
    }

    private void limpiarSeleccion() {
        tbl_clientes.getSelectionModel().clearSelection();
        limpiarCamposCliente();
        txt_cedula.setDisable(false);
    }

    private void limpiarCamposCliente() {
        txt_nombre.clear();
        txt_cedula.clear();
        txt_telefono.clear();
        txt_correo.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        clienteController = new ClienteController(App.empresa);
        initView();
        assert cl_estadoCliente != null : "fx:id=\"cl_estadoCliente\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_telefono\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_7 != null : "fx:id=\"bt_7\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_5 != null : "fx:id=\"bt_5\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_6 != null : "fx:id=\"bt_6\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_3 != null : "fx:id=\"bt_3\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_1 != null : "fx:id=\"lbl_1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_2 != null : "fx:id=\"lbl_2\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_4 != null : "fx:id=\"bt_4\" was not injected: check your FXML file 'cliente.fxml'.";
        assert cl_cedula != null : "fx:id=\"cl_cedula\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_1 != null : "fx:id=\"bt_1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_3 != null : "fx:id=\"lbl_3\" was not injected: check your FXML file 'cliente.fxml'.";
        assert tbl_clientes != null : "fx:id=\"tbl_clientes\" was not injected: check your FXML file 'cliente.fxml'.";
        assert cl_correo != null : "fx:id=\"cl_correo\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_2 != null : "fx:id=\"bt_2\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_4 != null : "fx:id=\"lbl_4\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_5 != null : "fx:id=\"lbl_5\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'cliente.fxml'.";
        assert cl_telefono != null : "fx:id=\"cl_telefono\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'cliente.fxml'.";
        assert pane_1 != null : "fx:id=\"pane_1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert cl_nombre != null : "fx:id=\"cl_nombre\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txt_cedula != null : "fx:id=\"txt_cedula\" was not injected: check your FXML file 'cliente.fxml'.";
    }
}