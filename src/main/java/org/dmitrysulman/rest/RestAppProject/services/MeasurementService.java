package org.dmitrysulman.rest.RestAppProject.services;

import org.dmitrysulman.rest.RestAppProject.models.Measurement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MeasurementService {
    Measurement save(Measurement measurement);

    List<Measurement> findAll();

    long getRainyDaysCount();
}
