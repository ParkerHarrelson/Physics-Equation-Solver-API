package com.pes.physicsequationsolver.dto.requests;

import com.pes.physicsequationsolver.dto.measurements.MeasurementDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForceCalculationRequestDTO {

    private MeasurementDTO mass;
    private MeasurementDTO acceleration;
}
