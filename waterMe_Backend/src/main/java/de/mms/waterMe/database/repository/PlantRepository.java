package de.mms.waterMe.database.repository;

import de.mms.waterMe.database.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlantRepository extends JpaRepository<Plant, Long> {

}