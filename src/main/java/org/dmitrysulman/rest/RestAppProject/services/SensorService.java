package org.dmitrysulman.rest.RestAppProject.services;

import org.dmitrysulman.rest.RestAppProject.models.Sensor;
import org.springframework.stereotype.Service;

@Service
public interface SensorService {
    boolean existsByName(String name);

    Sensor save(Sensor sensor);
}
