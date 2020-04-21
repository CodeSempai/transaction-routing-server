package com.brichev.controllers;

import com.brichev.models.BankIssuer;
import com.brichev.models.BankIssuerBin;
import com.brichev.models.WebForm;
import com.brichev.repositories.BankIssuerBinRepository;
import com.brichev.repositories.BankIssuerRepository;
import com.brichev.services.BankIssuerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WebInterfaceController.class)
class WebInterfaceControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    BankIssuerService bankIssuerService;
    @MockBean
    BankIssuerBinRepository bankIssuerBinRepository;
    @MockBean
    BankIssuerRepository bankIssuerRepository;

    private final BankIssuerBin bankIssuerBin;
    private final WebForm webForm;

    WebInterfaceControllerTest(){
        bankIssuerBin = new BankIssuerBin();
        bankIssuerBin.setBin("12345");
        BankIssuer bankIssuer = new BankIssuer();
        bankIssuer.setUrl("www.test.com");
        bankIssuer.setTargetName("test");
        bankIssuerBin.setBankIssuer(bankIssuer);

        webForm = new WebForm(bankIssuerBin);
    }

    @Test
    void binsList() throws Exception {
        List<BankIssuer> bankIssuerList = new ArrayList<>();
        bankIssuerList.add(bankIssuerBin.getBankIssuer());
        given(bankIssuerBinRepository.findById(bankIssuerBin.getId())).willReturn(java.util.Optional.of(new BankIssuerBin()));
        given(bankIssuerRepository.findByUrlAndAndTargetName(bankIssuerBin.getBankIssuer().getUrl(),
                bankIssuerBin.getBankIssuer().getTargetName())).willReturn(bankIssuerList);
        mvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @Test
    void showCreatePage() throws Exception {
        mvc.perform(get("/create"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

}