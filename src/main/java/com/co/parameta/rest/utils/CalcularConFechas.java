package com.co.parameta.rest.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class CalcularConFechas {

    public static String calcularTiempoVinculacion(String fechaVinculacion) throws Exception {

        String tiempoVinculacion = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date fechaConvertida = formatter.parse(fechaVinculacion);

            LocalDate fechaVinculacionLocalDate =  fechaConvertida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Period tiempoCalculado = Period.between(fechaVinculacionLocalDate, LocalDate.now());

            tiempoVinculacion = "años: " + tiempoCalculado.getYears() + " meses: " + tiempoCalculado.getMonths() + " dias: " + tiempoCalculado.getDays();

            return tiempoVinculacion;

        } catch (Exception ex) {
            throw new Exception("Error formateando la fecha");
        }
    }

    public static String calcularEdad(String fechaNacimiento) throws Exception {

        String tiempoEdad = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date fechaConvertida = formatter.parse(fechaNacimiento);

            LocalDate fechaNacimientoLocalDate =  fechaConvertida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Period tiempoCalculado = Period.between(fechaNacimientoLocalDate, LocalDate.now());

            tiempoEdad = "años: " + tiempoCalculado.getYears() + " meses: " + tiempoCalculado.getMonths() + " dias: " + tiempoCalculado.getDays();

            return tiempoEdad;

        } catch (Exception ex) {
            throw new Exception("Error formateando la fecha");
        }
    }
}
