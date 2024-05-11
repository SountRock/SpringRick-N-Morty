package com.example.HWSpring6RNM.configuration;

import com.example.HWSpring6RNM.service.Impl.CharacterServiceApi;
import com.example.HWSpring6RNM.service.Impl.EpisodeServiceApi;
import com.example.HWSpring6RNM.service.Impl.LocationServiceApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * Класс конфигурации для устранения проблем с @Autowired
 */
@Configuration
public class AutowiredBeanConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders httpHeaders() {
        return new HttpHeaders();
    }

    @Bean
    public LocationServiceApi locationServiceApi(){
        return new LocationServiceApi();
    }

    @Bean
    public EpisodeServiceApi episodeServiceApi(){
        return new EpisodeServiceApi();
    }

    @Bean
    public CharacterServiceApi characterServiceApi(){
        return new CharacterServiceApi();
    }
}
