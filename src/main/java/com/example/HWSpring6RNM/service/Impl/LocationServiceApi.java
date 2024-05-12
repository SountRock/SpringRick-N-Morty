package com.example.HWSpring6RNM.service.Impl;

import com.example.HWSpring6RNM.domain.ModelsListI;
import com.example.HWSpring6RNM.domain.episode.EpisodeResult;
import com.example.HWSpring6RNM.domain.episode.Episodes;
import com.example.HWSpring6RNM.domain.location.LocationResult;
import com.example.HWSpring6RNM.domain.location.Locations;
import com.example.HWSpring6RNM.service.ServiceApiI;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;

import java.util.List;

public class LocationServiceApi implements ServiceApiI {
    private String serviceName = "local";
    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Value("${links.locationApi}")
    private String mainPage;

    @Getter @Setter
    @Value("${links.locationApi}")
    private String nextPage;
    @Getter @Setter
    private String prevPage;

    @Override
    public Locations getAllMain() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON)); //Определяем тип тела ответа на запросы (пока что пустой)
        HttpEntity<String> entity = new HttpEntity<>(headers); //Создаем сушность и задаем в ней тело (пустой json файл)

        //template - необходим для выполнения http запросов. exchange - метод выполнения запроса
        //(url по которой будем обращаться с запросом, тип метода, указание получаемой сущности, тип преобразования результата ответа)
        ResponseEntity<Locations> response = template.exchange(mainPage, HttpMethod.GET, entity, Locations.class);

        updatePagesVars(response.getBody(), this);

        return response.getBody();
    }

    @Override
    public Locations getNextAll() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Locations> response = template.exchange(nextPage, HttpMethod.GET, entity, Locations.class);
            updatePagesVars(response.getBody(), this);

            return response.getBody();
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public Locations getPrevAll() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Locations> response = template.exchange(prevPage, HttpMethod.GET, entity, Locations.class);
            updatePagesVars(response.getBody(), this);

            return response.getBody();
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public LocationResult getOne(String href) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<LocationResult> response = template.exchange(href, HttpMethod.GET, entity, LocationResult.class);

        return response.getBody();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
}
