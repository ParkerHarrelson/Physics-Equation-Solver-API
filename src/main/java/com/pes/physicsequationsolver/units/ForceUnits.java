package com.pes.physicsequationsolver.units;

import lombok.Getter;

@Getter
public enum ForceUnits implements Unit {

    NEWTONS("N"),
    POUND_FORCE("lbf");

    private final String unit;

    ForceUnits(String unit) {
        this.unit = unit;
    }

}
