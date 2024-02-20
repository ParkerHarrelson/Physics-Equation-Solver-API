package com.pes.physicsequationsolver.dto.requests;

import com.pes.physicsequationsolver.constants.coordinates.CoordinateSystemType;
import com.pes.physicsequationsolver.dto.measurements.MassDTO;
import com.pes.physicsequationsolver.dto.measurements.VectorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForceCalculationRequestDTO {

    private MassDTO mass;
    private VectorDTO acceleration;
    private List<VectorDTO> additionalForces;
    private CoordinateSystemType coordinateSystemType = CoordinateSystemType.CARTESIAN;
}
