package com.example.HWSpring6RNM.controller;

import com.example.HWSpring6RNM.domain.ModelsListI;
import com.example.HWSpring6RNM.service.ServiceApiI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController для получения содержимого в json формате
 */
@RestController
@RequestMapping("/fast")
public class ControllerAPI {
    @Autowired
    private List<ServiceApiI> services;

    /**
     * Перейти в начало
     * @param type (char, local, epis)
     * @return result
     */
    @GetMapping("/{type}")
    public ResponseEntity<ModelsListI> getAllMain(@PathVariable("type") String type){
        for (ServiceApiI s : services) {
            if(s.getServiceName().equals(type)){
                ModelsListI allModels = s.getAllMain();
                if(allModels == null){
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(allModels, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Перейти в на следующую страницу
     * @param type (char, local, epis)
     * @return result
     */
    @GetMapping("/{type}/next")
    public ResponseEntity<ModelsListI> getAllNext(@PathVariable("type") String type){
        for (ServiceApiI s : services) {
            if(s.getServiceName().equals(type)){
                ModelsListI allModels = s.getNextAll();
                if(allModels == null){
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(allModels, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Перейти в на предыдущую страницу
     * @param type (char, local, epis)
     * @return result
     */
    @GetMapping("/{type}/prev")
    public ResponseEntity<ModelsListI> getAllPrev(@PathVariable("type") String type){
        for (ServiceApiI s : services) {
            if(s.getServiceName().equals(type)){
                ModelsListI allModels = s.getPrevAll();
                if(allModels == null){
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(allModels, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
