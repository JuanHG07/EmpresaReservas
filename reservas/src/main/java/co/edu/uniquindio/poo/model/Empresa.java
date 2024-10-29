package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private LinkedList<Cliente> clientes;
    private LinkedList<Reserva> reservas;
    private LinkedList<Vehiculo> vehiculos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
        reservas = new LinkedList<>();
        vehiculos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void agregarCliente(Cliente cliente) {
        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
        }
    }

    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public Cliente buscarCliente(String cedula) {
        Cliente clienteBuscado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clienteBuscado = cliente;
            }
        }
        return clienteBuscado;
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void agregarReserva(Reserva reserva) {
        if (!verificarReserva(reserva.getCodigo())) {
            reservas.add(reserva);
            reserva.getCliente().getReservas().add(reserva);
        }
    }

    public boolean verificarReserva(String codigo) {
        boolean centinela = false;
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigo)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (!verificarVehiculo(vehiculo.getMatricula())) {
            vehiculos.add(vehiculo);
        }
    }

    public boolean verificarVehiculo(String matricula) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public Vehiculo buscarVehiculo(String matricula) {
        Vehiculo vehiculoBuscado = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                vehiculoBuscado = vehiculo;
            }
        }
        return vehiculoBuscado;
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + ", clientes=" + clientes + ", reservas=" + reservas + ", vehiculos="
                + vehiculos + "]";
    }
}
