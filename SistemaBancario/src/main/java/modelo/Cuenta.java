/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author emanu
 */
// clase abstracta que define el contrato de cualquier tipo de cuenta
public abstract class Cuenta implements IOperable {
    // atributos compartidos por todas las cuentas
    protected String numero;
    protected String nombreDueno;
    protected Fecha fechaApertura;
    protected double saldo;

    // constructor de la clase base
    public Cuenta(String numero, String nombreDueno, Fecha fechaApertura, double saldoInicial) {
        this.numero = numero;
        this.nombreDueno = nombreDueno;
        this.fechaApertura = fechaApertura;
        this.saldo = saldoInicial;
    }

    // getters
    public String getNumero() { return numero; }
    public String getNombreDueno() { return nombreDueno; }
    public Fecha getFechaApertura() { return fechaApertura; }

    // metodo concreto para consignar (aplica para todas las cuentas)
    @Override
    public void consignar(double valor) {
        // valida que el valor sea positivo
        if (valor <= 0) {
            throw new ArithmeticException("El valor a consignar debe ser mayor que cero.");
        }
        this.saldo += valor;
    }

    // metodo abstracto que cada subclase implementa segun su regla
    @Override
    public abstract void retirar(double valor) throws ArithmeticException;

    // metodo concreto que devuelve el saldo actual
    @Override
    public double consultarSaldo() {
        return saldo;
    }

    // metodo concreto que muestra todos los datos de la cuenta
    @Override
    public String mostrarDatos() {
        return String.format("Cuenta: %s | Dueno: %s | Apertura: %s | Saldo: %.2f",
                numero, nombreDueno, fechaApertura.toString(), saldo);
    }

    // metodo sobrecargado que muestra solo el saldo si el parametro es true
    @Override
    public String mostrarDatos(boolean soloSaldo) {
        // estructura condicional anidada
        if (soloSaldo) {
            return String.format("Cuenta: %s | Saldo actual: %.2f", numero, saldo);
        } else {
            // si no, delega al metodo sin parametros
            return mostrarDatos();
        }
    }
}