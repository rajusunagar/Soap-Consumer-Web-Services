package com.soap.ConsumerWebService.controller;

import com.soap.ConsumerWebService.service.TemperatureConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureConversionController {

    private static final Logger logger = LoggerFactory.getLogger(TemperatureConversionController.class);
    private final TemperatureConversionService conversionService;

    public TemperatureConversionController(TemperatureConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/convert/celsius-to-fahrenheit")
    public String convertCelsiusToFahrenheit(@RequestParam("celsius") double celsius) {
        logger.info("Temperature conversion request received: {} Celsius", celsius);
        double fahrenheit = conversionService.convertToFahrenheit(celsius);
        logger.info("Temperature conversion completed: {} Celsius = {} Fahrenheit", celsius, fahrenheit);
        return celsius + " Celsius = " + fahrenheit + " Fahrenheit";
    }
}
