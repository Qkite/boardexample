package com.springboot.mustache.boardexample.controller;


import com.springboot.mustache.boardexample.domain.Hospital;
import com.springboot.mustache.boardexample.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hospital")
@Slf4j
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("")
    public String mainDisplay(){

        return "redirect:/hospital/list";
    }


    @GetMapping("/list")
    public String hospitalList(Model model){
        List<Hospital> hospitalList = hospitalRepository.findAll();
        model.addAttribute("hospitals", hospitalList);
        return "hospital/hospital-list";
    }
}
