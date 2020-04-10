package com.brichev.controllers;

import com.brichev.models.CardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BankIssuerController {
    /*
    @Autowired
    private AccordanceRepository accordanceRepository;
*/
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String addNewAccordance(@RequestBody CardForm cardForm) {
        //Accordance accordance = new Accordance();
        //accordance.setBin(bin);
        //accordance.setUrl(url);
        //accordance.setTargetName(targetName);
        //accordanceRepository.save(accordance);
        return "Saved";
    }


}
