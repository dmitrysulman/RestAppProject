package org.dmitrysulman.rest.RestAppProject.repositories;

import org.dmitrysulman.rest.RestAppProject.models.Measurement;
import org.dmitrysulman.rest.RestAppProject.util.RainyDaysCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    @Query(value = "select count (distinct date(created_at)) as rainyDaysCount from measurements where raining = true",
            nativeQuery = true)
    List<RainyDaysCount> getRainyDaysCount();

    List<Measurement> findAllByOrderByCreatedAtAsc();
}
