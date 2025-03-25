package com.calculator.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.calculator.util.UnitConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private List<String> history = new ArrayList<>();

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        double result = a + b;
        history.add("Added: " + a + " + " + b + " = " + result);
        return result;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        double result = a - b;
        history.add("Subtracted: " + a + " - " + b + " = " + result);
        return result;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        double result = a * b;
        history.add("Multiplied: " + a + " * " + b + " = " + result);
        return result;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero not allowed");
        }
        double result = a / b;
        history.add("Divided: " + a + " / " + b + " = " + result);
        return result;
    }

    @GetMapping("/convert/{fromUnit}/{toUnit}")
    public double convertUnits(@RequestParam double value, @PathVariable String fromUnit, @PathVariable String toUnit) {
        try {
            double result = UnitConverter.convertLength(value, fromUnit, toUnit); // Adjust based on the type of conversion
            history.add("Converted: " + value + " " + fromUnit + " to " + toUnit + " = " + result);
            return result;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/convert/weight")
    public double convertWeight(@RequestParam double value, @RequestParam String fromUnit, @RequestParam String toUnit) {
        double result = UnitConverter.convertWeight(value, fromUnit, toUnit);
        history.add("Converted Weight: " + value + " " + fromUnit + " to " + toUnit + " = " + result);
        return result;
    }

    @GetMapping("/convert/temperature")
    public double convertTemperature(@RequestParam double value, @RequestParam String fromUnit, @RequestParam String toUnit) {
        double result = UnitConverter.convertTemperature(value, fromUnit, toUnit);
        history.add("Converted Temperature: " + value + " " + fromUnit + " to " + toUnit + " = " + result);
        return result;
    }

    @GetMapping("/convert/currency")
    public double convertCurrency(@RequestParam double value, @RequestParam String fromCurrency, @RequestParam String toCurrency) {
        double result = UnitConverter.convertCurrency(value, fromCurrency, toCurrency);
        history.add("Converted Currency: " + value + " " + fromCurrency + " to " + toCurrency + " = " + result);
        return result;
    }

    @GetMapping("/history")
    public List<String> getHistory() {
        return history;
    }

    private boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }

    @GetMapping("/sin")
    public double sin(@RequestParam String value) {
        if (!isNumeric(value)) {
            throw new IllegalArgumentException("Invalid input: " + value);
        }
        double numericValue = Double.parseDouble(value);
        double result = Math.sin(numericValue);
        history.add("Sin: sin(" + numericValue + ") = " + result);
        return result;
    }

    @GetMapping("/cos")
    public double cos(@RequestParam String value) {
        if (!isNumeric(value)) {
            throw new IllegalArgumentException("Invalid input: " + value);
        }
        double numericValue = Double.parseDouble(value);
        double result = Math.cos(numericValue);
        history.add("Cos: cos(" + numericValue + ") = " + result);
        return result;
    }

    @GetMapping("/tan")
    public double tan(@RequestParam String value) {
        if (!isNumeric(value)) {
            throw new IllegalArgumentException("Invalid input: " + value);
        }
        double numericValue = Double.parseDouble(value);
        double result = Math.tan(numericValue);
        history.add("Tan: tan(" + numericValue + ") = " + result);
        return result;
    }

    @GetMapping("/log")
    public double log(@RequestParam String value) {
        if (!isNumeric(value)) {
            throw new IllegalArgumentException("Invalid input: " + value);
        }
        double numericValue = Double.parseDouble(value);
        if (numericValue <= 0) {
            throw new IllegalArgumentException("Logarithm of non-positive number not allowed");
        }
        double result = Math.log(numericValue);
        history.add("Log: log(" + numericValue + ") = " + result);
        return result;
    }

    @GetMapping("/ln")
    public double ln(@RequestParam String value) {
        return log(value); // ln is the same as log in base e
    }

    @GetMapping("/exp")
    public double exp(@RequestParam String value) {
        if (!isNumeric(value)) {
            throw new IllegalArgumentException("Invalid input: " + value);
        }
        double numericValue = Double.parseDouble(value);
        double result = Math.exp(numericValue);
        history.add("Exp: exp(" + numericValue + ") = " + result);
        return result;
    }

    @GetMapping("/pow")
    public double pow(@RequestParam double base, @RequestParam double exponent) {
        double result = Math.pow(base, exponent);
        history.add("Pow: " + base + "^" + exponent + " = " + result);
        return result;
    }

    // Add similar methods for weight, temperature, etc.
}
