package com.co.parameta.controller;

import com.co.parameta.controller.dto.EmpleadoDTO;
import com.co.parameta.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<EmpleadoDTO> obtenerEmpleado(@RequestBody EmpleadoDTO empleadoDTO) throws Exception {
        String validacionesEmpleado = empleadoService.validacionesInformacionEmpleado(empleadoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
