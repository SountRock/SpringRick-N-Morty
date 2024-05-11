package com.example.HWSpring6RNM.controller;

import com.example.HWSpring6RNM.domain.character.CharacterResult;
import com.example.HWSpring6RNM.domain.character.Characters;
import com.example.HWSpring6RNM.service.Impl.CharacterServiceApi;
import com.example.HWSpring6RNM.service.Impl.EpisodeServiceApi;
import com.example.HWSpring6RNM.service.Impl.LocationServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControllerAPIHtml {
    @Autowired
    private CharacterServiceApi characterS;

    @Autowired
    private LocationServiceApi locationS;

    @Autowired
    private EpisodeServiceApi episodeS;

    //episodes
    //locations
    //characters
    @GetMapping("/characters")
    public String getAll(Model model){
        //Characters domain = characterS.getAll();
        //List<CharacterResult> results = domain.getResults();
        //model.addAttribute("results", results);

        return HttpStatus.NOT_FOUND.toString();
    }
}
