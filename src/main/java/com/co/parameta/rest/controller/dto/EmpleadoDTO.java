package com.co.parameta.rest.controller.dto;

import com.co.parameta.rest.utils.CalcularConFechas;

public class EmpleadoDTO {

    private Long id;

    private String nombre;

    private String apellidos;

    private String tipoDocumento;

    private String numeroDocumento;

    private String fecha;

    private String fechaVinculacionCompania;

    private String cargo;

    private Double salario;

    private String vinculacionCompania;

    private String edad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaVinculacionCompania() {
        return fechaVinculacionCompania;
    }

    public void setFechaVinculacionCompania(String fechaVinculacionCompania) {
        this.fechaVinculacionCompania = fechaVinculacionCompania;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getVinculacionCompania() throws Exception {
        return CalcularConFechas.calcularTiempoVinculacion(this.getFechaVinculacionCompania());
    }

    public String getEdad() throws Exception {
        return CalcularConFechas.calcularEdad(this.getFecha());
    }
}
