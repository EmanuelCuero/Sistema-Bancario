/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author emanu
 */
// cuenta de ahorros: solo permite retirar si hay saldo suficiente
public class CuentaAhorros extends Cuenta {

    // constructor sobrecargado 1: recibe todos los datos
    public CuentaAhorros(String numero, String nombreDueno, Fecha fechaApertura, double saldoInicial) {
        super(numero, nombreDueno, fechaApertura, saldoInicial);
    }

    // constructor sobrecargado 2: crea la cuenta con saldo cero y la fecha de hoy del sistema
    public CuentaAhorros(String numero, String nombreDueno) {
        super(numero, nombreDueno, new Fecha(1, 1, 2026), 0);
    }

    // implementa el metodo retirar solo si valor <= saldo
    @Override
    public void retirar(double valor) throws ArithmeticException {
        // valida que el valor sea positivo
        if (valor <= 0) {
            throw new ArithmeticException("El valor a retirar debe ser mayor que cero.");
        }
        // estructura condicional anidada
        if (valor <= saldo) {
            if (valor > 0) {
                saldo -= valor;
            } else {
                throw new ArithmeticException("El valor a retirar debe ser positivo.");
            }
        } else {
            throw new ArithmeticException("Fondos insuficientes en la cuenta de ahorros.");
        }
    }

    // sobrescribe mostrarDatos agregando el tipo de cuenta
    @Override
    public String mostrarDatos() {
        return String.format("[AHORROS] %s", super.mostrarDatos());
    }
}