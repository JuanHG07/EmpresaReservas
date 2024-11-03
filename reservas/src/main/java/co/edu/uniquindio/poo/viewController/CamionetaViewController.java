package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.CamionetaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CamionetaViewController {

    @FXML
    private Button btnAceptar;

    @FXML
    private TextField txtCapacidadCarga;

    private App app;

    CamionetaController camionetaController;

    private double capacidad;

    @FXML
    void initialize() {
        camionetaController = new CamionetaController(app.empresa);

        txtCapacidadCarga.clear();
    }

    @FXML
    void regresar(ActionEvent event) {

        if (obtenerData()) {

            Stage stage = (Stage) btnAceptar.getScene().getWindow();
            stage.close();

        } else if (txtCapacidadCarga.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes rellenar los espacios.");
            alert.showAndWait();

        }
    }

    public boolean obtenerData() {
        
        boolean centinela = false;
        String auxText = txtCapacidadCarga.getText();

        try {

            if (!auxText.isEmpty()) {

                double aux = Double.parseDouble(txtCapacidadCarga.getText());
                this.capacidad = aux;
                centinela = true;

            }

        } catch (NumberFormatException e) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Formato incorrecto de la casilla.");
            alert.showAndWait();
            
        }
        return centinela;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
