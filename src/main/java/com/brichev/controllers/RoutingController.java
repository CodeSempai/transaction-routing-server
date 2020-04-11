package com.brichev.controllers;


import com.brichev.models.PaymentInfo;
import com.brichev.services.RoutingSystemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RoutingController {

    @Autowired
    RoutingSystemService routingSystemService;

    @PostMapping(path = "/proceed", consumes = "application/json", produces = "application/json")
    public String payment(@RequestBody PaymentInfo paymentInfo) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(routingSystemService.sendRequestToIssuer(paymentInfo));
    }

}
