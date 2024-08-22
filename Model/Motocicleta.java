public class Motocicleta extends Vehiculo {
    private int cilindraje;

    public Motocicleta(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularTarifa() {
        // Implementación específica para Motocicleta
        return 5000; // Tarifa base para motocicleta en COP
    }
}
