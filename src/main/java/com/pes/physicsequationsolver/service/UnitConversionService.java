package com.pes.physicsequationsolver.service;

import com.pes.physicsequationsolver.units.Unit;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UnitConversionService {

    private final Map<String, Map<String, Double>> conversionFactors;

    public UnitConversionService(Map<String, Map<String, Double>> conversionFactors) {
        this.conversionFactors = conversionFactors;
    }

    public double convert(double value, Unit fromUnit, Unit toUnit) {
        String category = fromUnit.getClass().getSimpleName().toLowerCase();
        String key = fromUnit + "_to_" + toUnit.toString();
        Double factor = Optional.ofNullable(conversionFactors.get(category))
                .map(factors -> factors.get(key))
                .orElseThrow(() -> new UnsupportedOperationException("Conversion not supported: " + key));

        return value * factor;
    }
}
