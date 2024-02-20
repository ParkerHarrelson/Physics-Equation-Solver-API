package com.pes.physicsequationsolver.dto.measurements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SphericalCoordinates {

    private Double theta;
    private Double phi;
}
