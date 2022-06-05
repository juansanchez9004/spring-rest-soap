package com.co.parameta.rest.config;

import com.co.parameta.rest.service.SoapClient;
import com.sun.security.auth.UserPrincipal;
import org.apache.catalina.authenticator.BasicAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;

@Configuration
public class ConfigClientWS {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.co.parameta.soap.ws.empleado");
        return marshaller;
    }
}
