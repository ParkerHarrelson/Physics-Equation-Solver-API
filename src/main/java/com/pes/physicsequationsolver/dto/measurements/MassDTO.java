package com.pes.physicsequationsolver.dto.measurements;

import com.pes.physicsequationsolver.constants.units.MassUnits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MassDTO {

    private Double value = 0.0;
    private MassUnits unit;
}
