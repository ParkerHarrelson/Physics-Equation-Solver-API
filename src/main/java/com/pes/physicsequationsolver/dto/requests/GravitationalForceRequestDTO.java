package com.pes.physicsequationsolver.dto.requests;

import com.pes.physicsequationsolver.dto.measurements.DistanceDTO;
import com.pes.physicsequationsolver.dto.measurements.MassDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GravitationalForceRequestDTO {

    private MassDTO bodyOneMass;
    private MassDTO bodyTwoMass;
    private DistanceDTO distanceBetweenBodies;
}
