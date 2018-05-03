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
    private Stage listadoClientes, anadirCliente, mostrarCliente, listadoVehiculos,
            anadirVehiculo, mostrarVehiculo, listadoAlquileres, anadirAlquiler, mostrarAlquiler;

    @FXML
    private Button btListarClientes, btAnadirCliente, btBuscarCliente, btListarVehiculos, btAnadirVehiculo,
            btBuscarVehiculo, btListarAlquileres, btAnadirAlquiler, btBuscarAlquiler;

    @FXML
    private void listarClientes() {
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
        listadoVehiculos.showAndWait();
    }

    @FXML
    private void anadirVehiculo() {
        anadirVehiculo.showAndWait();
    }

    @FXML
    private void buscarVehiculo() {
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
}
