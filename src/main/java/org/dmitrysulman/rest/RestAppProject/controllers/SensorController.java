package org.dmitrysulman.rest.RestAppProject.controllers;

import org.dmitrysulman.rest.RestAppProject.dto.SensorDto;
import org.dmitrysulman.rest.RestAppProject.models.Sensor;
import org.dmitrysulman.rest.RestAppProject.services.SensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<Void> registerSensor(@RequestBody @Valid SensorDto sensorDto,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //TODO
            return ResponseEntity.noContent().build();
        }
        sensorService.save(modelMapper.map(sensorDto, Sensor.class));
        return ResponseEntity.noContent().build();
    }
}
