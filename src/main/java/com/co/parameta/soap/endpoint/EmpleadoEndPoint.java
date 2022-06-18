package com.co.parameta.soap.endpoint;

import com.co.parameta.soap.endpoint.converters.EmpleadoSoapConverter;
import com.co.parameta.soap.modelo.Empleado;
import com.co.parameta.soap.repository.EmpleadoRepository;
import com.co.parameta.soap.ws.empleado.CreateEmpleadoRequest;
import com.co.parameta.soap.ws.empleado.CreateEmpleadoResponse;
import com.co.parameta.soap.ws.empleado.EmpleadoResponse;
import com.co.parameta.soap.ws.empleado.EmpleadoSoapDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.text.ParseException;

@Endpoint
public class EmpleadoEndPoint {

    private static final String NAMESPACE_URI = "http://parameta.co.com/soap/ws/empleado";

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoSoapConverter empleadoConverter;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEmpleadoRequest")
    @ResponsePayload
    public CreateEmpleadoResponse createEmpleadosRequest(@RequestPayload CreateEmpleadoRequest request) throws ParseException {
        CreateEmpleadoResponse response = new CreateEmpleadoResponse();
        EmpleadoResponse empleadoResponse = new EmpleadoResponse();

        try {
            Empleado empleado = empleadoConverter.convertirDTOAEntidad(request.getEmpleadoSoapDTO());

            empleado = empleadoRepository.save(empleado);

            EmpleadoSoapDTO empleadoSoapDTO = empleadoConverter.convertirEntidadADTO(empleado);
            empleadoResponse.setEmpleadoSoapDTO(empleadoSoapDTO);
            response.setData(empleadoResponse);
            response.setStatus("OK");

            return response;

        } catch (ParseException e) {
            response.setStatus("FAIL");

            return response;
        }
    }
}
