package com.example.HWSpring6RNM.service.Impl;

import com.example.HWSpring6RNM.domain.location.Locations;
import com.example.HWSpring6RNM.service.ServiceApiI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;

import java.util.List;

public class LocationServiceApi implements ServiceApiI {
    private String serviceName = "locations";
    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Value("${links.locationApi}")
    private String locationApi;

    @Override
    public Locations getAll(){
        headers.setAccept(List.of(MediaType.APPLICATION_JSON)); //Определяем тип тела ответа на запросы (пока что пустой)
        HttpEntity<String> entity = new HttpEntity<>(headers); //Создаем сушность и задаем в ней тело (пустой json файл)

        //template - необходим для выполнения http запросов. exchange - метод выполнения запроса
        //(url по которой будем обращаться с запросом, тип метода, указание получаемой сущности, тип преобразования результата ответа)
        ResponseEntity<Locations> responce = template.exchange(locationApi, HttpMethod.GET, entity, Locations.class);

        return responce.getBody();

    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
}
