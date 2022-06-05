package com.co.parameta.rest.service;

import com.co.parameta.rest.controller.dto.EmpleadoDTO;
import com.co.parameta.rest.service.converters.EmpleadoRestConverter;
import com.co.parameta.soap.ws.empleado.CreateEmpleadoRequest;
import com.co.parameta.soap.ws.empleado.CreateEmpleadoResponse;
import com.co.parameta.soap.ws.empleado.EmpleadoSoapDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.text.ParseException;

@Service
public class SoapClient extends WebServiceGatewaySupport {

    private String endpoint = "http://localhost:8091/ws/empleadows.wsdl";

    @Autowired
    private Jaxb2Marshaller marshaller;
    @Autowired
    private EmpleadoRestConverter empleadoRestConverter;

    public EmpleadoDTO crearEmpleado(EmpleadoDTO empleadoDTO) throws ParseException {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);
        EmpleadoSoapDTO empleadoSoapDTO = empleadoRestConverter.convertirDTOASoapDTO(empleadoDTO);
        CreateEmpleadoRequest request = new CreateEmpleadoRequest();
        request.setEmpleadoSoapDTO(empleadoSoapDTO);

        CreateEmpleadoResponse response = (CreateEmpleadoResponse) webServiceTemplate.marshalSendAndReceive(endpoint,
                request);

        return empleadoRestConverter.convertirSoapDTOADTO(response.getData().getEmpleadoSoapDTO());
    }
}
