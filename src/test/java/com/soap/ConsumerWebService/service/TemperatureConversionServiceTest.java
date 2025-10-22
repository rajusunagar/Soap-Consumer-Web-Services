package com.soap.ConsumerWebService.service;

import com.soap.Temperature.CelsiusToFahrenheit;
import com.soap.Temperature.CelsiusToFahrenheitResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TemperatureConversionServiceTest {

    @Mock
    private WebServiceTemplate temperatureWebServiceTemplate;

    private TemperatureConversionService service;

    @BeforeEach
    void setUp() {
        service = new TemperatureConversionService(temperatureWebServiceTemplate);
    }

    @Test
    void convertToFahrenheit_ShouldReturnCorrectConversion() {
        // Given
        double celsius = 100.0;
        CelsiusToFahrenheitResponse response = new CelsiusToFahrenheitResponse();
        response.setCelsiusToFahrenheitResult("212");

        when(temperatureWebServiceTemplate.marshalSendAndReceive(
                any(CelsiusToFahrenheit.class),
                any(SoapActionCallback.class)))
                .thenReturn(response);

        // When
        double result = service.convertToFahrenheit(celsius);

        // Then
        assertEquals(212.0, result);
    }
}