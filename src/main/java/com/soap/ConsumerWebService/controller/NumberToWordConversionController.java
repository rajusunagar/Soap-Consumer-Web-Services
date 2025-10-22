package com.soap.ConsumerWebService.controller;

import com.soap.ConsumerWebService.service.NumberToWordConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberToWordConversionController {

    private static final Logger logger = LoggerFactory.getLogger(NumberToWordConversionController.class);
    private final NumberToWordConversionService conversionService;

    public NumberToWordConversionController(NumberToWordConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/convert/number-to-words")
    public String convertNumberToWords(@RequestParam("number") int number) {
        logger.info("Number to words conversion request received: {}", number);
        String words = conversionService.convertToWords(number);
        logger.info("Number to words conversion completed: {} = {}", number, words);
        return number + " = " + words;
    }
}
