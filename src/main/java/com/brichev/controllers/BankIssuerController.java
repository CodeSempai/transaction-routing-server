package com.brichev.controllers;

import com.brichev.repositories.AccordanceRepository;
import com.brichev.templates.Accordance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/db")
public class BankIssuerController {
    @Autowired
    private AccordanceRepository accordanceRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewAccordance(@RequestParam String bin) {
        Accordance accordance = new Accordance();
        accordance.setBin(bin);
        //accordance.setUrl(url);
        //accordance.setTargetName(targetName);
        accordanceRepository.save(accordance);
        return "Saved";
    }
}
