package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.EmpresaController;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.TipoCaja;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class EmpresaViewController {

    @FXML
    private Button btnLimpiarC;

    @FXML
    private Button btnLimpiarV;

    @FXML
    private Button btnLimpiarR;

    @FXML
    private RadioButton rdAuto;

    @FXML
    private RadioButton rdMoto;

    @FXML
    private RadioButton rdCamioneta;

    @FXML
    private Button btnModificarC;

    @FXML
    private Button btnAgregarV;

    @FXML
    private TableColumn<Reserva, Integer> tcDias;

    @FXML
    private TableView<Cliente> tvClientes;

    @FXML
    private TextField txtCedula;

    @FXML
    private Button btnEliminarC;

    @FXML
    private TableColumn<Vehiculo, String> tcMatricula;

    @FXML
    private Button btnAgregarC;

    @FXML
    private Tab tbVehiculos;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn<Reserva, String> tcCedulaR;

    @FXML
    private Button btnEliminarV;

    @FXML
    private TableColumn<Cliente, String> tcCedula;

    @FXML
    private TextField txtMatriculaR;

    @FXML
    private TableView<Reserva> tvReservas;

    @FXML
    private TableColumn<Reserva, String> tcCodigo;

    @FXML
    private TextField txtDias;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TabPane tpEmpresa;

    @FXML
    private Button btnAgregarR;

    @FXML
    private Button btnEliminarR;

    @FXML
    private TableColumn<Vehiculo, String> tcMarca;

    @FXML
    private TableView<Vehiculo> tvVehiculos;

    @FXML
    private TableColumn<Cliente, String> tcNombre;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtTarifaBase;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtCedulaR;

    @FXML
    private TextField txtAnioFabricacion;

    @FXML
    private TableColumn<Vehiculo, Double> tcTarifaBase;

    @FXML
    private Button btnModificarR;

    @FXML
    private TableColumn<Vehiculo, String> tcModelo;

    @FXML
    private TableColumn<Reserva, Double> tcCosto;

    @FXML
    private Tab tbReservas;

    @FXML
    private TableColumn<Reserva, String> tcMatriculaR;

    @FXML
    private TextField txtMarca;

    @FXML
    private Tab tbClientes;

    @FXML
    private TableColumn<Vehiculo, Integer> tcAnioFabricacion;

    @FXML
    private Button btnModificarV;

    private App app;

    EmpresaController empresaController;

    private ObservableList<Cliente> clientes;
    private ObservableList<Reserva> reservas;
    private ObservableList<Vehiculo> vehiculos;

    Cliente selectedCliente;
    Vehiculo selectedVehiculo;
    Reserva selectedReserva;

    ToggleGroup tg;

    @FXML
    void initialize() {
        clientes = FXCollections.observableArrayList();
        reservas = FXCollections.observableArrayList();
        vehiculos = FXCollections.observableArrayList();
        this.tg = new ToggleGroup();

        empresaController = new EmpresaController(app.empresa);

        carga();
    }

    @FXML
    private void carga() {
        // Tabla Cliente
        enlaceDataCliente();

        // Tabla Reserva
        enlaceDataReserva();

        // Tabla Vehiculo
        enlaceDataVehiculo();

        // Correccion opciones
        enlaceOpciones();

        seleccionarCliente();
        seleccionarVehiculo();
        seleccionarReserva();
    }

    private void enlaceDataCliente() {
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
    }

    private void enlaceDataReserva() {
        tcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tcDias.setCellValueFactory(new PropertyValueFactory<>("dias"));
        tcCedulaR.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tcMatriculaR.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        tcCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));
    }

    private void enlaceDataVehiculo() {
        tcMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        tcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tcAnioFabricacion.setCellValueFactory(new PropertyValueFactory<>("anioFabricacion"));
        tcTarifaBase.setCellValueFactory(new PropertyValueFactory<>("tarifaBase"));
    }

    private void enlaceOpciones() {
        rdMoto.setToggleGroup(tg);
        rdAuto.setToggleGroup(tg);
        rdCamioneta.setToggleGroup(tg);
    }

    private void seleccionarCliente() {
        tvClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtNombre.setText(cliente.getNombre());
            txtCedula.setText(cliente.getCedula());
        }
    }

    private void seleccionarVehiculo() {
        tvVehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVehiculo = newSelection;
            mostrarInformacionVehiculo(selectedVehiculo);
        });
    }

    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            txtMatricula.setText(vehiculo.getMatricula());
            txtMarca.setText(vehiculo.getMarca());
            txtModelo.setText(vehiculo.getModelo());
            txtAnioFabricacion.setText(vehiculo.getAnioFabricacion() + "");
            txtTarifaBase.setText(vehiculo.getTarifaBase() + "");

            rdAuto.setSelected(false);
            rdMoto.setSelected(false);
            rdCamioneta.setSelected(false);
        
            if (vehiculo instanceof Auto) {
                rdAuto.setSelected(true);
            } else if (vehiculo instanceof Moto) {
                rdMoto.setSelected(true);
            } else if (vehiculo instanceof Camioneta) {
                rdCamioneta.setSelected(true);
            }
        }
    }

    private void seleccionarReserva() {
        tvReservas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedReserva = newSelection;
            mostrarInformacionReserva(selectedReserva);
        });
    }

    private void mostrarInformacionReserva(Reserva reserva) {
        if (reserva != null) {
            txtCodigo.setText(reserva.getCodigo());
            txtDias.setText(reserva.getDias() + "");
            txtCedulaR.setText(reserva.getCliente().getCedula());
            txtMatriculaR.setText(reserva.getVehiculo().getMatricula());
        }
    }

    @FXML
    void agregarCliente(ActionEvent event) {

        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();

        Cliente cliente = new Cliente(nombre, cedula);

        if (nombre.isEmpty() || cedula.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes rellenar los espacios.");
            alert.showAndWait();

        } else {

            if (!empresaController.verificarCliente(cedula)) {
                empresaController.agregarCliente(cliente);
                clientes.add(cliente);
                tvClientes.setItems(clientes);
                limpiarCliente();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("El cliente ya existe.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void modificarCliente(ActionEvent event) {

        Cliente cliente = tvClientes.getSelectionModel().getSelectedItem();

        if (cliente == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar a un cliente.");
            alert.showAndWait();
        } else {
            String nombre = txtNombre.getText();
            String cedula = txtCedula.getText();
            if (nombre.isEmpty() || cedula.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Debes rellenar los espacios.");
                alert.showAndWait();
            } else {

                Cliente aux = new Cliente(nombre, cedula);

                if (cliente.getCedula().equals(cedula)) {
                    cliente.setNombre(aux.getNombre());
                    cliente.setCedula(aux.getCedula());

                    tvClientes.refresh();
                    tvClientes.getSelectionModel().clearSelection();
                    limpiarCliente();
                } else if (empresaController.verificarCliente(cedula)) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("El cliente ya existe.");
                    alert.showAndWait();

                }
            }
        }
    }

    @FXML
    void eliminarCliente(ActionEvent event) {

        Cliente cliente = tvClientes.getSelectionModel().getSelectedItem();

        if (cliente == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar a un cliente.");
            alert.showAndWait();
        } else {
            empresaController.obtenerListaClientes().remove(cliente);
            clientes.remove(cliente);

            tvClientes.refresh();
            limpiarCliente();
        }
    }

    @FXML
    void limpiarCliente(ActionEvent event) {
        limpiarCliente();
    }

    public void limpiarCliente() {
        txtNombre.clear();
        txtCedula.clear();
    }

    @FXML
    void agregarVehiculo(ActionEvent event) {

        try {

            String matricula = txtMatricula.getText();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            String anioFabricacionText = txtAnioFabricacion.getText();
            String tarifaBaseText = txtTarifaBase.getText();

            Vehiculo vehiculo;

            if (matricula.isEmpty() || marca.isEmpty() || modelo.isEmpty() || anioFabricacionText.isEmpty() || tarifaBaseText.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Debes rellenar los espacios.");
                alert.showAndWait();

            } else {

                int anioFabricacion = Integer.parseInt(txtAnioFabricacion.getText());
                double tarifaBase = Double.parseDouble(txtTarifaBase.getText());

                if (!empresaController.verificarVehiculo(matricula)) {

                    if (rdAuto.isSelected()) {

                        app.openAutoView();

                        int numPuertas = app.getAutoViewController().getNumPuertas();

                        vehiculo = new Auto(matricula, marca, modelo, anioFabricacion, tarifaBase, numPuertas);
                        empresaController.agregarVehiculo(vehiculo);
                        vehiculos.add(vehiculo);
                        tvVehiculos.setItems(vehiculos);
                        limpiarVehiculo();

                    } else if (rdMoto.isSelected()) {

                        app.openMotoView();

                        TipoCaja tipoCaja = app.getMotoViewController().getTipoCaja();

                        vehiculo = new Moto(matricula, marca, modelo, anioFabricacion, tarifaBase, tipoCaja);
                        empresaController.agregarVehiculo(vehiculo);
                        vehiculos.add(vehiculo);
                        tvVehiculos.setItems(vehiculos);
                        limpiarVehiculo();

                    } else if (rdCamioneta.isSelected()) {

                        app.openCamionetaView();

                        double capacidad = app.getCamionetaViewController().getCapacidad();

                        vehiculo = new Camioneta(matricula, marca, modelo, anioFabricacion, tarifaBase, capacidad);
                        empresaController.agregarVehiculo(vehiculo);
                        vehiculos.add(vehiculo);
                        tvVehiculos.setItems(vehiculos);
                        limpiarVehiculo();

                    } else {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("ERROR");
                        alert.setContentText("Debes seleccionar una opcion de vehiculo.");
                        alert.showAndWait();

                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("El vehiculo ya existe.");
                    alert.showAndWait();
                }
            }
        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Formato incorrecto en casilla: Año de Fabricacion o Tarifa Base.");
            alert.showAndWait();

        }
    }

    @FXML
    void modificarVehiculo(ActionEvent event) {

        Vehiculo vehiculo = tvVehiculos.getSelectionModel().getSelectedItem();

        if (vehiculo == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar a un vehiculo.");
            alert.showAndWait();
        } else {

            String matricula = txtMatricula.getText();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            int anioFabricacion = Integer.parseInt(txtAnioFabricacion.getText());
            double tarifaBase = Double.parseDouble(txtTarifaBase.getText());

            if (vehiculo instanceof Auto) {
                rdAuto.setSelected(true);
            } else if (vehiculo instanceof Moto) {
                rdMoto.setSelected(true);
            } else if (vehiculo instanceof Camioneta) {
                rdCamioneta.setSelected(true);
            }

            if (vehiculo.getMatricula().equals(matricula)) {
                
                if (rdAuto.isSelected()) {

                    app.openAutoView();

                    int numPuertas = app.getAutoViewController().getNumPuertas();

                    Vehiculo aux = new Auto(matricula, marca, modelo, anioFabricacion, tarifaBase, numPuertas);
                    
                    vehiculo.setMatricula(aux.getMatricula());  
                    vehiculo.setMarca(aux.getMarca());
                    vehiculo.setModelo(aux.getModelo());
                    vehiculo.setAnioFabricacion(aux.getAnioFabricacion());
                    vehiculo.setTarifaBase(aux.getTarifaBase());
                    ((Auto) vehiculo).setNumPuertas(((Auto) aux).getNumPuertas());

                    tvVehiculos.refresh();
                    tvVehiculos.getSelectionModel().clearSelection();
                    limpiarVehiculo();

                } else if (rdMoto.isSelected()) {

                    app.openMotoView();

                    TipoCaja tipoCaja = app.getMotoViewController().getTipoCaja();

                    Vehiculo aux = new Moto(matricula, marca, modelo, anioFabricacion, tarifaBase, tipoCaja);
                    
                    vehiculo.setMatricula(aux.getMatricula());  
                    vehiculo.setMarca(aux.getMarca());
                    vehiculo.setModelo(aux.getModelo());
                    vehiculo.setAnioFabricacion(aux.getAnioFabricacion());
                    vehiculo.setTarifaBase(aux.getTarifaBase());
                    ((Moto) vehiculo).setTipoCaja(((Moto) aux).getTipoCaja());

                    tvVehiculos.refresh();
                    tvVehiculos.getSelectionModel().clearSelection();
                    limpiarVehiculo();

                } else if (rdCamioneta.isSelected()) {

                    app.openCamionetaView();

                    double capacidad = app.getCamionetaViewController().getCapacidad();

                    Vehiculo aux = new Camioneta(matricula, marca, modelo, anioFabricacion, tarifaBase, capacidad);
                    
                    vehiculo.setMatricula(aux.getMatricula());  
                    vehiculo.setMarca(aux.getMarca());
                    vehiculo.setModelo(aux.getModelo());
                    vehiculo.setAnioFabricacion(aux.getAnioFabricacion());
                    vehiculo.setTarifaBase(aux.getTarifaBase());
                    ((Camioneta) vehiculo).setCapacidadCarga(((Camioneta) aux).getCapacidadCarga());

                    tvVehiculos.refresh();
                    tvVehiculos.getSelectionModel().clearSelection();
                    limpiarVehiculo();
                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("Debes seleccionar una opcion de vehiculo.");
                    alert.showAndWait();

                }

            } else if (empresaController.verificarVehiculo(matricula)) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("El vehiculo ya existe.");
                alert.showAndWait();

            }
        }
    }

    @FXML
    void eliminarVehiculo(ActionEvent event) {

        Vehiculo vehiculo = tvVehiculos.getSelectionModel().getSelectedItem();

        if (vehiculo == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar a un vehiculo.");
            alert.showAndWait();
        } else {
            empresaController.obtenerListaVehiculos().remove(vehiculo);
            vehiculos.remove(vehiculo);

            tvVehiculos.refresh();
            limpiarVehiculo();
        }
    }

    @FXML
    void limpiarVehiculo(ActionEvent event) {
        limpiarVehiculo();
    }

    public void limpiarVehiculo() {
        txtMatricula.clear();
        txtModelo.clear();
        txtMarca.clear();
        txtAnioFabricacion.clear();
        txtTarifaBase.clear();
        tg.selectToggle(null);
    }

    @FXML
    void agregarReserva(ActionEvent event) {

        try {

            String codigo = txtCodigo.getText();
            int dias = Integer.parseInt(txtDias.getText());
            String cedula = txtCedulaR.getText();
            String matricula = txtMatriculaR.getText();

            Cliente cliente = empresaController.buscarCliente(cedula);
            Vehiculo vehiculo = empresaController.buscarVehiculo(matricula);

            Reserva reserva = new Reserva(codigo, dias, cliente, vehiculo);

            if (!empresaController.verificarReserva(codigo)) {
                empresaController.agregarReserva(reserva);
                reservas.add(reserva);
                tvReservas.setItems(reservas);
                reserva.calcularCosto();
                cliente.getReservas().add(reserva);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("La reserva ya existe.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Formato incorrecto.");
            alert.showAndWait();
        }
    }

    @FXML
    public void seleccionarReserva(MouseEvent event) {

        Reserva reserva = tvReservas.getSelectionModel().getSelectedItem();

        if (reserva != null) {
            txtCodigo.setText(reserva.getCodigo());
            txtDias.setText(reserva.getDias() + "");
            txtCedulaR.setText(reserva.getCliente().getCedula());
            txtMatriculaR.setText(reserva.getVehiculo().getMatricula());
        }
    }

    @FXML
    void modificarReserva(ActionEvent event) {

        Reserva reserva = tvReservas.getSelectionModel().getSelectedItem();
        try {
            if (reserva == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Debes seleccionar una reserva.");
                alert.showAndWait();
            } else {
                String codigo = txtCodigo.getText();
                int dias = Integer.parseInt(txtDias.getText());
                String cedula = txtCedulaR.getText();
                String matricula = txtMatriculaR.getText();

                Cliente cliente = empresaController.buscarCliente(cedula);
                Vehiculo vehiculo = empresaController.buscarVehiculo(matricula);

                Reserva aux = new Reserva(codigo, dias, cliente, vehiculo);

                if (!empresaController.verificarReserva(codigo)) {
                    reserva.setCodigo(aux.getCodigo());
                    reserva.setDias(aux.getDias());
                    reserva.setCliente(aux.getCliente());
                    reserva.setVehiculo(aux.getVehiculo());

                    tvReservas.refresh();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("La reserva ya existe.");
                    alert.showAndWait();
                }
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Formato incorrecto.");
            alert.showAndWait();
        }
    }

    @FXML
    void eliminarReserva(ActionEvent event) {

        Reserva reserva = tvReservas.getSelectionModel().getSelectedItem();

        if (reserva == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debes seleccionar una reserva.");
            alert.showAndWait();
        } else {
            empresaController.obtenerListaReservas().remove(reserva);
            reservas.remove(reserva);

            tvReservas.refresh();
        }
    }

    @FXML
    void limpiarReserva(ActionEvent event) {

    }

    public void setApp(App app) {
        this.app = app;
    }
}
