package com.bsuir.springapp.controller;

import com.bsuir.springapp.entity.RecordData;
import com.bsuir.springapp.facade.RecordFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
public class MainController {
    @Resource
    private RecordFacade recordFacade;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("records", recordFacade.getAllRecords());
        model.addAttribute("record", new RecordData());
        return "index";
    }

    @PostMapping("/records")
    public String createRecord(@ModelAttribute("record") RecordData recordData, RedirectAttributes model) {
        recordFacade.saveRecord(recordData);
        return "redirect:/";
    }
}
