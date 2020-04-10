package com.brichev.repositories;

import com.brichev.models.BankIssuer;
import org.springframework.data.repository.CrudRepository;

public interface BankIssuerRepository extends CrudRepository<BankIssuer, Integer> {

}