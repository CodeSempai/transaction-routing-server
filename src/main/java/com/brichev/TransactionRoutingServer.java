package com.brichev;

import com.brichev.templates.CardForm;
import com.mongodb.client.MongoClients;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@SpringBootApplication
public class TransactionRoutingServer {

    public static void main(String[] args){
        SpringApplication.run(TransactionRoutingServer.class, args);
    }

}
