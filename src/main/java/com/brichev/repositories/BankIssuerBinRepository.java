package com.brichev.repositories;

import com.brichev.models.BankIssuer;
import com.brichev.models.BankIssuerBin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BankIssuerBinRepository extends JpaRepository<BankIssuerBin, Integer> {
    Long removeById(Integer id);

    Optional<BankIssuerBin> findById(Integer id);

    Long countAllByBin(String bin);

    List<BankIssuerBin> findAllByBankIssuer(BankIssuer bankIssuer);
}