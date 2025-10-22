package com.soap.ConsumerWebService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapClientConfig {

    private static final String TEMPERATURE_SERVICE_URL = "https://www.w3schools.com/xml/tempconvert.asmx";
    private static final String NUMBER_SERVICE_URL = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";
    private static final String TEMPERATURE_PACKAGE = "com.soap.Temperature";
    private static final String NUMBER_PACKAGE = "com.soap.Number";

    @Bean(name = "temperatureWebServiceTemplate")
    public WebServiceTemplate temperatureWebServiceTemplate() {
        return createWebServiceTemplate(TEMPERATURE_PACKAGE, TEMPERATURE_SERVICE_URL);
    }

    @Bean(name = "numberToWordWebServiceTemplate")
    public WebServiceTemplate numberToWordWebServiceTemplate() {
        return createWebServiceTemplate(NUMBER_PACKAGE, NUMBER_SERVICE_URL);
    }

    private WebServiceTemplate createWebServiceTemplate(String packageToScan, String serviceUrl) {
        WebServiceTemplate template = new WebServiceTemplate();
        Jaxb2Marshaller marshaller = createMarshaller(packageToScan);
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        template.setDefaultUri(serviceUrl);
        return template;
    }

    private Jaxb2Marshaller createMarshaller(String packageToScan) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(packageToScan);
        return marshaller;
    }
}