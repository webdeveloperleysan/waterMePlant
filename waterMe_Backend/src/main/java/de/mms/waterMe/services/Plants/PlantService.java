package de.mms.waterMe.services.Plants;

import de.mms.waterMe.api.Plants.PlantModelAssembler;
import de.mms.waterMe.api.Plants.PlantNotFoundException;
import de.mms.waterMe.database.entity.Plant;
import de.mms.waterMe.database.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.EntityModel;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;


@Service
@ResponseBody
@ResponseStatus
public class PlantService {

    @Autowired
    private PlantRepository repository;
    @Autowired
    private PlantModelAssembler assembler;

    public PlantService(PlantRepository plantRepository, PlantModelAssembler assembler) {
        this.repository =plantRepository;
        this.assembler=assembler;
    }

    public EntityModel<Plant> newPlant(Plant plant) {
        return assembler.toModel(repository.save(plant));
    }

    public EntityModel<Plant> editPlant(Long id, Plant plant) {
        Plant updatedPlant = repository.findById(id)
                .map( targetPlant -> {
                    plant.setId(targetPlant.getId());
                    return repository.save(plant);
                })
                .orElseThrow();

        return assembler.toModel(updatedPlant);
    }

    public EntityModel<Plant> onePlant(Long id) {
        Plant plant = repository.findById(id)
                .orElseThrow();

        return assembler.toModel(plant);
    }

    public List<EntityModel<Plant>> allPlants(){
        List<EntityModel<Plant>> Plants = repository.findAll()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return plants;
    }

    public EntityModel<?> deletePlant(Long id) {
        Plant plant = repository.findById(id).map(
                target ->  {
                    repository.delete(target);
                    return target;
                }
        ).orElseThrow();
        return assembler.deletedToModel();
    }



}
