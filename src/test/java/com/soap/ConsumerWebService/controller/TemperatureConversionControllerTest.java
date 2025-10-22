package com.soap.ConsumerWebService.controller;

import com.soap.ConsumerWebService.service.TemperatureConversionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TemperatureConversionControllerTest {

    @Mock
    private TemperatureConversionService temperatureConversionService;

    @InjectMocks
    private TemperatureConversionController controller;

    @Test
    void convertCelsiusToFahrenheit_ShouldReturnFormattedString() {
        // Given
        double celsius = 100.0;
        when(temperatureConversionService.convertToFahrenheit(celsius)).thenReturn(212.0);

        // When
        String result = controller.convertCelsiusToFahrenheit(celsius);

        // Then
        assertEquals("100.0 Celsius = 212.0 Fahrenheit", result);
    }
}