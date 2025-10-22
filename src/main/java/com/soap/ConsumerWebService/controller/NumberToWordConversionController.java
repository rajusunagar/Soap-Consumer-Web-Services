package com.soap.ConsumerWebService.controller;

import com.soap.ConsumerWebService.service.NumberToWordConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberToWordConversionController {

    private final NumberToWordConversionService conversionService;

    public NumberToWordConversionController(NumberToWordConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/convert/number-to-words")
    public String convertNumberToWords(@RequestParam("number") int number) {
        String words = conversionService.convertToWords(number);
        return number + " = " + words;
    }
}
