package com.co.parameta.soap.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellidos;
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Column(name = "FECHA")
    private Date fecha;
    @Column(name = "FECHA_VINCULACION")
    private Date fechaVinculacionCompania;
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "SALARIO")
    private Double salario;

    public Empleado() {
        super();
    }

    public Empleado(Long id, String nombre, String apellidos, String tipoDocumento, String numeroDocumento, Date fecha, Date fechaVinculacionCompania, String cargo, Double salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fecha = fecha;
        this.fechaVinculacionCompania = fechaVinculacionCompania;
        this.cargo = cargo;
        this.salario = salario;
    }

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaVinculacionCompania() {
        return fechaVinculacionCompania;
    }

    public void setFechaVinculacionCompania(Date fechaVinculacionCompania) {
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
}
