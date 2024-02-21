package com.pes.physicsequationsolver.controller;

import com.pes.physicsequationsolver.dto.requests.ForceCalculationRequestDTO;
import com.pes.physicsequationsolver.dto.requests.GravitationalForceRequestDTO;
import com.pes.physicsequationsolver.dto.responses.ForceResponseDTO;
import com.pes.physicsequationsolver.dto.responses.GravitationalForceResponseDTO;
import com.pes.physicsequationsolver.service.ClassicalMechanicsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.pes.physicsequationsolver.constants.ApplicationConstants.*;


@RestController
@RequestMapping(URL_CLASSICAL_MECHANICS)
@AllArgsConstructor
@Tag(name = "Classical Mechanics Controller")
public class ClassicalMechanicsController {

    private final ClassicalMechanicsService classicalMechanicsService;

    @GetMapping(value = URL_CALCULATE_FORCE)
    @Operation(description = "GET Endpoint for Calculating Results for Newton's Second Law of Motion")
    public ResponseEntity<ForceResponseDTO> calculateForce(@RequestBody ForceCalculationRequestDTO forceCalculationRequest) {
        return new ResponseEntity<>(classicalMechanicsService.calculateForce(forceCalculationRequest), HttpStatus.OK);
    }

    @GetMapping(value = URL_GRAVITATIONAL_FORCE)
    @Operation(description = "GET Endpoint for Calculating the Gravitational Force Between Two Bodies")
    public ResponseEntity<GravitationalForceResponseDTO> calculateGravitationalForce(@RequestBody GravitationalForceRequestDTO gravitationalForceRequest) {
        return new ResponseEntity<>(classicalMechanicsService.calculateGravitationalForce(gravitationalForceRequest), HttpStatus.OK);
    }
}
