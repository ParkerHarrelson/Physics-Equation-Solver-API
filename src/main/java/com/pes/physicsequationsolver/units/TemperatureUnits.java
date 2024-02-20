package com.pes.physicsequationsolver.units;

import lombok.Getter;

@Getter
public enum TemperatureUnits implements Unit {

    CELSIUS("C"),
    KELVIN("K"),
    FAHRENHEIT("F");

    private final String unit;

    TemperatureUnits(String unit) {
        this.unit = unit;
    }

}
