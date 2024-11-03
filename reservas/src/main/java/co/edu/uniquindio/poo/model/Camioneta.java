package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo {
    private double capacidadCarga;
    private static final double porcentajeExtra = 0.1;

    public Camioneta(String matricula, String marca, String modelo, int anioFabricacion, double tarifaBase, double capacidadCarga) {
        super(matricula, marca, modelo, anioFabricacion, tarifaBase);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCostoVehiculo(Reserva reserva) {
        int diasReserva = reserva.getDias();
        double tarifaBase = super.getTarifaBase();
        double costo = diasReserva * tarifaBase;
        costo += costo * capacidadCarga * porcentajeExtra;
        return costo;
    }

    @Override
    public String toString() {
        return super.toString() + "Camioneta [capacidadCarga=" + capacidadCarga + "]";
    }
}
