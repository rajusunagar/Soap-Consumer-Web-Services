package com.soap.ConsumerWebService.service;

import com.soap.ConsumerWebService.temperature.CelsiusToFahrenheit;
import com.soap.ConsumerWebService.temperature.CelsiusToFahrenheitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class TemperatureConversionService {

    private final WebServiceTemplate temperatureWebServiceTemplate;

    @Autowired
    public TemperatureConversionService(@Qualifier("temperatureWebServiceTemplate") WebServiceTemplate temperatureWebServiceTemplate) {
        this.temperatureWebServiceTemplate = temperatureWebServiceTemplate;
    }

    public String convertCelsiusToFahrenheit(double celsius) {
        CelsiusToFahrenheit request = new CelsiusToFahrenheit();
        request.setCelsius(String.valueOf(celsius));

        CelsiusToFahrenheitResponse response = (CelsiusToFahrenheitResponse) temperatureWebServiceTemplate
                .marshalSendAndReceive(request,
                        new SoapActionCallback("https://www.w3schools.com/xml/CelsiusToFahrenheit"));

        return response.getCelsiusToFahrenheitResult();
    }
}