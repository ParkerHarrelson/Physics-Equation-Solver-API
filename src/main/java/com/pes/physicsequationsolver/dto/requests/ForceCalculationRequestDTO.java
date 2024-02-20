package com.pes.physicsequationsolver.dto.requests;

import com.pes.physicsequationsolver.dto.measurements.ForceDTO;
import com.pes.physicsequationsolver.dto.measurements.MeasurementDTO;
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

    private MeasurementDTO mass;
    private MeasurementDTO acceleration;
    private List<ForceDTO> additionalForces;
}
