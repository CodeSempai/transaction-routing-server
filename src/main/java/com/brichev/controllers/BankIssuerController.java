package com.brichev.controllers;

import com.brichev.models.BankIssuerBin;
import com.brichev.services.BankIssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BankIssuerController {

    @Autowired
    private BankIssuerService bankIssuerService;


    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String addNewAccordance(@RequestBody BankIssuerBin bankIssuerBin) {
        bankIssuerService.saveBankIssuerBin(bankIssuerBin);
        return "Saved";
    }

    @Transactional
    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public String removeAccordance(@RequestBody BankIssuerBin bankIssuerBin) {
        bankIssuerService.removeBankIssuerBin(bankIssuerBin);
        return "Removed " + bankIssuerBin.getId();
    }

    /*
    @Transactional
    @PostMapping(path = "/edit", consumes = "application/json", produces = "application/json")
    public String editAccordance(@RequestBody LinkedHashMap editInfo) {
        bankIssuerService.editBankIssuerBin((int)editInfo.get(0), (BankIssuerBin)editInfo.get(1));
        return "Edited";
    }
     */


    @GetMapping(path="/getBins")
    public @ResponseBody Iterable<BankIssuerBin> getBins() {
      return bankIssuerService.getAllBins();
    }


}
