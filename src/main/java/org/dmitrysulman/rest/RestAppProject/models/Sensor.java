package org.dmitrysulman.rest.RestAppProject.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Name should not be empty")
    @Size(min = 3, max = 30, message = "Size should be between 3 and 30 characters")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "sensor",
            cascade = {CascadeType.ALL})
    private List<Measurement> measurements;

    public Sensor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }
}
