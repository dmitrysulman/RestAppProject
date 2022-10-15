package org.dmitrysulman.rest.RestAppProject.controllers;

import org.dmitrysulman.rest.RestAppProject.dto.MeasurementDto;
import org.dmitrysulman.rest.RestAppProject.dto.RainyDaysCountDto;
import org.dmitrysulman.rest.RestAppProject.models.Measurement;
import org.dmitrysulman.rest.RestAppProject.services.MeasurementService;
import org.dmitrysulman.rest.RestAppProject.util.MeasurementDtoValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;
    private final MeasurementDtoValidator measurementDtoValidator;

    @Autowired
    public MeasurementController(MeasurementService measurementService, ModelMapper modelMapper, MeasurementDtoValidator measurementDtoValidator) {
        this.measurementService = measurementService;
        this.modelMapper = modelMapper;
        this.measurementDtoValidator = measurementDtoValidator;
    }

    @InitBinder("measurementDto")
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(measurementDtoValidator);
    }

    @GetMapping("")
    public List<MeasurementDto> getMeasurements() {
        return measurementService.findAll()
                .stream()
                .map(m -> modelMapper.map(m, MeasurementDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/rainyDaysCount")
    public RainyDaysCountDto getRainyDaysCount() {
        return new RainyDaysCountDto(measurementService.getRainyDaysCount());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addMeasurement(@RequestBody @Valid MeasurementDto measurementDto) {
        measurementService.save(modelMapper.map(measurementDto, Measurement.class));
        return ResponseEntity.noContent().build();
    }
}
