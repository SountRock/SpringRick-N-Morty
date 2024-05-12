package com.example.HWSpring6RNM.controller.HTML;

import com.example.HWSpring6RNM.domain.Info;
import com.example.HWSpring6RNM.domain.character.CharacterResult;
import com.example.HWSpring6RNM.domain.character.Characters;
import com.example.HWSpring6RNM.service.Impl.CharacterServiceApi;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/characters")
public class CharacterControllerHTML implements ControllersHTMLI{
    @Autowired
    private CharacterServiceApi characterS;

    @GetMapping
    @Override
    public String getMainPage(Model model){
        Characters domain = characterS.getAllMain();
        if(domain == null) {
            return "404";
        }

        List<CharacterResult> results = domain.getResults();
        model.addAttribute("results", results);

        String next = domain.getInfo().getNext();
        model.addAttribute("next", next);
        String prev = domain.getInfo().getPrev();
        model.addAttribute("prev", prev);

        return "characters";
    }

    @GetMapping("/next")
    @Override
    public String getNextPage(Model model){
        Characters domain = characterS.getNextAll();
        if(domain == null) {
            return "404";
        }

        List<CharacterResult> results = domain.getResults();
        model.addAttribute("results", results);

        String next = domain.getInfo().getNext();
        model.addAttribute("next", next);
        String prev = domain.getInfo().getPrev();
        model.addAttribute("prev", prev);

        return "characters";
    }

    @GetMapping("/prev")
    @Override
    public String getNextPrev(Model model){
        Characters domain = characterS.getPrevAll();
        if(domain == null) {
            return "404";
        }

        List<CharacterResult> results = domain.getResults();
        model.addAttribute("results", results);

        String next = domain.getInfo().getNext();
        model.addAttribute("next", next);
        String prev = domain.getInfo().getPrev();
        model.addAttribute("prev", prev);

        return "characters";
    }

    @GetMapping("/one")
    @Override
    public String getOne(@PathParam("href") String href, Model model){
        CharacterResult result = characterS.getOne(href);
        model.addAttribute("one", result);

        return "character";
    }
}
