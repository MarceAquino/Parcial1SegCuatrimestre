package model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * La clase Hospedaje representa un tipo de servicio de hospedaje.
 * Extiende de la clase Servicio y contiene información sobre el
 * nombre del hospedaje, el precio por noche, y cómo calcular
 * el precio final basado en promociones y el día de la semana.
 */
public class Hospedaje extends Servicio {

    private String hospedaje;
    private double precioPorNoche;


    public Hospedaje(String codServicio, String hospedaje, double precioPorNoche, double porcentajeDescuento, boolean enPromocion
    ) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }
    /**
     * Calcula el precio final del hospedaje para un día específico.
     * Si el hospedaje está en promoción y el día no es sábado ni domingo,
     * se aplica el descuento al precio por noche.
     * @param dia el día para el cual se está calculando el precio final.
     * @return el precio final del hospedaje, con el descuento aplicado si corresponde.
     */
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        DayOfWeek diaSemana = dia.getDayOfWeek();
        double precioFinal = this.precioPorNoche;
        if (this.enPromocion && diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY) {
            precioFinal -= (precioFinal * this.porcentajeDescuento) / 100;
        }
        return precioFinal;
    }
    /**
     * Devuelve una representación en forma de cadena de texto del objeto hospedaje.
     * @return una cadena que representa el objeto Gastronomia".
     */
    @Override
    public String toString() {
        return "Hospedaje{" +
                "hospedaje='" + hospedaje + '\'' +
                ", precioPorNoche=" + precioPorNoche +
                ", codServicio='" + codServicio + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                ", enPromocion=" + enPromocion +
                '}';
    }
}
