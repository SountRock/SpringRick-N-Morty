package com.example.HWSpring6RNM.controller;

import com.example.HWSpring6RNM.domain.ModelsListI;
import com.example.HWSpring6RNM.service.Impl.CharacterServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterControllerAPI {
    @Autowired
    private CharacterServiceApi serviceApi;

    @GetMapping("/")
    public ResponseEntity<ModelsListI> getCharacters(){
        ModelsListI allCharacters = serviceApi.getAll();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }
}
