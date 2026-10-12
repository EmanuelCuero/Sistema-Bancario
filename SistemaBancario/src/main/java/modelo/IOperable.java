/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author emanu
 */
// interfaz que define las operaciones bancarias basicas
public interface IOperable {
    void consignar(double valor);
    void retirar(double valor) throws ArithmeticException;
    double consultarSaldo();
    String mostrarDatos();
    String mostrarDatos(boolean soloSaldo);
}