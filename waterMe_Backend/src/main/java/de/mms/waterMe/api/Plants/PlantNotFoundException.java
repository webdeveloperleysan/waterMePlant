package de.mms.waterMe.api.Plants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlantNotFoundException extends RuntimeException {
    PlantNotFoundException(Long id) {
        super("Could not find irrigation: " + id);
    }
}



