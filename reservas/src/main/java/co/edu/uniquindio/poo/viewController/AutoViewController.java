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

    private int numeroPuertas;

    @FXML
    void initialize() {
        autoController = new AutoController(app.empresa);
    }
    
    @FXML
    void regresar(ActionEvent event) {
        
        guardarInfo();

        Stage stage = (Stage) btnAceptar.getScene().getWindow();
        stage.close();
    }

    public void guardarInfo() {
        try {
            this.numeroPuertas = Integer.parseInt(txtNumeroPuertas.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Formato incorrecto.");
            alert.showAndWait();
        }
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
