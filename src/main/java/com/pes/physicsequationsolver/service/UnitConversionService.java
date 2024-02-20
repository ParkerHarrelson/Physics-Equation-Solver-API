package com.pes.physicsequationsolver.service;

import com.pes.physicsequationsolver.units.TemperatureUnits;
import com.pes.physicsequationsolver.units.Unit;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

import static com.pes.physicsequationsolver.constants.ApplicationConstants.*;

@Service
public class UnitConversionService {

    private final Map<String, Map<String, Double>> conversionFactors;

    public UnitConversionService(Map<String, Map<String, Double>> conversionFactors) {
        this.conversionFactors = conversionFactors;
    }

    public double convert(double value, Unit fromUnit, Unit toUnit) {
        if (!fromUnit.getClass().equals(toUnit.getClass()) && !(isTemperatureUnit(fromUnit) && isTemperatureUnit(toUnit))) {
            throw new IllegalArgumentException("Incompatible units: " + fromUnit + " and " + toUnit);
        }

        if (isTemperatureUnit(fromUnit) && isTemperatureUnit(toUnit)) {
            return convertTemperature(value, fromUnit, toUnit);
        }

        String category = fromUnit.getClass().getSimpleName().toLowerCase();
        String key = fromUnit + "_to_" + toUnit;
        Double factor = Optional.ofNullable(conversionFactors.get(category))
                .map(factors -> factors.get(key))
                .orElseThrow(() -> new UnsupportedOperationException("Conversion not supported: " + key));

        return value * factor;
    }

    private boolean isTemperatureUnit(Unit unit) {
        return unit instanceof TemperatureUnits;
    }

    private double convertTemperature(double value, Unit fromUnit, Unit toUnit) {
        double valueInKelvin = getValueInKelvin(value, fromUnit);

        if (toUnit == TemperatureUnits.CELSIUS) {
            return valueInKelvin - KELVIN_OFFSET;
        } else if (toUnit == TemperatureUnits.FAHRENHEIT) {
            return (valueInKelvin - KELVIN_OFFSET) * FAHRENHEIT_SCALE + FAHRENHEIT_OFFSET;
        } else if (toUnit == TemperatureUnits.KELVIN) {
            return valueInKelvin;
        } else {
            throw new UnsupportedOperationException("Unsupported target temperature unit: " + toUnit);
        }
    }

    private static double getValueInKelvin(double value, Unit fromUnit) {
        double valueInKelvin;
        if (fromUnit == TemperatureUnits.CELSIUS) {
            valueInKelvin = value + KELVIN_OFFSET;
        } else if (fromUnit == TemperatureUnits.FAHRENHEIT) {
            valueInKelvin = (value - FAHRENHEIT_OFFSET) * 5 / 9 + KELVIN_OFFSET;
        } else if (fromUnit == TemperatureUnits.KELVIN) {
            valueInKelvin = value;
        } else {
            throw new UnsupportedOperationException("Unsupported source temperature unit: " + fromUnit);
        }
        return valueInKelvin;
    }


}
