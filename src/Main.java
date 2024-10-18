import exception.ErrorCodigoServicioException;
import model.Gastronomia;
import model.Hospedaje;
import model.Servicio;
import model.Sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        System.out.println("\n***** 1.1 - Creación de gastronomia *****\n");
        try {
            Gastronomia gastronomia = new Gastronomia("4892", "Hamburguesa criolla", 180.0, 4, 15.0, true);
            System.out.println(gastronomia);
        } catch (ErrorCodigoServicioException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n***** 1.2 - Creación de gastronomia *****\n");
        try {
            Gastronomia gastronomia2 = new Gastronomia("489235", "Hamburguesa criolla", 180, 4, 15, true);
            System.out.println(gastronomia2);
            System.out.println("***** 2.1 - Calcular Precio *****\n");
            LocalDate dia = LocalDate.of(2020, 10, 28);
            System.out.println(gastronomia2.calcularPrecioFinal(dia));
        } catch (ErrorCodigoServicioException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n***** 1.3 - Creación de hospedaje *****\n");
        try {
            Hospedaje hospedaje = new Hospedaje("2872", "Cabaña 3 personas", 1500, 10, true);
            System.out.println(hospedaje);
        } catch (ErrorCodigoServicioException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n***** 1.4 - Creación de hospedaje *****\n");
        try {
            Hospedaje hospedaje2 = new Hospedaje("287282", "Cabaña 3 personas", 1500, 10, true);
            System.out.println(hospedaje2);
            System.out.println("\n***** 2.2 - Calcular Precio *****\n");
            LocalDate dia = LocalDate.of(2020, 10, 27);
            System.out.println(hospedaje2.calcularPrecioFinal(dia));

        } catch (ErrorCodigoServicioException e) {
            System.out.println(e.getMessage());
        }
        //---------------------------------------------------------
        System.out.println("\n***** 3 - Agregar Servicios *****\n");
        List<Servicio> servicios = new ArrayList<>();
        Sistema sistema = new Sistema(servicios);
        //--------------------------------------------------------
        try {
            sistema.agregarGastronomia("858927", 15, true, "Milanesa con pure", 350, 3);
            System.out.println("Se agrego correctamente");
        } catch (ErrorCodigoServicioException e) {
            System.out.println(e.getMessage());
        }
        try {
            sistema.agregarHospedaje("489259", "Habitacion triple", 2200, 10, true);
            System.out.println("Se agrego correctamente");
        } catch (ErrorCodigoServicioException e) {
            System.out.println(e.getMessage());
        }
        try {
            sistema.agregarGastronomia("182835", 20, false, "Gaseosa", 120, 3);
            System.out.println("Se agrego correctamente");
        } catch (ErrorCodigoServicioException e) {
            System.out.println(e.getMessage());
        }
        try {
            sistema.agregarHospedaje("758972", "Habitacion simple", 1000, 15, false);
            System.out.println("Se agrego correctamente");
        } catch (ErrorCodigoServicioException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n***** 4.1 - Servicios true *****\n");
        try {
            System.out.println(sistema.traerServicio(true));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n***** 4.2 - Servicios por dia *****\n");
        try {
            LocalDate dia = LocalDate.of(2020, 10, 28);
            System.out.println(sistema.traerServicio(true, dia));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }


}
