package com.soap.ConsumerWebService.controller;

import com.soap.ConsumerWebService.service.TemperatureConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureConversionController {

    private final TemperatureConversionService conversionService;

    public TemperatureConversionController(TemperatureConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/convert/celsius-to-fahrenheit")
    public String convertCelsiusToFahrenheit(@RequestParam("celsius") double celsius) {
        double fahrenheit = conversionService.convertToFahrenheit(celsius);
        return celsius + " Celsius = " + fahrenheit + " Fahrenheit";
    }
}
