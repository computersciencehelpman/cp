package com.coderscampus.cp.web;

import com.coderscampus.cp.domain.Dinosaur;
import com.coderscampus.cp.service.DinosaurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Dinosaur")
public class DinosaurController {

    private final DinosaurService dinosaurService;

    DinosaurController(DinosaurService dinosaurService) {
        this.dinosaurService = dinosaurService;
    }

    @GetMapping({"", "/"})
    public String home(ModelMap model) {
        List<Dinosaur> dinosaurs = dinosaurService.findAll();
        model.put("dinosaurs", dinosaurs);
        model.addAttribute("pageTitle", "Dinosaur Read");
        model.put("isDinosaur", true);
        return "dinosaur/read";
    }

    @GetMapping("/create")
    public String getCreate(ModelMap model) {
        Dinosaur dinosaur = new Dinosaur();
        model.put("dinosaur", dinosaur);
        model.addAttribute("pageTitle", "Dinosaur Create");
        model.put("isDinosaur", true);
        return "dinosaur/create";
    }

    @PostMapping("/create")
    public String create(Dinosaur dinosaur) {
        dinosaurService.save(dinosaur);
        return "redirect:/Dinosaur/";
    }


    @GetMapping("/update/{id}")
    public String fetch(ModelMap model, @PathVariable Long id) {
        Dinosaur dinosaur = dinosaurService.findById(id);
        model.put("dinosaur", dinosaur);
        model.addAttribute("pageTitle", "dinosaur Update");
        model.put("isdinosaur", true);
        return "dinosaur/update";
    }

    @PostMapping("/update")
    public String update(Dinosaur dinosaur) {
        dinosaurService.save(dinosaur);
        return "redirect:/Dinosaur/";
    }

    @PostMapping("/delete")
    public String delete(Dinosaur dinosaur) {
        dinosaurService.delete(dinosaur);
        return "redirect:/Dinosaur/";
    }
    
}
