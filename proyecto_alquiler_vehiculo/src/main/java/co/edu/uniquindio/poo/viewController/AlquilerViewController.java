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
    ClienteViewController clienteViewController;
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
    private TableColumn<Alquiler, Integer> cl_matricula;

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
    private TableColumn<Alquiler, String> cl_cedula;

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
     * Metodo para inicializar la interfaz del vehiculo
     */
    @FXML
    void onOpenVehiculo() {
        app.openVehiculo();
    }

    /**
     * Metodo para inicializar la interfaz del cliente
     */
    @FXML
    void onOpenCliente() {
        app.openCliente();
    }

    /**
     * Metodo para manejar el evento de limpiar la seleccion actual
     */
    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    /**
     * Metodo para manejar el evento de agregar un alquiler
     */
    @FXML
    void onAgregarAlquiler() {
        agregarAlquiler();
    }

    /**
     * Metodo para manejar el evento de actualizar un alquiler
     */
    @FXML
    void onActualizarAlquiler() {
        actualizarAlquiler();
    }

    /**
     * Metodo para manejar el evento de eliminar un alquiler
     */
    @FXML
    void onEliminarAlquiler() {
        eliminarAlquiler();
    }

    /**
     * Metodo que inicializa la vista del controlador
     */
    private void initView() {
        initDataBinding();
        obtenerAlquileres();
        tbl_alquileres.getItems().clear();
        tbl_alquileres.setItems(listaAlquileres);
        listenerSelection();
    }

    /**
     * Metodo para configurar los tipos de datos de cada columna de la tabla alquileres del controlador
     */
    private void initDataBinding() {
        cl_codigo.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCodigo()).asObject());
        cl_dias.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getDiasAlquiler()).asObject());
        cl_precioDia.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTarifaBase()).asObject());
        cl_matricula.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getVehiculo().getNumMatricula()).asObject());
        cl_cedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getCedula()));
        cl_total.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getCostoAlquiler()).asObject());
    }

    /**
     * Metodo para obtener la lista de alquileres de la empresa y asignarla a la lista de alquileres del controlador
     */
    private void obtenerAlquileres() {
        listaAlquileres.addAll(alquilerController.obtenerListaAlquileres());
    }

    /**
     * Metodo para mostrar la informacion de un alquiler en los campos correspondientes de la tabla de alquileres
     * @param alquiler Alquiler con la informacion que se busca mostrar
     */
    private void mostrarInformacionAlquiler(Alquiler alquiler) {
        if (alquiler != null) {
            txt_codigo.setText(String.valueOf(alquiler.getCodigo()));
            txt_dias.setText(String.valueOf(alquiler.getDiasAlquiler()));
            txt_precioDia.setText(String.valueOf(alquiler.getTarifaBase()));
            txt_vehiculo.setText(String.valueOf(alquiler.getVehiculo().getNumMatricula()));
            txt_cliente.setText(alquiler.getCliente().getCedula());
            txt_codigo.setDisable(true);
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
     * Metodo para verificar si las casillas de texto relacionadas con la informacion del alquiler tienen datos validos
     * @return Booleano sobre si los campos relacionados al alquiler tienen datos validos
     */
    private boolean verificarCasillasCorrectas(){
        boolean decision = false;
        if (esEntero(txt_codigo.getText()) && esEntero(txt_dias.getText()) && esDouble(txt_precioDia.getText()) && esEntero(txt_vehiculo.getText())) {
            if (alquilerController.verificarCliente(txt_cliente.getText()) && alquilerController.verificarVehiculo(Integer.parseInt(txt_vehiculo.getText()))) {
                decision = true;
            }
        }
        return decision;
    }

    /**
     * Metodo para verificar si las casillas de texto relacionadas con la informacion del alquiler estan llenas
     * @return Booleano sobre si todos los campos estan llenos o no
     */
    private boolean verificarAlquilerCasillas(){
        boolean decision = false;
        if (!txt_codigo.getText().isEmpty() && !txt_dias.getText().isEmpty() && !txt_precioDia.getText().isEmpty() && !txt_vehiculo.getText().isEmpty() && !txt_cliente.getText().isEmpty()) {
            decision = true;
        }
        return decision;
    }

    /**
     * Metodo para agregar un alquiler a la lista de alquileres si los campos estan llenos y con los tipos de datos validos
     */
    private void agregarAlquiler() {
        if (verificarCasillasCorrectas() && verificarAlquilerCasillas()) {
            Alquiler alquiler = buildAlquiler();
            if (alquiler != null) {
                if (alquilerController.crearAlquiler(alquiler)) {
                    listaAlquileres.add(alquiler);
                    limpiarCamposAlquiler();
                }
            }   
        }
    }

    /**
     * Metodo para crear un alquiler con los datos ingresados en los campos de texto
     * @return Alquiler creado
     */
    private Alquiler buildAlquiler() {
        if (esEntero(txt_vehiculo.getText())) {
            Vehiculo vehiculo = buscarVehiculoPorMatricula(Integer.parseInt(txt_vehiculo.getText()));
            Cliente cliente = buscarClientePorCedula(txt_cliente.getText());
            if (vehiculo != null && cliente != null) {
                Alquiler alquiler = new Alquiler(Integer.parseInt(txt_codigo.getText()), cliente, vehiculo, Integer.parseInt(txt_dias.getText()), Double.parseDouble(txt_precioDia.getText()));
                return alquiler;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }

    /**
     * Metodo para actualizar la informacion del alquiler seleccionado si los campos estan llenos correctamente
     */
    private void actualizarAlquiler() {
        if (verificarAlquilerCasillas() && verificarCasillasCorrectas()) {
            if (selectedAlquiler != null && alquilerController.actualizarAlquiler(selectedAlquiler.getCodigo(), buildAlquiler())) {
                tbl_alquileres.refresh();
                limpiarSeleccion();
                limpiarCamposAlquiler();
            }
        }
    }

    /**
     * Metodo para eliminar un alquiler de la lista de alquileres segun el codigo proporcionado en el campo de este
     */
    private void eliminarAlquiler() {
        if (!txt_codigo.getText().isEmpty() && esEntero(txt_codigo.getText())) {
            if (alquilerController.eliminarAlquiler(Integer.parseInt(txt_codigo.getText()))) {
                listaAlquileres.remove(selectedAlquiler);
                limpiarCamposAlquiler();
                limpiarSeleccion();
            }
        }   
    }

    /**
     * Metodo para buscar un cliente en la lista de cliente con un numero de cedula
     * @param cedula Cedula para buscar el cliente
     * @return Un cliente que tenga el mismo numero de cedula que el dado o un null si no se encontro ningun cliente con esta condicion
     */
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

    /**
     * Metodo para buscar un vehiculo en la lista de vehiculos con un numero de matricula
     * @param matricula Numero de matricula para buscar el vehiculo
     * @return Un vehiculo que tenga el mismo numero de matricula que el dado o un null si no se encontro ningun vehiculo con esta condicion
     */
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

    /**
     * Metodo para configurar la seleccion de un elemento en la tabla de alquileres
     */
    private void listenerSelection() {
        tbl_alquileres.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedAlquiler = newSelection;
            mostrarInformacionAlquiler(selectedAlquiler);
        });
    }

    /**
     * Metodo para limpiar la seleccion de un elementos en la tabla de alquileres
     */
    private void limpiarSeleccion() {
        tbl_alquileres.getSelectionModel().clearSelection();
        limpiarCamposAlquiler();
    }

    /**
     * Metodo para limpiar los campos de texto relacionados con la informacion del alquiler
     */
    private void limpiarCamposAlquiler() {
        txt_codigo.clear();
        txt_dias.clear();
        txt_vehiculo.clear();
        txt_cliente.clear();
        txt_precioDia.clear();
        txt_codigo.setDisable(false);
    }

    /**
     * Metodo para inicializar el controlador despues de que su archivo FXML haya sido cargado y configura el alquilerController
     */
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