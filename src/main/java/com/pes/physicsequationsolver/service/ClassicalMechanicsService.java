package com.pes.physicsequationsolver.service;

import com.pes.physicsequationsolver.constants.coordinates.CoordinateSystemType;
import com.pes.physicsequationsolver.constants.units.ForceUnits;
import com.pes.physicsequationsolver.constants.units.MassUnits;
import com.pes.physicsequationsolver.dto.measurements.VectorDTO;
import com.pes.physicsequationsolver.dto.requests.ForceCalculationRequestDTO;
import com.pes.physicsequationsolver.dto.responses.ForceResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class ClassicalMechanicsService {

    private UnitConversionService unitConversionService;

    public ForceResponseDTO calculateForce(ForceCalculationRequestDTO forceCalculationRequest) {

        if (Objects.isNull(forceCalculationRequest.getMass()) || Objects.isNull(forceCalculationRequest.getAcceleration())) {
            throw new RuntimeException("fix this later");
        }

        double mass = unitConversionService.convert(forceCalculationRequest.getMass().getValue(), forceCalculationRequest.getMass().getUnit(), MassUnits.KILOGRAM);
        VectorDTO acceleration = forceCalculationRequest.getAcceleration();
        acceleration.convertToCartesian();

        double forceX = mass * acceleration.getX();
        double forceY = mass * acceleration.getY();
        double forceZ = mass * acceleration.getZ();

        for (VectorDTO additionalForce : forceCalculationRequest.getAdditionalForces()) {
            additionalForce.convertToCartesian();
            forceX += additionalForce.getX();
            forceY += additionalForce.getY();
            forceZ += additionalForce.getZ();
        }

        double resultantForceMagnitude = Math.sqrt(forceX * forceX + forceY * forceY + forceZ * forceZ);

        VectorDTO resultantVector = VectorDTO.builder()
                .x(forceX)
                .y(forceY)
                .z(forceZ)
                .theta(0.0)
                .phi(0.0)
                .magnitude(0.0)
                .coordinateSystemType(CoordinateSystemType.CARTESIAN)
                .build();

        if (forceCalculationRequest.getCoordinateSystemType() == CoordinateSystemType.SPHERICAL) {
            resultantVector.convertToSpherical();
        }

        return ForceResponseDTO.builder()
                .force(resultantVector)
                .resultantForceMagnitude(resultantForceMagnitude)
                .unit(ForceUnits.NEWTONS)
                .build();
    }
}
