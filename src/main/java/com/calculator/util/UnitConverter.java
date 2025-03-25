package com.calculator.util;

public class UnitConverter {
    // Length conversion
    public static double convertLength(double value, String fromUnit, String toUnit) {
        switch (fromUnit.toLowerCase()) {
            case "meters":
                if (toUnit.equalsIgnoreCase("feet")) {
                    return value * 3.28084;
                } else if (toUnit.equalsIgnoreCase("inches")) {
                    return value * 39.3701;
                }
                break;
            case "feet":
                if (toUnit.equalsIgnoreCase("meters")) {
                    return value / 3.28084;
                } else if (toUnit.equalsIgnoreCase("inches")) {
                    return value * 12;
                }
                break;
            case "inches":
                if (toUnit.equalsIgnoreCase("meters")) {
                    return value / 39.3701;
                } else if (toUnit.equalsIgnoreCase("feet")) {
                    return value / 12;
                }
                break;
            // Add more length units as needed
        }
        throw new IllegalArgumentException("Invalid length conversion from " + fromUnit + " to " + toUnit);
    }

    // Weight conversion
    public static double convertWeight(double value, String fromUnit, String toUnit) {
        switch (fromUnit.toLowerCase()) {
            case "kilograms":
                if (toUnit.equalsIgnoreCase("pounds")) {
                    return value * 2.20462;
                }
                break;
            case "pounds":
                if (toUnit.equalsIgnoreCase("kilograms")) {
                    return value / 2.20462;
                }
                break;
            // Add more weight units as needed
        }
        throw new IllegalArgumentException("Invalid weight conversion from " + fromUnit + " to " + toUnit);
    }

    // Temperature conversion
    public static double convertTemperature(double value, String fromUnit, String toUnit) {
        if (fromUnit.equalsIgnoreCase("celsius")) {
            if (toUnit.equalsIgnoreCase("fahrenheit")) {
                return (value * 9/5) + 32;
            } else if (toUnit.equalsIgnoreCase("kelvin")) {
                return value + 273.15;
            }
        } else if (fromUnit.equalsIgnoreCase("fahrenheit")) {
            if (toUnit.equalsIgnoreCase("celsius")) {
                return (value - 32) * 5/9;
            } else if (toUnit.equalsIgnoreCase("kelvin")) {
                return (value - 32) * 5/9 + 273.15;
            }
        } else if (fromUnit.equalsIgnoreCase("kelvin")) {
            if (toUnit.equalsIgnoreCase("celsius")) {
                return value - 273.15;
            } else if (toUnit.equalsIgnoreCase("fahrenheit")) {
                return (value - 273.15) * 9/5 + 32;
            }
        }
        throw new IllegalArgumentException("Invalid temperature conversion from " + fromUnit + " to " + toUnit);
    }

    // Currency conversion (example, you may want to use an API for real-time rates)
    public static double convertCurrency(double value, String fromCurrency, String toCurrency) {
        // Example conversion rates (these should be updated with real rates)
        double rate = 1.0;
        if (fromCurrency.equalsIgnoreCase("usd") && toCurrency.equalsIgnoreCase("inr")) {
            rate = 74.0; // Example rate
        } else if (fromCurrency.equalsIgnoreCase("inr") && toCurrency.equalsIgnoreCase("usd")) {
            rate = 1 / 74.0; // Example rate
        }
        // Add more currency conversions as needed
        return value * rate;
    }
}
