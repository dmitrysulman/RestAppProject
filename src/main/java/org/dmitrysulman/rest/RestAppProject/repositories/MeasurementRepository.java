package org.dmitrysulman.rest.RestAppProject.repositories;

import org.dmitrysulman.rest.RestAppProject.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
