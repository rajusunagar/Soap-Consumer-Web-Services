package com.soap.ConsumerWebService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapClientConfig {

    @Bean(name = "temperatureWebServiceTemplate")
    public WebServiceTemplate temperatureWebServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.soap.ConsumerWebService.Temperature");
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri("https://www.w3schools.com/xml/tempconvert.asmx");
        return webServiceTemplate;
    }

    @Bean(name = "numberToWordWebServiceTemplate")
    public WebServiceTemplate numberToWordWebServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.soap.ConsumerWebService.Number");
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        return webServiceTemplate;
    }
}