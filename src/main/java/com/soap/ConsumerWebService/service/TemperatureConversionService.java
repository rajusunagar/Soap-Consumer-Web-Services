package com.soap.ConsumerWebService.service;

import com.soap.Temperature.CelsiusToFahrenheit;
import com.soap.Temperature.CelsiusToFahrenheitResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class TemperatureConversionService {

    private static final Logger logger = LoggerFactory.getLogger(TemperatureConversionService.class);
    private static final String SOAP_ACTION = "https://www.w3schools.com/xml/CelsiusToFahrenheit";
    private final WebServiceTemplate webServiceTemplate;

    public TemperatureConversionService(@Qualifier("temperatureWebServiceTemplate") WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public double convertToFahrenheit(double celsius) {
        logger.info("Calling SOAP service for temperature conversion: {} Celsius", celsius);
        CelsiusToFahrenheit request = createRequest(celsius);
        CelsiusToFahrenheitResponse response = sendRequest(request);
        double result = Double.parseDouble(response.getCelsiusToFahrenheitResult());
        logger.info("SOAP service response received: {} Fahrenheit", result);
        return result;
    }

    private CelsiusToFahrenheit createRequest(double celsius) {
        CelsiusToFahrenheit request = new CelsiusToFahrenheit();
        request.setCelsius(String.valueOf(celsius));
        return request;
    }

    private CelsiusToFahrenheitResponse sendRequest(CelsiusToFahrenheit request) {
        return (CelsiusToFahrenheitResponse) webServiceTemplate
                .marshalSendAndReceive(request, new SoapActionCallback(SOAP_ACTION));
    }
}