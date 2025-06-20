package com.bnmit.workshop_app.controller;

import com.bnmit.workshop_app.model.Workshop;
import com.bnmit.workshop_app.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class WorkshopController {
    @Autowired
    private WorkshopRepository workshopRepository;

    @GetMapping("/")
    public String viewWorkshops(Model model){
        model.addAttribute("workshops",workshopRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addWorkshops(Model model){
        model.addAttribute("workshops",new Workshop());
        return "add-form";
    }
    @PostMapping("/save")
    public String saveWorkshop(@ModelAttribute Workshop workshop){
        workshopRepository.save(workshop);
        return "redirect:/";
    }
}
