package mvc.vista.iugrafica.controladoresvista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.vista.iugrafica.IUGrafica;

public class ControladorListadoVehiculos {

    @FXML
    private ListView<String> lvVehiculos;

    @FXML
    private Label lbTitulo;

    @FXML
    private void initialize() {
        actualizaVehiculos();
    }

    public void actualizaVehiculos() {
        ObservableList<String> vehiculos = FXCollections.observableArrayList();
        for (Vehiculo vehiculo : IUGrafica.controladorMVC.obtenerVehiculos()) {
            String vehiculoStr = String.format(
                    "Matrícula: %s, Marca: %s, Modelo: %s%n\tDatos Tecnicos: %s",
                    vehiculo.getMatricula(), vehiculo.getMarca(), vehiculo.getModelo(),
                    vehiculo.getDatosTecnicos().getCilindrada(), vehiculo.getDatosTecnicos().getNumeroPlazas(), vehiculo.getDatosTecnicos().getPma());
            vehiculos.add(vehiculoStr);
        }
        lvVehiculos.setItems(vehiculos);
    }
}
