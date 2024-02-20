package com.pes.physicsequationsolver.controller;

import com.pes.physicsequationsolver.dto.requests.ForceCalculationRequestDTO;
import com.pes.physicsequationsolver.service.ClassicalMechanicsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pes.physicsequationsolver.constants.ApplicationConstants.URL_CLASSICAL_MECHANICS;
import static com.pes.physicsequationsolver.constants.ApplicationConstants.URL_CALCULATE_FORCE;


@RestController
@RequestMapping(URL_CLASSICAL_MECHANICS)
@AllArgsConstructor
@Tag(name = "Classical Mechanics Controller")
public class ClassicalMechanicsController {

    private final ClassicalMechanicsService classicalMechanicsService;

    @GetMapping(value = URL_CALCULATE_FORCE)
    @Operation(description = "GET Endpoint for Calculating Results for Newton's Second Law of Motion")
    public ResponseEntity<?> calculateForce(@RequestBody ForceCalculationRequestDTO forceCalculationRequest) {
        return new ResponseEntity<>(classicalMechanicsService.calculateForce(forceCalculationRequest), HttpStatus.OK);
    }
}
