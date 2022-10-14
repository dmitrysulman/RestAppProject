package org.dmitrysulman.rest.RestAppProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementDto {
    @NotNull(message = "Value should not be empty")
    @Min(value = -100, message = "Value should be greater than -101")
    @Max(value = 100, message = "Value should be less than 101")
    private Float value;

    @NotNull(message = "Raining should not be empty")
    private Boolean raining;

    @JsonProperty("sensor")
    private SensorDto sensor;

    public MeasurementDto() {
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean isRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDto getSensor() {
        return sensor;
    }

    public void setSensor(SensorDto sensor) {
        this.sensor = sensor;
    }
}