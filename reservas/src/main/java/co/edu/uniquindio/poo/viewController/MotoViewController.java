package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MotoController;
import co.edu.uniquindio.poo.model.TipoCaja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MotoViewController {

    @FXML
    private Button btnAceptar;

    @FXML
    private RadioButton rdManual;

    @FXML
    private RadioButton rdAutomatica;

    private App app;

    MotoController motoController;

    private TipoCaja tipoCaja;

    ToggleGroup tg;

    @FXML
    void initialize() {
        motoController = new MotoController(app.empresa);
        this.tg = new ToggleGroup();

        enlaceOpciones();

        rdAutomatica.setSelected(false);
        rdManual.setSelected(false);
    }

    private void enlaceOpciones() {
        rdAutomatica.setToggleGroup(tg);
        rdManual.setToggleGroup(tg);
    }

    @FXML
    void regresar(ActionEvent event) {
        if (obtenerData()) {
            Stage stage = (Stage) btnAceptar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes escoger alguna opcion.");
            alert.showAndWait();
        }
    }

    public boolean obtenerData() {

        boolean centinela = false; 

        if (rdAutomatica.isSelected()) {
            this.tipoCaja = TipoCaja.AUTOMATICA;
            centinela = true;
        } if (rdManual.isSelected()) {
            this.tipoCaja = TipoCaja.MANUAL;
            centinela = true;
        }
        return centinela;
    }

    public TipoCaja getTipoCaja() {
        return tipoCaja;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
