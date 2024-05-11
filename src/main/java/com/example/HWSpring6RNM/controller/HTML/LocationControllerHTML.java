package com.example.HWSpring6RNM.controller.HTML;

import com.example.HWSpring6RNM.domain.character.CharacterResult;
import com.example.HWSpring6RNM.domain.location.LocationResult;
import com.example.HWSpring6RNM.domain.location.Locations;
import com.example.HWSpring6RNM.service.Impl.LocationServiceApi;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationControllerHTML {
    @Autowired
    private LocationServiceApi locationS;

    @GetMapping
    public String getMainPage(Model model){
        Locations domain = locationS.getAllMain();
        if(domain == null) {
            return "404";
        }

        List<LocationResult> results = domain.getResults();
        model.addAttribute("results", results);

        String next = domain.getInfo().getNext();
        model.addAttribute("next", next);
        String prev = domain.getInfo().getPrev();
        model.addAttribute("prev", prev);

        return "locations";
    }

    @GetMapping("/next")
    public String getNextPage(Model model){
        Locations domain = locationS.getNextAll();
        if(domain == null) {
            return "404";
        }

        List<LocationResult> results = domain.getResults();
        model.addAttribute("results", results);

        String next = domain.getInfo().getNext();
        model.addAttribute("next", next);
        String prev = domain.getInfo().getPrev();
        model.addAttribute("prev", prev);

        return "locations";
    }

    @GetMapping("/prev")
    public String getNextPrev(Model model){
        Locations domain = locationS.getPrevAll();
        if(domain == null) {
            return "404";
        }

        List<LocationResult> results = domain.getResults();
        model.addAttribute("results", results);

        String next = domain.getInfo().getNext();
        model.addAttribute("next", next);
        String prev = domain.getInfo().getPrev();
        model.addAttribute("prev", prev);

        return "locations";
    }

    @GetMapping("/one")
    public String getOne(@PathParam("href") String href, Model model){
        LocationResult result = locationS.getOne(href);
        model.addAttribute("one", result);

        return "location";
    }
}
