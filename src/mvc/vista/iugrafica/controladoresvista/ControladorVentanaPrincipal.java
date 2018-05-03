package mvc.vista.iugrafica.controladoresvista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class ControladorVentanaPrincipal {

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
        anadirCliente.showAndWait();
    }

    @FXML
    private void buscarCliente() {
  
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
}