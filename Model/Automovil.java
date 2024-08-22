public class Automovil extends Vehiculo {
    private String tipoCombustible;

    public Automovil(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public double calcularTarifa() {
        // Implementación específica para Automóvil
        return 10000; // Tarifa base para automóvil en COP
    }
}
