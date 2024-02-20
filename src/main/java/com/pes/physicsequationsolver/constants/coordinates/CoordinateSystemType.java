package com.pes.physicsequationsolver.constants.coordinates;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum CoordinateSystemType {

    CARTESIAN("Cartesian"),
    SPHERICAL("Spherical");

    private final String systemType;

    CoordinateSystemType(String systemType) {
        this.systemType = systemType;
    }
}
