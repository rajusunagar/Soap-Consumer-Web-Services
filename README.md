# Task-SoapConsumerWebServices

Create a spring boot application to Consume below two SOAP Web services by creating RESTful interfaces to accept input in the GET parameter:

1. Temperature conversion Web service

Operation: CelsiusToFahrenheit

WSDL: https://www.w3schools.com/xml/tempconvert.asmx?WSDL

2. Number to word conversion Web serivce 

Operation:  NumberToWords

WSDL: https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL

You can refer to below official spring boot documentation

Consuming SOAP Web services

https://spring.io/guides/gs/consuming-web-service/

Building REST Services

https://spring.io/guides/tutorials/rest/


# Execution Process

Spring boot application will be excuted on http://localhost:8080 as server-port mentioned in applicaton.properties file

# Project Structure

![Project Structure](https://github.com/rajusunagar/Extio-Task-SoapConsumerWebServices/blob/main/Screenshots/Screenshot%20(56).png)

# 1. Temperature conversion Web service [Celsius To Fahrenheit]

Spring boot application will be executed on URl http://localhost:8080/convert/celsius-to-fahrenheit?celsius=25

For Example: Need to convert 25 celsius to Fahrenheit. According to my Spring boot project 25 celsius to be updated on end of URL like         
**?celsius=25**

For result observe the below screenshot

![Temperature](https://github.com/rajusunagar/Extio-Task-SoapConsumerWebServices/blob/main/Screenshots/Screenshot%20(57).png)

# 2. Number to word conversion Web serivce [Number To Words]

Spring boot application will be executed on http://localhost:8080/convert/number-to-words?number=1233546

For Example: Need to convert 1233546 number to words. According to my Spring boot project 1233546 number to be updated on end of URL like 
**?number=1233546**

For result observe the below screenshot

![Number](https://github.com/rajusunagar/Extio-Task-SoapConsumerWebServices/blob/main/Screenshots/Screenshot%20(58).png)

# Codebase Structure

## Core Components

### 1. Controllers
- **HomeController**: Serves the main landing page at `/`
- **TemperatureConversionController**: REST endpoint at `/convert/celsius-to-fahrenheit` for temperature conversion
- **NumberToWordConversionController**: REST endpoint at `/convert/number-to-words` for number to word conversion

### 2. Services
- **TemperatureConversionService**: Handles SOAP client calls to W3Schools temperature conversion service
- **NumberToWordConversionService**: Handles SOAP client calls to DataAccess number conversion service

### 3. Configuration
- **SoapClientConfig**: Spring configuration for SOAP web service templates and marshallers

### 4. Generated SOAP Clients
- **com.soap.Temperature**: Auto-generated classes from temperature conversion WSDL
- **com.soap.Number**: Auto-generated classes from number conversion WSDL

## Key Technologies
- **Spring Boot 2.7.18**: Main framework
- **Apache CXF**: SOAP client generation and web service calls
- **JAXB**: XML marshalling/unmarshalling
- **Maven**: Build and dependency management

## Build Process
1. CXF codegen plugin generates SOAP client classes from WSDLs during `generate-sources` phase
2. Generated classes are placed in `target/generated-sources/cxf` (excluded from Git)
3. Spring Boot packages everything into executable JAR

## Configuration Files
- `application.properties`: Server port configuration (8080)
- `pom.xml`: Maven dependencies and CXF plugin configuration
- `.gitignore`: Excludes build artifacts and generated sources





