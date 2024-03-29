package com.pes.physicsequationsolver.service;

import com.pes.physicsequationsolver.constants.units.TemperatureUnits;
import com.pes.physicsequationsolver.constants.units.Unit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

import static com.pes.physicsequationsolver.constants.ApplicationConstants.*;

@Service
@AllArgsConstructor
public class UnitConversionService {

    private final Map<String, Map<String, Double>> conversionFactors;

    public double convert(double value, Unit fromUnit, Unit toUnit) {
        if (fromUnit == toUnit) {
            return value;
        }

        if (isTemperatureUnit(fromUnit) && isTemperatureUnit(toUnit)) {
            return convertTemperature(value, fromUnit, toUnit);
        }

        if (!fromUnit.getClass().equals(toUnit.getClass())) {
            throw new IllegalArgumentException("Incompatible units: " + fromUnit + " and " + toUnit);
        }

        String category = fromUnit.getClass().getSimpleName();
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
