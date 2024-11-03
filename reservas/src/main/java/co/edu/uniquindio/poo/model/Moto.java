package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {
    private TipoCaja tipoCaja;
    private static final double tarifaExtra = 5000;

    public Moto(String matricula, String marca, String modelo, int anioFabricacion, double tarifaBase, TipoCaja tipoCaja) {
        super(matricula, marca, modelo, anioFabricacion, tarifaBase);
        this.tipoCaja = tipoCaja;
    }

    public TipoCaja getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(TipoCaja tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    @Override
    public double calcularCostoVehiculo(Reserva reserva) {
        int diasReserva = reserva.getDias();
        double tarifaBase = super.getTarifaBase();
        double costo = tarifaBase * diasReserva;
        if (tipoCaja.equals(TipoCaja.AUTOMATICA)) {
            costo += tarifaExtra;
        }
        return costo;
    }

    @Override
    public String toString() {
        return super.toString() + "Moto [tipoCaja=" + tipoCaja + "]";
    }
}
