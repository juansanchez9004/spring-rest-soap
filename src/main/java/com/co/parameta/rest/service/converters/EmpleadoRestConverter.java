package com.co.parameta.rest.service.converters;

import com.co.parameta.rest.controller.dto.EmpleadoDTO;
import com.co.parameta.soap.ws.empleado.EmpleadoSoapDTO;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class EmpleadoRestConverter {

    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public EmpleadoSoapDTO convertirDTOASoapDTO(EmpleadoDTO empleadoDTO) throws ParseException {
        EmpleadoSoapDTO empleadoSoapDTO = new EmpleadoSoapDTO();
        empleadoSoapDTO.setNombre(empleadoDTO.getNombre());
        empleadoSoapDTO.setApellidos(empleadoDTO.getApellidos());
        empleadoSoapDTO.setTipoDocumento(empleadoDTO.getTipoDocumento());
        empleadoSoapDTO.setNumeroDocumento(empleadoDTO.getNumeroDocumento());
        empleadoSoapDTO.setFecha(empleadoDTO.getFecha());
        empleadoSoapDTO.setFechaVinculacionCompania(empleadoDTO.getFechaVinculacionCompania());
        empleadoSoapDTO.setCargo(empleadoDTO.getCargo());
        empleadoSoapDTO.setSalary(empleadoDTO.getSalario());
        return empleadoSoapDTO;
    }

    public EmpleadoDTO convertirSoapDTOADTO(EmpleadoSoapDTO empleadoSoapDTO) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setId(empleadoSoapDTO.getId());
        empleadoDTO.setNombre(empleadoSoapDTO.getNombre());
        empleadoDTO.setApellidos(empleadoSoapDTO.getApellidos());
        empleadoDTO.setTipoDocumento(empleadoSoapDTO.getTipoDocumento());
        empleadoDTO.setNumeroDocumento(empleadoSoapDTO.getNumeroDocumento());
        empleadoDTO.setFecha(empleadoSoapDTO.getFecha());
        empleadoDTO.setFechaVinculacionCompania(empleadoSoapDTO.getFechaVinculacionCompania());
        empleadoDTO.setCargo(empleadoSoapDTO.getCargo());
        empleadoDTO.setSalario(empleadoSoapDTO.getSalary());
        return empleadoDTO;
    }
}
