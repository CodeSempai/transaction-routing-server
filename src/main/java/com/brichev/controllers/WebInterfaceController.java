package com.brichev.controllers;


import com.brichev.models.BankIssuer;
import com.brichev.models.BankIssuerBin;
import com.brichev.models.webForms.CreateForm;
import com.brichev.services.BankIssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebInterfaceController {

    @Autowired
    private BankIssuerService bankIssuerService;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String binsList(Model model) {
        model.addAttribute("bins", bankIssuerService.getBinsList());
        return "index";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
        CreateForm createForm = new CreateForm();
        model.addAttribute("createForm", createForm);
        return "create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("createForm") CreateForm createForm) {
        BankIssuerBin bankIssuerBin = new BankIssuerBin();
        bankIssuerBin.setBin(createForm.getBin());
        bankIssuerBin.setBankIssuer(new BankIssuer());
        bankIssuerBin.getBankIssuer().setUrl(createForm.getUrl());
        bankIssuerBin.getBankIssuer().setTargetName(createForm.getTargetName());
        bankIssuerService.saveBankIssuerBin(bankIssuerBin);
        return "redirect:/";
    }

}





