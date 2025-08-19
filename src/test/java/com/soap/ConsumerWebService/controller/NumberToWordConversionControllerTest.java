package com.soap.ConsumerWebService.controller;

import com.soap.ConsumerWebService.service.NumberToWordConversionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumberToWordConversionControllerTest {

    @Mock
    private NumberToWordConversionService numberToWordConversionService;

    @InjectMocks
    private NumberToWordConversionController controller;

    @Test
    void numberToWords_ShouldReturnFormattedString() {
        // Given
        int number = 42;
        when(numberToWordConversionService.numberToWords(number)).thenReturn("forty two");

        // When
        String result = controller.numberToWords(number);

        // Then
        assertEquals("The Given 42 is  ---> forty two.", result);
    }
}