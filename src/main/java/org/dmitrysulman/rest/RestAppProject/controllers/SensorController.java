package org.dmitrysulman.rest.RestAppProject.controllers;

import org.dmitrysulman.rest.RestAppProject.dto.SensorDto;
import org.dmitrysulman.rest.RestAppProject.models.Sensor;
import org.dmitrysulman.rest.RestAppProject.services.SensorService;
import org.dmitrysulman.rest.RestAppProject.util.SensorDtoValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;
    private final ModelMapper modelMapper;
    private final SensorDtoValidator sensorDtoValidator;

    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper, SensorDtoValidator sensorDtoValidator) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.sensorDtoValidator = sensorDtoValidator;
    }

    @InitBinder("sensorDto")
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(sensorDtoValidator);
    }

    @PostMapping("/registration")
    public ResponseEntity<Void> registerSensor(@RequestBody @Valid SensorDto sensorDto) {
        sensorService.save(modelMapper.map(sensorDto, Sensor.class));
        return ResponseEntity.noContent().build();
    }
}
