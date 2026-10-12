/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author emanu
 */
import java.util.ArrayList;
import java.util.List;
import modelo.Cuenta;
import modelo.CuentaAhorros;
import modelo.CuentaCorriente;
import modelo.Fecha;

// controlador que conecta la vista con el modelo
public class ControladorBanco {
    // lista de cuentas del banco (polimorfismo: guarda la clase base)
    private List<Cuenta> cuentas;

    public ControladorBanco() {
        this.cuentas = new ArrayList<>();
    }

    // crea una cuenta de ahorros
    public boolean crearCuentaAhorros(String numero, String dueno, int dia, int mes, int anio,
                                      double saldoInicial) {
        // valida que el numero no exista ya
        if (buscarCuenta(numero) != null) {
            return false;
        }
        // instancia la fecha (lanza ArithmeticException si es invalida)
        Fecha fecha = new Fecha(dia, mes, anio);
        // crea el objeto del modelo
        Cuenta cuenta = new CuentaAhorros(numero, dueno, fecha, saldoInicial);
        cuentas.add(cuenta);
        return true;
    }

    // crea una cuenta corriente con cupo de sobregiro
    public boolean crearCuentaCorriente(String numero, String dueno, int dia, int mes, int anio,
                                        double saldoInicial, double cupoSobregiro) {
        // valida que el numero no exista ya
        if (buscarCuenta(numero) != null) {
            return false;
        }
        // valida que el cupo sea positivo
        if (cupoSobregiro < 0) {
            return false;
        }
        // instancia la fecha
        Fecha fecha = new Fecha(dia, mes, anio);
        // crea el objeto del modelo
        Cuenta cuenta = new CuentaCorriente(numero, dueno, fecha, saldoInicial, cupoSobregiro);
        cuentas.add(cuenta);
        return true;
    }

    // busca una cuenta por su numero
    public Cuenta buscarCuenta(String numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumero().equalsIgnoreCase(numero)) {
                return c;
            }
        }
        return null;
    }

    // invoca el metodo consignar de la cuenta
    public boolean consignar(String numero, double valor) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta == null) {
            return false;
        }
        // invoca el metodo de negocio del modelo
        cuenta.consignar(valor);
        return true;
    }

    // invoca el metodo retirar de la cuenta
    public boolean retirar(String numero, double valor) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta == null) {
            return false;
        }
        // invoca el metodo de negocio del modelo
        cuenta.retirar(valor);
        return true;
    }

    // consulta el saldo de una cuenta
    public double consultarSaldo(String numero) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta == null) {
            throw new ArithmeticException("La cuenta no existe.");
        }
        return cuenta.consultarSaldo();
    }

    // obtiene los datos completos de una cuenta
    public String obtenerDatosCuenta(String numero) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta == null) {
            return "La cuenta no existe.";
        }
        // polimorfismo: cada subclase responde a su manera
        return cuenta.mostrarDatos();
    }

    // obtiene los datos en modo "solo saldo"
    public String obtenerDatosCuenta(String numero, boolean soloSaldo) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta == null) {
            return "La cuenta no existe.";
        }
        // invoca el metodo sobrecargado del modelo
        return cuenta.mostrarDatos(soloSaldo);
    }
}

//