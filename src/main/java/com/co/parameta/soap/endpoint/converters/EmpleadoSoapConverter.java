package com.co.parameta.soap.endpoint.converters;

import com.co.parameta.soap.modelo.Empleado;
import com.co.parameta.soap.ws.empleado.EmpleadoSoapDTO;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class EmpleadoSoapConverter {

    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public Empleado convertirDTOAEntidad(EmpleadoSoapDTO empleadoSoapDTO) throws ParseException {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoSoapDTO.getNombre());
        empleado.setApellidos(empleadoSoapDTO.getApellidos());
        empleado.setTipoDocumento(empleadoSoapDTO.getTipoDocumento());
        empleado.setNumeroDocumento(empleadoSoapDTO.getNumeroDocumento());
        empleado.setFecha(formatoFecha.parse(empleadoSoapDTO.getFecha()));
        empleado.setFechaVinculacionCompania(formatoFecha.parse(empleadoSoapDTO.getFechaVinculacionCompania()));
        empleado.setCargo(empleadoSoapDTO.getCargo());
        empleado.setSalario(empleadoSoapDTO.getSalary());
        return empleado;
    }

    public EmpleadoSoapDTO convertirEntidadADTO(Empleado empleado) {
        EmpleadoSoapDTO empleadoSoapDTO = new EmpleadoSoapDTO();
        empleadoSoapDTO.setId(empleado.getId());
        empleadoSoapDTO.setNombre(empleado.getNombre());
        empleadoSoapDTO.setApellidos(empleado.getApellidos());
        empleadoSoapDTO.setTipoDocumento(empleado.getTipoDocumento());
        empleadoSoapDTO.setNumeroDocumento(empleado.getNumeroDocumento());
        empleadoSoapDTO.setFecha(formatoFecha.format(empleado.getFecha()));
        empleadoSoapDTO.setFechaVinculacionCompania(formatoFecha.format(empleado.getFechaVinculacionCompania()));
        empleadoSoapDTO.setCargo(empleado.getCargo());
        empleadoSoapDTO.setSalary(empleado.getSalario());
        return empleadoSoapDTO;
    }
}
