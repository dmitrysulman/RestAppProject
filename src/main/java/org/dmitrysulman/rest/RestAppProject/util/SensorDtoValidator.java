package org.dmitrysulman.rest.RestAppProject.util;

import org.dmitrysulman.rest.RestAppProject.dto.SensorDto;
import org.dmitrysulman.rest.RestAppProject.models.Sensor;
import org.dmitrysulman.rest.RestAppProject.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class SensorDtoValidator implements Validator {
    private final SensorService sensorService;

    @Autowired
    public SensorDtoValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SensorDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDto sensorDto = (SensorDto) target;
        if (sensorService.existsByName(sensorDto.getName())) {
            errors.rejectValue("name", "", "This name is already exists");
        }
    }
}
