package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ClienteViewController {

    @FXML
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Button bt_1;

    @FXML
    private Label lbl_3;

    @FXML
    private Button bt_2;

    @FXML
    private Label lbl_4;

    @FXML
    private Label lbl_5;

    @FXML
    private TableColumn<?, ?> cl_4;

    @FXML
    private TableColumn<?, ?> cl_2;

    @FXML
    private Pane pane_1;

    @FXML
    private TableColumn<?, ?> cl_3;

    @FXML
    private TableColumn<?, ?> cl_1;

    @FXML
    private TextField txt_1;

    @FXML
    private TextField txt_2;

    @FXML
    private TextField txt_3;

    @FXML
    private TextField txt_4;

    @FXML
    void onOpenMenu() {
        app.openMenu();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        assert bt_5 != null : "fx:id=\"bt_5\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_6 != null : "fx:id=\"bt_6\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_3 != null : "fx:id=\"bt_3\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_1 != null : "fx:id=\"lbl_1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_2 != null : "fx:id=\"lbl_2\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_4 != null : "fx:id=\"bt_4\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_1 != null : "fx:id=\"bt_1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_3 != null : "fx:id=\"lbl_3\" was not injected: check your FXML file 'cliente.fxml'.";
        assert bt_2 != null : "fx:id=\"bt_2\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_4 != null : "fx:id=\"lbl_4\" was not injected: check your FXML file 'cliente.fxml'.";
        assert lbl_5 != null : "fx:id=\"lbl_5\" was not injected: check your FXML file 'cliente.fxml'.";
        assert cl_4 != null : "fx:id=\"cl_4\" was not injected: check your FXML file 'cliente.fxml'.";
        assert cl_2 != null : "fx:id=\"cl_2\" was not injected: check your FXML file 'cliente.fxml'.";
        assert pane_1 != null : "fx:id=\"pane_1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert cl_3 != null : "fx:id=\"cl_3\" was not injected: check your FXML file 'cliente.fxml'.";
        assert cl_1 != null : "fx:id=\"cl_1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txt_1 != null : "fx:id=\"txt_1\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txt_2 != null : "fx:id=\"txt_2\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txt_3 != null : "fx:id=\"txt_3\" was not injected: check your FXML file 'cliente.fxml'.";
        assert txt_4 != null : "fx:id=\"txt_4\" was not injected: check your FXML file 'cliente.fxml'.";

    }
}