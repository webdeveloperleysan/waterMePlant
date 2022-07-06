package de.mms.waterMe.database.repository;

import de.mms.waterMe.database.entity.Irrigation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrrigationRepository extends JpaRepository<Irrigation, Long> {

}
