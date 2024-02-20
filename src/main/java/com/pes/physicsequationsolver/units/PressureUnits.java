package com.pes.physicsequationsolver.units;

import lombok.Getter;

@Getter
public enum PressureUnits implements Unit {

    PASCAL("Pa"),
    ATMOSPHERE("atm"),
    BAR("bar"),
    POUNDS_PER_SQUARE_INCH("psi");

    private final String unit;

    PressureUnits(String unit) {
        this.unit = unit;
    }

}
