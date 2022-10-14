package org.dmitrysulman.rest.RestAppProject.services;

import org.dmitrysulman.rest.RestAppProject.models.Measurement;
import org.dmitrysulman.rest.RestAppProject.models.Sensor;
import org.dmitrysulman.rest.RestAppProject.repositories.MeasurementRepository;
import org.dmitrysulman.rest.RestAppProject.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MeasurementServiceImpl implements MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    @Transactional
    public Measurement save(Measurement measurement) {
        Sensor sensor = sensorRepository.findByName(measurement.getSensor().getName()).orElse(null);
        measurement.setSensor(sensor);
        return measurementRepository.save(measurement);
    }
}
