package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.CamionetaController;
import co.edu.uniquindio.poo.controller.MotoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class MotoViewController {

    @FXML
    private Button btnAceptar;

    @FXML
    private RadioButton rdManual;

    @FXML
    private RadioButton rdAutomatica;

    private App app;

    MotoController motoController;

    @FXML
    void initialize() {
        motoController = new MotoController(app.empresa);
    }

    @FXML
    void regresar(ActionEvent event) {

    }

    @FXML
    void determinarCaja(ActionEvent event) {

    }

    public void setApp(App app) {
        this.app = app;
    }
}

