package model;

import exception.ErrorCodigoServicioException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * La clase abstracta Servicio representa un servicio genérico que puede
 * tener un código, un porcentaje de descuento y una indicación de si
 * está en promoción. Esta clase sirve como base para otros tipos de servicios,
 * como Gastronomía y Hospedaje.
 */
public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    private static final Set<String> codigoServicios = new HashSet<>();

    protected Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) {
        validarCodigoVehiculo(codServicio);
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    /**
     * Valida el código del servicio.
     * @param codVehiculo el código del servicio a validar.
     * @throws ErrorCodigoServicioException si el código es nulo, no tiene 6 caracteres o ya está registrado.
     */
    private void validarCodigoVehiculo(String codVehiculo) throws ErrorCodigoServicioException {
        if (codVehiculo == null || codVehiculo.length() != 6) {
            throw new ErrorCodigoServicioException("El código del vehículo debe tener 7 caracteres.");
        }
        if (!codigoServicios.add(codVehiculo)) {
            throw new ErrorCodigoServicioException("El código ya se encuentra registrado.");
        }
    }
    /**
     * Método abstracto para calcular el precio final del servicio.
     * @param dia el día para el cual se está calculando el precio final.
     * @return el precio final del servicio.
     */
    protected abstract double calcularPrecioFinal(LocalDate dia);

    /**
     * Devuelve una representación en cadena del servicio.
     * @return una cadena que representa los detalles del servicio.
     */
    @Override
    public String toString() {
        return "Servicio{" +
                "codServicio='" + codServicio + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                ", enPromocion=" + enPromocion +
                '}';
    }
}
