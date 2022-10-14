package org.dmitrysulman.rest.RestAppProject.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SensorDto {
    @NotNull(message = "Name should not be empty")
    @Size(min = 3, max = 30, message = "Size should be between 3 and 30 characters")
    @Column(name = "name")
    private String name;

    public SensorDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
