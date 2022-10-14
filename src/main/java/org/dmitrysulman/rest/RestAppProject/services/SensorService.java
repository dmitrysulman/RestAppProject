package org.dmitrysulman.rest.RestAppProject.services;

import org.dmitrysulman.rest.RestAppProject.models.Sensor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SensorService {
    Optional<Sensor> findByName(String name);

    boolean existsByName(String name);

    Sensor save(Sensor sensor);
}
