package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {
    private int numPuertas;

    public Auto(String matricula, String marca, String modelo, int anioFabricacion, double tarifaBase, Reserva reserva,
            int numPuertas) {
        super(matricula, marca, modelo, anioFabricacion, tarifaBase);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public double calcularCostoVehiculo() {
        int diasReserva = super.getReserva().getDias();
        double tarifaBase = super.getTarifaBase();
        double costo = tarifaBase * diasReserva;
        return costo;
    }

    @Override
    public String toString() {
        return super.toString() + "Auto [numPuertas=" + numPuertas + "]";
    }
}
