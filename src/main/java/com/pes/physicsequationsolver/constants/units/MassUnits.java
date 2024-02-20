package com.pes.physicsequationsolver.constants.units;

import lombok.Getter;

@Getter
public enum MassUnits implements Unit {

    KILOGRAM("kg"),
    GRAMS("g"),
    POUNDS("lb"),
    OUNCES("oz");

    private final String unit;

    MassUnits(String unit) {
        this.unit = unit;
    }

}
