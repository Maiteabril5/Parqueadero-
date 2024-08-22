import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class parqueadero extends JFrame {
    private GestionParqueadero gestionParqueadero;
    private JComboBox<String> placaField;
    private JComboBox<String> marcaField;
    private JComboBox<String> tipoVehiculoBox;
    private JTextArea logArea;

    public parqueadero() {
        gestionParqueadero = new GestionParqueadero();

        setTitle("Sistema de Gestión de Parqueadero");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel placaLabel = new JLabel("Placa:");
        String[] placas = {"ABC123", "DEF456", "GHI789", "JKL012", "MNO345"};
        placaField = new JComboBox<>(placas);
        placaField.setEditable(true);

        JLabel marcaLabel = new JLabel("Marca:");
        String[] marcas = {"Toyota", "Honda", "Chevrolet", "Nissan", "Ford"};
        marcaField = new JComboBox<>(marcas);

        JLabel tipoVehiculoLabel = new JLabel("Tipo de Vehículo:");
        String[] tiposVehiculo = {"Automóvil", "Motocicleta", "Camión"};
        tipoVehiculoBox = new JComboBox<>(tiposVehiculo);

        JButton registrarEntradaButton = new JButton("Registrar Entrada");
        JButton registrarSalidaButton = new JButton("Registrar Salida");

        logArea = new JTextArea(15, 40);
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        registrarEntradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = (String) placaField.getSelectedItem();
                String marca = (String) marcaField.getSelectedItem();
                String tipoVehiculo = (String) tipoVehiculoBox.getSelectedItem();
                Vehiculo vehiculo = null;

                if (tipoVehiculo.equals("Automóvil")) {
                    vehiculo = new Automovil(placa, marca, "Modelo");
                } else if (tipoVehiculo.equals("Motocicleta")) {
                    vehiculo = new Motocicleta(placa, marca, "Modelo");
                } else if (tipoVehiculo.equals("Camión")) {
                    vehiculo = new Camion(placa, marca, "Modelo");
                }

                if (vehiculo != null) {
                    gestionParqueadero.registrarEntrada(vehiculo);
                    logArea.append("Entrada registrada: " + vehiculo.getPlaca() + " (" + tipoVehiculo + ", " + marca + ")\n");
                }
            }
        });

        registrarSalidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = (String) placaField.getSelectedItem();
                double tarifa = gestionParqueadero.registrarSalida(placa);
                if (tarifa > 0) {
                    logArea.append("Salida registrada: " + placa + ". Tarifa: $" + tarifa + " COP\n");
                } else {
                    logArea.append("Vehículo con placa " + placa + " no encontrado.\n");
                }
            }
        });

        add(placaLabel);
        add(placaField);
        add(marcaLabel);
        add(marcaField);
        add(tipoVehiculoLabel);
        add(tipoVehiculoBox);
        add(registrarEntradaButton);
        add(registrarSalidaButton);
        add(scrollPane);
    }

    public static void main(String[] args) {
        parqueadero frame = new parqueadero();
        frame.setVisible(true);
    }
}


    

