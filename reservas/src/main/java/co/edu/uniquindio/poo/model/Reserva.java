package co.edu.uniquindio.poo.model;

public class Reserva {
    private String codigo;
    private int dias;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double costo;

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

    public String getCedula() {
        return cliente != null ? cliente.getCedula() : null;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public String getMatricula() {
        return vehiculo != null ? vehiculo.getMatricula() : null;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getCosto() {
        return costo;
    }

    public void calcularCosto() {
        this.costo = vehiculo.calcularCostoVehiculo(this);
    }

    @Override
    public String toString() {
        return "Reserva [codigo=" + codigo + ", dias=" + dias + ", cliente=" + cliente + ", vehiculo=" + vehiculo + "]";
    }
}
