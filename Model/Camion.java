public class Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularTarifa() {
        // Implementación específica para Camión
        return 20000; // Tarifa base para camión en COP
    }
}
