package com.soap.ConsumerWebService.controller;

import com.soap.ConsumerWebService.service.TemperatureConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureConversionController {

    @Autowired
    private TemperatureConversionService temperatureConversionService;

    @GetMapping("/convert/celsius-to-fahrenheit")
    public String celsiusToFahrenheit(@RequestParam("celsius") double celsius) {
        double fahrenheit = Double.parseDouble(temperatureConversionService.convertCelsiusToFahrenheit(celsius));
        return celsius + " Celsius = " + fahrenheit + " Fahrenheit.";
    }
}
