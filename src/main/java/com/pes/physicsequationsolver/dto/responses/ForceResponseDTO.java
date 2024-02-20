package com.pes.physicsequationsolver.dto.responses;

import com.pes.physicsequationsolver.constants.units.Unit;
import com.pes.physicsequationsolver.dto.measurements.VectorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForceResponseDTO {

    private VectorDTO force;
    private Double resultantForceMagnitude;
    private Unit unit;
}
