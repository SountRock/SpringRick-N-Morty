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

@RestController
@RequestMapping("/f")
public class ControllerAPI {
    @Autowired
    private List<ServiceApiI> services;

    //episodes
    //locations
    //characters
    @GetMapping("/{type}")
    public ResponseEntity<ModelsListI> getAll(@PathVariable String type){
        for (ServiceApiI s : services) {
            if(s.getServiceName().equals(type)){
                ModelsListI allModels = s.getAll();
                return new ResponseEntity<>(allModels, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
