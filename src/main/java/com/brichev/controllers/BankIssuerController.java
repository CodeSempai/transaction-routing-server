package com.brichev.controllers;

import com.brichev.models.BankIssuer;
import com.brichev.models.BankIssuerBin;
import com.brichev.models.CardForm;
import com.brichev.repositories.BankIssuerBinRepository;
import com.brichev.repositories.BankIssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BankIssuerController {

    @Autowired
    private BankIssuerBinRepository bankIssuerBinRepository;

    @Autowired
    private BankIssuerRepository bankIssuerRepository;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String addNewAccordance(@RequestBody BankIssuerBin bankIssuerBin) {
        bankIssuerRepository.save(bankIssuerBin.getBankIssuer());
        bankIssuerBinRepository.save(bankIssuerBin);
        return "Saved";
    }


}
