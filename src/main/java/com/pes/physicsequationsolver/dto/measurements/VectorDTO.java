package com.pes.physicsequationsolver.dto.measurements;

import com.pes.physicsequationsolver.constants.coordinates.CoordinateSystemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VectorDTO {

    private Double magnitude = 0.0;
    private Double theta = 0.0;
    private Double phi = 0.0;
    private Double x = 0.0;
    private Double y = 0.0;
    private Double z = 0.0;
    private CoordinateSystemType coordinateSystemType;

    public void convertToCartesian() {
        if (coordinateSystemType == CoordinateSystemType.SPHERICAL) {
            double thetaRad = Math.toRadians(theta);
            double phiRad = Math.toRadians(phi);
            x = magnitude * Math.sin(phiRad) * Math.cos(thetaRad);
            y = magnitude * Math.sin(phiRad) * Math.sin(thetaRad);
            z = magnitude * Math.cos(phiRad);

            magnitude = 0.0;
            theta = 0.0;
            phi = 0.0;
            coordinateSystemType = CoordinateSystemType.CARTESIAN;
        }
    }

    public void convertToSpherical() {
        if (coordinateSystemType == CoordinateSystemType.CARTESIAN) {
            magnitude = Math.sqrt(x*x + y*y + z*z);
            theta = Math.toDegrees(Math.atan2(y, x));
            phi = Math.toDegrees(Math.acos(z / magnitude));

            x = 0.0;
            y = 0.0;
            z = 0.0;
            coordinateSystemType = CoordinateSystemType.SPHERICAL;
        }
    }

}
