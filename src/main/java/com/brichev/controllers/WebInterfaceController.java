package com.brichev.controllers;


import com.brichev.models.BankIssuer;
import com.brichev.models.BankIssuerBin;
import com.brichev.models.WebForm;
import com.brichev.services.BankIssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@Controller
public class WebInterfaceController {

    @Autowired
    private BankIssuerService bankIssuerService;

    private BankIssuerBin createFromWebForm(WebForm webForm) {
        BankIssuerBin bankIssuerBin = new BankIssuerBin();
        bankIssuerBin.setBin(webForm.getBin());
        bankIssuerBin.setBankIssuer(new BankIssuer());
        bankIssuerBin.getBankIssuer().setUrl(webForm.getUrl());
        bankIssuerBin.getBankIssuer().setTargetName(webForm.getTargetName());
        return bankIssuerBin;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String binsList(Model model) {
        model.addAttribute("bins", bankIssuerService.getBinsList());
        return "index";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String showCreatePage(Model model) {
        WebForm webForm = new WebForm();
        model.addAttribute("webForm", webForm);
        return "create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String createAccordance(Model model, @ModelAttribute("webForm") WebForm webForm) {
        bankIssuerService.saveBankIssuerBin(createFromWebForm(webForm));
        return "redirect:/";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
    public String showEditPage(Model model, @ModelAttribute("bin") Integer id) {
        BankIssuerBin bankIssuerBin = bankIssuerService.getBinById(id);
        WebForm webForm = new WebForm(bankIssuerBin);
        webForm.setId(id);
        model.addAttribute("webForm", webForm);
        return "edit";
    }

    @Transactional
    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String editAccordance(Model model, @ModelAttribute("webForm") WebForm webForm) {
        bankIssuerService.editBankIssuerBin(webForm.getId(), createFromWebForm(webForm));
        return "redirect:/";
    }

    @Transactional
    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
    public String delete(Model model, @ModelAttribute("bin") Integer id) {
        bankIssuerService.removeBankIssuerBin(id);
        return "redirect:/";
    }

}





