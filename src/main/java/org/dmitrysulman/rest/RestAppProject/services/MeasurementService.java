package org.dmitrysulman.rest.RestAppProject.services;

import org.dmitrysulman.rest.RestAppProject.models.Measurement;
import org.springframework.stereotype.Service;

@Service
public interface MeasurementService {
    Measurement save(Measurement measurement);
}
