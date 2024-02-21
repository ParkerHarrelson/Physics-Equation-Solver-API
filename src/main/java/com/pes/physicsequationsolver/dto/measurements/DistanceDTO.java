package com.pes.physicsequationsolver.dto.measurements;

import com.pes.physicsequationsolver.constants.units.DistanceLengthUnits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DistanceDTO {

    private Double value = 0.0;
    private DistanceLengthUnits unit = DistanceLengthUnits.METER;
}
