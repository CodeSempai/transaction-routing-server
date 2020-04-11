package com.brichev.services;


import com.brichev.models.BankIssuer;
import com.brichev.models.BankIssuerBin;
import com.brichev.models.PaymentInfo;
import com.brichev.repositories.BankIssuerBinRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoutingSystemService {

    @Autowired
    RestClientService restClientService;
    @Autowired
    BankIssuerBinRepository bankIssuerBinRepository;

    private BankIssuer getBankIssuerByBIN(String bin) {
        List<BankIssuerBin> services = bankIssuerBinRepository.findAll();
        for (BankIssuerBin service : services) {
            if (bin.matches(service.getBin())) {
                return service.getBankIssuer();
            }
        }
        return null;
    }

    public String sendRequestToIssuer(PaymentInfo paymentInfo) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        BankIssuer bankIssuer = this.getBankIssuerByBIN(paymentInfo.getCard().getBin());
        assert bankIssuer != null;
        String response = this.restClientService.post(bankIssuer.getUrl(), objectMapper.writeValueAsString(paymentInfo));

        return response;
    }

}
