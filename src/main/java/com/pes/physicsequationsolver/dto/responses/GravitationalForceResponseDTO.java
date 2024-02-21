package com.pes.physicsequationsolver.dto.responses;

import com.pes.physicsequationsolver.constants.units.ForceUnits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GravitationalForceResponseDTO {

    private Double resultantForce;
    private ForceUnits forceUnit;
}
