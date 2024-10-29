package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.viewController.AutoViewController;
import co.edu.uniquindio.poo.viewController.CamionetaViewController;
import co.edu.uniquindio.poo.viewController.EmpresaViewController;
import co.edu.uniquindio.poo.viewController.MotoViewController;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage empresaStage;
    private Stage autoStage;
    private Stage motoStage;
    private Stage camionetaStage;

    public static Empresa empresa = new Empresa("UQ");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage empresaStage) throws IOException {
        this.empresaStage = empresaStage;
        this.empresaStage.setTitle("Gestion de la Empresa");
        openViewEmpresa();
    }

    private void openViewEmpresa() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EmpresaView.fxml"));
            Parent root = loader.load();

            EmpresaViewController empresaViewController = loader.getController();
            empresaViewController.setApp(this);

            Scene scene = new Scene(root);
            empresaStage.setScene(scene);
            empresaStage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openAutoView() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AutoView.fxml"));
            Parent root = loader.load();

            AutoViewController autoViewController = loader.getController();
            autoViewController.setApp(this);

            Scene scene = new Scene(root);
            autoStage.initModality(Modality.WINDOW_MODAL);
            autoStage.setScene(scene);
            autoStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openMotoView() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("MotoView.fxml"));
            Parent root = loader.load();

            MotoViewController motoViewController = loader.getController();
            motoViewController.setApp(this);

            Scene scene = new Scene(root);
            motoStage.initModality(Modality.WINDOW_MODAL);
            motoStage.setScene(scene);
            motoStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCamionetaView() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("CamionetaView.fxml"));
            Parent root = loader.load();

            CamionetaViewController camionetaViewController = loader.getController();
            camionetaViewController.setApp(this);

            Scene scene = new Scene(root);
            camionetaStage.initModality(Modality.WINDOW_MODAL);
            camionetaStage.setScene(scene);
            camionetaStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}