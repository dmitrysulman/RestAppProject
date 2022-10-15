package org.dmitrysulman.rest.RestAppProject.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Instant;

public class MeasurementDto {
    @NotNull(message = "Value should not be empty")
    @Min(value = -100, message = "Value should be greater than -101")
    @Max(value = 100, message = "Value should be less than 101")
    private Float value;

    @NotNull(message = "Raining should not be empty")
    private Boolean raining;

    @NotNull(message = "Sensor should not be empty")
    private SensorDto sensor;

    private Instant createdAt;

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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
