package co.edu.uniquindio.poo.controller;

import java.util.Collection;
import java.util.LinkedList;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

public class EmpresaController {

    Empresa empresa;

    public EmpresaController(Empresa empresa) {
        this.empresa = empresa;
    }

    public void agregarCliente(Cliente cliente) {
        empresa.agregarCliente(cliente);
    }

    public boolean verificarCliente(String cedula) {
        return empresa.verificarCliente(cedula);
    }

    public Cliente buscarCliente(String cedula) {
        return empresa.buscarCliente(cedula);
    }

    public LinkedList<Cliente> obtenerListaClientes() {
        return empresa.getClientes();
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        empresa.agregarVehiculo(vehiculo);
    }

    public boolean verificarVehiculo(String matricula) {
        return empresa.verificarVehiculo(matricula);
    }

    public Vehiculo buscarVehiculo(String matricula) {
        return empresa.buscarVehiculo(matricula);
    }

    public LinkedList<Vehiculo> obtenerListaVehiculos() {
        return empresa.getVehiculos();
    }

    public void agregarReserva(Reserva reserva) {
        empresa.agregarReserva(reserva);
    }

    public boolean verificarReserva(String codigo) {
        return empresa.verificarReserva(codigo);
    }

    public LinkedList<Reserva> obtenerListaReservas() {
        return empresa.getReservas();
    }
}
