package com.example.HWSpring6RNM.service.Impl;

import com.example.HWSpring6RNM.domain.character.CharacterResult;
import com.example.HWSpring6RNM.domain.character.Characters;
import com.example.HWSpring6RNM.domain.episode.EpisodeResult;
import com.example.HWSpring6RNM.domain.episode.Episodes;
import com.example.HWSpring6RNM.service.ServiceApiI;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@EnableConfigurationProperties
public class EpisodeServiceApi implements ServiceApiI {
    private String serviceName = "episo";
    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Value("${links.episodeApi}")
    private String mainPage;

    @Getter @Setter
    @Value("${links.episodeApi}")
    private String nextPage;
    @Getter @Setter
    private String prevPage;


    @Override
    public Episodes getAllMain() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Episodes> response = template.exchange(mainPage, HttpMethod.GET, entity, Episodes.class);

        updatePagesVars(response.getBody(), this);

        return response.getBody();
    }

    @Override
    public Episodes getNextAll() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Episodes> response = template.exchange(nextPage, HttpMethod.GET, entity, Episodes.class);
            updatePagesVars(response.getBody(), this);

            return response.getBody();
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public Episodes getPrevAll() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Episodes> response = template.exchange(prevPage, HttpMethod.GET, entity, Episodes.class);
            updatePagesVars(response.getBody(), this);

            return response.getBody();
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    public EpisodeResult getOne(String href) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<EpisodeResult> response = template.exchange(href, HttpMethod.GET, entity, EpisodeResult.class);

        return response.getBody();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
}
