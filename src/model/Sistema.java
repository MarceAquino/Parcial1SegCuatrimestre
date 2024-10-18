package model;

import exception.ErrorCodigoServicioException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * La clase Sistema gestiona una lista de servicios de hospedaje y gastronomía.
 * Proporciona métodos para agregar servicios, buscar servicios por código y filtrar
 * servicios en promoción o según el día de la semana.
 */
public class Sistema {
    List<Servicio> lstServicio;

    public Sistema(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    /**
     * Trae un servicio basado en el código proporcionado.
     * @param codServicio El código del servicio a buscar.
     * @return El servicio correspondiente al código.
     * @throws ErrorCodigoServicioException si el código ingresado no pertenece a un servicio.
     */
    public Servicio traerServicio(String codServicio) throws ErrorCodigoServicioException {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicio;
            }
        }
        throw new ErrorCodigoServicioException("El codigo ingresado no pertene a un servicio");
    }
    /**
     * Trae una lista de servicios que están en promoción.
     * @param enPromocion Valor booleano que indica si se buscan servicios en promoción.
     * @return Lista de servicios que cumplen con el criterio de promoción.
     * @throws IllegalArgumentException si no se encuentran servicios que cumplan con el criterio.
     */
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> servicioEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                servicioEnPromocion.add(servicio);
            }
        }
        if (servicioEnPromocion.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron servicios que cumplan con el criterio de promoción.");
        }
        return servicioEnPromocion;

    }
    /**
     * Trae una lista de servicios que están en promoción y que son válidos para una fecha .
     * @param enPromocion Valor booleano que indica si se buscan servicios en promoción.
     * @param dia La fecha para filtrar los servicios según el día de la semana.
     * @return Lista de servicios que cumplen con el criterio de promoción y fecha.
     * @throws IllegalArgumentException si no se encuentran servicios que cumplan con la fecha.
     */
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> serviciosPorFecha = new ArrayList<>();
        int diaSemana = dia.getDayOfWeek().getValue();
        for (Servicio servicio : lstServicio) {
            boolean servicioEnPromocion = servicio.isEnPromocion() == enPromocion;
            if (servicio instanceof Gastronomia gastronomia) {
                if (gastronomia.getDiaSemDesc() == diaSemana && servicioEnPromocion) {
                    serviciosPorFecha.add(gastronomia);
                }
            }
        }
        if (serviciosPorFecha.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron servicios que cumplan con la fecha.");
        }
        return serviciosPorFecha;
    }
    /**
     * Agrega un nuevo servicio de gastronomia al sistema.
     * @return true si el servicio se agregó correctamente.
     */
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion,
                                      String gastronomia, double precio, int diaSemDesc) {
        Gastronomia nuevaGastronomia = new Gastronomia(codServicio, gastronomia, precio, diaSemDesc, porcentajeDescuento, enPromocion);
        lstServicio.add(nuevaGastronomia);
        return true;

    }
    /**
     * Agrega un nuevo servicio de hospedaje al sistema.
     * @return true si el servicio se agregó correctamente.
     */
    public boolean agregarHospedaje(String codServicio, String hospedaje, double precioPorNoche, double porcentajeDescuento, boolean enPromocion
    ) {
        Hospedaje nuevoHospedaje = new Hospedaje(codServicio, hospedaje, precioPorNoche, porcentajeDescuento, enPromocion);
        lstServicio.add(nuevoHospedaje);
        return true;
    }
}
