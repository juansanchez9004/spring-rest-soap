package com.co.parameta.rest.controller;

import com.co.parameta.rest.controller.dto.EmpleadoDTO;
import com.co.parameta.rest.service.EmpleadoService;
import com.co.parameta.rest.service.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ServerErrorException;

import javax.ws.rs.InternalServerErrorException;

@RestController
@RequestMapping("/rest/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private SoapClient soapClient;

    @GetMapping
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO) throws Exception {
        String validacionesEmpleado = empleadoService.validacionesEmpleado(empleadoDTO);

        if(!validacionesEmpleado.equals("")) {
            throw new IllegalArgumentException(validacionesEmpleado);
        }

        empleadoDTO = soapClient.crearEmpleado(empleadoDTO);
        return ResponseEntity.ok(empleadoDTO);
    }
}
