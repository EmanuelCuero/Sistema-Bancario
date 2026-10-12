/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author emanu
 */
// clase auxiliar para manejar fechas sin librerias externas
public class Fecha {
    // atributos basicos de la fecha
    private int dia;
    private int mes;
    private int anio;

    // constructor de la clase fecha con validaciones basicas
    public Fecha(int dia, int mes, int anio) {
        // valida que el mes este entre 1 y 12
        if (mes < 1 || mes > 12) {
            throw new ArithmeticException("El mes debe estar entre 1 y 12.");
        }
        // valida que el dia este en el rango correcto segun el mes
        if (dia < 1 || dia > 31) {
            throw new ArithmeticException("El dia debe estar entre 1 y 31.");
        }
        // valida que el año sea positivo
        if (anio < 1900 || anio > 2100) {
            throw new ArithmeticException("El anio debe estar entre 1900 y 2100.");
        }
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // getters
    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAnio() { return anio; }

    // sobrescribe toString para mostrar la fecha en formato dd/mm/aaaa
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}