package org.dmitrysulman.rest.RestAppProject.util;

import org.dmitrysulman.rest.RestAppProject.dto.MeasurementDto;
import org.dmitrysulman.rest.RestAppProject.services.MeasurementService;
import org.dmitrysulman.rest.RestAppProject.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementDtoValidator implements Validator {
    private final SensorService sensorService;

    @Autowired
    public MeasurementDtoValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MeasurementDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementDto measurementDto = (MeasurementDto) target;
        if (measurementDto.getSensor() == null) {
            errors.rejectValue("sensor", "", "Sensor should not be empty");
        } else {
            if (!sensorService.existsByName(measurementDto.getSensor().getName())) {
                errors.rejectValue("sensor", "", "This sensor does not exists");
            }
        }
    }
}
