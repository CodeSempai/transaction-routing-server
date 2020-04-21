package com.brichev.controllers;

import com.brichev.models.BankIssuer;
import com.brichev.models.BankIssuerBin;
import com.brichev.repositories.BankIssuerBinRepository;
import com.brichev.services.BankIssuerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BankIssuerController.class)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class BankIssuerControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    BankIssuerService bankIssuerService;
    @MockBean
    BankIssuerBinRepository bankIssuerBinRepository;

    private final BankIssuerBin bankIssuerBin;

    BankIssuerControllerTest(){
        bankIssuerBin = new BankIssuerBin();
        bankIssuerBin.setBin("12345");
        BankIssuer bankIssuer = new BankIssuer();
        bankIssuer.setUrl("www.test.com");
        bankIssuer.setTargetName("test");
        bankIssuerBin.setBankIssuer(bankIssuer);
    }

    @Test
    void addNewAccordance() throws Exception {
        this.mvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJsonString((bankIssuerBin))))
                .andExpect(status().isOk());
    }

    @Test
    void removeAccordance() throws Exception {
        this.mvc.perform(post("/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJsonString((bankIssuerBin))))
                .andExpect(status().isOk());
    }

    @Test
    void getBins() throws Exception {
        this.mvc.perform(get("/")).andExpect(status().isOk());
    }


    public static String toJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}