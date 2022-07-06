package de.mms.waterMe.database;


import de.mms.waterMe.database.entity.Plant;
import de.mms.waterMe.database.repository.PlantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;


public class LoadDatabase {

    private final static Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);
    public CommandLineRunner initPlants(PlantRepository plantRepository) {
        return args -> {
            Plant plant = new Plant(new Long(1),new Long(2),3);
            plantRepository.save(plant);
            plantRepository.save(new Plant(new Long(3),new Long(2),4));
            plantRepository.save(new Plant(new Long(2),new Long(1),4));
            plantRepository.save(new Plant(new Long(3),new Long(2),4));
            plantRepository.save(new Plant(new Long(5),new Long(1),4));

            plantRepository.findAll().forEach(order -> LOG.info("Preloaded "+ order));
        };
    }
}