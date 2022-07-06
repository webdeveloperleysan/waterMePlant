package de.mms.waterMe.api;

import de.mms.waterMe.database.entity.Plant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.net.URI;
import java.net.URISyntaxException;


@SpringBootTest
@AutoConfigureMockMvc
public class PlantControllerTest {

    final String baseUrl = "http://localhost:8080/api/plant/";

    @Test
    void Posting() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(baseUrl);
        Plant plant = new Plant(new Long(10), new Long(4), 3);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Plant> request = new HttpEntity<>(plant, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        Assertions.assertEquals(201, result.getStatusCodeValue());
    }

    @Test
    void GetOne() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        initOne();

        URI uri = new URI(baseUrl+"1");
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void GetAll() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(baseUrl+"all");

        initPlants();

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void Update() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(baseUrl+"1");

        initOne();




    }

    void initOne() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(baseUrl);
        Plant plant = new Plant(new Long(10), new Long(4), 3);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Plant> request = new HttpEntity<>(plant, headers);
        restTemplate.postForEntity(uri, request, String.class);
    }
    void initPlants() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Plant> request;

        request = new HttpEntity<>(new Plant(new Long(10), new Long(4), 3), headers);
        restTemplate.postForEntity(uri, request, String.class);
        request = new HttpEntity<>(new Plant(new Long(11), new Long(5), 3), headers);
        restTemplate.postForEntity(uri, request, String.class);
        request = new HttpEntity<>(new Plant(new Long(12), new Long(6), 3), headers);
        restTemplate.postForEntity(uri, request, String.class);
        request = new HttpEntity<>(new Plant(new Long(13), new Long(4), 3), headers);
        restTemplate.postForEntity(uri, request, String.class);
        request = new HttpEntity<>(new Plant(new Long(14), new Long(5), 3), headers);
        restTemplate.postForEntity(uri, request, String.class);
        request = new HttpEntity<>(new Plant(new Long(10), new Long(4), 3), headers);
        restTemplate.postForEntity(uri, request, String.class);
    }
}
