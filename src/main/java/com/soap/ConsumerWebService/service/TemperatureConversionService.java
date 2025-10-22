package com.soap.ConsumerWebService.service;

import com.soap.Temperature.CelsiusToFahrenheit;
import com.soap.Temperature.CelsiusToFahrenheitResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class TemperatureConversionService {

    private static final String SOAP_ACTION = "https://www.w3schools.com/xml/CelsiusToFahrenheit";
    private final WebServiceTemplate webServiceTemplate;

    public TemperatureConversionService(@Qualifier("temperatureWebServiceTemplate") WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public double convertToFahrenheit(double celsius) {
        CelsiusToFahrenheit request = createRequest(celsius);
        CelsiusToFahrenheitResponse response = sendRequest(request);
        return Double.parseDouble(response.getCelsiusToFahrenheitResult());
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