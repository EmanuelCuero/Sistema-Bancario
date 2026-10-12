/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author emanu
 */
// cuenta corriente: permite sobregiro hasta un cupo maximo
public class CuentaCorriente extends Cuenta {
    // cupo maximo de sobregiro permitido
    private double cupoSobregiro;

    // constructor sobrecargado 1: recibe todos los datos incluido el cupo
    public CuentaCorriente(String numero, String nombreDueno, Fecha fechaApertura,
                           double saldoInicial, double cupoSobregiro) {
        super(numero, nombreDueno, fechaApertura, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
    }

    // constructor sobrecargado 2: crea la cuenta con saldo cero y cupo definido
    public CuentaCorriente(String numero, String nombreDueno, double cupoSobregiro) {
        super(numero, nombreDueno, new Fecha(1, 1, 2026), 0);
        this.cupoSobregiro = cupoSobregiro;
    }

    // getter del cupo
    public double getCupoSobregiro() { return cupoSobregiro; }

    // implementa el metodo retirar permitiendo sobregiro
    @Override
    public void retirar(double valor) throws ArithmeticException {
        // valida que el valor sea positivo
        if (valor <= 0) {
            throw new ArithmeticException("El valor a retirar debe ser mayor que cero.");
        }
        // estructura condicional anidada
        if (valor <= saldo) {
            // caso 1: hay saldo suficiente
            saldo -= valor;
        } else {
            // caso 2: no hay saldo suficiente, se evalua el sobregiro
            if (valor <= (saldo + cupoSobregiro)) {
                // permite que el saldo quede negativo
                saldo -= valor;
            } else {
                throw new ArithmeticException("El retiro excede el cupo de sobregiro disponible.");
            }
        }
    }

    // sobrescribe mostrarDatos agregando el cupo de sobregiro
    @Override
    public String mostrarDatos() {
        return String.format("[CORRIENTE] %s | Cupo sobregiro: %.2f",
                super.mostrarDatos(), cupoSobregiro);
    }
}