package com.pes.physicsequationsolver.dto.measurements;

import com.pes.physicsequationsolver.constants.units.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeasurementDTO {

    private Double value;
    private Unit unit;
}
