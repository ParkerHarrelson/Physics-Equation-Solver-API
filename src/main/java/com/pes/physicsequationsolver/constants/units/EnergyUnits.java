package com.pes.physicsequationsolver.constants.units;

import lombok.Getter;

@Getter
public enum EnergyUnits implements Unit {

    JOULE("J"),
    KILOWATT_HOUR("kWh"),
    CALORIE("cal"),
    KILOCALORIE("kcal"),
    BRITISH_THERMAL_UNIT("BTU");

    private final String unit;

    EnergyUnits(String unit) {
        this.unit = unit;
    }

}
