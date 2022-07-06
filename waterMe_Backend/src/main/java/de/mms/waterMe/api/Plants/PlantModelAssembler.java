package de.mms.waterMe.api.Plants;


import de.mms.waterMe.database.entity.Irrigation;
import de.mms.waterMe.database.entity.Plant;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class PlantModelAssembler implements RepresentationModelAssembler<Plant, EntityModel<Plant>> {

    @Override
    public EntityModel<Plant> toModel(Plant plant) {
        return EntityModel.of(plant,
        WebMvcLinkBuilder.linkTo(methodOn(PlantController.class).onePlant(plant.getId())).withSelfRel(),
                linkTo(methodOn(PlantnController.class).allPlant()).withRel("plants"));
    }


        public EntityModel<?> deletedToModel() {
            return EntityModel.of(
            WebMvcLinkBuilder.linkTo(methodOn(PlantService.class).allPlant()).withRel("plants"));
        }
}







