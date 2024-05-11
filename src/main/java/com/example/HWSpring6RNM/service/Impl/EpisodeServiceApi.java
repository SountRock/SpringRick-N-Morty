package com.example.HWSpring6RNM.service.Impl;

import com.example.HWSpring6RNM.domain.episode.Episodes;
import com.example.HWSpring6RNM.service.ServiceApiI;
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
    private String serviceName = "episodes";
    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Value("${links.episodeApi}")
    private String episodeApi;

    @Override
    public Episodes getAll() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Episodes> response = template.exchange(episodeApi, HttpMethod.GET, entity, Episodes.class);

        return response.getBody();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
}
