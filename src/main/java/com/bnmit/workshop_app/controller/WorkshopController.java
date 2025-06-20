package com.bnmit.workshop_app.controller;
import com.bnmit.workshop_app.model.Workshop;
import com.bnmit.workshop_app.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class WorkshopController {
    @Autowired
    private WorkshopRepository workshopRepository;

    // Show list of workshops
    @GetMapping("/")
    public String viewWorkshops(Model model){
        model.addAttribute("workshops", workshopRepository.findAll());
        return "index"; // This is the html page to be rendered
    }
    // Show form to add new workshop
    @GetMapping("/add")
    public String addWorkshopForm(Model model){
        model.addAttribute("workshop", new Workshop());
        return "add-form";
    }
    // Save workshop
    @PostMapping("/save")
    public String saveWorkshop(@ModelAttribute Workshop workshop){
        workshopRepository.save(workshop);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String  editWorkshop(@PathVariable Integer id , Model model){
        Optional<Workshop> workshop = workshopRepository.findById(id);
        if(workshop.isPresent()){
            model.addAttribute("workshop" , workshop.get());
            return "edit-form";
        }
        else {
            return "redirect:/";
        }
    }



}
