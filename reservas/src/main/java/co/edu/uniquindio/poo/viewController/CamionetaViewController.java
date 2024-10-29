package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.AutoController;
import co.edu.uniquindio.poo.controller.CamionetaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CamionetaViewController {

    @FXML
    private Button btnAceptar;

    @FXML
    private TextField txtCapacidadCarga;

    private App app;

    CamionetaController camionetaController;

    @FXML
    void initialize() {
        camionetaController = new CamionetaController(app.empresa);
    }

    @FXML
    void regresar(ActionEvent event) {

    }

    public void setApp(App app) {
        this.app = app;
    }
}
