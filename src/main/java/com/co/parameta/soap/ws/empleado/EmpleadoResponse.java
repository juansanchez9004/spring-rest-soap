//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.06.05 a las 03:42:39 PM COT 
//


package com.co.parameta.soap.ws.empleado;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para empleadoResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="empleadoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="empleadoSoapDTO" type="{http://parameta.co.com/soap/ws/empleado}empleadoSoapDTO"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "empleadoResponse", propOrder = {
    "empleadoSoapDTO"
})
public class EmpleadoResponse {

    @XmlElement(required = true)
    protected EmpleadoSoapDTO empleadoSoapDTO;

    /**
     * Obtiene el valor de la propiedad empleadoSoapDTO.
     * 
     * @return
     *     possible object is
     *     {@link EmpleadoSoapDTO }
     *     
     */
    public EmpleadoSoapDTO getEmpleadoSoapDTO() {
        return empleadoSoapDTO;
    }

    /**
     * Define el valor de la propiedad empleadoSoapDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link EmpleadoSoapDTO }
     *     
     */
    public void setEmpleadoSoapDTO(EmpleadoSoapDTO value) {
        this.empleadoSoapDTO = value;
    }

}
