package mvc.vista.iugrafica.controladoresvista;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.vista.iugrafica.IUGrafica;
import mvc.vista.iugrafica.utilidades.Dialogos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class ControladorVentanaPrincipal {

    private ControladorDatosCliente cDatosClienteAC, cDatosClienteMC;
    private ControladorListadoClientes cListadoClientes;
    private ControladorAnadirCliente cAnadirCliente;
    private ControladorMostrarCliente cMostrarCliente;
    private ControladorListadoVehiculos cListadoVehiculos;
    private ControladorAnadirVehiculo cAnadirVehiculo;
    private ControladorMostrarVehiculo cMostrarVehiculo;
    private Stage listadoClientes, anadirCliente, mostrarCliente, listadoVehiculos,
            anadirVehiculo, mostrarVehiculo, listadoAlquileres, anadirAlquiler, mostrarAlquiler;

    @FXML
    private Button btListarClientes, btAnadirCliente, btBuscarCliente, btListarVehiculos, btAnadirVehiculo,
            btBuscarVehiculo, btListarAlquileres, btAnadirAlquiler, btBuscarAlquiler;

    @FXML
    private void listarClientes() {
        cListadoClientes.actualizaClientes();
        listadoClientes.showAndWait();
    }

    @FXML
    private void anadirCliente() {
        cDatosClienteAC.setCliente(null);
        anadirCliente.showAndWait();
    }

    @FXML
    private void buscarCliente() {
        String dniCliente = Dialogos.mostrarDialogoTexto("Buscar cliente", "Introduce el DNI del cliente a buscar");
        if (dniCliente != null) {
            Cliente cliente = IUGrafica.controladorMVC.buscarCliente(dniCliente);
            if (cliente != null) {
                cDatosClienteMC.setCliente(cliente);
                cDatosClienteMC.inhabilitaEdicionCampos();
                cMostrarCliente.setCliente(cliente);
                mostrarCliente.showAndWait();
            } else {
                Dialogos.mostrarDialogoError("Cliente no encontrado", "No existe ningún cliente con ese DNI");
            }
        }
    }

    @FXML
    private void listarVehiculos() {
        cListadoVehiculos.actualizaVehiculos();
        listadoVehiculos.showAndWait();
    }

    @FXML
    private void anadirVehiculo() {
        cAnadirVehiculo.setVehiculo(null);
        anadirVehiculo.showAndWait();
    }

    @FXML
    private void buscarVehiculo() {
        String matricula = Dialogos.mostrarDialogoTexto("Buscar vehículo", "Introduce la matrícula del vehículo a buscar");
        if (matricula != null) {
            Vehiculo vehiculo = IUGrafica.controladorMVC.buscarVehiculo(matricula);
            if (vehiculo != null) {
                cMostrarVehiculo.setVehiculo(vehiculo);
                mostrarVehiculo.showAndWait();
            } else {
                Dialogos.mostrarDialogoError("Vehículo no encontrado", "No existe ningún vehículo con esa matrícula");
            }
        }
    }

    @FXML
    private void listarAlquileres() {
        listadoAlquileres.showAndWait();
    }

    @FXML
    private void anadirAlquiler() {
    }

    @FXML
    private void buscarAlquiler() {
    }

    @FXML
    private void initialize() {
        try {
            crearListadoClientes();
            crearAnadirCliente();
            crearMostrarCliente();
            crearListadoVehiculos();
            crearAnadirVehiculo();
            crearMostrarVehiculo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void crearMostrarCliente() throws IOException {
        mostrarCliente = new Stage();
        FXMLLoader cargadorMostrarCliente = new FXMLLoader(
                getClass().getResource("/mvc/vista/iugrafica/vistas/MostrarCliente.fxml"));
        VBox raizMostrarClientes = (VBox) cargadorMostrarCliente.load();
        cMostrarCliente = cargadorMostrarCliente.getController();
        FXMLLoader cargadorDatosCliente = new FXMLLoader(
                getClass().getResource("/mvc/vista/iugrafica/vistas/DatosCliente.fxml"));
        GridPane gpDatosCliente = (GridPane) cargadorDatosCliente.load();
        cDatosClienteMC = cargadorDatosCliente.getController();
        raizMostrarClientes.getChildren().add(0, gpDatosCliente);
        Scene escenaMostrarCliente = new Scene(raizMostrarClientes);
        mostrarCliente.setTitle("Mostrar cliente");
        mostrarCliente.initModality(Modality.APPLICATION_MODAL);
        mostrarCliente.setScene(escenaMostrarCliente);
    }

    private void crearAnadirCliente() throws IOException {
        anadirCliente = new Stage();
        FXMLLoader cargadorAnadirCliente = new FXMLLoader(
                getClass().getResource("/mvc/vista/iugrafica/vistas/AnadirCliente.fxml"));
        VBox raizAnadirCliente = (VBox) cargadorAnadirCliente.load();
        cAnadirCliente = cargadorAnadirCliente.getController();
        FXMLLoader cargadorDatosCliente = new FXMLLoader(
                getClass().getResource("/mvc/vista/iugrafica/vistas/DatosCliente.fxml"));
        GridPane gpDatosCliente = (GridPane) cargadorDatosCliente.load();
        cDatosClienteAC = cargadorDatosCliente.getController();
        cAnadirCliente.setDatosCliente(cDatosClienteAC);
        raizAnadirCliente.getChildren().add(0, gpDatosCliente);
        Scene escenaAnadirCliente = new Scene(raizAnadirCliente);
        anadirCliente.setTitle("Añadir cliente");
        anadirCliente.initModality(Modality.APPLICATION_MODAL);
        anadirCliente.setScene(escenaAnadirCliente);
    }

    private void crearListadoClientes() throws IOException {
        listadoClientes = new Stage();
        FXMLLoader cargadorListadoClientes = new FXMLLoader(
                getClass().getResource("/mvc/vista/iugrafica/vistas/ListadoClientes.fxml"));
        VBox raizListadoClientes = (VBox) cargadorListadoClientes.load();
        cListadoClientes = cargadorListadoClientes.getController();
        Scene escenaListadoClientes = new Scene(raizListadoClientes);
        listadoClientes.setTitle("Listar clientes");
        listadoClientes.initModality(Modality.APPLICATION_MODAL);
        listadoClientes.setScene(escenaListadoClientes);
    }

    private void crearListadoVehiculos() throws IOException {
        listadoVehiculos = new Stage();
        FXMLLoader cargadorListadoVehiculos = new FXMLLoader(
                getClass().getResource("/mvc/vista/iugrafica/vistas/ListadoVehiculos.fxml"));
        VBox raizListadoVehiculos = (VBox) cargadorListadoVehiculos.load();
        cListadoVehiculos = cargadorListadoVehiculos.getController();
        Scene escenaListadoVehiculos = new Scene(raizListadoVehiculos);
        listadoVehiculos.setTitle("Listar vehículos");
        listadoVehiculos.initModality(Modality.APPLICATION_MODAL);
        listadoVehiculos.setScene(escenaListadoVehiculos);
    }

    private void crearAnadirVehiculo() throws IOException {
        anadirVehiculo = new Stage();
        FXMLLoader cargadorAnadirVehiculo = new FXMLLoader(
                getClass().getResource("/mvc/vista/iugrafica/vistas/AnadirVehiculo.fxml"));
        VBox raizAnadirVehiculo = (VBox) cargadorAnadirVehiculo.load();
        cAnadirVehiculo = cargadorAnadirVehiculo.getController();
        Scene escenaAnadirVehiculo = new Scene(raizAnadirVehiculo);
        anadirVehiculo.setTitle("Añadir vehículo");
        anadirVehiculo.initModality(Modality.APPLICATION_MODAL);
        anadirVehiculo.setScene(escenaAnadirVehiculo);
    }

    private void crearMostrarVehiculo() throws IOException {
        mostrarVehiculo = new Stage();
        FXMLLoader cargadorMostrarVehiculo = new FXMLLoader(
                getClass().getResource("/mvc/vista/iugrafica/vistas/MostrarVehiculo.fxml"));
        VBox raizMostrarVehiculo = (VBox) cargadorMostrarVehiculo.load();
        cMostrarVehiculo = cargadorMostrarVehiculo.getController();
        Scene escenaMostrarVehiculo = new Scene(raizMostrarVehiculo);
        mostrarVehiculo.setTitle("Mostrar vehículo");
        mostrarVehiculo.initModality(Modality.APPLICATION_MODAL);
        mostrarVehiculo.setScene(escenaMostrarVehiculo);
    }
}
