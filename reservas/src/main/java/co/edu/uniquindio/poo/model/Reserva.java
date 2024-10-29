package co.edu.uniquindio.poo.model;

public class Reserva {
    private String codigo;
    private int dias;
    private double costo;
    private Cliente cliente;
    private Vehiculo vehiculo;

    public Reserva(String codigo, int dias, Cliente cliente, Vehiculo vehiculo) {
        this.codigo = codigo;
        this.dias = dias;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void calcularCostoReserva() {
        this.costo = vehiculo.calcularCostoVehiculo();
    }

    @Override
    public String toString() {
        return "Reserva [codigo=" + codigo + ", dias=" + dias + ", cliente=" + cliente + ", vehiculo=" + vehiculo + "]";
    }
}
