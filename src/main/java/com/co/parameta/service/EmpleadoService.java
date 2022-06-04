package com.co.parameta.service;

import com.co.parameta.controller.dto.EmpleadoDTO;
import com.co.parameta.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public String validacionesInformacionEmpleado(EmpleadoDTO empleadoDTO) throws Exception {

        String validacionesEmpleado = "";

        validacionesEmpleado = validacionesCampos(empleadoDTO);

        if(validacionesEmpleado.equals("")) {
            // invocar soap
        } else {
            throw new Exception(validacionesEmpleado);
        }

        return "";
    }

    public String validacionFormatoCorrectoFecha(String fecha, String tipoFecha) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String validaciones = "";

        try {
            formatter.parse(fecha);
        }catch (Exception ex) {
            validaciones = "La fecha " + tipoFecha + " no tiene el formato dd/MM/yyyy \n";
        }
        return validaciones;
    }

    public String validacionesCampos(EmpleadoDTO empleadoDTO) throws Exception {

        String validaciones = "";

        if(empleadoDTO.getNombre() == null || empleadoDTO.getNombre().equals("")) {
            validaciones = validaciones + "El nombre es obligatorio \n";
        }

        if(empleadoDTO.getApellidos() == null || empleadoDTO.getApellidos().equals("")) {
            validaciones = validaciones + "El apellido es obligatorio \n";
        }

        if(empleadoDTO.getTipoDocumento() == null || empleadoDTO.getTipoDocumento().equals("")) {
            validaciones = validaciones + "El tipo documento es obligatorio \n";
        }

        if(empleadoDTO.getNumeroDocumento() == null ||empleadoDTO.getNumeroDocumento().equals("")) {
            validaciones = validaciones + "El numero de documento es obligatorio \n";
        }

        if(empleadoDTO.getFecha() == null || empleadoDTO.getFecha().equals("")) {
            validaciones = validaciones + "El fecha nacimiento es obligatorio \n";
        }

        if(empleadoDTO.getFecha() != null) {
            validaciones = validaciones + validacionFormatoCorrectoFecha(empleadoDTO.getFecha(), "nacimiento");
            validaciones = validaciones + validarMayorEdad(empleadoDTO.getFecha());
        }

        if(empleadoDTO.getFechaVinculacionCompania() == null || empleadoDTO.getFechaVinculacionCompania().equals("")) {
            validaciones = validaciones + "El fecha vinculacion es obligatorio \n";
        }

        if(empleadoDTO.getFechaVinculacionCompania() != null) {
            validaciones = validaciones + validacionFormatoCorrectoFecha(empleadoDTO.getFechaVinculacionCompania(), "vinculacion");
        }

        if(empleadoDTO.getCargo() == null || empleadoDTO.getCargo().equals("")) {
            validaciones = validaciones + "El cargo es obligatorio \n";
        }

        if(empleadoDTO.getSalario() == null || empleadoDTO.getSalario().equals("")) {
            validaciones = validaciones + "El salario es obligatorio \n";
        }

        return validaciones;
    }

    public String validarMayorEdad(String fechaNacimiento) throws Exception {

        String validacion = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date fechaConvertida = formatter.parse(fechaNacimiento);

            LocalDate fechaNacimientoLocalDate =  fechaConvertida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Period edad = Period.between(fechaNacimientoLocalDate, LocalDate.now());

            if(edad.getYears() < 18) {
                validacion = "El empleado no es mayor de edad";
            }
            return validacion;
        } catch (Exception ex) {
            throw new Exception("Error formateando la fecha");
        }
    }
}
