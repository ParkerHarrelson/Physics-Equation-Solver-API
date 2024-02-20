package com.pes.physicsequationsolver.constants.units;

import lombok.Getter;

@Getter
public enum TimeUnits implements Unit {

    SECOND("s"),
    MINUTE("min"),
    HOUR("hr");

    private final String unit;

    TimeUnits(String unit) {
        this.unit = unit;
    }

}
