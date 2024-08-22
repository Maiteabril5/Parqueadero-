import java.util.ArrayList;
import java.util.List;

public class GestionParqueadero {
    private List<Vehiculo> vehiculos;

    public GestionParqueadero() {
        this.vehiculos = new ArrayList<>();
    }

    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public double registrarSalida(String placa) {
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo != null) {
            vehiculos.remove(vehiculo);
            return vehiculo.calcularTarifa();
        } else {
            return 0;
        }
    }

    private Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public List<Vehiculo> consultarEstado() {
        return new ArrayList<>(vehiculos); // Retorna una copia de la lista de vehículos
    }
}
