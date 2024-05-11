package com.example.HWSpring6RNM.service.Impl;

import com.example.HWSpring6RNM.domain.character.Characters;
import com.example.HWSpring6RNM.service.ServiceApiI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CharacterServiceApi implements ServiceApiI {
    private String serviceName = "characters";
    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Value("${links.characterApi}")
    private String characterApi;

    @Override
    public Characters getAll() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(characterApi, HttpMethod.GET, entity, Characters.class);

        return responce.getBody();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }


}
