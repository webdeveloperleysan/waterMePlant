package de.mms.waterMe.api.Plants;

import de.mms.waterMe.database.entity.Plant;
import de.mms.waterMe.database.repository.PlantRepository;
import de.mms.waterMe.services.Plants.PlantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
    @Autowired
    private PlantService service;

    //private static final Logger log = LoggerFactory.getLogger(PlantController.class);
   // private final PlantRepository plantRepository;

    public PlantController(PlantRepository plantRepository, PlantModelAssembler assembler) {
        this.service= new PlantService(plantRepository,assembler);
    }

    @GetMapping("/{id}")
        public ResponseEntity<?> onePlant(@PathVariable Long id) {
            return ResponseEntity.status(200).header("FETCHED PLANT SUCCESSFULLY").body(service.onePlant(id));
        }

    @GetMapping("/all")
//    public List<Plant> getPlants() {
//        log.info("get all plants");
//        return (List<Plant>) plantRepository.findAll();
//    }
//
        public ResponseEntity<?> allPlants() {
            List<EntityModel<Plant>> plants = service.allPlants();

            return ResponseEntity.status(200).header("FETCHED SUCCESSFULLY").body(responseBody);
        }


//    @PostMapping
//    public void savePlant(@RequestBody Plant plant) {
//        log.info("save plant" + plant);
//        plantRepository.save(plant);
//    }


    @PostMapping("/")
        public ResponseEntity<?> newPlant(@RequestBody Plant plant) {
            EntityModel<Plant> entityModel = service.newPlant(plant);

            return ResponseEntity.status(200).header("CREATED PLANT").body(entityModel);
        }

    @PutMapping("/{id}")
        public ResponseEntity<?> editPlant(@PathVariable Long id, @RequestBody Plant plant) {
            plant.setId(id);
            EntityModel<Plant> entityModel = service.editPlant(id,plant);

        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();
        return ResponseEntity.status(200).header("UPDATED PLANTN").body(entityModel);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<?> deletePlant(@PathVariable Long id){
            return ResponseEntity.status(200).header("DELETED SUCESSFULLY").body(service.deletePlant(id));
        }
}