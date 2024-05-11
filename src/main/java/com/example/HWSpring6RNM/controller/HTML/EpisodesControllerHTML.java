package com.example.HWSpring6RNM.controller.HTML;

import com.example.HWSpring6RNM.domain.episode.EpisodeResult;
import com.example.HWSpring6RNM.domain.episode.Episodes;
import com.example.HWSpring6RNM.domain.location.LocationResult;
import com.example.HWSpring6RNM.service.Impl.EpisodeServiceApi;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/episodes")
public class EpisodesControllerHTML {
    @Autowired
    private EpisodeServiceApi episodeS;

    @GetMapping
    public String getMainPage(Model model){
        Episodes domain = episodeS.getAllMain();
        if(domain == null) {
            return "404";
        }

        List<EpisodeResult> results = domain.getResults();
        model.addAttribute("results", results);

        String next = domain.getInfo().getNext();
        model.addAttribute("next", next);
        String prev = domain.getInfo().getPrev();
        model.addAttribute("prev", prev);

        return "episodes";
    }

    @GetMapping("/next")
    public String getNextPage(Model model){
        Episodes domain = episodeS.getNextAll();
        if(domain == null) {
            return "404";
        }

        List<EpisodeResult> results = domain.getResults();
        model.addAttribute("results", results);

        String next = domain.getInfo().getNext();
        model.addAttribute("next", next);
        String prev = domain.getInfo().getPrev();
        model.addAttribute("prev", prev);

        return "episodes";
    }

    @GetMapping("/prev")
    public String getNextPrev(Model model){
        Episodes domain = episodeS.getPrevAll();
        if(domain == null) {
            return "404";
        }

        List<EpisodeResult> results = domain.getResults();
        model.addAttribute("results", results);

        String next = domain.getInfo().getNext();
        model.addAttribute("next", next);
        String prev = domain.getInfo().getPrev();
        model.addAttribute("prev", prev);

        return "episodes";
    }

    @GetMapping("/one")
    public String getOne(@PathParam("href") String href, Model model){
        EpisodeResult result = episodeS.getOne(href);
        model.addAttribute("one", result);

        return "episode";
    }
}
