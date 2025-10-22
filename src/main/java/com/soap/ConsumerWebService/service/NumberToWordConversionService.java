package com.soap.ConsumerWebService.service;

import com.soap.Number.NumberToWords;
import com.soap.Number.NumberToWordsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigInteger;

@Service
public class NumberToWordConversionService {

    private static final Logger logger = LoggerFactory.getLogger(NumberToWordConversionService.class);
    private static final String SOAP_ACTION = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso/NumberToWords";
    private final WebServiceTemplate webServiceTemplate;

    public NumberToWordConversionService(@Qualifier("numberToWordWebServiceTemplate") WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public String convertToWords(int number) {
        logger.info("Calling SOAP service for number to words conversion: {}", number);
        NumberToWords request = createRequest(number);
        NumberToWordsResponse response = sendRequest(request);
        String result = response.getNumberToWordsResult();
        logger.info("SOAP service response received: {}", result);
        return result;
    }

    private NumberToWords createRequest(int number) {
        NumberToWords request = new NumberToWords();
        request.setUbiNum(BigInteger.valueOf(number));
        return request;
    }

    private NumberToWordsResponse sendRequest(NumberToWords request) {
        return (NumberToWordsResponse) webServiceTemplate
                .marshalSendAndReceive(request, new SoapActionCallback(SOAP_ACTION));
    }
}