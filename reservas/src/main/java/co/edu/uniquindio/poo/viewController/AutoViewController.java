package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.AutoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AutoViewController {

    @FXML
    private Button btnAceptar;

    @FXML
    private TextField txtNumeroPuertas;

    private App app;

    AutoController autoController;

    private int numPuertas;

    @FXML
    void initialize() {
        autoController = new AutoController(app.empresa);

        txtNumeroPuertas.clear();
    }
    
    @FXML
    void regresar(ActionEvent event) {

        if (obtenerData()) {

            Stage stage = (Stage) btnAceptar.getScene().getWindow();
            stage.close();

        } else if (txtNumeroPuertas.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes rellenar los espacios.");
            alert.showAndWait();

        }  
    }
    
    public boolean obtenerData() {
        
        boolean centinela = false;
        String auxText = txtNumeroPuertas.getText();

        try {

            if (!auxText.isEmpty()) {

                int aux = Integer.parseInt(txtNumeroPuertas.getText());
                this.numPuertas = aux;
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

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
