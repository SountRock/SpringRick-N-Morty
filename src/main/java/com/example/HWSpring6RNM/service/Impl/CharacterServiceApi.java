package com.example.HWSpring6RNM.service.Impl;

import com.example.HWSpring6RNM.domain.character.CharacterResult;
import com.example.HWSpring6RNM.domain.character.Characters;
import com.example.HWSpring6RNM.service.ServiceApiI;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CharacterServiceApi implements ServiceApiI {
    private String serviceName = "char";
    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Value("${links.characterApi}")
    private String mainPage;

    @Getter @Setter
    @Value("${links.characterApi}")
    private String nextPage;
    @Getter @Setter
    private String prevPage;

    @Override
    public Characters getAllMain() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Characters> response = template.exchange(mainPage, HttpMethod.GET, entity, Characters.class);

        updatePagesVars(response.getBody(), this);

        return response.getBody();
    }

    @Override
    public Characters getNextAll() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Characters> response = template.exchange(nextPage, HttpMethod.GET, entity, Characters.class);
            updatePagesVars(response.getBody(), this);

            return response.getBody();
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public Characters getPrevAll() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Characters> response = template.exchange(prevPage, HttpMethod.GET, entity, Characters.class);
            updatePagesVars(response.getBody(), this);

            return response.getBody();
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    public CharacterResult getOne(String href) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CharacterResult> response = template.exchange(href, HttpMethod.GET, entity, CharacterResult.class);

        return response.getBody();
    }


    @Override
    public String getServiceName() {
        return serviceName;
    }
}
