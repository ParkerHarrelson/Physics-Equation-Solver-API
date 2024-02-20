package com.pes.physicsequationsolver.constants.units;

import lombok.Getter;

@Getter
public enum DistanceLengthUnits implements Unit {

    METER("m"),
    CENTIMETER("cm"),
    MILLIMETER("mm"),
    KILOMETER("km"),
    FEET("ft"),
    INCHES("in"),
    MILE("mi");

    private final String unit;

    DistanceLengthUnits(String unit) {
        this.unit = unit;
    }

}
