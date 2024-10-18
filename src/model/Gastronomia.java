package model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * La clase Gastronomia representa un servicio gastronómico que puede tener un descuento
 * aplicable en un día específico de la semana.
 */
public class Gastronomia extends Servicio {

    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, String gastronomia, double precio, int diaSemDesc, double porcentajeDescuento, boolean enPromocion) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.diaSemDesc = validacionDiaDeLaSemana(diaSemDesc);
        this.gastronomia = gastronomia;
        this.precio = precio;

    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }
    /**
     * Valida que el día de la semana esté en el rango permitido (1-7).
     * @param diaSemDesc el día de la semana a validar.
     * @return el día de la semana validado.
     * @throws IllegalArgumentException si el día de la semana no está en el rango permitido.
     */
    private int validacionDiaDeLaSemana(int diaSemDesc) {
        if (diaSemDesc < 1 || diaSemDesc > 7) {
            throw new IllegalArgumentException("El dia de la semana debe ser un valor entre 1 y 7.");
        }
        return diaSemDesc;
    }
    /**
     * Calcula el precio final del servicio aplicando un descuento si corresponde
     * en el día específico.
     * @param dia la fecha para la que se desea calcular el precio final.
     * @return el precio final después de aplicar el descuento si corresponde.
     */
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        DayOfWeek diaSemana = dia.getDayOfWeek();
        double precioFinal = this.precio;
        if (this.enPromocion && diaSemana.getValue() == this.diaSemDesc) {
            precioFinal -= (precioFinal * this.porcentajeDescuento) / 100;
        }
        return precioFinal;
    }
    /**
     * Devuelve una representación en forma de cadena de texto del objeto Gastronomia.
     * @return una cadena que representa el objeto Gastronomia".
     */
    @Override
    public String toString() {
        return String.format("Gastronomia: gastronomia='%s', precio=%.2f, diaSemDesc=%s, %s",
                gastronomia, precio, diaSemDesc, super.toString());
    }
}
