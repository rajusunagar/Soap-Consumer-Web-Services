package com.soap.ConsumerWebService.controller;

import com.soap.ConsumerWebService.service.NumberToWordConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberToWordConversionController {

    @Autowired
    private NumberToWordConversionService numberToWordConversionService;

    @GetMapping("/convert/Number-to-words")
    public String numberToWords(@RequestParam("Number") int number) {
        String words = numberToWordConversionService.numberToWords(number);
        return "The Given " + number + " is  ---> " + words + ".";
    }
}
